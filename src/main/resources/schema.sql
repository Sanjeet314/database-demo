--/*
--create table person
--(
--    id integer not null,
--    name varchar(255) not null,
--    location varchar(255),
--    birth_date timestamp,
--    primary key(id)
--);
--*/

INSERT INTO PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1000001, 'SANJEET', 'JHARKHAND', sysdate());

INSERT INTO PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1000002, 'tammy', 'lostland', sysdate());


INSERT INTO PERSON
    (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(1000003, 'kallmam', 'brighton', sysdate());
