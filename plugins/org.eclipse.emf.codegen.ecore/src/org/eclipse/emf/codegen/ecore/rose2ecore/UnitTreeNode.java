/**
 * <copyright> 
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: UnitTreeNode.java,v 1.1 2004/03/06 17:31:31 marcelop Exp $
 */
package org.eclipse.emf.codegen.ecore.rose2ecore;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.rose2ecore.parser.RoseNode;
import org.eclipse.emf.common.util.EList;



public class UnitTreeNode 
{
  protected String name;
  protected String quid;
  protected String roseFileName;
  protected String ecoreFileName;
  protected List nodes;
  protected EList extent;
  protected RoseNode roseNode;

  public UnitTreeNode(String name, String quid, String fileName)
  {
    this.name = name;
    this.quid = quid;
    roseFileName = fileName;
    int index = roseFileName.lastIndexOf(".");
    if (index != -1)
    {
      ecoreFileName = roseFileName.substring(0, index + 1) + "ecore";
    }
    else
    {
      ecoreFileName = roseFileName + ".ecore";
    }

    nodes = new ArrayList();
  }

  public RoseNode getRoseNode()
  {
    return roseNode;
  }

  public void setRoseNode(RoseNode roseNode)
  {
    this.roseNode = roseNode;
  }

  public String getRoseFileName() 
  {
     return roseFileName;
  }

  public String getEcoreFileName() 
  {
     return ecoreFileName;
  }

  public String getQUID() 
  {
     return quid;
  }

  public String getName() 
  {
     return name;
  }

  public void setRoseFileName(String roseFileName) 
  {
    this.roseFileName = roseFileName;
  }

  public void setEcoreFileName(String ecoreFileName) 
  {
    this.ecoreFileName = ecoreFileName;
  }

  public void setName(String name) 
  {
    this.name = name;
  }

  public void setQUID(String quid) 
  {
    this.quid = quid;
  }

  public void addNode(UnitTreeNode node) 
  {
    nodes.add(node);
  }

  public List getNodes() 
  {
    return nodes;
  }

  public void setExtent(EList extent) 
  {
    this.extent = extent;
  }

  public EList getExtent() 
  {
    return extent;
  }
}