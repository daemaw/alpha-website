create table users(
uid int primary key generated always as identity,
admin boolean not null,
username varchar(30) unique,
vorname varchar(30) not null,
nachname varchar(30) not null,
passwort varchar(100) not null);

create table flugziele(
zid int primary key generated always as identity,
abflug varchar(30) not null,
ankunft varchar(30) not null);

create table fluege(
fid int primary key generated always as identity,
zid int,
zeit time,
flugdauer float,
foreign key(zid) references flugziele);

create table stati(
sid int primary key generated always as identity,
status varchar(30));

create table buchungen(
bid int primary key generated always as identity,
fid int,
uid int,
datum date,
sid int,
foreign key(fid) references fluege,
foreign key(uid) references users,
foreign key(sid) references stati);
