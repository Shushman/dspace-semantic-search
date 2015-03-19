

<br />

### Video Tutorial ###

**Semantic Search v2 - Part 1 of 3: Constructing a query**

<a href='http://www.youtube.com/watch?feature=player_embedded&v=fp6PWFx1F8k' target='_blank'><img src='http://img.youtube.com/vi/fp6PWFx1F8k/0.jpg' width='425' height=344 /></a>

**Semantic Search v2 - Part 2 of 3: Results and the Navigation Pane**

<a href='http://www.youtube.com/watch?feature=player_embedded&v=sFA7ucgJrV8' target='_blank'><img src='http://img.youtube.com/vi/sFA7ucgJrV8/0.jpg' width='425' height=344 /></a>

**Semantic Search v2 - Part 3 of 3: Options**

<a href='http://www.youtube.com/watch?feature=player_embedded&v=5eTtv1mfHnU' target='_blank'><img src='http://img.youtube.com/vi/5eTtv1mfHnU/0.jpg' width='425' height=344 /></a>



### Introduction ###

Semantic Search is a novel feature that allows "intelligent" search in DSpace, by taking advantage of Semantic Web technologies. Semantic search, in collaboration with the appropriate inference engine, allows for the construction, submission and evaluation of semantic queries. Queries follow a special OWL syntax known as "Manchester syntax", which maps Description Logics symbols to English words and phrases. More information about Manchester syntax can be found [here](http://www.w3.org/TR/owl2-manchester-syntax/).

<img src='http://images.dspace-semantic-search.googlecode.com/git/ss-interface.jpg' width='500' />

### How to Formulate a Semantic Query ###

Depending on how familiar you are with Manchester syntax, you can choose among two alternative options for constructing your query in the Semantic Search interface, as described below.

**1.** In case you are an expert user, accustomed to ontologies and Manchester syntax, you can directly jump to the "_Generated_ _query_" field and type your query there:

<img src='http://images.dspace-semantic-search.googlecode.com/git/ss-gc-interface.jpg' width='500' />

This is a fully editable text area that leaves at your responsibility the creation of a syntactically correct query. Keep in mind, though, that all provided entities (class names, properties, individuals) should be supplied along with their corresponding prefixes. Hence, don't choose this direct method of query construction until you have a basic knowledge of the underlying ontology.

**2.** If your don't know all syntactic details of Manchester syntax, you can be guided in the creation of your query, by following a step-by-step approach:

<img src='http://images.dspace-semantic-search.googlecode.com/git/ss-cq-interface.jpg' width='500' />

**Step 1 (S1):** Here, you can either provide a property or a class name. An auto-complete mechanism is triggered as soon as you start typing a word, suggesting names for classes and properties of the loaded ontology. Suggested values are grouped under the title _Types_ -for classes- and _Relations_ -for properties. Mark the check box "_not_" only if you want to declare the negation of the class expression you are going to construct. You don't have to worry about prefixes at this point, they are added automatically by the system during the last step (Step 5). In case you have selected a property name, the subsequent fields become active so you can proceed with Step 2. Otherwise you jump to the last step (Step 5) of the query formulation process.

**Step 2 (S2):** As long as you have entered a property name in the previous field, you should now set a number-, value- or existential restriction. For this reason, the "Restriction" drop down menu provides you with available Manchester syntax keywords. This should be your middle atom of the query.

**Step 3 (S3):** "Expression" is an editable, free-text box where you can supply a single class name or expression, an individual or a positive integer, optionally followed by a class. In case you enter a class name, the auto-complete facility is triggered and makes helpful suggestions. Then move to Step 4 in order to proceed with your query's evaluation.

**Step 4 (S4):** By pressing "_Add Term"_the query constructed so far will appear inside the "Generated query" box. If you want to make your search more specific, you can combine your query with more class expressions. To do this you either select a conjunction ("and") or a disjunction ("or") and then go back to Step 1 to create your next operand.

**Step 5 (S5):** This is the final step where you can finally submit your query. Just press the "_Search_" button and then all matching results will appear below the Semantic Search interface, in the form of a table.

### Examples ###

> _for more examples take a look at [this document](http://swig.hpclab.ceid.upatras.gr/SSEvaluationAppendix?action=AttachFile&do=get&target=QueryExamples.pdf)_

For example, suppose you want to retrieve a list of all repository items, namely all instances of the "`Item`" class. This is the simplest case of a semantic query and is expressed through the following single-class expression:

`dspace-ont:Item`

To perform this search, you need to type (or select) the word "`Item`" in the "_Search for_" field (S1), then press the "_Add term_" button (S4), and finally evaluate your query by requesting a "_Search_" (S5):

<img src='http://images.dspace-semantic-search.googlecode.com/git/simple-query.jpg' width='500' />

If you want to obtain all DSpace items that consist of more than one DSpace-specific types (e.g. they are _both_ a learning object _and_ a book or a paper _and_ a dataset) you need the following query:

`dcterms:type min 2 dspace-ont:DspaceType`

In this case, you need to start with the "_Search_ _for_" field (S1) and seek for the "`type`" relation from the auto-complete suggestion list. Select the "`min`" keyword from the "_Restriction_" drop down menu (S2), type in the "_Expression_" field the phrase "`2 dspace-ont:DspaceType`" (S3), and finally press the "Add term" (S4) and "Search" (S5) buttons successively:

<img src='http://images.dspace-semantic-search.googlecode.com/git/complex-query.jpg' width='500' />

### Other Tabs ###

The **_Options_** tab includes options that give you the ability to change: a) the ontology against which the search will be performed and b) the underlying reasoner. By default, the Semantic Search service loads your repository's specific ontology and the "Pellet" reasoner. For querying a different ontology, you just need to provide a valid URL of an OWL/OWL 2-compliant ontology in the "_Ontology_" text box. For using a different reasoner, choose among the currently available Pellet, FaCT++ or HermiT from the drop down menu of the "_Reasoner_" field. Press the "_Save options_" button to commit your changes. Pressing "_Reload_" will create a new reasoner object and load a fresh copy of the ontology, but may take some time.

<img src='http://images.dspace-semantic-search.googlecode.com/git/options.gif' width='500' />

The **_Advanced topics_** tab is currently inactive and is reserved for future extensions of the system.

### Results ###

Results returned by Semantic Search are not merely DSpace items, as is the case with the traditional search facilities of the repository. They can be entities of any type. You can, for example, retrieve all items written by a particular author with the following query:

`dspace-ont:author some (foaf:name value "Georgia")`

Results appear as shown in the next picture (organized in a two-column table):

<img src='http://images.dspace-semantic-search.googlecode.com/git/results.gif' width='400' />

The right column (_Value_) contains the retrieved results which are linkable entities. In this case, item Handle IDs are shown. The left column (_Type_) gives a hint about the class to which the entity belongs.

### The Navigation Pane ###

When you click a result a new page is created on the fly - the navigation pane. This page gives a detailed view of the selected entity and allows navigation among other instances which this entity may be related to:

<img src='http://images.dspace-semantic-search.googlecode.com/git/navigation-pane.gif' width='700' />

More specifically, through the navigation pane you can obtain detailed reference to the entity's ontological information. You are given information about the:

  * _Classes_ to which the selected entity belongs
  * _Object Properties_ that relate the current entity to other entities
  * _Data Properties_ and _Annotation Properties_ that show the entity's relations with text (literal) values.

Each class name is a link that, if selected, all the instances of this class are shown. In fact, you are redirected back to the Semantic Search page with the specific class already predefined.