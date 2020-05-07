insert into users(isadmin, USERNAME, vorname, nachname, passwort) values (true, 'adminHeinz', 'Heinz', 'Heinrich', '6a0860106299dfe7781443e845feac989a946fd7990dfbab18a07e67a1202650');
insert into users(isadmin, USERNAME, vorname, nachname, passwort) values (false, 'einhorn123', 'Julia', 'Dengler', 'ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad');

insert into flugziele(abflug, ankunft) values ('MUC', 'JFK');
insert into flugziele(abflug, ankunft) values ('MUC', 'TXL');
insert into flugziele(abflug, ankunft) values ('MUC', 'CDG');
insert into flugziele(abflug, ankunft) values ('JFK', 'MUC');
insert into flugziele(abflug, ankunft) values ('TXL', 'MUC');
insert into flugziele(abflug, ankunft) values ('CDG', 'MUC');

insert into fluege(zid, zeit, flugdauer) values (1, '09:00:00', 8.5);
insert into fluege(zid, zeit, flugdauer) values (2, '11:00:00', 1.0);
insert into fluege(zid, zeit, flugdauer) values (3, '13:00:00', 2.5);
insert into fluege(zid, zeit, flugdauer) values (1, '19:00:00', 8.5);

insert into stati(status) values('aktiv');
insert into stati(status) values('storniert');
insert into stati(status) values('schon geflogen');
