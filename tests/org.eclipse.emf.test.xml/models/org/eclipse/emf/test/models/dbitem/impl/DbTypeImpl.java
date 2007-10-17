/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.test.models.dbitem.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.test.models.dbitem.DbType;
import org.eclipse.emf.test.models.dbitem.DbitemPackage;

import org.eclipse.emf.test.models.dbprice.PenType;
import org.eclipse.emf.test.models.dbprice.PencilType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Db Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.test.models.dbitem.impl.DbTypeImpl#getRedPen <em>Red Pen</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.dbitem.impl.DbTypeImpl#getBluePen <em>Blue Pen</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.dbitem.impl.DbTypeImpl#getRedPencil <em>Red Pencil</em>}</li>
 *   <li>{@link org.eclipse.emf.test.models.dbitem.impl.DbTypeImpl#getBluePencil <em>Blue Pencil</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DbTypeImpl extends EObjectImpl implements DbType
{
  /**
   * The cached value of the '{@link #getRedPen() <em>Red Pen</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedPen()
   * @generated
   * @ordered
   */
  protected PenType redPen = null;

  /**
   * The cached value of the '{@link #getBluePen() <em>Blue Pen</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBluePen()
   * @generated
   * @ordered
   */
  protected PenType bluePen = null;

  /**
   * The cached value of the '{@link #getRedPencil() <em>Red Pencil</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRedPencil()
   * @generated
   * @ordered
   */
  protected PencilType redPencil = null;

  /**
   * The cached value of the '{@link #getBluePencil() <em>Blue Pencil</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBluePencil()
   * @generated
   * @ordered
   */
  protected PencilType bluePencil = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DbTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EClass eStaticClass()
  {
    return DbitemPackage.eINSTANCE.getDbType();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PenType getRedPen()
  {
    return redPen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRedPen(PenType newRedPen, NotificationChain msgs)
  {
    PenType oldRedPen = redPen;
    redPen = newRedPen;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__RED_PEN, oldRedPen, newRedPen);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedPen(PenType newRedPen)
  {
    if (newRedPen != redPen)
    {
      NotificationChain msgs = null;
      if (redPen != null)
        msgs = ((InternalEObject)redPen).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__RED_PEN, null, msgs);
      if (newRedPen != null)
        msgs = ((InternalEObject)newRedPen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__RED_PEN, null, msgs);
      msgs = basicSetRedPen(newRedPen, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__RED_PEN, newRedPen, newRedPen));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PenType getBluePen()
  {
    return bluePen;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBluePen(PenType newBluePen, NotificationChain msgs)
  {
    PenType oldBluePen = bluePen;
    bluePen = newBluePen;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__BLUE_PEN, oldBluePen, newBluePen);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBluePen(PenType newBluePen)
  {
    if (newBluePen != bluePen)
    {
      NotificationChain msgs = null;
      if (bluePen != null)
        msgs = ((InternalEObject)bluePen).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__BLUE_PEN, null, msgs);
      if (newBluePen != null)
        msgs = ((InternalEObject)newBluePen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__BLUE_PEN, null, msgs);
      msgs = basicSetBluePen(newBluePen, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__BLUE_PEN, newBluePen, newBluePen));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PencilType getRedPencil()
  {
    return redPencil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRedPencil(PencilType newRedPencil, NotificationChain msgs)
  {
    PencilType oldRedPencil = redPencil;
    redPencil = newRedPencil;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__RED_PENCIL, oldRedPencil, newRedPencil);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRedPencil(PencilType newRedPencil)
  {
    if (newRedPencil != redPencil)
    {
      NotificationChain msgs = null;
      if (redPencil != null)
        msgs = ((InternalEObject)redPencil).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__RED_PENCIL, null, msgs);
      if (newRedPencil != null)
        msgs = ((InternalEObject)newRedPencil).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__RED_PENCIL, null, msgs);
      msgs = basicSetRedPencil(newRedPencil, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__RED_PENCIL, newRedPencil, newRedPencil));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PencilType getBluePencil()
  {
    return bluePencil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBluePencil(PencilType newBluePencil, NotificationChain msgs)
  {
    PencilType oldBluePencil = bluePencil;
    bluePencil = newBluePencil;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__BLUE_PENCIL, oldBluePencil, newBluePencil);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBluePencil(PencilType newBluePencil)
  {
    if (newBluePencil != bluePencil)
    {
      NotificationChain msgs = null;
      if (bluePencil != null)
        msgs = ((InternalEObject)bluePencil).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__BLUE_PENCIL, null, msgs);
      if (newBluePencil != null)
        msgs = ((InternalEObject)newBluePencil).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DbitemPackage.DB_TYPE__BLUE_PENCIL, null, msgs);
      msgs = basicSetBluePencil(newBluePencil, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbitemPackage.DB_TYPE__BLUE_PENCIL, newBluePencil, newBluePencil));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs)
  {
    if (featureID >= 0)
    {
      switch (eDerivedStructuralFeatureID(featureID, baseClass))
      {
        case DbitemPackage.DB_TYPE__RED_PEN:
          return basicSetRedPen(null, msgs);
        case DbitemPackage.DB_TYPE__BLUE_PEN:
          return basicSetBluePen(null, msgs);
        case DbitemPackage.DB_TYPE__RED_PENCIL:
          return basicSetRedPencil(null, msgs);
        case DbitemPackage.DB_TYPE__BLUE_PENCIL:
          return basicSetBluePencil(null, msgs);
        default:
          return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
      }
    }
    return eBasicSetContainer(null, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object eGet(EStructuralFeature eFeature, boolean resolve)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case DbitemPackage.DB_TYPE__RED_PEN:
        return getRedPen();
      case DbitemPackage.DB_TYPE__BLUE_PEN:
        return getBluePen();
      case DbitemPackage.DB_TYPE__RED_PENCIL:
        return getRedPencil();
      case DbitemPackage.DB_TYPE__BLUE_PENCIL:
        return getBluePencil();
    }
    return eDynamicGet(eFeature, resolve);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eSet(EStructuralFeature eFeature, Object newValue)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case DbitemPackage.DB_TYPE__RED_PEN:
        setRedPen((PenType)newValue);
        return;
      case DbitemPackage.DB_TYPE__BLUE_PEN:
        setBluePen((PenType)newValue);
        return;
      case DbitemPackage.DB_TYPE__RED_PENCIL:
        setRedPencil((PencilType)newValue);
        return;
      case DbitemPackage.DB_TYPE__BLUE_PENCIL:
        setBluePencil((PencilType)newValue);
        return;
    }
    eDynamicSet(eFeature, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void eUnset(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case DbitemPackage.DB_TYPE__RED_PEN:
        setRedPen((PenType)null);
        return;
      case DbitemPackage.DB_TYPE__BLUE_PEN:
        setBluePen((PenType)null);
        return;
      case DbitemPackage.DB_TYPE__RED_PENCIL:
        setRedPencil((PencilType)null);
        return;
      case DbitemPackage.DB_TYPE__BLUE_PENCIL:
        setBluePencil((PencilType)null);
        return;
    }
    eDynamicUnset(eFeature);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean eIsSet(EStructuralFeature eFeature)
  {
    switch (eDerivedStructuralFeatureID(eFeature))
    {
      case DbitemPackage.DB_TYPE__RED_PEN:
        return redPen != null;
      case DbitemPackage.DB_TYPE__BLUE_PEN:
        return bluePen != null;
      case DbitemPackage.DB_TYPE__RED_PENCIL:
        return redPencil != null;
      case DbitemPackage.DB_TYPE__BLUE_PENCIL:
        return bluePencil != null;
    }
    return eDynamicIsSet(eFeature);
  }

} //DbTypeImpl