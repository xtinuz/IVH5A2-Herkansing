::
:: IVH5 startscript for RMI registry.
::
:: Requirements:
:: - Java JDK installed.
:: - rmiregistry can be found from the command line.
::   (add javahome/bin to your PATH-environment variabele)
:: - Webserver up and running.
:: - The application classes must be available at the codebase location.
::
:: The codebase provides the location of the application classes. The registry,
:: server and client need to be able to find these classes via the webserver.
:: You can modify the codebase to be any other path, as long as all parties
:: can access the code at the codebase.
::

rmiregistry -J-Djava.rmi.server.codebase="http://localhost/classes/physio-server.jar http://localhost/classes/physio-shared.jar http://localhost/classes/physio-api.jar http://localhost/classes/shared-1.0-SNAPSHOT.jar http://localhost/classes/SharedPhysioInsurance-1.0-SNAPSHOT.jar"

@pause