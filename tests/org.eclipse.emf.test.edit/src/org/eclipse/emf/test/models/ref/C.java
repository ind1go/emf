/**
 * <copyright>
 * </copyright>
 *
 * $Id: C.java,v 1.1.4.1 2005/08/05 20:42:43 nickb Exp $
 */
package org.eclipse.emf.test.models.ref;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.test.models.ref.C#getD <em>D</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.ref.C#getC4 <em>C4</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.test.models.ref.RefPackage#getC()
 * @model
 * @generated
 */
public interface C extends EObject
{
  /**
   * Returns the value of the '<em><b>D</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.test.models.ref.D}.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.test.models.ref.D#getC <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>D</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>D</em>' reference list.
   * @see org.eclipse.emf.test.models.ref.RefPackage#getC_D()
   * @see org.eclipse.emf.test.models.ref.D#getC
   * @model type="org.eclipse.emf.test.models.ref.D" opposite="c"
   * @generated
   */
  EList getD();

  /**
   * Returns the value of the '<em><b>C4</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.emf.test.models.ref.C4#getC <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>C4</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>C4</em>' container reference.
   * @see #setC4(C4)
   * @see org.eclipse.emf.test.models.ref.RefPackage#getC_C4()
   * @see org.eclipse.emf.test.models.ref.C4#getC
   * @model opposite="c" required="true"
   * @generated
   */
  C4 getC4();

  /**
   * Sets the value of the '{@link org.eclipse.emf.test.models.ref.C#getC4 <em>C4</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>C4</em>' container reference.
   * @see #getC4()
   * @generated
   */
  void setC4(C4 value);

} // C