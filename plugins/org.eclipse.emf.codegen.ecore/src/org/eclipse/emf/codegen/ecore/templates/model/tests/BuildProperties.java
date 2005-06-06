package org.eclipse.emf.codegen.ecore.templates.model.tests;

import org.eclipse.emf.codegen.ecore.genmodel.*;

public class BuildProperties
{
  protected static String nl;
  public static synchronized BuildProperties create(String lineSeparator)
  {
    nl = lineSeparator;
    BuildProperties result = new BuildProperties();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!--";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "/**" + NL + " * <copyright>" + NL + " * </copyright>" + NL + " *" + NL + " * ";
  protected final String TEXT_4 = "Id";
  protected final String TEXT_5 = NL + " */" + NL + "-->";
  protected final String TEXT_6 = NL + "bin.includes = plugin.xml,\\";
  protected final String TEXT_7 = NL + "               ";
  protected final String TEXT_8 = ",\\";
  protected final String TEXT_9 = NL + "               META-INF/,\\";
  protected final String TEXT_10 = NL + "               plugin.properties" + NL + "jars.compile.order = ";
  protected final String TEXT_11 = NL + "source.";
  protected final String TEXT_12 = " = src/" + NL + "output.";
  protected final String TEXT_13 = " = bin/" + NL + "exclude.";
  protected final String TEXT_14 = " = **/doc-files/**";
  protected final String TEXT_15 = NL + "bin.includes = plugin.xml,\\";
  protected final String TEXT_16 = NL + "               META-INF/,\\";
  protected final String TEXT_17 = NL + "               plugin.properties";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

    GenModel genModel = (GenModel)argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_4);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_5);
    if (genModel.isRuntimeJar()) {
    String jarFile = genModel.getTestsPluginID()+".jar";
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_8);
    if (genModel.isBundleManifest()) {
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(jarFile);
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    if (genModel.isBundleManifest()) {
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
