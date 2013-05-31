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

package com.stickynotes.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the stickyNote service. Represents a row in the &quot;stickynotes_stickyNote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.stickynotes.model.impl.stickyNoteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.stickynotes.model.impl.stickyNoteImpl}.
 * </p>
 *
 * @author mbelda
 * @see stickyNote
 * @see com.stickynotes.model.impl.stickyNoteImpl
 * @see com.stickynotes.model.impl.stickyNoteModelImpl
 * @generated
 */
public interface stickyNoteModel extends BaseModel<stickyNote> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sticky note model instance should use the {@link stickyNote} interface instead.
	 */

	/**
	 * Returns the primary key of this sticky note.
	 *
	 * @return the primary key of this sticky note
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sticky note.
	 *
	 * @param primaryKey the primary key of this sticky note
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the company ID of this sticky note.
	 *
	 * @return the company ID of this sticky note
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this sticky note.
	 *
	 * @param companyId the company ID of this sticky note
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this sticky note.
	 *
	 * @return the group ID of this sticky note
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this sticky note.
	 *
	 * @param groupId the group ID of this sticky note
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this sticky note.
	 *
	 * @return the user ID of this sticky note
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this sticky note.
	 *
	 * @param userId the user ID of this sticky note
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this sticky note.
	 *
	 * @return the user uuid of this sticky note
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this sticky note.
	 *
	 * @param userUuid the user uuid of this sticky note
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the plid of this sticky note.
	 *
	 * @return the plid of this sticky note
	 */
	public long getPlid();

	/**
	 * Sets the plid of this sticky note.
	 *
	 * @param plid the plid of this sticky note
	 */
	public void setPlid(long plid);

	/**
	 * Returns the sticky note ID of this sticky note.
	 *
	 * @return the sticky note ID of this sticky note
	 */
	public long getStickyNoteId();

	/**
	 * Sets the sticky note ID of this sticky note.
	 *
	 * @param stickyNoteId the sticky note ID of this sticky note
	 */
	public void setStickyNoteId(long stickyNoteId);

	/**
	 * Returns the text of this sticky note.
	 *
	 * @return the text of this sticky note
	 */
	@AutoEscape
	public String getText();

	/**
	 * Sets the text of this sticky note.
	 *
	 * @param text the text of this sticky note
	 */
	public void setText(String text);

	/**
	 * Returns the position x of this sticky note.
	 *
	 * @return the position x of this sticky note
	 */
	public double getPositionX();

	/**
	 * Sets the position x of this sticky note.
	 *
	 * @param positionX the position x of this sticky note
	 */
	public void setPositionX(double positionX);

	/**
	 * Returns the position y of this sticky note.
	 *
	 * @return the position y of this sticky note
	 */
	public double getPositionY();

	/**
	 * Sets the position y of this sticky note.
	 *
	 * @param positionY the position y of this sticky note
	 */
	public void setPositionY(double positionY);

	/**
	 * Returns the position z of this sticky note.
	 *
	 * @return the position z of this sticky note
	 */
	public long getPositionZ();

	/**
	 * Sets the position z of this sticky note.
	 *
	 * @param positionZ the position z of this sticky note
	 */
	public void setPositionZ(long positionZ);

	/**
	 * Returns the color of this sticky note.
	 *
	 * @return the color of this sticky note
	 */
	@AutoEscape
	public String getColor();

	/**
	 * Sets the color of this sticky note.
	 *
	 * @param color the color of this sticky note
	 */
	public void setColor(String color);

	/**
	 * Returns the date created of this sticky note.
	 *
	 * @return the date created of this sticky note
	 */
	public Date getDateCreated();

	/**
	 * Sets the date created of this sticky note.
	 *
	 * @param dateCreated the date created of this sticky note
	 */
	public void setDateCreated(Date dateCreated);

	/**
	 * Returns the date modified of this sticky note.
	 *
	 * @return the date modified of this sticky note
	 */
	public Date getDateModified();

	/**
	 * Sets the date modified of this sticky note.
	 *
	 * @param dateModified the date modified of this sticky note
	 */
	public void setDateModified(Date dateModified);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(stickyNote stickyNote);

	public int hashCode();

	public CacheModel<stickyNote> toCacheModel();

	public stickyNote toEscapedModel();

	public String toString();

	public String toXmlString();
}