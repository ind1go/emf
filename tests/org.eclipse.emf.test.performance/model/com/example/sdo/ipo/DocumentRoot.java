/**
 * <copyright>
 * </copyright>
 *
 * $Id: DocumentRoot.java,v 1.1.2.1 2005/05/30 19:29:31 nickb Exp $
 */
package com.example.sdo.ipo;

import commonj.sdo.Sequence;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.example.sdo.ipo.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.example.sdo.ipo.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.example.sdo.ipo.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.example.sdo.ipo.DocumentRoot#getComment <em>Comment</em>}</li>
 *   <li>{@link com.example.sdo.ipo.DocumentRoot#getPurchaseOrder <em>Purchase Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.example.sdo.ipo.IpoPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @see com.example.sdo.ipo.IpoPackage#getDocumentRoot_Mixed()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='elementWildcard' name=':mixed'"
   * @generated
   */
  Sequence getMixed();

  /**
   * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>XMLNS Prefix Map</em>' map.
   * @see com.example.sdo.ipo.IpoPackage#getDocumentRoot_XMLNSPrefixMap()
   * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
   *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
   * @generated
   */
  Map getXMLNSPrefixMap();

  /**
   * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
   * The key is of type {@link java.lang.String},
   * and the value is of type {@link java.lang.String},
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>XSI Schema Location</em>' map.
   * @see com.example.sdo.ipo.IpoPackage#getDocumentRoot_XSISchemaLocation()
   * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
   *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
   * @generated
   */
  Map getXSISchemaLocation();

  /**
   * Returns the value of the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' attribute.
   * @see #setComment(String)
   * @see com.example.sdo.ipo.IpoPackage#getDocumentRoot_Comment()
   * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='comment' namespace='##targetNamespace'"
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link com.example.sdo.ipo.DocumentRoot#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

  /**
   * Returns the value of the '<em><b>Purchase Order</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Purchase Order</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Purchase Order</em>' containment reference.
   * @see #setPurchaseOrder(PurchaseOrderType)
   * @see com.example.sdo.ipo.IpoPackage#getDocumentRoot_PurchaseOrder()
   * @model containment="true" resolveProxies="false" upper="-2" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='purchaseOrder' namespace='##targetNamespace'"
   * @generated
   */
  PurchaseOrderType getPurchaseOrder();

  /**
   * Sets the value of the '{@link com.example.sdo.ipo.DocumentRoot#getPurchaseOrder <em>Purchase Order</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Purchase Order</em>' containment reference.
   * @see #getPurchaseOrder()
   * @generated
   */
  void setPurchaseOrder(PurchaseOrderType value);

} // DocumentRoot