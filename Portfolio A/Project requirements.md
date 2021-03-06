﻿System Stakeholders
===

### About the Stakeholders
- Clients - Commission the collection of qualitative data bespoke to their own requirements, other clients may just use pre-existing collected data. Examples of clients are;
    - Donors (individuals/groups)
    - Other charities in area/sector
- Environment - This would be the area in which the surveys are conducted in. They play a major role in the outcome of the resulting data, but also can then be in turn affected by the collected data. For instance if the environment was to be chosen for future improvement projects.
- Interviewers - These are local researchers who conduct the collection of qualitative data from interviewees in the selected environment. They are told nothing about the organisation and project whose impact is being assessed, to reduces potential bias from interviewees.
- Interviewees - Selected at random from the chosen environment, the interviewees provide the qualitative date. They answer a series of open-ended questions about changes in selected aspects of their lives and livelihoods over a specified period. Just like the environment, they affect the outcome of the collected data, but can also be affected by the date.
- Ketl - Is a company focused on data management and helps our client migrate his data to the software MicroStrategy.
- Coders - Take the raw field data and having been briefed about details of the project identifies and codes cause-and-effect statements in the data using the QuiP coding system.
- Reporting - Utilised the visualisations in a report, as requested by the client. It also includes analysed data displaying in a variety of ways to demonstrate the key positive and negative drivers of change, and potential links between project activities and incidental/external drivers of change.
- Lead Evaluator (co-ordinates study) - Organise the collection of data, the coding and reporting stages.
- Evaluation Community - QuiP is a new approach to the collection of qualitative date, the evaluation community ensure that it continues to tackles bias in data collection, and encourages real engagement with findings through the use of innovative interactive data visualisations.

---

![high-level use-case diagram](usecase.jpg)

### Achieving Use-Case Goals
- Reporting - Have a visualisations that effectively conveys drivers and outcomes to utilise in report for client
    1. Ensure sufficient qualitative data is collected, it is coded correctly and ready to be imported into visualisation software.
    1. Visualisation software correctly uses the coded data to represents the collected data.  
    1. The visualisation software can reduce the data set, so that only drivers with outcomes of significant weight is displayed
    1. The visualisation allows for manipulation of the graph, so it can be presented neatly, with minimal edges crossing over.
    1. Visualisation software exports the visualisation as a .png ready for use in the report.
    1. The product allows for separate users, so accounts can be created for the clients clients to view dynamic visualisations.
    1. An unintended path through system, would be having limited variations of ways to display the data, and only being able to export the visualisation as a static image.
- Evaluation Community - To be able to assess process of investigation and the final findings to ensure QuiP is working
    1. Firstly the evaluation community would need to assess the collection of data, and how process of preparing it for use in the visualisation software. The QuiP is a part of this 
    stage and would be under the most scrutiny, to ensure it is working as it should be, to improve the use a qualitative data.
    1. The evaluation community may be interested in how the visualisation software takes the coded data, and uses it to represent the drivers of change, that is representative of the data originally collected.
    1. Reporting stage must be successfully completed, to assess the final findings, report, of the investigation.
- Client - To be able to assess impact of charitable work done, request BSDR to carry out report.
    1. Firstly they'll need to have conducted some sort of work that needs to have its impact assessed.
    1. The client then must contact BSDR to create with a bespoke solution to assessing the impact of their work.
    1. The client will then wait for the report which will detail drivers of change, the client can then themselves determine the impact of their work done.
    1. The client will also receive a log in for our product so they can see a dynamic version of the visualisation of the drivers of change.
    1. Alternative path would be being a client that doesn't need to assess impact of specific work, but would make use of already documented drivers of change. 

-----

### Main Goal

The main goal of the project is to decrease the time and effort needed to create visualisations for causal chain analysis. The current method
of using MicroStrategy is slow, clunky and produces a low quality visualisation. Additionally there is no way of saving the visualisation between
sessions, meaning progress is lost, this progress is also reset when filtering by respondent count. 
In order to achieve this, we need to provide a web application.

We will take the following steps to achieve this goal:
- Allow user to upload projects in the form of csv files
- Create a data structure to store project data in a weighted, directed graph
- Allow simple, one-click filtering of fields in the data set
- Provide intuitive UI as outlined in the requirements

Cases of exceptional **(e)** or alternative **(a)** flow include:
- `e` Trying to create a project without a name, missing files, or non .csv files will result in an error message informing the user to correct what they've done wrong.
- `a` Using the product not to create and export a visualisation, but to create one, and then allow the client to log in to view a dynamic version of the visualisation.
- `a` Exporting data before creating a visualisation. This will create a visualisation the export it, without giving the user the chance to edit node positions

----

### Functional requirements
1. Loading and storing data:
    1. data is loaded from two uploaded .csv files, named maintable and sankey.
    1. data is represented internally as a graph structure that connects drivers to outcomes using weighted edges
1. Manipulating the data:
    1. edges can be filtered out of the visualisations by their weight values, using a slider
    1. nodes can be filtered out of the visualisations by their name, using checkboxes in the sidebar, under categories of outcomes and drivers.
1. Creating visualisations:
    1. data is presented to the user as a directed, weighted graph
    1. the user can move nodes on the graph around to rearrange the visualisation
    1. a vertex can be displayed as both a driver and an outcome
1. Exporting the visualisations:
    1. the graph can be exported as a static image file e.g. .png
    1. the graph can be additionally exported by sending login details to the client for them to view a dynamic version of the visualisation.

### Non-functional requirements
1. User Interface
    1. Use of all features of the program can be learnt in at most 5-10 minutes, due to its similarity of the clients previous system MicroStrategy.
    1. The general flow of drivers to outcomes in the visualisation will be left to right
1. Maintainability & Extendability
    1. The data structure for each node will allow any number of nodes to be implemented in a graph
1. Security
    1. Security will come in the form of users having their own separate account
    1. New accounts can be created once a current user has logged in
1. Performance
    1. Data will be loaded from .csv files within 5 seconds.
    1. Visualisations will be created within 15 seconds for the 24 interviewees
    1. All visualisations will be exported within 5 seconds


#### References

[_Bath Social & Development Research Ltd._](http://bathsdr.org/) 09/11/18
