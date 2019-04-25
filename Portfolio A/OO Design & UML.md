## OO Design & UML

### High-level diagram
![](https://raw.githubusercontent.com/DavidManda/QuIPv/master/Portfolio%20A/Highlevel.png)

The above diagram illustrates the architecture of our web application. The user can log into our app and upload CSV files that follow a structure specific to our client. Each upload creates a project with a corresponding visualisation, a directed graph.

 The backend is a Java Spring Boot application running on an Oracle server. One of the main components is a converter, that takes the structured data and transforms it in an internal representation, that is then stored in an MySQL database. This data is then used to generate a Graph that can be displayed in the browser.


![](https://raw.githubusercontent.com/DavidManda/QuIPv/master/Portfolio%20A/staticUML.png)

![](https://raw.githubusercontent.com/DavidManda/QuIPv/master/Portfolio%20A/dynamicUML.png)

These diagrams capture a key part of our system, the process which takes the raw upload data and creates a graph from it. This is achieved in two steps. First, the upload data is used to create a Project object, that has a similar structure to the upload data, but is easier to manipulate. Then, a Graph object is created from the Project object. Only this graph is stored in our database and is then displayed.

The reasoning behind this is that it allows our app to be flexible. Both the graph we need to show and the input data might change in the future, so we want to be able to deal with this change with ease and with little side effects. This can be achieved as all that needs to be maintained is the mapping from Project to Graph, which we have full control over.
