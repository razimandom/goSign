/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com._42Penguins.gosign.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com._42Penguins.gosign.model.EntDoc;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ent doc service. This utility wraps {@link com._42Penguins.gosign.service.persistence.impl.EntDocPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Raziman Dom
 * @see EntDocPersistence
 * @see com._42Penguins.gosign.service.persistence.impl.EntDocPersistenceImpl
 * @generated
 */
@ProviderType
public class EntDocUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EntDoc entDoc) {
		getPersistence().clearCache(entDoc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EntDoc> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EntDoc> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EntDoc> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EntDoc update(EntDoc entDoc) {
		return getPersistence().update(entDoc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EntDoc update(EntDoc entDoc, ServiceContext serviceContext) {
		return getPersistence().update(entDoc, serviceContext);
	}

	/**
	* Returns all the ent docs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching ent docs
	*/
	public static List<EntDoc> findByFindUserId(long userId) {
		return getPersistence().findByFindUserId(userId);
	}

	/**
	* Returns a range of all the ent docs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @return the range of matching ent docs
	*/
	public static List<EntDoc> findByFindUserId(long userId, int start, int end) {
		return getPersistence().findByFindUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the ent docs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ent docs
	*/
	public static List<EntDoc> findByFindUserId(long userId, int start,
		int end, OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence()
				   .findByFindUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ent docs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ent docs
	*/
	public static List<EntDoc> findByFindUserId(long userId, int start,
		int end, OrderByComparator<EntDoc> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFindUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first ent doc in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ent doc
	* @throws NoSuchEntDocException if a matching ent doc could not be found
	*/
	public static EntDoc findByFindUserId_First(long userId,
		OrderByComparator<EntDoc> orderByComparator)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence().findByFindUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first ent doc in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ent doc, or <code>null</code> if a matching ent doc could not be found
	*/
	public static EntDoc fetchByFindUserId_First(long userId,
		OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence()
				   .fetchByFindUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last ent doc in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ent doc
	* @throws NoSuchEntDocException if a matching ent doc could not be found
	*/
	public static EntDoc findByFindUserId_Last(long userId,
		OrderByComparator<EntDoc> orderByComparator)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence().findByFindUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last ent doc in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ent doc, or <code>null</code> if a matching ent doc could not be found
	*/
	public static EntDoc fetchByFindUserId_Last(long userId,
		OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence().fetchByFindUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the ent docs before and after the current ent doc in the ordered set where userId = &#63;.
	*
	* @param docId the primary key of the current ent doc
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ent doc
	* @throws NoSuchEntDocException if a ent doc with the primary key could not be found
	*/
	public static EntDoc[] findByFindUserId_PrevAndNext(long docId,
		long userId, OrderByComparator<EntDoc> orderByComparator)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence()
				   .findByFindUserId_PrevAndNext(docId, userId,
			orderByComparator);
	}

	/**
	* Removes all the ent docs where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByFindUserId(long userId) {
		getPersistence().removeByFindUserId(userId);
	}

	/**
	* Returns the number of ent docs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching ent docs
	*/
	public static int countByFindUserId(long userId) {
		return getPersistence().countByFindUserId(userId);
	}

	/**
	* Returns all the ent docs where sign_email = &#63;.
	*
	* @param sign_email the sign_email
	* @return the matching ent docs
	*/
	public static List<EntDoc> findByFindSignEmail(java.lang.String sign_email) {
		return getPersistence().findByFindSignEmail(sign_email);
	}

	/**
	* Returns a range of all the ent docs where sign_email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sign_email the sign_email
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @return the range of matching ent docs
	*/
	public static List<EntDoc> findByFindSignEmail(
		java.lang.String sign_email, int start, int end) {
		return getPersistence().findByFindSignEmail(sign_email, start, end);
	}

	/**
	* Returns an ordered range of all the ent docs where sign_email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sign_email the sign_email
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ent docs
	*/
	public static List<EntDoc> findByFindSignEmail(
		java.lang.String sign_email, int start, int end,
		OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence()
				   .findByFindSignEmail(sign_email, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the ent docs where sign_email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sign_email the sign_email
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ent docs
	*/
	public static List<EntDoc> findByFindSignEmail(
		java.lang.String sign_email, int start, int end,
		OrderByComparator<EntDoc> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByFindSignEmail(sign_email, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first ent doc in the ordered set where sign_email = &#63;.
	*
	* @param sign_email the sign_email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ent doc
	* @throws NoSuchEntDocException if a matching ent doc could not be found
	*/
	public static EntDoc findByFindSignEmail_First(
		java.lang.String sign_email, OrderByComparator<EntDoc> orderByComparator)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence()
				   .findByFindSignEmail_First(sign_email, orderByComparator);
	}

	/**
	* Returns the first ent doc in the ordered set where sign_email = &#63;.
	*
	* @param sign_email the sign_email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ent doc, or <code>null</code> if a matching ent doc could not be found
	*/
	public static EntDoc fetchByFindSignEmail_First(
		java.lang.String sign_email, OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence()
				   .fetchByFindSignEmail_First(sign_email, orderByComparator);
	}

	/**
	* Returns the last ent doc in the ordered set where sign_email = &#63;.
	*
	* @param sign_email the sign_email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ent doc
	* @throws NoSuchEntDocException if a matching ent doc could not be found
	*/
	public static EntDoc findByFindSignEmail_Last(java.lang.String sign_email,
		OrderByComparator<EntDoc> orderByComparator)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence()
				   .findByFindSignEmail_Last(sign_email, orderByComparator);
	}

	/**
	* Returns the last ent doc in the ordered set where sign_email = &#63;.
	*
	* @param sign_email the sign_email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ent doc, or <code>null</code> if a matching ent doc could not be found
	*/
	public static EntDoc fetchByFindSignEmail_Last(
		java.lang.String sign_email, OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence()
				   .fetchByFindSignEmail_Last(sign_email, orderByComparator);
	}

	/**
	* Returns the ent docs before and after the current ent doc in the ordered set where sign_email = &#63;.
	*
	* @param docId the primary key of the current ent doc
	* @param sign_email the sign_email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ent doc
	* @throws NoSuchEntDocException if a ent doc with the primary key could not be found
	*/
	public static EntDoc[] findByFindSignEmail_PrevAndNext(long docId,
		java.lang.String sign_email, OrderByComparator<EntDoc> orderByComparator)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence()
				   .findByFindSignEmail_PrevAndNext(docId, sign_email,
			orderByComparator);
	}

	/**
	* Removes all the ent docs where sign_email = &#63; from the database.
	*
	* @param sign_email the sign_email
	*/
	public static void removeByFindSignEmail(java.lang.String sign_email) {
		getPersistence().removeByFindSignEmail(sign_email);
	}

	/**
	* Returns the number of ent docs where sign_email = &#63;.
	*
	* @param sign_email the sign_email
	* @return the number of matching ent docs
	*/
	public static int countByFindSignEmail(java.lang.String sign_email) {
		return getPersistence().countByFindSignEmail(sign_email);
	}

	/**
	* Caches the ent doc in the entity cache if it is enabled.
	*
	* @param entDoc the ent doc
	*/
	public static void cacheResult(EntDoc entDoc) {
		getPersistence().cacheResult(entDoc);
	}

	/**
	* Caches the ent docs in the entity cache if it is enabled.
	*
	* @param entDocs the ent docs
	*/
	public static void cacheResult(List<EntDoc> entDocs) {
		getPersistence().cacheResult(entDocs);
	}

	/**
	* Creates a new ent doc with the primary key. Does not add the ent doc to the database.
	*
	* @param docId the primary key for the new ent doc
	* @return the new ent doc
	*/
	public static EntDoc create(long docId) {
		return getPersistence().create(docId);
	}

	/**
	* Removes the ent doc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param docId the primary key of the ent doc
	* @return the ent doc that was removed
	* @throws NoSuchEntDocException if a ent doc with the primary key could not be found
	*/
	public static EntDoc remove(long docId)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence().remove(docId);
	}

	public static EntDoc updateImpl(EntDoc entDoc) {
		return getPersistence().updateImpl(entDoc);
	}

	/**
	* Returns the ent doc with the primary key or throws a {@link NoSuchEntDocException} if it could not be found.
	*
	* @param docId the primary key of the ent doc
	* @return the ent doc
	* @throws NoSuchEntDocException if a ent doc with the primary key could not be found
	*/
	public static EntDoc findByPrimaryKey(long docId)
		throws com._42Penguins.gosign.exception.NoSuchEntDocException {
		return getPersistence().findByPrimaryKey(docId);
	}

	/**
	* Returns the ent doc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param docId the primary key of the ent doc
	* @return the ent doc, or <code>null</code> if a ent doc with the primary key could not be found
	*/
	public static EntDoc fetchByPrimaryKey(long docId) {
		return getPersistence().fetchByPrimaryKey(docId);
	}

	public static java.util.Map<java.io.Serializable, EntDoc> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ent docs.
	*
	* @return the ent docs
	*/
	public static List<EntDoc> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ent docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @return the range of ent docs
	*/
	public static List<EntDoc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ent docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ent docs
	*/
	public static List<EntDoc> findAll(int start, int end,
		OrderByComparator<EntDoc> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ent docs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntDocModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ent docs
	* @param end the upper bound of the range of ent docs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ent docs
	*/
	public static List<EntDoc> findAll(int start, int end,
		OrderByComparator<EntDoc> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ent docs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ent docs.
	*
	* @return the number of ent docs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EntDocPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EntDocPersistence, EntDocPersistence> _serviceTracker =
		ServiceTrackerFactory.open(EntDocPersistence.class);
}