Development Testing
===

### Overview

We have used a multi level testing strategy for our final product. We have used [Unit Testing](http://softwaretestingfundamentals.com/unit-testing/)
 for operations relating to the structure of the visualisation i.e. the data Models and modules relating to creating the visualisation. 
 Other modules we found were considerably complex and not as effective to test by unit testing. 
 We deemed it more valuable to test UI & some database controllers in a more real world approach by using the application ourselves.
 This allowed us to test a lot more inputs on the components without the overhead of setting up test data which would have been more time consuming.

For the UI we decided that [Systems Testing](http://softwaretestingfundamentals.com/system-testing/) was the best option. 
We were able to utilise Black Box [_(BBt)_](http://softwaretestingfundamentals.com/black-box-testing/), White Box [_(WBt)_](http://softwaretestingfundamentals.com/white-box-testing/) 
and Gray Box [_(GBt)_](http://softwaretestingfundamentals.com/gray-box-testing/) testing in order to both assess real world 
usage of the application whilst digging deeper to investigate edge cases only known to the developers. This was accomplished 
using group members that created the UI (BBt), group members who didn't work on the UI but had knowledge of the system (GBt) 
and the client (WBt). Examples of this working well are exampled by on of our UI developers discovery that, due to a bug in the 
D3 library, if a node was placed on another then moved away a new edge would erroneously be created. Our client was also able to 
inform us that the file size restrictions used for the file upload were too restrictive as when they uploaded a different dataset 
(one we did not have access to) they recieved a Whitelabel error. We were then able to fix this bug quite quickly due to their feedback.

Our client was also vital to the [Acceptance Testing](http://softwaretestingfundamentals.com/acceptance-testing/) of our application. 
Working with them we had created a set of functionality goals for the application which we worked towards and could measure to some 
extent for ourselves. This is how we initially tested our application before releasing it to the client. However, their feedback was 
more informative as to what they wanted as the expectations evolved throughout the project. Their continued feedback in the latter 
stages of the project was of great assistance to help guide our priorities when completing the application. Bath SDR using the application gave us 
insight into how the application will be used in the real world, exposing bugs or flaws not apparent to our development team.

---

### Visualisation Graph Testing

Below is a detailed description of the testing strategies used for the dynamic UML diagram in the previous section.
This relates to the uploading and processing of data files used to create the causal chain visualisation.

We have used Travis CI to automatically run testing of the application whenever code is pushed to our git repository.
Maven is used to manage the build of the application in order to run our testing modules. These modules use JUnit and
Springboot testing frameworks to test the logic of Helpers (ProjectHelper & GraphHelper) and Models (Project & Graph).

| Module | Challenges | Testing |
|:---:|:---:|:---:|
| File Upload Controller | Ensuring the files are of the correct format and file type, responding appropriately to unexpected input. | Both our team and the client used the application ourselves to look for errors. We could quickly test different cases using minor changes to .csv files. The client tested a wider variety of datasets, not available to us. This made it quicker to find errors and update the response messages than using unit testing. |
| Project Helper | Removing null fields from legitimate datasets, linking data from across two files.  | We used unit testing to look ensure the complex logic and lambda expressions in this class functioned as expected using small datasets. We could then make sure it scaled by using the application ourselves on the full dataset of real client data. |
| Project | Making sure all the data is correctly stored when called upon by the ProjectHelper. | Identical methodolgy to ProjectHelper. A fairly simple class to test. |
| Graph Helper | Ensuring the graph is correctly weighted and directed. | Identical methodolgy to ProjectHelper. Using the application allowed our team to test our filtering the data which calls upon Graph. |
| Graph | Ensuring the logic functions correctly, making sure the graph updates correctly in the database after every action. | Identical methodolgy to ProjectHelper. Using the application allowed us to see if changes were persistent in the graph storage. We were also able to see that the visualisation filters and node positions were saved between sessions using the application. |

---

#### References
[Software Testing Fundamentals](http://softwaretestingfundamentals.com) 11/11/18
