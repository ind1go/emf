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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "# <copyright>" + NL + "# </copyright>" + NL + "#" + NL + "# ";
  protected final String TEXT_3 = "Id";
  protected final String TEXT_4 = NL + NL + "bin.includes = ";
  protected final String TEXT_5 = ",\\";
  protected final String TEXT_6 = NL + "               META-INF/,\\";
  protected final String TEXT_7 = NL + "               plugin.xml,\\" + NL + "               plugin.properties" + NL + "jars.compile.order = ";
  protected final String TEXT_8 = NL + "source.";
  protected final String TEXT_9 = " = src/" + NL + "output.";
  protected final String TEXT_10 = " = bin/";

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

    GenModel genModel = (GenModel)argument;
    String pluginClassesLocation = genModel.isRuntimeJar() ? genModel.getTestsPluginID()+".jar" : ".";
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_3);
    stringBuffer.append("$");
    stringBuffer.append(TEXT_4);
    stringBuffer.append(pluginClassesLocation);
    stringBuffer.append(TEXT_5);
    if (genModel.isBundleManifest()) {
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(pluginClassesLocation);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(pluginClassesLocation);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pluginClassesLocation);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}