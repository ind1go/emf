/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.  This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DBPricePackageImpl.java,v 1.3 2007/06/15 21:22:17 emerks Exp $
 */
package org.eclipse.emf.test.models.dbprice.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.emf.test.models.dbitem.DBItemPackage;

import org.eclipse.emf.test.models.dbitem.impl.DBItemPackageImpl;

import org.eclipse.emf.test.models.dbprice.DBPriceFactory;
import org.eclipse.emf.test.models.dbprice.DBPricePackage;
import org.eclipse.emf.test.models.dbprice.PenType;
import org.eclipse.emf.test.models.dbprice.PencilType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DBPricePackageImpl extends EPackageImpl implements DBPricePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pencilTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass penTypeEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.emf.test.models.dbprice.DBPricePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DBPricePackageImpl()
  {
    super(eNS_URI, DBPriceFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DBPricePackage init()
  {
    if (isInited) return (DBPricePackage)EPackage.Registry.INSTANCE.getEPackage(DBPricePackage.eNS_URI);

    // Obtain or create and register package
    DBPricePackageImpl theDBPricePackage = (DBPricePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DBPricePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DBPricePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    DBItemPackageImpl theDBItemPackage = (DBItemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DBItemPackage.eNS_URI) instanceof DBItemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DBItemPackage.eNS_URI) : DBItemPackage.eINSTANCE);

    // Create package meta-data objects
    theDBPricePackage.createPackageContents();
    theDBItemPackage.createPackageContents();

    // Initialize created meta-data
    theDBPricePackage.initializePackageContents();
    theDBItemPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDBPricePackage.freeze();

    return theDBPricePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPencilType()
  {
    return pencilTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPencilType_Price()
  {
    return (EAttribute)pencilTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPenType()
  {
    return penTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPenType_Price()
  {
    return (EAttribute)penTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DBPriceFactory getDBPriceFactory()
  {
    return (DBPriceFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    pencilTypeEClass = createEClass(PENCIL_TYPE);
    createEAttribute(pencilTypeEClass, PENCIL_TYPE__PRICE);

    penTypeEClass = createEClass(PEN_TYPE);
    createEAttribute(penTypeEClass, PEN_TYPE__PRICE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(pencilTypeEClass, PencilType.class, "PencilType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPencilType_Price(), theXMLTypePackage.getInt(), "price", null, 1, 1, PencilType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(penTypeEClass, PenType.class, "PenType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPenType_Price(), theXMLTypePackage.getInt(), "price", null, 1, 1, PenType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
    addAnnotation
      (pencilTypeEClass, 
       source, 
       new String[] 
       {
       "name", "pencilType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getPencilType_Price(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "price"
       });		
    addAnnotation
      (penTypeEClass, 
       source, 
       new String[] 
       {
       "name", "penType",
       "kind", "elementOnly"
       });		
    addAnnotation
      (getPenType_Price(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "price",
       "namespace", "##targetNamespace"
       });
  }

} //DBPricePackageImpl