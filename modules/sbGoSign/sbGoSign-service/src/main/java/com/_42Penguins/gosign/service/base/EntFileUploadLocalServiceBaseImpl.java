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

package com._42Penguins.gosign.service.base;

import aQute.bnd.annotation.ProviderType;

import com._42Penguins.gosign.model.EntFileUpload;
import com._42Penguins.gosign.model.EntFileUploadFile_blobBlobModel;
import com._42Penguins.gosign.service.EntFileUploadLocalService;
import com._42Penguins.gosign.service.persistence.EntDocPersistence;
import com._42Penguins.gosign.service.persistence.EntFileUploadPersistence;
import com._42Penguins.gosign.service.persistence.EntKeyPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ent file upload local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com._42Penguins.gosign.service.impl.EntFileUploadLocalServiceImpl}.
 * </p>
 *
 * @author Raziman Dom
 * @see com._42Penguins.gosign.service.impl.EntFileUploadLocalServiceImpl
 * @see com._42Penguins.gosign.service.EntFileUploadLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class EntFileUploadLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements EntFileUploadLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com._42Penguins.gosign.service.EntFileUploadLocalServiceUtil} to access the ent file upload local service.
	 */

	/**
	 * Adds the ent file upload to the database. Also notifies the appropriate model listeners.
	 *
	 * @param entFileUpload the ent file upload
	 * @return the ent file upload that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EntFileUpload addEntFileUpload(EntFileUpload entFileUpload) {
		entFileUpload.setNew(true);

		return entFileUploadPersistence.update(entFileUpload);
	}

	/**
	 * Creates a new ent file upload with the primary key. Does not add the ent file upload to the database.
	 *
	 * @param fileId the primary key for the new ent file upload
	 * @return the new ent file upload
	 */
	@Override
	public EntFileUpload createEntFileUpload(long fileId) {
		return entFileUploadPersistence.create(fileId);
	}

	/**
	 * Deletes the ent file upload with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileId the primary key of the ent file upload
	 * @return the ent file upload that was removed
	 * @throws PortalException if a ent file upload with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EntFileUpload deleteEntFileUpload(long fileId)
		throws PortalException {
		return entFileUploadPersistence.remove(fileId);
	}

	/**
	 * Deletes the ent file upload from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entFileUpload the ent file upload
	 * @return the ent file upload that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EntFileUpload deleteEntFileUpload(EntFileUpload entFileUpload) {
		return entFileUploadPersistence.remove(entFileUpload);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(EntFileUpload.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return entFileUploadPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com._42Penguins.gosign.model.impl.EntFileUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return entFileUploadPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com._42Penguins.gosign.model.impl.EntFileUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return entFileUploadPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return entFileUploadPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return entFileUploadPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public EntFileUpload fetchEntFileUpload(long fileId) {
		return entFileUploadPersistence.fetchByPrimaryKey(fileId);
	}

	/**
	 * Returns the ent file upload with the primary key.
	 *
	 * @param fileId the primary key of the ent file upload
	 * @return the ent file upload
	 * @throws PortalException if a ent file upload with the primary key could not be found
	 */
	@Override
	public EntFileUpload getEntFileUpload(long fileId)
		throws PortalException {
		return entFileUploadPersistence.findByPrimaryKey(fileId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(entFileUploadLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EntFileUpload.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("fileId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(entFileUploadLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(EntFileUpload.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("fileId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(entFileUploadLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(EntFileUpload.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("fileId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return entFileUploadLocalService.deleteEntFileUpload((EntFileUpload)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return entFileUploadPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ent file uploads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com._42Penguins.gosign.model.impl.EntFileUploadModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ent file uploads
	 * @param end the upper bound of the range of ent file uploads (not inclusive)
	 * @return the range of ent file uploads
	 */
	@Override
	public List<EntFileUpload> getEntFileUploads(int start, int end) {
		return entFileUploadPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ent file uploads.
	 *
	 * @return the number of ent file uploads
	 */
	@Override
	public int getEntFileUploadsCount() {
		return entFileUploadPersistence.countAll();
	}

	/**
	 * Updates the ent file upload in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param entFileUpload the ent file upload
	 * @return the ent file upload that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EntFileUpload updateEntFileUpload(EntFileUpload entFileUpload) {
		return entFileUploadPersistence.update(entFileUpload);
	}

	@Override
	public EntFileUploadFile_blobBlobModel getFile_blobBlobModel(
		Serializable primaryKey) {
		Session session = null;

		try {
			session = entFileUploadPersistence.openSession();

			return (EntFileUploadFile_blobBlobModel)session.get(EntFileUploadFile_blobBlobModel.class,
				primaryKey);
		}
		catch (Exception e) {
			throw entFileUploadPersistence.processException(e);
		}
		finally {
			entFileUploadPersistence.closeSession(session);
		}
	}

	/**
	 * Returns the ent doc local service.
	 *
	 * @return the ent doc local service
	 */
	public com._42Penguins.gosign.service.EntDocLocalService getEntDocLocalService() {
		return entDocLocalService;
	}

	/**
	 * Sets the ent doc local service.
	 *
	 * @param entDocLocalService the ent doc local service
	 */
	public void setEntDocLocalService(
		com._42Penguins.gosign.service.EntDocLocalService entDocLocalService) {
		this.entDocLocalService = entDocLocalService;
	}

	/**
	 * Returns the ent doc persistence.
	 *
	 * @return the ent doc persistence
	 */
	public EntDocPersistence getEntDocPersistence() {
		return entDocPersistence;
	}

	/**
	 * Sets the ent doc persistence.
	 *
	 * @param entDocPersistence the ent doc persistence
	 */
	public void setEntDocPersistence(EntDocPersistence entDocPersistence) {
		this.entDocPersistence = entDocPersistence;
	}

	/**
	 * Returns the ent file upload local service.
	 *
	 * @return the ent file upload local service
	 */
	public EntFileUploadLocalService getEntFileUploadLocalService() {
		return entFileUploadLocalService;
	}

	/**
	 * Sets the ent file upload local service.
	 *
	 * @param entFileUploadLocalService the ent file upload local service
	 */
	public void setEntFileUploadLocalService(
		EntFileUploadLocalService entFileUploadLocalService) {
		this.entFileUploadLocalService = entFileUploadLocalService;
	}

	/**
	 * Returns the ent file upload persistence.
	 *
	 * @return the ent file upload persistence
	 */
	public EntFileUploadPersistence getEntFileUploadPersistence() {
		return entFileUploadPersistence;
	}

	/**
	 * Sets the ent file upload persistence.
	 *
	 * @param entFileUploadPersistence the ent file upload persistence
	 */
	public void setEntFileUploadPersistence(
		EntFileUploadPersistence entFileUploadPersistence) {
		this.entFileUploadPersistence = entFileUploadPersistence;
	}

	/**
	 * Returns the ent key local service.
	 *
	 * @return the ent key local service
	 */
	public com._42Penguins.gosign.service.EntKeyLocalService getEntKeyLocalService() {
		return entKeyLocalService;
	}

	/**
	 * Sets the ent key local service.
	 *
	 * @param entKeyLocalService the ent key local service
	 */
	public void setEntKeyLocalService(
		com._42Penguins.gosign.service.EntKeyLocalService entKeyLocalService) {
		this.entKeyLocalService = entKeyLocalService;
	}

	/**
	 * Returns the ent key persistence.
	 *
	 * @return the ent key persistence
	 */
	public EntKeyPersistence getEntKeyPersistence() {
		return entKeyPersistence;
	}

	/**
	 * Sets the ent key persistence.
	 *
	 * @param entKeyPersistence the ent key persistence
	 */
	public void setEntKeyPersistence(EntKeyPersistence entKeyPersistence) {
		this.entKeyPersistence = entKeyPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com._42Penguins.gosign.model.EntFileUpload",
			entFileUploadLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com._42Penguins.gosign.model.EntFileUpload");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EntFileUploadLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return EntFileUpload.class;
	}

	protected String getModelClassName() {
		return EntFileUpload.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = entFileUploadPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com._42Penguins.gosign.service.EntDocLocalService.class)
	protected com._42Penguins.gosign.service.EntDocLocalService entDocLocalService;
	@BeanReference(type = EntDocPersistence.class)
	protected EntDocPersistence entDocPersistence;
	@BeanReference(type = EntFileUploadLocalService.class)
	protected EntFileUploadLocalService entFileUploadLocalService;
	@BeanReference(type = EntFileUploadPersistence.class)
	protected EntFileUploadPersistence entFileUploadPersistence;
	@BeanReference(type = com._42Penguins.gosign.service.EntKeyLocalService.class)
	protected com._42Penguins.gosign.service.EntKeyLocalService entKeyLocalService;
	@BeanReference(type = EntKeyPersistence.class)
	protected EntKeyPersistence entKeyPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}