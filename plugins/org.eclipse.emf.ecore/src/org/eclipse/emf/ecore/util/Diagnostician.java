/**
 * <copyright>
 *
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Diagnostician.java,v 1.6 2005/06/08 06:20:10 nickb Exp $
 */
package org.eclipse.emf.ecore.util;


//import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * A validity checker for basic EObject constraints.
 */
public class Diagnostician implements EValidator.SubstitutionLabelProvider, EValidator
{
  public static final Diagnostician INSTANCE = new Diagnostician();

  protected EValidator.Registry eValidatorRegistry;

  public Diagnostician(EValidator.Registry eValidatorRegistry)
  {
    this.eValidatorRegistry = eValidatorRegistry;
  }

  public Diagnostician()
  {
    this(EValidator.Registry.INSTANCE);
  }

  public String getObjectLabel(EObject eObject)
  {
    return EcoreUtil.getIdentification(eObject);
  }

  public String getFeatureLabel(EStructuralFeature eStructuralFeature)
  {
    return eStructuralFeature.getName();
  }

  public String getValueLabel(EDataType eDataType, Object value)
  {
    return EcoreUtil.convertToString(eDataType, value);
  }

  public Diagnostic validate(EObject eObject)
  {
    Map context = new HashMap();
    context.put(EValidator.SubstitutionLabelProvider.class, this);
    context.put(EValidator.class, this);
    BasicDiagnostic diagnostics = 
      new BasicDiagnostic
        (EObjectValidator.DIAGNOSTIC_SOURCE,
         0,
         EcorePlugin.INSTANCE.getString
           ("_UI_DiagnosticRoot_diagnostic", 
            new Object [] { getObjectLabel(eObject) }),
         new Object [] { eObject });
    validate(eObject, diagnostics, context);
    return diagnostics;
  }

  /**
   * Validates the object in the given context, optionally producing diagnostics.
   * @param eObject the object to validate.
   * @param diagnostics a place to accumulate diagnostics; if it's <code>null</code>, no diagnostics should be produced.
   * @return whether the object is valid.
   */
  public boolean validate(EObject eObject, DiagnosticChain diagnostics)
  {
    Map context = new HashMap();
    context.put(EValidator.SubstitutionLabelProvider.class, this);
    context.put(EValidator.class, this);
    return validate(eObject, diagnostics, context);
  }

  public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map context)
  {
    return validate(eObject.eClass(), eObject, diagnostics, context); 
  }

  public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map context)
  {
    Object eValidator;
    while ((eValidator = eValidatorRegistry.get(eClass.eContainer())) == null)
    {
      List eSuperTypes = eClass.getESuperTypes();
      if (eSuperTypes.isEmpty())
      {
        eValidator = eValidatorRegistry.get(null);
        break;
      }
      else
      {
        eClass = (EClass)eSuperTypes.get(0);
      }
    }

    boolean result = ((EValidator)eValidator).validate(eClass, eObject, diagnostics, context);
    if (result || diagnostics != null)
    {
      result &= doValidateContents(eObject, diagnostics, context);
    }
    return result;
  }

  protected boolean doValidateContents(EObject eObject, DiagnosticChain diagnostics, Map context)
  {
    List eContents = eObject.eContents();
    if (!eContents.isEmpty())
    {
      Iterator i = eContents.iterator(); 
      EObject child = (EObject)i.next();
      boolean result = validate(child, diagnostics, context);
      while (i.hasNext() && (result || diagnostics != null))
      {
        child = (EObject)i.next();
        result &= validate(child, diagnostics, context);
      }
      return result;
    }
    else
    {
      return true;
    }
  }

  public Diagnostic validate(EDataType eDataType, Object value)
  {
    Map context = new HashMap();
    context.put(EValidator.SubstitutionLabelProvider.class, this);
    context.put(EValidator.class, this);
    BasicDiagnostic diagnostics = 
      new BasicDiagnostic
        (EObjectValidator.DIAGNOSTIC_SOURCE,
         0,
         EcorePlugin.INSTANCE.getString
           ("_UI_DiagnosticRoot_diagnostic", 
            new Object [] { getValueLabel(eDataType, value) }),
         new Object [] { value, eDataType });
    validate(eDataType, value, diagnostics, context);
    return diagnostics;
  }

  public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map context)
  {
    Object eValidator = eValidatorRegistry.get(eDataType.eContainer());
    if (eValidator == null)
    {
      eValidator = eValidatorRegistry.get(null);
    }

    return ((EValidator)eValidator).validate(eDataType, value, diagnostics, context);
  }
}