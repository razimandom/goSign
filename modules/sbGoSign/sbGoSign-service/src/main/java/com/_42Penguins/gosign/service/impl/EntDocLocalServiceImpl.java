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

package com._42Penguins.gosign.service.impl;

import java.util.List;

import com._42Penguins.gosign.model.EntDoc;
import com._42Penguins.gosign.service.base.EntDocLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the ent doc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com._42Penguins.gosign.service.EntDocLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntDocLocalServiceBaseImpl
 * @see com._42Penguins.gosign.service.EntDocLocalServiceUtil
 */
public class EntDocLocalServiceImpl extends EntDocLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com._42Penguins.gosign.service.EntDocLocalServiceUtil} to access the ent doc local service.
	 */
	
	
	public List<EntDoc> findByUserId(long userId, int start, int end) throws SystemException{
		return this.entDocPersistence.findByFindUserId(userId, start, end);
	}
	
	public List<EntDoc> findBySignEmail(String sign_email, int start, int end) throws SystemException{
		return this.entDocPersistence.findByFindSignEmail(sign_email, start, end);
	}
	
}