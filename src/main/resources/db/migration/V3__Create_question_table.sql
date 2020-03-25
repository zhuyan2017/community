create table question
(
	id           int auto_increment primary key not null,
	title        varchar(50),
	description  text,
	gmt_create   bigint,
	gmt_modified bigint
);