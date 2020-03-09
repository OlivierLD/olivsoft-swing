connect user SA password "";
create user chart password chart ADMIN;
connect user chart password chart;

drop table charts;
echo creating Table charts
create table charts (chartno integer not null primary key, title varchar(64), topleftLat double, topleftLong double, bottomrightLat double, bottomrightLong double, provider varchar(32), year smallint, nbcopies smallint, comment varchar(256));

commit;
