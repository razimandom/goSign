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

package com._42Penguins.gosign.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the EntDoc service. Represents a row in the &quot;document_data&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com._42Penguins.gosign.model.impl.EntDocModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com._42Penguins.gosign.model.impl.EntDocImpl}.
 * </p>
 *
 * @author Raziman Dom
 * @see EntDoc
 * @see com._42Penguins.gosign.model.impl.EntDocImpl
 * @see com._42Penguins.gosign.model.impl.EntDocModelImpl
 * @generated
 */
@ProviderType
public interface EntDocModel extends BaseModel<EntDoc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ent doc model instance should use the {@link EntDoc} interface instead.
	 */

	/**
	 * Returns the primary key of this ent doc.
	 *
	 * @return the primary key of this ent doc
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ent doc.
	 *
	 * @param primaryKey the primary key of this ent doc
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the doc ID of this ent doc.
	 *
	 * @return the doc ID of this ent doc
	 */
	public long getDocId();

	/**
	 * Sets the doc ID of this ent doc.
	 *
	 * @param docId the doc ID of this ent doc
	 */
	public void setDocId(long docId);

	/**
	 * Returns the file ID of this ent doc.
	 *
	 * @return the file ID of this ent doc
	 */
	public long getFileId();

	/**
	 * Sets the file ID of this ent doc.
	 *
	 * @param fileId the file ID of this ent doc
	 */
	public void setFileId(long fileId);

	/**
	 * Returns the user ID of this ent doc.
	 *
	 * @return the user ID of this ent doc
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this ent doc.
	 *
	 * @param userId the user ID of this ent doc
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ent doc.
	 *
	 * @return the user uuid of this ent doc
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ent doc.
	 *
	 * @param userUuid the user uuid of this ent doc
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the sign ID of this ent doc.
	 *
	 * @return the sign ID of this ent doc
	 */
	public long getSignId();

	/**
	 * Sets the sign ID of this ent doc.
	 *
	 * @param signId the sign ID of this ent doc
	 */
	public void setSignId(long signId);

	/**
	 * Returns the req_name of this ent doc.
	 *
	 * @return the req_name of this ent doc
	 */
	@AutoEscape
	public String getReq_name();

	/**
	 * Sets the req_name of this ent doc.
	 *
	 * @param req_name the req_name of this ent doc
	 */
	public void setReq_name(String req_name);

	/**
	 * Returns the req_email of this ent doc.
	 *
	 * @return the req_email of this ent doc
	 */
	@AutoEscape
	public String getReq_email();

	/**
	 * Sets the req_email of this ent doc.
	 *
	 * @param req_email the req_email of this ent doc
	 */
	public void setReq_email(String req_email);

	/**
	 * Returns the sign_name of this ent doc.
	 *
	 * @return the sign_name of this ent doc
	 */
	@AutoEscape
	public String getSign_name();

	/**
	 * Sets the sign_name of this ent doc.
	 *
	 * @param sign_name the sign_name of this ent doc
	 */
	public void setSign_name(String sign_name);

	/**
	 * Returns the sign_email of this ent doc.
	 *
	 * @return the sign_email of this ent doc
	 */
	@AutoEscape
	public String getSign_email();

	/**
	 * Sets the sign_email of this ent doc.
	 *
	 * @param sign_email the sign_email of this ent doc
	 */
	public void setSign_email(String sign_email);

	/**
	 * Returns the doc_title of this ent doc.
	 *
	 * @return the doc_title of this ent doc
	 */
	@AutoEscape
	public String getDoc_title();

	/**
	 * Sets the doc_title of this ent doc.
	 *
	 * @param doc_title the doc_title of this ent doc
	 */
	public void setDoc_title(String doc_title);

	/**
	 * Returns the doc_type of this ent doc.
	 *
	 * @return the doc_type of this ent doc
	 */
	@AutoEscape
	public String getDoc_type();

	/**
	 * Sets the doc_type of this ent doc.
	 *
	 * @param doc_type the doc_type of this ent doc
	 */
	public void setDoc_type(String doc_type);

	/**
	 * Returns the doc_md5 of this ent doc.
	 *
	 * @return the doc_md5 of this ent doc
	 */
	@AutoEscape
	public String getDoc_md5();

	/**
	 * Sets the doc_md5 of this ent doc.
	 *
	 * @param doc_md5 the doc_md5 of this ent doc
	 */
	public void setDoc_md5(String doc_md5);

	/**
	 * Returns the doc_status of this ent doc.
	 *
	 * @return the doc_status of this ent doc
	 */
	@AutoEscape
	public String getDoc_status();

	/**
	 * Sets the doc_status of this ent doc.
	 *
	 * @param doc_status the doc_status of this ent doc
	 */
	public void setDoc_status(String doc_status);

	/**
	 * Returns the doc_deadline of this ent doc.
	 *
	 * @return the doc_deadline of this ent doc
	 */
	@AutoEscape
	public String getDoc_deadline();

	/**
	 * Sets the doc_deadline of this ent doc.
	 *
	 * @param doc_deadline the doc_deadline of this ent doc
	 */
	public void setDoc_deadline(String doc_deadline);

	/**
	 * Returns the doc_description of this ent doc.
	 *
	 * @return the doc_description of this ent doc
	 */
	@AutoEscape
	public String getDoc_description();

	/**
	 * Sets the doc_description of this ent doc.
	 *
	 * @param doc_description the doc_description of this ent doc
	 */
	public void setDoc_description(String doc_description);

	/**
	 * Returns the doc_signature of this ent doc.
	 *
	 * @return the doc_signature of this ent doc
	 */
	@AutoEscape
	public String getDoc_signature();

	/**
	 * Sets the doc_signature of this ent doc.
	 *
	 * @param doc_signature the doc_signature of this ent doc
	 */
	public void setDoc_signature(String doc_signature);

	/**
	 * Returns the req_date created of this ent doc.
	 *
	 * @return the req_date created of this ent doc
	 */
	@AutoEscape
	public String getReq_dateCreated();

	/**
	 * Sets the req_date created of this ent doc.
	 *
	 * @param req_dateCreated the req_date created of this ent doc
	 */
	public void setReq_dateCreated(String req_dateCreated);

	/**
	 * Returns the req_date modified of this ent doc.
	 *
	 * @return the req_date modified of this ent doc
	 */
	@AutoEscape
	public String getReq_dateModified();

	/**
	 * Sets the req_date modified of this ent doc.
	 *
	 * @param req_dateModified the req_date modified of this ent doc
	 */
	public void setReq_dateModified(String req_dateModified);

	/**
	 * Returns the req_time created of this ent doc.
	 *
	 * @return the req_time created of this ent doc
	 */
	@AutoEscape
	public String getReq_timeCreated();

	/**
	 * Sets the req_time created of this ent doc.
	 *
	 * @param req_timeCreated the req_time created of this ent doc
	 */
	public void setReq_timeCreated(String req_timeCreated);

	/**
	 * Returns the req_time modified of this ent doc.
	 *
	 * @return the req_time modified of this ent doc
	 */
	@AutoEscape
	public String getReq_timeModified();

	/**
	 * Sets the req_time modified of this ent doc.
	 *
	 * @param req_timeModified the req_time modified of this ent doc
	 */
	public void setReq_timeModified(String req_timeModified);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(EntDoc entDoc);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EntDoc> toCacheModel();

	@Override
	public EntDoc toEscapedModel();

	@Override
	public EntDoc toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}