INSERT INTO CreditCards VALUES(1,1,1);
INSERT INTO Logins VALUES (1,'password');
INSERT INTO Subscribers VALUES(1,1,1,'Jean','Lambert',TO_DATE('19900401','YYYYMMDD'));
INSERT INTO SupportCards VALUES(1,'CC');
INSERT INTO SubscriberCards VALUES(1,1,3,'ALL',10.0);
INSERT INTO Films VALUES(1,'Les dents de la mer',1975,'Histoire de requins...','Steven','Spielberg','M16');
INSERT INTO SupportFilms VALUES(1,1,'BR');
INSERT INTO Blurays VALUES(1,1,10.0,'RENTED');
INSERT INTO Rentals VALUES(1,1,1,TO_DATE('20221120','YYYYMMDD'),TO_DATE('20220501','YYYYMMDD'));
UPDATE Rentals SET beginDate = TO_DATE('20220920','YYYYMMDD') WHERE rentalsID = 1;