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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.stickynotes.service.ClpSerializer;
import com.stickynotes.service.stickyNoteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mbelda
 */
public class stickyNoteClp extends BaseModelImpl<stickyNote>
	implements stickyNote {
	public stickyNoteClp() {
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
	public long getPrimaryKey() {
		return _stickyNoteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStickyNoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stickyNoteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_stickyNoteRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_stickyNoteRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_stickyNoteRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getPlid() {
		return _plid;
	}

	@Override
	public void setPlid(long plid) {
		_plid = plid;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setPlid", long.class);

				method.invoke(_stickyNoteRemoteModel, plid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStickyNoteId() {
		return _stickyNoteId;
	}

	@Override
	public void setStickyNoteId(long stickyNoteId) {
		_stickyNoteId = stickyNoteId;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setStickyNoteId", long.class);

				method.invoke(_stickyNoteRemoteModel, stickyNoteId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getText() {
		return _text;
	}

	@Override
	public void setText(String text) {
		_text = text;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setText", String.class);

				method.invoke(_stickyNoteRemoteModel, text);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPositionX() {
		return _positionX;
	}

	@Override
	public void setPositionX(double positionX) {
		_positionX = positionX;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionX", double.class);

				method.invoke(_stickyNoteRemoteModel, positionX);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPositionY() {
		return _positionY;
	}

	@Override
	public void setPositionY(double positionY) {
		_positionY = positionY;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionY", double.class);

				method.invoke(_stickyNoteRemoteModel, positionY);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPositionZ() {
		return _positionZ;
	}

	@Override
	public void setPositionZ(long positionZ) {
		_positionZ = positionZ;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionZ", long.class);

				method.invoke(_stickyNoteRemoteModel, positionZ);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColor() {
		return _color;
	}

	@Override
	public void setColor(String color) {
		_color = color;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setColor", String.class);

				method.invoke(_stickyNoteRemoteModel, color);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateCreated() {
		return _dateCreated;
	}

	@Override
	public void setDateCreated(Date dateCreated) {
		_dateCreated = dateCreated;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setDateCreated", Date.class);

				method.invoke(_stickyNoteRemoteModel, dateCreated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateModified() {
		return _dateModified;
	}

	@Override
	public void setDateModified(Date dateModified) {
		_dateModified = dateModified;

		if (_stickyNoteRemoteModel != null) {
			try {
				Class<?> clazz = _stickyNoteRemoteModel.getClass();

				Method method = clazz.getMethod("setDateModified", Date.class);

				method.invoke(_stickyNoteRemoteModel, dateModified);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getstickyNoteRemoteModel() {
		return _stickyNoteRemoteModel;
	}

	public void setstickyNoteRemoteModel(BaseModel<?> stickyNoteRemoteModel) {
		_stickyNoteRemoteModel = stickyNoteRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _stickyNoteRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_stickyNoteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			stickyNoteLocalServiceUtil.addstickyNote(this);
		}
		else {
			stickyNoteLocalServiceUtil.updatestickyNote(this);
		}
	}

	@Override
	public stickyNote toEscapedModel() {
		return (stickyNote)ProxyUtil.newProxyInstance(stickyNote.class.getClassLoader(),
			new Class[] { stickyNote.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		stickyNoteClp clone = new stickyNoteClp();

		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setPlid(getPlid());
		clone.setStickyNoteId(getStickyNoteId());
		clone.setText(getText());
		clone.setPositionX(getPositionX());
		clone.setPositionY(getPositionY());
		clone.setPositionZ(getPositionZ());
		clone.setColor(getColor());
		clone.setDateCreated(getDateCreated());
		clone.setDateModified(getDateModified());

		return clone;
	}

	@Override
	public int compareTo(stickyNote stickyNote) {
		int value = 0;

		value = DateUtil.compareTo(getDateCreated(), stickyNote.getDateCreated());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof stickyNoteClp)) {
			return false;
		}

		stickyNoteClp stickyNote = (stickyNoteClp)obj;

		long primaryKey = stickyNote.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", plid=");
		sb.append(getPlid());
		sb.append(", stickyNoteId=");
		sb.append(getStickyNoteId());
		sb.append(", text=");
		sb.append(getText());
		sb.append(", positionX=");
		sb.append(getPositionX());
		sb.append(", positionY=");
		sb.append(getPositionY());
		sb.append(", positionZ=");
		sb.append(getPositionZ());
		sb.append(", color=");
		sb.append(getColor());
		sb.append(", dateCreated=");
		sb.append(getDateCreated());
		sb.append(", dateModified=");
		sb.append(getDateModified());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.stickynotes.model.stickyNote");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>plid</column-name><column-value><![CDATA[");
		sb.append(getPlid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stickyNoteId</column-name><column-value><![CDATA[");
		sb.append(getStickyNoteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>text</column-name><column-value><![CDATA[");
		sb.append(getText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionX</column-name><column-value><![CDATA[");
		sb.append(getPositionX());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionY</column-name><column-value><![CDATA[");
		sb.append(getPositionY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionZ</column-name><column-value><![CDATA[");
		sb.append(getPositionZ());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>color</column-name><column-value><![CDATA[");
		sb.append(getColor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateCreated</column-name><column-value><![CDATA[");
		sb.append(getDateCreated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateModified</column-name><column-value><![CDATA[");
		sb.append(getDateModified());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _plid;
	private long _stickyNoteId;
	private String _text;
	private double _positionX;
	private double _positionY;
	private long _positionZ;
	private String _color;
	private Date _dateCreated;
	private Date _dateModified;
	private BaseModel<?> _stickyNoteRemoteModel;
	private Class<?> _clpSerializerClass = com.stickynotes.service.ClpSerializer.class;
}