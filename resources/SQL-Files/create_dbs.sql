use activeworkbench;


DROP TABLE IF EXISTS Abfahrt;
DROP TABLE IF EXISTS Route;
DROP TABLE IF EXISTS Haltepunkt;

CREATE table Haltepunkt (
    halteName varchar(115) not null unique,
    primary key(halteName)
);
INSERT INTO HALTEPUNKT (halteName) values ('Frankfurt (Main) Hbf'), ('Hanau Hbf'), ('Aschaffenburg Hbf'), ('Laufach'),('Rüsselsheim Opelwerk'),('Frankfurt (Main) Flughafen Regionalbahnhof'), ('Gemünden (Main)'), ('Würzburg Hbf'), ('Bamberg'), ('Wächtersbach'), ('Bad Soden-Salmünster'), ('Fulda'), ('Bad Hersfeld'), ('Bebra');

CREATE table Route (
	id varchar(8) not null unique,
    ziel varchar(115) not null,
    PRIMARY KEY(id),
    foreign key(ziel) references Haltepunkt(halteName)
);
INSERT INTO ROUTE (id,ziel) values ('12005001','Frankfurt (Main) Hbf'),('12005002','Fulda'),('13005101','Frankfurt (Main) Hbf'),('13005102','Wächtersbach'),('12005401','Frankfurt (Main) Hbf');
INSERT INTO ROUTE (id,ziel) values ('12005402','Würzburg Hbf'),('12005403','Bamberg'),('12005501','Frankfurt (Main) Hbf'),('12005502','Würzburg Hbf');
INSERT INTO ROUTE (id,ziel) values ('12005503','Bamberg'),('13005801','Frankfurt (Main) Hbf'),('13005802','Hanau Hbf'),('13005803','Aschaffenburg Hbf'),('13005804','Laufach');
INSERT INTO ROUTE (id,ziel) values ('13005805','Rüsselsheim Opelwerk'), ('12005901','Frankfurt (Main) Flughafen Regionalbahnhof'),('12005902','Hanau Hbf');
INSERT INTO ROUTE (id,ziel) values ('12000501','Frankfurt (Main) Hbf'), ('12000502','Bebra'),('12005003','Bebra'),('13005103','Fulda'),('13005104','Bad Soden-Salmünster');
INSERT INTO ROUTE (id,ziel) values ('10000301','Bad Soden (Taunus)');

CREATE table Abfahrt (
	abfahrt_id int not null auto_increment,
    abfahrt time not null,
    zugnr varchar(8) not null,
    gleis int not null,
    route_id varchar(8) not null,
    Primary Key(abfahrt_id),
    foreign key (route_id) references Route(id)
    );
# RE5+RE50+RB51 -> Ffm
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('00:26:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:09:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:26:00','RB51',5,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:15:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:53:00','RE50',5,'12005001');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:02:00','RE5',5,'12000501');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:33:30','RE5',5,'12000501');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:33:30','RE5',5,'12000501');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:33:30','RE5',5,'12000501');

# RE5+RE50+RB51 -> Fulda
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:48:00','RB51',6,'13005101');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:48:00','RB51',6,'13005104');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:48:00','RB51',6,'13005104');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:48:00','RB51',6,'13005104');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:48:00','RB51',6,'13005104');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:48:00','RB51',6,'13005102');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:48:00','RB51',6,'13005103');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:56:00','RE50',6,'12005003');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:33:45','RE50',6,'12005002');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:33:45','RE50',6,'12005003');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:33:45','RE50',6,'12005003');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:24:00','RE5',8,'12000502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:27:00','RE5',8,'12000502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:26:00','RE5',8,'12000502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:26:00','RE5',8,'12000502');

#RE55/54 -> Würzburg
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:40:00','RE55',6,'12005502');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:10:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('02:40:00','RE54',8,'12005403');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:17:00','RB58',8,'13005804');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:56:00','RB58',7,'13005805');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:56:00','RB58',7,'13005805');

INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('04:39:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:40:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:41:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:39:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:39:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:39:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:40:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:39:00','RE59',7,'12005901');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:39:00','RE59',7,'12005901');

INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:14:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:21:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:24:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:24:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:24:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:23:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:21:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:24:00','RE59',8,'12005902');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:24:00','RE59',8,'12005902');

-- S3 Richtung Bad Soden
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('00:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('00:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('01:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('02:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('03:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('04:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('04:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('05:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('06:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('07:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('08:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('09:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('10:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('11:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('12:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('13:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('14:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('15:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('16:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('17:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('18:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('19:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('20:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('21:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('22:33:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:03:00','S3',4,'10000301');
INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values ('23:33:00','S3',4,'10000301');
