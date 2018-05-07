Numbers to Words Conversion Tool
====================

This project runs a self contained jetty server hosted on http://localhost:8080.  

It serves up a simple HTML interface with a backing REST API.



### To Run 
#### Requirements
1. Maven
1. Java JRE

#### HOW-TO
1. Download all the src
1. Open a command line terminal
1. Navigate to the root directory of the repository
1. Execute `mvn clean install` 
    * This will produce a jar file in the target directory
1. Execute the jar file
    * ex: `java -jar target\sonatype-hw-1.0.jar`
    
A Jetty server is now running at [localhost:8080](http://localhost:8080).  Navigate to the URL using your favorite browser
and start converting!
