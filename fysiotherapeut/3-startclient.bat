::
:: Batch bestand voor het starten van de IVH5 LibraryClient.
::
:: Voer dit batchbestand uit vanuit de IVH5\client directory, of pas de paden naar
:: de classes hieronder aan.
:: Zorg ervoor dat de registry en de LibraryServer gestart zijn.
::

java -cp .\client\target\physio-client.jar edu.avans.ivh5.client.view.main.PhysioClient -properties .\client\resources\client.properties

@pause