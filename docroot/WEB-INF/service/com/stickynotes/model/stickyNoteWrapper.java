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

package com.stickynotes.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link stickyNote}.
 * </p>
 *
 * @author mbelda
 * @see stickyNote
 * @generated
 */
public class stickyNoteWrapper implements stickyNote, ModelWrapper<stickyNote> {
	public stickyNoteWrapper(stickyNote stickyNote) {
		_stickyNote = stickyNote;
	}

	@Override
	public Class<?> getModelClass() {
		return stickyNote.class;
	}

	@Override
	public String getModelClassName() {
		return stickyNote.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("plid", getPlid());
		attributes.put("stickyNoteId", getStickyNoteId());
		attributes.put("text", getText());
		attributes.put("positionX", getPositionX());
		attributes.put("positionY", getPositionY());
		attributes.put("positionZ", getPositionZ());
		attributes.put("color", getColor());
		attributes.put("dateCreated", getDateCreated());
		attributes.put("dateModified", getDateModified());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long plid = (Long)attributes.get("plid");

		if (plid != null) {
			setPlid(plid);
		}

		Long stickyNoteId = (Long)attributes.get("stickyNoteId");

		if (stickyNoteId != null) {
			setStickyNoteId(stickyNoteId);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		Double positionX = (Double)attributes.get("positionX");

		if (positionX != null) {
			setPositionX(positionX);
		}

		Double positionY = (Double)attributes.get("positionY");

		if (positionY != null) {
			setPositionY(positionY);
		}

		Long positionZ = (Long)attributes.get("positionZ");

		if (positionZ != null) {
			setPositionZ(positionZ);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		Date dateCreated = (Date)attributes.get("dateCreated");

		if (dateCreated != null) {
			setDateCreated(dateCreated);
		}

		Date dateModified = (Date)attributes.get("dateModified");

		if (dateModified != null) {
			setDateModified(dateModified);
		}
	}

	/**
	* Returns the primary key of this sticky note.
	*
	* @return the primary key of this sticky note
	*/
	@Override
	public long getPrimaryKey() {
		return _stickyNote.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sticky note.
	*
	* @param primaryKey the primary key of this sticky note
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_stickyNote.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the company ID of this sticky note.
	*
	* @return the company ID of this sticky note
	*/
	@Override
	public long getCompanyId() {
		return _stickyNote.getCompanyId();
	}

	/**
	* Sets the company ID of this sticky note.
	*
	* @param companyId the company ID of this sticky note
	*/
	@Override
	public void setCompanyId(long companyId) {
		_stickyNote.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this sticky note.
	*
	* @return the group ID of this sticky note
	*/
	@Override
	public long getGroupId() {
		return _stickyNote.getGroupId();
	}

	/**
	* Sets the group ID of this sticky note.
	*
	* @param groupId the group ID of this sticky note
	*/
	@Override
	public void setGroupId(long groupId) {
		_stickyNote.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this sticky note.
	*
	* @return the user ID of this sticky note
	*/
	@Override
	public long getUserId() {
		return _stickyNote.getUserId();
	}

	/**
	* Sets the user ID of this sticky note.
	*
	* @param userId the user ID of this sticky note
	*/
	@Override
	public void setUserId(long userId) {
		_stickyNote.setUserId(userId);
	}

	/**
	* Returns the user uuid of this sticky note.
	*
	* @return the user uuid of this sticky note
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _stickyNote.getUserUuid();
	}

	/**
	* Sets the user uuid of this sticky note.
	*
	* @param userUuid the user uuid of this sticky note
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_stickyNote.setUserUuid(userUuid);
	}

	/**
	* Returns the plid of this sticky note.
	*
	* @return the plid of this sticky note
	*/
	@Override
	public long getPlid() {
		return _stickyNote.getPlid();
	}

	/**
	* Sets the plid of this sticky note.
	*
	* @param plid the plid of this sticky note
	*/
	@Override
	public void setPlid(long plid) {
		_stickyNote.setPlid(plid);
	}

	/**
	* Returns the sticky note ID of this sticky note.
	*
	* @return the sticky note ID of this sticky note
	*/
	@Override
	public long getStickyNoteId() {
		return _stickyNote.getStickyNoteId();
	}

	/**
	* Sets the sticky note ID of this sticky note.
	*
	* @param stickyNoteId the sticky note ID of this sticky note
	*/
	@Override
	public void setStickyNoteId(long stickyNoteId) {
		_stickyNote.setStickyNoteId(stickyNoteId);
	}

	/**
	* Returns the text of this sticky note.
	*
	* @return the text of this sticky note
	*/
	@Override
	public java.lang.String getText() {
		return _stickyNote.getText();
	}

	/**
	* Sets the text of this sticky note.
	*
	* @param text the text of this sticky note
	*/
	@Override
	public void setText(java.lang.String text) {
		_stickyNote.setText(text);
	}

	/**
	* Returns the position x of this sticky note.
	*
	* @return the position x of this sticky note
	*/
	@Override
	public double getPositionX() {
		return _stickyNote.getPositionX();
	}

	/**
	* Sets the position x of this sticky note.
	*
	* @param positionX the position x of this sticky note
	*/
	@Override
	public void setPositionX(double positionX) {
		_stickyNote.setPositionX(positionX);
	}

	/**
	* Returns the position y of this sticky note.
	*
	* @return the position y of this sticky note
	*/
	@Override
	public double getPositionY() {
		return _stickyNote.getPositionY();
	}

	/**
	* Sets the position y of this sticky note.
	*
	* @param positionY the position y of this sticky note
	*/
	@Override
	public void setPositionY(double positionY) {
		_stickyNote.setPositionY(positionY);
	}

	/**
	* Returns the position z of this sticky note.
	*
	* @return the position z of this sticky note
	*/
	@Override
	public long getPositionZ() {
		return _stickyNote.getPositionZ();
	}

	/**
	* Sets the position z of this sticky note.
	*
	* @param positionZ the position z of this sticky note
	*/
	@Override
	public void setPositionZ(long positionZ) {
		_stickyNote.setPositionZ(positionZ);
	}

	/**
	* Returns the color of this sticky note.
	*
	* @return the color of this sticky note
	*/
	@Override
	public java.lang.String getColor() {
		return _stickyNote.getColor();
	}

	/**
	* Sets the color of this sticky note.
	*
	* @param color the color of this sticky note
	*/
	@Override
	public void setColor(java.lang.String color) {
		_stickyNote.setColor(color);
	}

	/**
	* Returns the date created of this sticky note.
	*
	* @return the date created of this sticky note
	*/
	@Override
	public java.util.Date getDateCreated() {
		return _stickyNote.getDateCreated();
	}

	/**
	* Sets the date created of this sticky note.
	*
	* @param dateCreated the date created of this sticky note
	*/
	@Override
	public void setDateCreated(java.util.Date dateCreated) {
		_stickyNote.setDateCreated(dateCreated);
	}

	/**
	* Returns the date modified of this sticky note.
	*
	* @return the date modified of this sticky note
	*/
	@Override
	public java.util.Date getDateModified() {
		return _stickyNote.getDateModified();
	}

	/**
	* Sets the date modified of this sticky note.
	*
	* @param dateModified the date modified of this sticky note
	*/
	@Override
	public void setDateModified(java.util.Date dateModified) {
		_stickyNote.setDateModified(dateModified);
	}

	@Override
	public boolean isNew() {
		return _stickyNote.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_stickyNote.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _stickyNote.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_stickyNote.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _stickyNote.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _stickyNote.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_stickyNote.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _stickyNote.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_stickyNote.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_stickyNote.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_stickyNote.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new stickyNoteWrapper((stickyNote)_stickyNote.clone());
	}

	@Override
	public int compareTo(com.stickynotes.model.stickyNote stickyNote) {
		return _stickyNote.compareTo(stickyNote);
	}

	@Override
	public int hashCode() {
		return _stickyNote.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.stickynotes.model.stickyNote> toCacheModel() {
		return _stickyNote.toCacheModel();
	}

	@Override
	public com.stickynotes.model.stickyNote toEscapedModel() {
		return new stickyNoteWrapper(_stickyNote.toEscapedModel());
	}

	@Override
	public com.stickynotes.model.stickyNote toUnescapedModel() {
		return new stickyNoteWrapper(_stickyNote.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _stickyNote.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _stickyNote.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_stickyNote.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof stickyNoteWrapper)) {
			return false;
		}

		stickyNoteWrapper stickyNoteWrapper = (stickyNoteWrapper)obj;

		if (Validator.equals(_stickyNote, stickyNoteWrapper._stickyNote)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public stickyNote getWrappedstickyNote() {
		return _stickyNote;
	}

	@Override
	public stickyNote getWrappedModel() {
		return _stickyNote;
	}

	@Override
	public void resetOriginalValues() {
		_stickyNote.resetOriginalValues();
	}

	private stickyNote _stickyNote;
}