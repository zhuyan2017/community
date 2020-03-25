alter table question add creator int;
alter table question add commit_count int default 0;
alter table question add view_count int default 0;
alter table question add like_count int default 0;
alter table question add tag varchar(256);



