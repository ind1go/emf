/**
 * <copyright>
 * </copyright>
 *
 * $Id: DbAdapterFactory.java,v 1.1 2005/02/08 20:54:12 marcelop Exp $
 */
package org.eclipse.emf.test.models.movie.db.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.test.models.movie.db.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.test.models.movie.db.DbPackage
 * @generated
 */
public class DbAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DbPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DbAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = DbPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch the delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DbSwitch modelSwitch =
    new DbSwitch()
    {
      public Object caseCriticsReviewType(CriticsReviewType object)
      {
        return createCriticsReviewTypeAdapter();
      }
      public Object caseCustomerReviewType(CustomerReviewType object)
      {
        return createCustomerReviewTypeAdapter();
      }
      public Object caseDocumentRoot(DocumentRoot object)
      {
        return createDocumentRootAdapter();
      }
      public Object caseMovieDBType(MovieDBType object)
      {
        return createMovieDBTypeAdapter();
      }
      public Object caseMovieType(MovieType object)
      {
        return createMovieTypeAdapter();
      }
      public Object defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  public Adapter createAdapter(Notifier target)
  {
    return (Adapter)modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.test.models.movie.db.CriticsReviewType <em>Critics Review Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.test.models.movie.db.CriticsReviewType
   * @generated
   */
  public Adapter createCriticsReviewTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.test.models.movie.db.CustomerReviewType <em>Customer Review Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.test.models.movie.db.CustomerReviewType
   * @generated
   */
  public Adapter createCustomerReviewTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.test.models.movie.db.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.test.models.movie.db.DocumentRoot
   * @generated
   */
  public Adapter createDocumentRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.test.models.movie.db.MovieDBType <em>Movie DB Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.test.models.movie.db.MovieDBType
   * @generated
   */
  public Adapter createMovieDBTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.test.models.movie.db.MovieType <em>Movie Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.test.models.movie.db.MovieType
   * @generated
   */
  public Adapter createMovieTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //DbAdapterFactory