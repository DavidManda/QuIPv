Overview
========

### Bath SDR 

BSDR _(Bath Social Development Research Ltd)_ is a non-profit research organisation founded by a small team of researchers
 from the CDS [_(Centre for Development Studies)_](http://www.bath.ac.uk/cds/) at the University of Bath with the ambition
 to bring more research into practice.
 
Using the newly developed QuIP [_(Qualitative Impact Protocol)_](http://bathsdr.org/wp-content/uploads/2017/09/Revised-QUIP-briefing-paper-July-2017.pdf)
 BSDR carries out impact assessment research on behalf of charities working in developing countries.

The QuIP provides a straightforward and cost-effective mechanism to ask intended beneficiaries about significant drivers
 of change in their lives, and to analyse and present the data collected. It is used to help organisations assess, learn
 from and demonstrate the social impact of their work. The most important aspect of the QuIP is placing intended beneficiaries'
 voices at the centre of reporting, whilst demonstrating a genuine commitment to learning about what works and what doesn't.
 
 --- 
  
### Problem 

The procedure needed to produce a visual report of the data is protracted and the quality could be improved. BSDR uses
 [Microstrategy](https://www.microstrategy.com/us) to analyse data and create causal chain diagrams, however, many technical issues arise such as graph being re-rendered every time a filter is applied, losing information about node position.
 
 Our client requests a software that will not replace Microstrategy but improve on its causal chain visualisation
 functionality in terms of diagram creation, manipulation and exportation. The user should be able to create and log into a user account and upload data from their local computer and generate visualisations from it. The data should be processed to create a causal chain diagram similar to Microstrategy. Users should then be able to access their diagram online and manipulate it through dragging the nodes or adding and subtracting nodes by applying filters. After the user is satisfied with the resulting disgram, it should then be able to be exported as either an image file ready to be used in reports or shared with other team members and analysts as an interactive webpage.

---

### Solution 

Our solution is a bespoke applicaton for BSDR that will:
1. Receive CSV data, generate a causal chain graph and store it in a database;
2. Allow the user to filter out nodes by name, or edges by weight;
3. The position of the nodes persists, as metadata about them is stored in the database. 
4. Allow the user to edit the diagram;
5. Allow diagrams to be exported as an image file. 

#### References
[_Bath Social and Development Research Ltd._](http://bathsdr.org/) 9/11/18
