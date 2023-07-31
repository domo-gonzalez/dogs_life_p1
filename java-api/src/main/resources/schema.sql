drop table dogs if exists;

--create table owners
--(
--    owner_id long not null auto_increment primary key,
--    name varchar(70)
--);

--select * from owners;

create table dogs
(
    id long not null auto_increment primary key,
    name varchar(70),
   age long
--   FOREIGN key (owner_id) REFERENCES owners(owner_id)
);

