drop table tags;
drop table images;
drop table img_types;
--
echo creating Table img_types
create table img_types (name varchar(16) primary key, description varchar(128));
commit;
echo creating Table images
create table images (name varchar(64) primary key, imagetype varchar(16) not null, width int not null, height int not null, image longvarbinary not null, created date not null);
alter table images add constraint images_fk_types foreign key (imagetype) references img_types(name) on delete cascade on update cascade;
commit;
echo creating table tags
create table tags (imgname varchar(64) not null, rnk int not null, label varchar(128) not null);
alter table tags add constraint pk_tags primary key (imgname, rnk);
alter table tags add constraint tags_fk_images foreign key (imgname) references images(name) on delete cascade on update cascade;
commit;
--
insert into img_types values ('jpg',  'Joint Photographic Experts Group');
insert into img_types values ('png',  'Portable Network Graphics');
insert into img_types values ('gif',  'Graphics Interchange Format');
insert into img_types values ('tiff', 'Tagged Image File Format');
insert into img_types values ('bmp',  'Bitmap');
commit;
