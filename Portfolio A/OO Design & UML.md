## OO Design & UML

### High-level diagram
![](https://raw.githubusercontent.com/DavidManda/QuIPv/master/Portfolio%20A/images/Highlevel.png)
The above diagram illustrates the architecture of our web application. The user can log into our app and upload CSV files that follow a structure specific to our client. Each upload creates a project with a corresponding visualisation, a directed graph.

 The backend is a Java Spring Boot application running on an Oracle server. One of the main components is a converter, that takes the structured data and transforms it in an internal representation, that is then stored in an MySQL database. This data is then used to generate a Graph that can be displayed in the browser.
