/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.stickynotes.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bi.rules.Query;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.stickynotes.model.stickyNote;
import com.stickynotes.service.base.stickyNoteLocalServiceBaseImpl;

/**
 * The implementation of the sticky note local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.stickynotes.service.stickyNoteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author mbelda
 * @see com.stickynotes.service.base.stickyNoteLocalServiceBaseImpl
 * @see com.stickynotes.service.stickyNoteLocalServiceUtil
 */
public class stickyNoteLocalServiceImpl extends stickyNoteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.stickynotes.service.stickyNoteLocalServiceUtil} to access the sticky note local service.
	 */
	
	public stickyNote addstickyNote(stickyNote newStickyNote, long userId) throws SystemException,	PortalException {
		
		long stickyNoteId = CounterLocalServiceUtil.increment(stickyNote.class.getName());
		
		stickyNote note = stickyNotePersistence.create(stickyNoteId);
		note.setText(newStickyNote.getText());
		note.setColor(newStickyNote.getColor());
		note.setPositionX(newStickyNote.getPositionX());
		note.setPositionY(newStickyNote.getPositionY());
		note.setPositionZ(newStickyNote.getPositionZ());	
		note.setPlid(newStickyNote.getPlid());
		note.setCompanyId(newStickyNote.getCompanyId());
		note.setGroupId(newStickyNote.getGroupId());
		note.setUserId(newStickyNote.getUserId());
		
		stickyNotePersistence.update(note, false);
		
		return note;

	}
	
	
	public stickyNote deletestickyNote(long stickyNoteId) throws PortalException,SystemException {
		stickyNote note = getstickyNote(stickyNoteId);
		return deletestickyNote(note);
	}
	
	public stickyNote deletestickyNote(stickyNote note)throws SystemException {
		return super.deletestickyNote(note);
	}
	
	public List<stickyNote> getStickyNotesByGroup (long groupId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(stickyNote.class)
				.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)));

		List results = stickyNoteLocalService.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return results;
	}
	
	public List<stickyNote> getStickyNotesByGroupAndUser(long groupId, long userId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(stickyNote.class)
				.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)))
				.add(PropertyFactoryUtil.forName("userId").eq(new Long(userId)));
		List results = stickyNoteLocalService.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return results;		
	}
	
	public List<stickyNote> getStickyNotesByPlid(long plid) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(stickyNote.class)
				.add(PropertyFactoryUtil.forName("plid").eq(new Long(plid)));
		List results = stickyNoteLocalService.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return results;
	}
	
	public List<stickyNote> getStickyNotesByPlidAndUser(long plid, long userId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(stickyNote.class)
				.add(PropertyFactoryUtil.forName("plid").eq(new Long(plid)))
				.add(PropertyFactoryUtil.forName("userId").eq(new Long(userId)));
		List results = stickyNoteLocalService.dynamicQuery(query, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return results;
	}
	/**
	/LPS-30606 => Finders creating indexes that cannot be deployed with security manager enabled
	 
	public List<stickyNote> getStickyNotesByGroup(long groupId) throws SystemException {		
		return stickyNotePersistence.findByGroup(groupId);
	}
	
	
	public List<stickyNote> getStickyNotesByGroupAndUser(long groupId, long userId) throws SystemException {
		return stickyNotePersistence.findByGroupAndUser(groupId, userId);
	}
	
	public List<stickyNote> getStickyNotesByPlid(long plid) throws SystemException {
		return stickyNotePersistence.findByPlid(plid);
	}
	
	public List<stickyNote> getStickyNotesByPlidAndUser(long plid, long userId) throws SystemException {
		return stickyNotePersistence.findByPlidUser(plid, userId);
	} */
}