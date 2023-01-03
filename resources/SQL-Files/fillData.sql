use
activeworkbench;


#DROP
TABLE IF EXISTS Haltepunkt;
#INSERT
INTO HALTEPUNKT (halteName) values ('Frankfurt (Main) Hbf'), ('Hanau Hbf'), ('Aschaffenburg Hbf'), ('Laufach'), ('Gemünden (Main)'), ('Würzburg Hbf'), ('Bamberg'), ('Wächtersbach'), ('Bad Soden-Salmünster'), ('Fulda'), ('Bad Hersfeld'), ('Bebra');
#INSERT
INTO HALTEPUNKT (halteName) value ('Kassel Hbf');
#INSERT
INTO HALTEPUNKT (halteName) values ('Gießen'),('Marburg (Lahn)'), ('Dieburg'), ('Rödermark-Ober Roden'), ('Darmstadt Hbf'), ('Babenhausen (Hessen)'), ('Kahl (Main)'), ('Gelnhausen'), ('Offenbach Hbf'), ('Groß Umstadt-Wiebelsbach');



#INSERT
INTO ROUTE (routeId, anzHalte, ziel_id) values (0 , 0, 0);

#INSERT
INTO ROUTE (routeId, anzHalte, ziel, halte) values ();