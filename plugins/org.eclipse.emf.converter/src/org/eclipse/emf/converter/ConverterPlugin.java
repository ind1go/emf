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
 *
 * $Id: ConverterPlugin.java,v 1.2 2006/06/01 13:24:26 davidms Exp $
 */
package org.eclipse.emf.converter;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;


/**
 * The <b>Plugin</b> for the model converter.
 * @since 2.2.0
 */
public final class ConverterPlugin extends EMFPlugin
{
  /**
   * The singleton instance of the plugin.
   */
  public static final ConverterPlugin INSTANCE = new ConverterPlugin();

  /**
   * The one instance of this class.
   */
  private static Implementation plugin;
  
  public static final String ID = "org.eclipse.emf.converter";

  /**
   * Creates the singleton instance.
   */
  private ConverterPlugin()
  {
    super
      (new ResourceLocator []
       {
         
       });
  }

  /*
   * Javadoc copied from base class.
   */
  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin.
   * @return the singleton instance.
   */
  public static Implementation getPlugin()
  {
    return plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   */
  public static class Implementation extends EclipsePlugin
  {
    /**
     * Creates an instance.
     */
    public Implementation()
    {
      super();

      // Remember the static instance.
      //
      plugin = this;
    }
  }
}