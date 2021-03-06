/**
 * Copyright (c) 2011-2012 Eclipse contributors and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.emf.ecore.xcore.resource;


import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xcore.XDataType;
import org.eclipse.emf.ecore.xcore.XNamedElement;
import org.eclipse.emf.ecore.xcore.XOperation;
import org.eclipse.emf.ecore.xcore.XPackage;
import org.eclipse.emf.ecore.xcore.XStructuralFeature;
import org.eclipse.emf.ecore.xcore.XcorePackage;
import org.eclipse.emf.ecore.xcore.mappings.XcoreMapper;
import org.eclipse.emf.ecore.xcore.util.XcoreEcoreBuilder;
import org.eclipse.emf.ecore.xcore.util.XcoreGenModelBuilder;
import org.eclipse.emf.ecore.xcore.util.XcoreJvmInferrer;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;


public class XcoreModelAssociator implements IJvmModelAssociations, ILogicalContainerProvider, IDerivedStateComputer
{
  @Inject
  private XcoreJvmInferrer jvmInferrer;

  @Inject
  private XcoreGenModelBuilder genModelBuilder;

  @Inject
  private Provider<XcoreEcoreBuilder> xcoreEcoreBuilderProvider;

  @Inject
  private XcoreMapper mapper;

  @Inject
  private IReferableElementsUnloader unloader;

  public void installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase)
  {
    if (resource.getParseResult() != null && resource.getParseResult().getRootASTElement() instanceof XPackage)
    {
      XPackage model = (XPackage)resource.getParseResult().getRootASTElement();
      XcoreEcoreBuilder xcoreEcoreBuilder = xcoreEcoreBuilderProvider.get();
      EPackage ePackage = xcoreEcoreBuilder.getEPackage(model);
      resource.getContents().add(ePackage);
      GenModel genModel = genModelBuilder.getGenModel(model);
      genModel.setCanGenerate(true);
      if (!preLinkingPhase)
      {
        xcoreEcoreBuilder.link();
        genModelBuilder.initializeUsedGenPackages(genModel);

        // If the model has edit support, it's important to determine if we have a dependencies on Ecore's generated item providers...
        //
        if (genModel.hasEditSupport())
        {
          for (GenPackage genPackage : genModel.getUsedGenPackages())
          {
            // If we find a GenPackage for Ecore itself...
            //
            if (EcorePackage.eNS_URI.equals(genPackage.getNSURI()))
            {
              boolean needsEcoreEditSupport = false;
              EPackage ecorePackage = genPackage.getEcorePackage();
              
              // Consider all the class of the package...
              LOOP:
              for (EClassifier eClassifier : ePackage.getEClassifiers())
              {
                if (eClassifier instanceof EClass)
                {
                  EClass eClass = (EClass)eClassifier;
                  
                  // If one of the super types is from the Ecore package and isn't EObject, we need Ecore edit support.
                  //
                  for (EClass eSuperType : eClass.getEAllSuperTypes())
                  {
                    if (eSuperType.getEPackage() == ecorePackage && !"EObject".equals(eSuperType.getName()))
                    {
                      needsEcoreEditSupport = true;
                      break LOOP;
                    }
                  }
                  // If one of the reference types is from the Ecore package and isn't EObject, we need Ecore edit support.
                  //
                  for (EReference eReference : eClass.getEAllReferences())
                  {
                    EClass eReferenceType = eReference.getEReferenceType();
                    if (eReferenceType != null && eReferenceType.getEPackage() == ecorePackage && !"EObject".equals(eReferenceType.getName()))
                    {
                      needsEcoreEditSupport = true;
                      break LOOP;
                    }
                  }
                }
              }
              // Modify the Ecore package's GenPackage's model to indicate whether Ecore provides edit support.
              //
              genPackage.getGenModel().setEditDirectory(needsEcoreEditSupport ? "/org.eclipse.emf.edit.ecore/src" : "");
              break;
            }
          }
        }
      }
      resource.getContents().addAll(jvmInferrer.inferElements(genModel));
      if (!preLinkingPhase)
      {
        xcoreEcoreBuilder.linkInstanceTypes();
        jvmInferrer.inferDeepStructure(genModel);
      }
      resource.getCache().clear(resource);
    }
  }

  public void discardDerivedState(DerivedStateAwareResource resource)
  {
    EList<EObject> contents = resource.getContents();
    int size = contents.size();
    if (size > 1)
    {
      List<EObject> toBeRemoved = Lists.newArrayList();
      for (Iterator<EObject> i = contents.iterator(); i.hasNext();)
      {
        EObject eObject = i.next();
        if (eObject instanceof XPackage)
        {
          mapper.unsetMapping((XPackage)eObject);
        }
        else
        {
          unloader.unloadRoot(eObject);
          toBeRemoved.add(eObject);
        }
      }
      contents.removeAll(toBeRemoved);
    }
  }

  public XExpression getAssociatedExpression(JvmIdentifiableElement element)
  {
    // TODO
    return null;
  }

  public Set<EObject> getJvmElements(EObject eObject)
  {
    final Set<EObject> result = Sets.newLinkedHashSet();
    if (eObject instanceof XNamedElement)
    {
      GenBase genBase = mapper.getGen((XNamedElement)eObject);
      if (genBase != null)
      {
        result.addAll(XcoreJvmInferrer.getInferredElements(genBase));
      }
    }
    else if (eObject instanceof GenBase)
    {
      result.addAll(XcoreJvmInferrer.getInferredElements((GenBase)eObject));
    }
    else if (eObject.eClass().getEPackage() == TypesPackage.eINSTANCE)
    {
      result.add(eObject);
    }
    return result;
  }

  public Set<EObject> getSourceElements(EObject eObject)
  {
    EObject xcoreElement = mapper.getXcoreElement(eObject);
    return xcoreElement == null || xcoreElement == eObject ? Collections.<EObject>emptySet() : Collections.singleton(eObject);
  }

  public EObject getPrimarySourceElement(EObject eObject)
  {
    EObject xcoreElement = mapper.getXcoreElement(eObject);
    return xcoreElement;
  }

  public JvmIdentifiableElement getLogicalContainer(EObject eObject)
  {
    if (eObject instanceof XBlockExpression)
    {
      EObject eContainer = eObject.eContainer();
      EReference eContainmentFeature = eObject.eContainmentFeature();
      if (eContainmentFeature == XcorePackage.Literals.XOPERATION__BODY)
      {
        return mapper.getMapping((XOperation)eContainer).getJvmOperation();
      }
      else if (eContainmentFeature == XcorePackage.Literals.XDATA_TYPE__CREATE_BODY)
      {
        return mapper.getMapping((XDataType)eContainer).getCreator();
      }
      else if (eContainmentFeature == XcorePackage.Literals.XDATA_TYPE__CONVERT_BODY)
      {
        return mapper.getMapping((XDataType)eContainer).getConverter();
      }
      else if (eContainmentFeature == XcorePackage.Literals.XSTRUCTURAL_FEATURE__GET_BODY)
      {
        return mapper.getMapping((XStructuralFeature)eContainer).getGetter();
      }
      else if (eContainmentFeature == XcorePackage.Literals.XSTRUCTURAL_FEATURE__SET_BODY)
      {
        return mapper.getMapping((XStructuralFeature)eContainer).getSetter();
      }
      else if (eContainmentFeature == XcorePackage.Literals.XSTRUCTURAL_FEATURE__IS_SET_BODY)
      {
        return mapper.getMapping((XStructuralFeature)eContainer).getIsSetter();
      }
      else if (eContainmentFeature == XcorePackage.Literals.XSTRUCTURAL_FEATURE__UNSET_BODY)
      {
        return mapper.getMapping((XStructuralFeature)eContainer).getUnsetter();
      }
      else
      {
        return null;
      }
    }
    return null;
  }

  public JvmIdentifiableElement getNearestLogicalContainer(EObject eObject)
  {
    for (EObject eContainer = eObject; eContainer != null; eContainer = eContainer.eContainer())
    {
      if (eContainer instanceof XBlockExpression)
      {
        return getLogicalContainer(eContainer);
      }
    }
    return null;
  }
  
}
