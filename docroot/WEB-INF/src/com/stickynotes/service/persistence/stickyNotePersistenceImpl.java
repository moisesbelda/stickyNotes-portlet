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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.stickynotes.NoSuchstickyNoteException;

import com.stickynotes.model.impl.stickyNoteImpl;
import com.stickynotes.model.impl.stickyNoteModelImpl;
import com.stickynotes.model.stickyNote;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the sticky note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mbelda
 * @see stickyNotePersistence
 * @see stickyNoteUtil
 * @generated
 */
public class stickyNotePersistenceImpl extends BasePersistenceImpl<stickyNote>
	implements stickyNotePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link stickyNoteUtil} to access the sticky note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = stickyNoteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
			stickyNoteModelImpl.FINDER_CACHE_ENABLED, stickyNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
			stickyNoteModelImpl.FINDER_CACHE_ENABLED, stickyNoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
			stickyNoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public stickyNotePersistenceImpl() {
		setModelClass(stickyNote.class);
	}

	/**
	 * Caches the sticky note in the entity cache if it is enabled.
	 *
	 * @param stickyNote the sticky note
	 */
	@Override
	public void cacheResult(stickyNote stickyNote) {
		EntityCacheUtil.putResult(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
			stickyNoteImpl.class, stickyNote.getPrimaryKey(), stickyNote);

		stickyNote.resetOriginalValues();
	}

	/**
	 * Caches the sticky notes in the entity cache if it is enabled.
	 *
	 * @param stickyNotes the sticky notes
	 */
	@Override
	public void cacheResult(List<stickyNote> stickyNotes) {
		for (stickyNote stickyNote : stickyNotes) {
			if (EntityCacheUtil.getResult(
						stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
						stickyNoteImpl.class, stickyNote.getPrimaryKey()) == null) {
				cacheResult(stickyNote);
			}
			else {
				stickyNote.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sticky notes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(stickyNoteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(stickyNoteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sticky note.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(stickyNote stickyNote) {
		EntityCacheUtil.removeResult(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
			stickyNoteImpl.class, stickyNote.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<stickyNote> stickyNotes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (stickyNote stickyNote : stickyNotes) {
			EntityCacheUtil.removeResult(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
				stickyNoteImpl.class, stickyNote.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sticky note with the primary key. Does not add the sticky note to the database.
	 *
	 * @param stickyNoteId the primary key for the new sticky note
	 * @return the new sticky note
	 */
	@Override
	public stickyNote create(long stickyNoteId) {
		stickyNote stickyNote = new stickyNoteImpl();

		stickyNote.setNew(true);
		stickyNote.setPrimaryKey(stickyNoteId);

		return stickyNote;
	}

	/**
	 * Removes the sticky note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stickyNoteId the primary key of the sticky note
	 * @return the sticky note that was removed
	 * @throws com.stickynotes.NoSuchstickyNoteException if a sticky note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public stickyNote remove(long stickyNoteId)
		throws NoSuchstickyNoteException, SystemException {
		return remove((Serializable)stickyNoteId);
	}

	/**
	 * Removes the sticky note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sticky note
	 * @return the sticky note that was removed
	 * @throws com.stickynotes.NoSuchstickyNoteException if a sticky note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public stickyNote remove(Serializable primaryKey)
		throws NoSuchstickyNoteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			stickyNote stickyNote = (stickyNote)session.get(stickyNoteImpl.class,
					primaryKey);

			if (stickyNote == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchstickyNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(stickyNote);
		}
		catch (NoSuchstickyNoteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected stickyNote removeImpl(stickyNote stickyNote)
		throws SystemException {
		stickyNote = toUnwrappedModel(stickyNote);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stickyNote)) {
				stickyNote = (stickyNote)session.get(stickyNoteImpl.class,
						stickyNote.getPrimaryKeyObj());
			}

			if (stickyNote != null) {
				session.delete(stickyNote);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (stickyNote != null) {
			clearCache(stickyNote);
		}

		return stickyNote;
	}

	@Override
	public stickyNote updateImpl(com.stickynotes.model.stickyNote stickyNote)
		throws SystemException {
		stickyNote = toUnwrappedModel(stickyNote);

		boolean isNew = stickyNote.isNew();

		Session session = null;

		try {
			session = openSession();

			if (stickyNote.isNew()) {
				session.save(stickyNote);

				stickyNote.setNew(false);
			}
			else {
				session.merge(stickyNote);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
			stickyNoteImpl.class, stickyNote.getPrimaryKey(), stickyNote);

		return stickyNote;
	}

	protected stickyNote toUnwrappedModel(stickyNote stickyNote) {
		if (stickyNote instanceof stickyNoteImpl) {
			return stickyNote;
		}

		stickyNoteImpl stickyNoteImpl = new stickyNoteImpl();

		stickyNoteImpl.setNew(stickyNote.isNew());
		stickyNoteImpl.setPrimaryKey(stickyNote.getPrimaryKey());

		stickyNoteImpl.setCompanyId(stickyNote.getCompanyId());
		stickyNoteImpl.setGroupId(stickyNote.getGroupId());
		stickyNoteImpl.setUserId(stickyNote.getUserId());
		stickyNoteImpl.setPlid(stickyNote.getPlid());
		stickyNoteImpl.setStickyNoteId(stickyNote.getStickyNoteId());
		stickyNoteImpl.setText(stickyNote.getText());
		stickyNoteImpl.setPositionX(stickyNote.getPositionX());
		stickyNoteImpl.setPositionY(stickyNote.getPositionY());
		stickyNoteImpl.setPositionZ(stickyNote.getPositionZ());
		stickyNoteImpl.setColor(stickyNote.getColor());
		stickyNoteImpl.setDateCreated(stickyNote.getDateCreated());
		stickyNoteImpl.setDateModified(stickyNote.getDateModified());

		return stickyNoteImpl;
	}

	/**
	 * Returns the sticky note with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sticky note
	 * @return the sticky note
	 * @throws com.stickynotes.NoSuchstickyNoteException if a sticky note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public stickyNote findByPrimaryKey(Serializable primaryKey)
		throws NoSuchstickyNoteException, SystemException {
		stickyNote stickyNote = fetchByPrimaryKey(primaryKey);

		if (stickyNote == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchstickyNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return stickyNote;
	}

	/**
	 * Returns the sticky note with the primary key or throws a {@link com.stickynotes.NoSuchstickyNoteException} if it could not be found.
	 *
	 * @param stickyNoteId the primary key of the sticky note
	 * @return the sticky note
	 * @throws com.stickynotes.NoSuchstickyNoteException if a sticky note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public stickyNote findByPrimaryKey(long stickyNoteId)
		throws NoSuchstickyNoteException, SystemException {
		return findByPrimaryKey((Serializable)stickyNoteId);
	}

	/**
	 * Returns the sticky note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sticky note
	 * @return the sticky note, or <code>null</code> if a sticky note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public stickyNote fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		stickyNote stickyNote = (stickyNote)EntityCacheUtil.getResult(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
				stickyNoteImpl.class, primaryKey);

		if (stickyNote == _nullstickyNote) {
			return null;
		}

		if (stickyNote == null) {
			Session session = null;

			try {
				session = openSession();

				stickyNote = (stickyNote)session.get(stickyNoteImpl.class,
						primaryKey);

				if (stickyNote != null) {
					cacheResult(stickyNote);
				}
				else {
					EntityCacheUtil.putResult(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
						stickyNoteImpl.class, primaryKey, _nullstickyNote);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(stickyNoteModelImpl.ENTITY_CACHE_ENABLED,
					stickyNoteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return stickyNote;
	}

	/**
	 * Returns the sticky note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stickyNoteId the primary key of the sticky note
	 * @return the sticky note, or <code>null</code> if a sticky note with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public stickyNote fetchByPrimaryKey(long stickyNoteId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stickyNoteId);
	}

	/**
	 * Returns all the sticky notes.
	 *
	 * @return the sticky notes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<stickyNote> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<stickyNote> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<stickyNote> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<stickyNote> list = (List<stickyNote>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STICKYNOTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STICKYNOTE;

				if (pagination) {
					sql = sql.concat(stickyNoteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<stickyNote>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<stickyNote>(list);
				}
				else {
					list = (List<stickyNote>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sticky notes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (stickyNote stickyNote : findAll()) {
			remove(stickyNote);
		}
	}

	/**
	 * Returns the number of sticky notes.
	 *
	 * @return the number of sticky notes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STICKYNOTE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the sticky note persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.stickynotes.model.stickyNote")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<stickyNote>> listenersList = new ArrayList<ModelListener<stickyNote>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<stickyNote>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(stickyNoteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STICKYNOTE = "SELECT stickyNote FROM stickyNote stickyNote";
	private static final String _SQL_COUNT_STICKYNOTE = "SELECT COUNT(stickyNote) FROM stickyNote stickyNote";
	private static final String _ORDER_BY_ENTITY_ALIAS = "stickyNote.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No stickyNote exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(stickyNotePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"text"
			});
	private static stickyNote _nullstickyNote = new stickyNoteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<stickyNote> toCacheModel() {
				return _nullstickyNoteCacheModel;
			}
		};

	private static CacheModel<stickyNote> _nullstickyNoteCacheModel = new CacheModel<stickyNote>() {
			@Override
			public stickyNote toEntityModel() {
				return _nullstickyNote;
			}
		};
}