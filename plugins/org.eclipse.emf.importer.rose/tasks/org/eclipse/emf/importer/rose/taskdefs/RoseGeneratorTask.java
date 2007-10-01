/**
 * <copyright> 
 *
 * Copyright (c) 2004-2005 IBM Corporation and others.
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
 * $Id: RoseGeneratorTask.java,v 1.3 2006/05/10 20:17:46 marcelop Exp $
 */
package org.eclipse.emf.importer.rose.taskdefs;

import org.eclipse.emf.ant.taskdefs.codegen.ecore.GeneratorTask;
import org.eclipse.emf.importer.rose.RoseImporterApplication;


/**
 * <p>
 * Generates source code from models specifed in <b>Rose</b> files.  Exposes some 
 * functionalities available on the {@link org.eclipse.emf.importer.rose.RoseImporterApplication} 
 * class - check its <tt>printUsage()</tt> method for detailed information on the arguments 
 * you can use with this task.
 * </p>
 * <p>
 * This task is supposed to be executed by a Eclipse driver with the 
 * <b>org.eclipse.emf.ant</b> plugin.  It is neither necessary to use Ant's task
 * <tt>TaskDef</tt> to declare this task in a script nor to change the Ant's runtime 
 * classpath.
 * </p>
 * <p>
 * The following command line will start a headless Eclipse instance and run the specified 
 * Ant script.
 * </p>
 * <p>
 * java -classpath <i>eclipseDir</i>/startup.jar org.eclipse.core.launcher.Main
 *      -data <i>worspaceDir</i>
 *      -application org.eclipse.ant.core.antRunner
 *      -buildfile <i>antScript</i>
 * </p>
 * <p>
 * Usage example:
 * </p>
 * <pre>
 * &lt;emf.Rose2Java model=&quot;c:/lib/model/lib.mdl&quot; 
 *                genModel=&quot;c:/lib/emf/lib.genmodel&quot; 
 *                modelProject=&quot;c:/lib&quot; 
 *                modelProjectFragmentPath=&quot;src&quot;&gt;
 *        &lt;arg line=&quot;-package library library library.xmi org.examples Library&quot;/&gt;
 *        &lt;arg line=&quot;-pathMap VABASE_PLUGINS_PATH d:/eclipse/plugins&quot/&gt;
 *  &lt;/emf.Rose2Java&gt;
 * </pre>
 * 
 * @since 2.1.0
 */
public class RoseGeneratorTask extends GeneratorTask
{
  protected boolean supportMultipleURIs()
  {
    return false;
  }
  
  protected void addGenModelArguments()
  {
    super.addGenModelArguments();
    getCommandline().createArgument().setValue("-noQualify");
  }

  protected void createGenModel(String[] arguments) throws Exception
  {
    new RoseImporterApplication().run(getProgressMonitor(), arguments);
  }
}