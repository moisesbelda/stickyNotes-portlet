create table stickynotes_stickyNote (
	companyId LONG,
	groupId LONG,
	userId LONG,
	plid LONG,
	stickyNoteId LONG not null primary key,
	text_ VARCHAR(100) null,
	positionX DOUBLE,
	positionY DOUBLE,
	positionZ LONG,
	color VARCHAR(75) null,
	dateCreated DATE null,
	dateModified DATE null
);