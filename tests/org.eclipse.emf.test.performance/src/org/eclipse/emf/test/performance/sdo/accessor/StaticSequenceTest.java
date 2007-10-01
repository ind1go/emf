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
 * $Id: StaticSequenceTest.java,v 1.20 2005/07/06 15:44:55 bportier Exp $
 */
package org.eclipse.emf.test.performance.sdo.accessor;


import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.ecore.sdo.EProperty;

import com.example.sdo.epo.PurchaseOrder;
import com.example.sdo.epo.Supplier;
import commonj.sdo.DataObject;
import commonj.sdo.Property;
import commonj.sdo.Sequence;


/**
 * Uses EMF and SDO APIs to get values of instances of a static Extended Purchase Order (EPO) model with derived features. 
 */
public class StaticSequenceTest extends DynamicSequenceTest
{

  public StaticSequenceTest(String name)
  {
    super(name);
  }

  public static Test suite()
  {
    TestSuite testSuite = new TestSuite();

    testSuite.addTest(new StaticSequenceTest("getSequenceByGenerated").setWarmUp(1).setRepetitions(REPETITIONS));
    testSuite.addTest(new StaticSequenceTest("getDerivedByGenerated").setWarmUp(1).setRepetitions(REPETITIONS));

    testSuite.addTest(new StaticSequenceTest("getSequenceWithEGet").setWarmUp(1).setRepetitions(REPETITIONS));
    testSuite.addTest(new StaticSequenceTest("getDerivedWithEGet").setWarmUp(1).setRepetitions(REPETITIONS));

    testSuite.addTest(new StaticSequenceTest("getSequence").setWarmUp(1).setRepetitions(REPETITIONS));
    testSuite.addTest(new StaticSequenceTest("getDerived").setWarmUp(1).setRepetitions(70));

    testSuite.addTest(new StaticSequenceTest("contains").setWarmUp(1).setRepetitions(REPETITIONS));

    return testSuite;
  }

  protected void setUp() throws Exception
  {
    super.setUp();
  }

  protected void supplierSetup()
  {
    initSupplier();
    initModel();
  }

  protected void initSupplier()
  {
    Supplier supplier = epoFactoryInstance.createSupplier();
    this.supplier = (DataObject)supplier;
    supplier.setName("The Supplier");

    PurchaseOrder po;
    for (int i = 0; i < 10; i++)
    {
      po = epoFactoryInstance.createPurchaseOrder();
      po.setComment("priority" + i);
      supplier.getPriorityOrders().add(po);
    }

    for (int i = 0; i < 10; i++)
    {
      po = epoFactoryInstance.createPurchaseOrder();
      po.setComment("standard" + i);
      supplier.getStandardOrders().add(po);
    }
  }

  private void initModel()
  {
    List properties = supplier.getType().getProperties();
    ordersProp = (Property)properties.get(1);
    ordersFeat = ((EProperty)ordersProp).getEStructuralFeature();
    priorityOrdersProp = (Property)properties.get(2);
    priorityOrdersFeat = ((EProperty)priorityOrdersProp).getEStructuralFeature();
    standardOrdersProp = (Property)properties.get(3);
    standardOrdersFeat = ((EProperty)standardOrdersProp).getEStructuralFeature();
  }

  /**
   * <p>
   * Uses the SDO generated API to get the value of a Sequence from a DataObject whose model has been statically created.
   * Test details:
   * <ul>
   * <li>get/set: get</li>
   * <li>type: Sequence</li>
   * <li>model generation: static</li>
   * <li>access API: generated</li>
   * </ul>
   * </p>
   */
  public void getSequenceByGenerated()
  {
    Supplier supplier = (Supplier)this.supplier;
    Sequence ordersValue = this.sequenceValue;

    startMeasuring();
    for (int i = 0; i < ITERATIONS_1000K; i++)
    {
      if (ordersValue != this)
      {
        ordersValue = supplier.getOrders();
      }
    }
    stopMeasuring();
  }

  /**
   * <p>
   * Uses the SDO generated API to get the value of a derived property/feature from a DataObject whose model has been statically created.
   * Test details:
   * <ul>
   * <li>get/set: get</li>
   * <li>type: List</li>
   * <li>model generation: static</li>
   * <li>access API: generated</li>
   * </ul>
   * </p>
   */
  public void getDerivedByGenerated()
  {
    Supplier supplier = (Supplier)this.supplier;
    List derivedValue = this.derivedValue;

    startMeasuring();
    for (int i = 0; i < ITERATIONS_100K; i++)
    {
      if (derivedValue != this)
      {
        derivedValue = supplier.getPriorityOrders();
        derivedValue = supplier.getStandardOrders();
      }
    }
    stopMeasuring();
  }

}