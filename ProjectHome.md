_**`***`**Help us improve Semantic Search for DSpace! Take this [survey](http://goo.gl/Zt0aP)**`***`**._

_**`***`**Support us on [Bountysource](https://www.bountysource.com/teams/dspace-semantic-search)**`***`**._



---


|[Deployment Instructions](DeploymentInstructions.md)| [Demo](http://swig.hpclab.ceid.upatras.gr/dspace-ss-demo)|
|:---------------------------------------------------|:---------------------------------------------------------|
|[Documentation & Videos](Documentation.md) | [Current Master Installation](http://apollo.hpclab.ceid.upatras.gr:8000/jspui-master)|
|[ChangeLog](http://dspace-semantic-search.googlecode.com/git/dspace-semantic-api/changelog.txt)|[Discussion Group](http://groups.google.com/group/dspace-semantic-search)|
| [Fact Sheet](http://dspace-semantic-search.googlecode.com/files/poster-final-A3.pdf) |[More Info](https://wiki.duraspace.org/display/DSPACE/Kotsomit) |

![http://images.dspace-semantic-search.googlecode.com/git/intro-screen.jpg](http://images.dspace-semantic-search.googlecode.com/git/intro-screen.jpg)

<wiki:gadget url="http://google-code-feed-gadget.googlecode.com/svn/trunk/gadget.xml" up\_feeds="http://dspace-semantic-search.blogspot.gr/atom.xml" width="80%" height="340" up\_maxFeeds="5" up\_gadgetTitle="News & Updates"/>


---


## Semantic Search for DSpace v. 3.0 ##
**Semantic Search v3.0** has been released. This version is compatible with **DSpace 4.x** and bundles a series of new features and improvements:
  * **Syntax highlighting** for Manchester Syntax, implemented through the CodeMirror Javascript component v.3.16.1,
  * a **query history** subsystem that keeps track of the last five input queries,
  * a **RESTful Linked Data provider** that exposes all reified resources’ (items, collections, authors, sponsors, mime types....) metadata as resolvable entities. Both HTML as well as RDF/XML representations are accommodated following a specific URI pattern or automatically, using content negotiation, based on the Jersey Framework.
  * a **DBpedia URL injection** and resolution facility for authors, contributors, sponsors and item types, as well as for subject and publisher values, that links to the DBpedia Lookup service.
  * Enabled the **SPARQL query tab**, supporting syntax highlighting and query history (not yet operational).
  * Compatibility with DSpace 4.x.
  * **Bootstrap-based look&feel** for the navigation pane and the semantic query interface pages.
  * Updated **HermiT** to **v1.3.8.4**.
  * Updated **FaCT++** to **v1.6.3**.
  * Updated **OWL API** to **v3.5**.


---


## Semantic Search for DSpace v. 2.3 ##

We have just released **v2.3** of Semantic Search for DSpace. This is mostly a maintenance and compatibility release that adjusts Semantic Search for **v3.x** of DSpace:

  * Provide a **new qdc.xsl** that allows full export of internal DSpace metadata to dcterms including bitstream metadata, types and language tags. This file replaces the default and its effects can be seen through the standard OAI interface.
  * Output semantic **query time** to the front-end (just like in traditional search).
  * various pom files fixes and configurations.

You can download the new version directly from git ([tag SSv2.3](http://code.google.com/p/dspace-semantic-search/source/browse/?name=SSv2.3)) or you can apply this [patch](http://code.google.com/p/dspace-semantic-search/downloads/detail?name=dspace-3.2-semantic-search-v2.3.patch) as per the updated [instructions](DeploymentInstructions.md).

**Attention:** for changes to take effect you need to _clean the OAI cache_ first:
`[dspace/bin]>./dspace oai clean-cache`



---


## Semantic Search for DSpace v. 2.2 is out! ##
This is to announce the release of **Semantic Search v2.2** for DSpace. This release is compatible up to **DSpace 1.8.2** and includes mostly bug fixes and improvements in the ontology construction. A release compatible with **DSpace 3.1** will be available soon. What's new:
  * **Better exception handling**/bug fixes: Avoid “Internal System Error” when ontology URL cannot load
  * Added **recent history** for **ontology URLs** in Options
  * Improved support for queries with the **DateTime datatype**. E.g. to find items accepted after 1-1-2011:  dcterms:available some xsd:dateTime[>"2011-01-01T00:00:00Z"^^xsd:dateTime]
  * **Linked Data**: Instead of URNs, the XSLT now assigns resolvable identifiers to ~~items and~~ collections (handles, if available)
Moreover:
  * Added three video tutorials under [Documentation](http://code.google.com/p/dspace-semantic-search/wiki/Documentation)
  * Bundled [changelog](http://dspace-semantic-search.googlecode.com/git/dspace-semantic-api/changelog.txt)
  * Added ontology files under git control ([here](http://code.google.com/p/dspace-semantic-search/source/browse?repo=ontologies))
  * Set up a version independent demo URL: http://swig.hpclab.ceid.upatras.gr/dspace-ss-demo The demo has been also updated to Semantic Search v2.2.


---

## Semantic Search for DSpace v. 2.1 released! ##
**Semantic Search version 2.1** fixes some issues with the previous version and contains new features, updates and improvements, like for example:
  * **Persistent reasoner cache**. In addition to the ontology registry and inference     precomputation there is now a reasoner registry for further speed-up and performance.
  * Added **Hermit 1.3.4** support.
  * Upgraded to **OWL API v3.2.4**.
  * Upgraded to **FaCT++ 1.5.2** API.
  * Added **reload button** in _Options_ to clear cache and load ontology and reasoner anew.
  * **Ontology enhancements** and namespace change.

The [demo](http://apollo.hpclab.ceid.upatras.gr:8000/jspui17-demo/semantic-search) has been now updated to Semantic Search v2.1.

An installation of the current trunk is available [here](http://apollo.hpclab.ceid.upatras.gr:8000/jspui18/semantic-search).

An updated patch for **DSpace 1.8.2** has now be [released](http://dspace-semantic-search.googlecode.com/files/dspace-1.8.2-semantic-search-v2.1_r2.patch).

A patch working and tested for **DSpace 1.7.x** is also available [here](http://dspace-semantic-search.googlecode.com/files/dspace-1.7.1-semantic-search-v2.1_r1.patch).

---


## Semantic Search for DSpace v. 2.0 ##

Semantic Search allows intelligent search of DSpace content, using Semantic Web technologies. It has now been totally refactored as an **add-on for DSpace** 1.6+ **and 1.7** and includes a series of new features, such as:
  * **New intuitive query interface**, based on guided construction of Manchester Syntax queries.
  * Support for **OWL API v3.1.0**.
  * Introduction of the **Dspace Semantic API** as a "catch-all" for all ontology-related tasks.
  * Support for latest **FaCT++** and **Pellet**.
  * **"Hot-swap"** between reasoners.
  * **Caching** loaded ontologies.

**New**: One-page fact sheet about DSpace Semantic Search (from the ESWC 2011 demo): [pdf](http://dspace-semantic-search.googlecode.com/files/poster-final-A3.pdf)

A demo installation of Semantic Search for DSpace is available [here](http://apollo.hpclab.ceid.upatras.gr:8000/jspui17-demo/semantic-search).
