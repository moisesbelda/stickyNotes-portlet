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

package com.stickynotes.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.stickynotes.model.stickyNote;

/**
 * The persistence interface for the sticky note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mbelda
 * @see stickyNotePersistenceImpl
 * @see stickyNoteUtil
 * @generated
 */
public interface stickyNotePersistence extends BasePersistence<stickyNote> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link stickyNoteUtil} to access the sticky note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the sticky note in the entity cache if it is enabled.
	*
	* @param stickyNote the sticky note
	*/
	public void cacheResult(com.stickynotes.model.stickyNote stickyNote);

	/**
	* Caches the sticky notes in the entity cache if it is enabled.
	*
	* @param stickyNotes the sticky notes
	*/
	public void cacheResult(
		java.util.List<com.stickynotes.model.stickyNote> stickyNotes);

	/**
	* Creates a new sticky note with the primary key. Does not add the sticky note to the database.
	*
	* @param stickyNoteId the primary key for the new sticky note
	* @return the new sticky note
	*/
	public com.stickynotes.model.stickyNote create(long stickyNoteId);

	/**
	* Removes the sticky note with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stickyNoteId the primary key of the sticky note
	* @return the sticky note that was removed
	* @throws com.stickynotes.NoSuchstickyNoteException if a sticky note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.stickynotes.model.stickyNote remove(long stickyNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.stickynotes.NoSuchstickyNoteException;

	public com.stickynotes.model.stickyNote updateImpl(
		com.stickynotes.model.stickyNote stickyNote)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sticky note with the primary key or throws a {@link com.stickynotes.NoSuchstickyNoteException} if it could not be found.
	*
	* @param stickyNoteId the primary key of the sticky note
	* @return the sticky note
	* @throws com.stickynotes.NoSuchstickyNoteException if a sticky note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.stickynotes.model.stickyNote findByPrimaryKey(long stickyNoteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.stickynotes.NoSuchstickyNoteException;

	/**
	* Returns the sticky note with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stickyNoteId the primary key of the sticky note
	* @return the sticky note, or <code>null</code> if a sticky note with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.stickynotes.model.stickyNote fetchByPrimaryKey(long stickyNoteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sticky notes.
	*
	* @return the sticky notes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.stickynotes.model.stickyNote> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sticky notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.stickynotes.model.impl.stickyNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sticky notes
	* @param end the upper bound of the range of sticky notes (not inclusive)
	* @return the range of sticky notes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.stickynotes.model.stickyNote> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sticky notes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.stickynotes.model.impl.stickyNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sticky notes
	* @param end the upper bound of the range of sticky notes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sticky notes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.stickynotes.model.stickyNote> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sticky notes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sticky notes.
	*
	* @return the number of sticky notes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}