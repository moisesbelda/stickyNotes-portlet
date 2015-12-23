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

package com.stickynotes.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.stickynotes.model.stickyNote;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing stickyNote in entity cache.
 *
 * @author mbelda
 * @see stickyNote
 * @generated
 */
public class stickyNoteCacheModel implements CacheModel<stickyNote>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", plid=");
		sb.append(plid);
		sb.append(", stickyNoteId=");
		sb.append(stickyNoteId);
		sb.append(", text=");
		sb.append(text);
		sb.append(", positionX=");
		sb.append(positionX);
		sb.append(", positionY=");
		sb.append(positionY);
		sb.append(", positionZ=");
		sb.append(positionZ);
		sb.append(", color=");
		sb.append(color);
		sb.append(", dateCreated=");
		sb.append(dateCreated);
		sb.append(", dateModified=");
		sb.append(dateModified);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public stickyNote toEntityModel() {
		stickyNoteImpl stickyNoteImpl = new stickyNoteImpl();

		stickyNoteImpl.setCompanyId(companyId);
		stickyNoteImpl.setGroupId(groupId);
		stickyNoteImpl.setUserId(userId);
		stickyNoteImpl.setPlid(plid);
		stickyNoteImpl.setStickyNoteId(stickyNoteId);

		if (text == null) {
			stickyNoteImpl.setText(StringPool.BLANK);
		}
		else {
			stickyNoteImpl.setText(text);
		}

		stickyNoteImpl.setPositionX(positionX);
		stickyNoteImpl.setPositionY(positionY);
		stickyNoteImpl.setPositionZ(positionZ);

		if (color == null) {
			stickyNoteImpl.setColor(StringPool.BLANK);
		}
		else {
			stickyNoteImpl.setColor(color);
		}

		if (dateCreated == Long.MIN_VALUE) {
			stickyNoteImpl.setDateCreated(null);
		}
		else {
			stickyNoteImpl.setDateCreated(new Date(dateCreated));
		}

		if (dateModified == Long.MIN_VALUE) {
			stickyNoteImpl.setDateModified(null);
		}
		else {
			stickyNoteImpl.setDateModified(new Date(dateModified));
		}

		stickyNoteImpl.resetOriginalValues();

		return stickyNoteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		plid = objectInput.readLong();
		stickyNoteId = objectInput.readLong();
		text = objectInput.readUTF();
		positionX = objectInput.readDouble();
		positionY = objectInput.readDouble();
		positionZ = objectInput.readLong();
		color = objectInput.readUTF();
		dateCreated = objectInput.readLong();
		dateModified = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(plid);
		objectOutput.writeLong(stickyNoteId);

		if (text == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(text);
		}

		objectOutput.writeDouble(positionX);
		objectOutput.writeDouble(positionY);
		objectOutput.writeLong(positionZ);

		if (color == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(color);
		}

		objectOutput.writeLong(dateCreated);
		objectOutput.writeLong(dateModified);
	}

	public long companyId;
	public long groupId;
	public long userId;
	public long plid;
	public long stickyNoteId;
	public String text;
	public double positionX;
	public double positionY;
	public long positionZ;
	public String color;
	public long dateCreated;
	public long dateModified;
}