INSERT INTO PERSON (FIRST_NAME, LAST_NAME,BIRTHDAY,NICKNAME) VALUES ('BOB', 'Digit', '2011-11-11','NIK');
INSERT INTO PERSON (FIRST_NAME, LAST_NAME,BIRTHDAY,NICKNAME) VALUES ('Jon', 'dorn',  '2003-08-30','pIK');
INSERT INTO PERSON (FIRST_NAME, LAST_NAME,BIRTHDAY,NICKNAME) VALUES ('Smit', 'Hokigit','2008-08-15','Hok');

INSERT INTO MESSAGE (CONTENT, TIME_SENT, PERSON_FROM,PERSON_TO) VALUES ('how are you ', '2015-05-22',3,1);
INSERT INTO MESSAGE (CONTENT, TIME_SENT, PERSON_FROM,PERSON_TO) VALUES ('hello hello', '2002-08-30',2,3);
INSERT INTO MESSAGE (CONTENT, TIME_SENT, PERSON_FROM,PERSON_TO) VALUES ('ok ok', '2015-08-30',2,1);
INSERT INTO MESSAGE (CONTENT, TIME_SENT, PERSON_FROM,PERSON_TO) VALUES ('see yor  late', '2014-01-30',2,1);
INSERT INTO MESSAGE (CONTENT, TIME_SENT, PERSON_FROM,PERSON_TO) VALUES ('hello ok', '2014-01-30',3,2);
INSERT INTO MESSAGE (CONTENT, TIME_SENT, PERSON_FROM,PERSON_TO) VALUES (' hello see yor  late', '2014-01-30',1,2);

INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('run', 'California','2005-08-30',2);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('run111', 'eeeeeeeeeee','2008-11-30',3);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('dansing', 'wundeful','2008-11-30',2);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('rep', 'BIRTHDAY','2008-11-30',3);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('hobby', 'dansing','2008-11-30',1);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('nunofelt', ' contains sparkly accents throughout','2008-11-30',1);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('wool', ' Thank you Amanda we had such a fun day hiking','2008-11-30',1);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('hello', ' Just Forgot that I had to mention something about someone to someone about how I forgot something, but now I forgot it','2008-11-30',2);
INSERT INTO POST (TITLE, CONTENT, PLASE_TAME, PERSON_ID) VALUES ('happy', ' All I thought was a dream (make a wish) Was as real as it seemed (happy birthday) All I thought was a dream (make a wish) Was as real as it seemed ','2008-11-30',2);

INSERT INTO HOBBY (TITLE,DESCRIPTION) VALUES ('dancing', 'contemp');
INSERT INTO HOBBY (TITLE,DESCRIPTION) VALUES ('felting', 'silk wool');
INSERT INTO HOBBY (TITLE,DESCRIPTION) VALUES ('knitting', 'knitting needles  hooks');
INSERT INTO HOBBY (TITLE,DESCRIPTION) VALUES ('quilling', 'paper felt');
INSERT INTO HOBBY (TITLE,DESCRIPTION) VALUES ('modeling clay', 'pottery');

INSERT INTO FRIENDSHIP (PERSON_ID,FRIEND_ID,DATA_FROM) VALUES (1, 2,'2015-10-29');
INSERT INTO FRIENDSHIP (PERSON_ID,FRIEND_ID,DATA_FROM) VALUES (2, 1,'2015-10-29');
INSERT INTO FRIENDSHIP (PERSON_ID,FRIEND_ID,DATA_FROM) VALUES (3, 1,'2014-11-28');
INSERT INTO FRIENDSHIP (PERSON_ID,FRIEND_ID,DATA_FROM) VALUES (1, 3,'2014-11-28');
INSERT INTO FRIENDSHIP (PERSON_ID,FRIEND_ID,DATA_FROM) VALUES (2, 3,'2014-05-27');


INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (2, 2);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (4, 2);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (1, 3);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (1, 2);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (3, 3);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (3, 1);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (3, 2);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (5, 2);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (5, 1);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (5, 3);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (6, 1);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (6, 3);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (7, 1);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (7, 2);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (7, 3);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (8, 3);
INSERT INTO POST_LIKES (POST_ID,PERSON_ID) VALUES (9, 1);

INSERT INTO PLACE (TITLE,DESCRIPTION,LATITUDE,LONGITUDE) VALUES ('Kiev', 'Ukraine',50,70);
INSERT INTO PLACE (TITLE,DESCRIPTION,LATITUDE,LONGITUDE) VALUES ('Lvov', 'Ukraine',55,70);
INSERT INTO PLACE (TITLE,DESCRIPTION,LATITUDE,LONGITUDE) VALUES ('Dnipro', 'Ukraine',57,80);

INSERT INTO PERSON_PlACE (PlACE_ID,PERSON_ID) VALUES (1, 2);
INSERT INTO PERSON_PlACE (PlACE_ID,PERSON_ID) VALUES (1, 1);
INSERT INTO PERSON_PlACE (PlACE_ID,PERSON_ID) VALUES (2, 3);
INSERT INTO PERSON_PlACE (PlACE_ID,PERSON_ID) VALUES (2, 1);
INSERT INTO PERSON_PlACE (PlACE_ID,PERSON_ID) VALUES (2, 2);

INSERT INTO PERSON_HOBBY (HOBBY_ID,PERSON_ID) VALUES (2, 1);
INSERT INTO PERSON_HOBBY (HOBBY_ID,PERSON_ID) VALUES (1, 2);
INSERT INTO PERSON_HOBBY (HOBBY_ID,PERSON_ID) VALUES (3, 3);
INSERT INTO PERSON_HOBBY (HOBBY_ID,PERSON_ID) VALUES (4, 1);
INSERT INTO PERSON_HOBBY (HOBBY_ID,PERSON_ID) VALUES (5, 2);
INSERT INTO PERSON_HOBBY (HOBBY_ID,PERSON_ID) VALUES (1, 3);
INSERT INTO PERSON_HOBBY (HOBBY_ID,PERSON_ID) VALUES (2, 2);