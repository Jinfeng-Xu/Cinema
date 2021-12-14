# Please read me first
Consider the possibility of simultaneous use of multiple systems.
We provide two types of users.
Among them, "Admin" is used by the administrator to manage the basic information of the theater, such as theater information, movie information, and time information, etc.
"Customer" is used for purchasers to purchase tickets.

Consider the possibility of database conflicts. We use **cloud databases** for real-time information storage and modification.
At the same time, consider that a large number of queries may affect system performance. For objects that are more time-consuming to query, the objects are stored in file format after the initial query. Priority access to local file objects, if there is no corresponding local object, go to the cloud database to find it.

In order to reduce the coupling between SQL and code, and facilitate unified management and optimization, reusability. We used the **Mybatis** framework.


# Project structure
```
├── main			    // Main
│   ├── gui			    // gui fxml resources
│   ├── java			// java files
│   │  ├── controller   // ui controller
│   │  ├── dao		    // connect with cloud db
│   │  ├── observer		// observe entity to update ui
│   │  ├── pojo		    // entity
│   │  ├── service		// service
│   │  ├── util			// utils
│   │  ├── ViewAlter	// App entrance
│   ├── persistent	    // Some cached objects are used to reduce queries and improve performance
│   ├── posters			// Temporary image file
│   ├── resources		// Configuration files and properties files
│   ├── log.log			// log for system
├── test			    // Test           
│   ├── java			// class files
│   │  ├── dao			// Database connection layer test
│   │  ├── service		// Business connection layer test
│   │  ├── util			// utils test

```

# Demo
Some demonstration videos about the system can be viewed in the VideoDemo file.

# Technologies
JavaFX, Mybatis, Maven
log4j, junit

# Run
Start View Alter.java

    
    
