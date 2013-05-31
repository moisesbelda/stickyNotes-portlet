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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    mbelda
 * @generated
 */
public class stickyNoteSoap implements Serializable {
	public static stickyNoteSoap toSoapModel(stickyNote model) {
		stickyNoteSoap soapModel = new stickyNoteSoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPlid(model.getPlid());
		soapModel.setStickyNoteId(model.getStickyNoteId());
		soapModel.setText(model.getText());
		soapModel.setPositionX(model.getPositionX());
		soapModel.setPositionY(model.getPositionY());
		soapModel.setPositionZ(model.getPositionZ());
		soapModel.setColor(model.getColor());
		soapModel.setDateCreated(model.getDateCreated());
		soapModel.setDateModified(model.getDateModified());

		return soapModel;
	}

	public static stickyNoteSoap[] toSoapModels(stickyNote[] models) {
		stickyNoteSoap[] soapModels = new stickyNoteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static stickyNoteSoap[][] toSoapModels(stickyNote[][] models) {
		stickyNoteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new stickyNoteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new stickyNoteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static stickyNoteSoap[] toSoapModels(List<stickyNote> models) {
		List<stickyNoteSoap> soapModels = new ArrayList<stickyNoteSoap>(models.size());

		for (stickyNote model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new stickyNoteSoap[soapModels.size()]);
	}

	public stickyNoteSoap() {
	}

	public long getPrimaryKey() {
		return _stickyNoteId;
	}

	public void setPrimaryKey(long pk) {
		setStickyNoteId(pk);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getPlid() {
		return _plid;
	}

	public void setPlid(long plid) {
		_plid = plid;
	}

	public long getStickyNoteId() {
		return _stickyNoteId;
	}

	public void setStickyNoteId(long stickyNoteId) {
		_stickyNoteId = stickyNoteId;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public double getPositionX() {
		return _positionX;
	}

	public void setPositionX(double positionX) {
		_positionX = positionX;
	}

	public double getPositionY() {
		return _positionY;
	}

	public void setPositionY(double positionY) {
		_positionY = positionY;
	}

	public long getPositionZ() {
		return _positionZ;
	}

	public void setPositionZ(long positionZ) {
		_positionZ = positionZ;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		_color = color;
	}

	public Date getDateCreated() {
		return _dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		_dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return _dateModified;
	}

	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;
	}

	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _plid;
	private long _stickyNoteId;
	private String _text;
	private double _positionX;
	private double _positionY;
	private long _positionZ;
	private String _color;
	private Date _dateCreated;
	private Date _dateModified;
}