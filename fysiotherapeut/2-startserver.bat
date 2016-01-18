::
:: Batchbestand voor het starten van de IVH5 LibraryServer.
:: Je start de server het handigst vanuit de directory waar de webserver
:: de classes kan vinden. Pas deze zo nodig hieronder aan.
::
cd C:\development\java\IVH5A2 Project\fysiotherapeut\target

:: Start java met het juiste classpath
start java -cp ./physio-server.jar;./physio-shared.jar;./physio-api.jar;./dependencies/log4j-1.2.17.jar;./dependencies/mysql-connector-java-5.1.33.jar edu.avans.ivh5.server.model.main.PhysioServer -properties resources/breda.properties
 
:: Wanneer je securityproblemen wilt oplossen, voeg dan onderstaande optie aan het command toe.
:: Hiermee krijg je inzicht in alle security instellingen.
::
:: 		-Djava.security.debug=access,failure

@pause