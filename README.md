isis-kitchensink
================

An app to act as a regression suite for [Apache Isis](http://isis.apache.org).


## Getting started (IntelliJ)

* Import into IntelliJ, using File > Import Module

* in the `kitchensinkapp-webapp`, locate `ide/intellij/launch` directory

* as per the README says, copy files into `workspace\.idea\runConfigurations` directory, and adjust file paths for Maven tasks.


## Running the app

The `-with-fixtures` run configuration runs the app using an additional system property that instructs Isis 
to run the fixture script defined in `WEB-INF/isis.properties`.

Login using `sven/pass`.
