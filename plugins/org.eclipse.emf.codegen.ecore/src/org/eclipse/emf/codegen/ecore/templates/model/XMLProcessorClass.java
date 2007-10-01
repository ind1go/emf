package org.eclipse.emf.codegen.ecore.templates.model;

import org.eclipse.emf.codegen.ecore.genmodel.*;

public class XMLProcessorClass
{
  protected static String nl;
  public static synchronized XMLProcessorClass create(String lineSeparator)
  {
    nl = lineSeparator;
    XMLProcessorClass result = new XMLProcessorClass();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "/**" + NL + " * <copyright>" + NL + " * </copyright>" + NL + " *" + NL + " * ";
  protected final String TEXT_3 = "Id";
  protected final String TEXT_4 = NL + " */" + NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * This class contains helper methods to serialize and deserialize XML documents" + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends ";
  protected final String TEXT_8 = NL + "{";
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_10 = " copyright = \"";
  protected final String TEXT_11 = "\";";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + NL + "\t/**" + NL + "\t * Public constructor to instantiate the helper." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_14 = "()" + NL + "\t{";
  protected final String TEXT_15 = NL + "\t\tsuper(new ";
  protected final String TEXT_16 = "(";
  protected final String TEXT_17 = ".Registry.INSTANCE));" + NL + "\t\textendedMetaData.putPackage(null, ";
  protected final String TEXT_18 = ".eINSTANCE);";
  protected final String TEXT_19 = NL + "\t\tsuper((";
  protected final String TEXT_20 = ".Registry.INSTANCE));" + NL + "\t\t";
  protected final String TEXT_21 = ".eINSTANCE.eClass();";
  protected final String TEXT_22 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Register for \"*\" and \"xml\" file extensions the ";
  protected final String TEXT_23 = " factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Map getRegistrations()" + NL + "\t{" + NL + "\t\tif (registrations == null)" + NL + "\t\t{" + NL + "\t\t\tsuper.getRegistrations();" + NL + "\t\t\tregistrations.put(XML_EXTENSION, new ";
  protected final String TEXT_24 = "());" + NL + "\t\t\tregistrations.put(STAR_EXTENSION, new ";
  protected final String TEXT_25 = "());" + NL + "\t\t}" + NL + "\t\treturn registrations;" + NL + "\t}" + NL + "" + NL + "} //";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others. 
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

    GenPackage genPackage = (GenPackage)argument; GenModel genModel=genPackage.getGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPackage.getUtilitiesPackageName());
    stringBuffer.append(TEXT_5);
    genModel.getImportedName("java.util.Map");
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genPackage.getXMLProcessorClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genPackage.getImportedXMLProcessorBaseClassName());
    stringBuffer.append(TEXT_8);
    if (genModel.getCopyrightText() != null) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genModel.getCopyrightText());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genPackage.getXMLProcessorClassName());
    stringBuffer.append(TEXT_14);
    if (genPackage.hasExtendedMetaData() && !genPackage.hasTargetNamespace()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.EPackageRegistryImpl"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_18);
    } else {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genPackage.getResourceFactoryClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genPackage.getResourceFactoryClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genPackage.getResourceFactoryClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genPackage.getXMLProcessorClassName());
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}