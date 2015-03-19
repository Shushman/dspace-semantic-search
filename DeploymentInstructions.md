# Deployment Instructions for Semantic Search v2.x #




| **Tag** | **DSpace Version** | **Release Date** |
|:--------|:-------------------|:-----------------|
| SSv3.0 | DSpace 4.2 with Semantic Search v3.0 | August 3, 2014 |
| SSv2.3 | DSpace 3.2 with Semantic Search v2.3 | October 20, 2013 |
| SSv2.2 | DSpace 1.8.2 with Semantic Search v2.2 | July 1, 2013 |
| SSv2.1\_r2 | DSpace 1.8.2 with Semantic Search v2.1 | April 16, 2012 |
| SSv2.1\_r1 | DSpace 1.7.2 with Semantic Search v2.1 | March 6, 2012 |
| SSv2.0\_r4 | DSpace 1.7.1 with Semantic Search v2.0 | July 5, 2011 |
| SSv2.0\_r3 | DSpace 1.7.1 with Semantic Search v2.0| April 5, 2011 |
| SSv2.0\_r2 | DSpace 1.7.0 with Semantic Search v2.0 | February 7, 2011 |
| SSv2.0\_r1 | DSpace 1.6.2 with Semantic Search v2.0| February 1, 2011 |

_[ChangeLog](http://dspace-semantic-search.googlecode.com/git/dspace-semantic-api/changelog.txt) Info_

### Installation ###
There are the following options for incorporating Semantic Search facility in DSpace:

  * You can [download](http://drive.google.com/folderview?id=0B1p36oSm62skTFlNSjB0NDg2cDQ&usp=sharing) the current release of the patch depending on your DSpace version. Suppose you have a freshly installed and working DSpace installation. Then to apply the patch in git:
```
[dspace-source]$ git apply <patch_file_name>
```
> Next, you should rebuild DSpace. In linux, this should be something like<sup>1</sup>:
```
 cd [dspace-source]/dspace 
 mvn clean package
 cd [dspace-source]/dspace/target/[dspace-build.dir]
 ant -Dconfig=[dspace]/config/dspace.cfg init_configs
 ant –Dconfig=[dspace]/config/dspace.cfg update
```
> _<sup>1</sup>Note that for DSpace 1.8.2 the 'mvn clean package' command needs to run from the root [dspace-source] directory._

> Finally, restart your servlet container. If everything went OK, you should be able to see Semantic Search at: `http://[dspace.jspui.URL]/semantic-search`

  * You can also directly fetch the  whole DSpace modified version by the corresponding tag. For example, for _SSv2.2_:
```
git remote add origin https://code.google.com/p/dspace-semantic-search/
git fetch origin refs/tags/SSv2.2:refs/tags/SSv2.2
```

  * Alternatively you can clone the latest development version:
```
git clone https://code.google.com/p/dspace-semantic-search/
```
> For the two cases above, you should install DSpace anew, as per [documentation](https://wiki.duraspace.org/display/DSDOC/Installation).


### Metadata Export ###
Semantic Search depends on the **OAI** facility to create its ontology on-the-fly. As such, the patch enables also the dspace OAI service and configures it to export metadata in qualified DC format (“qdc”). DSpace limits the number of exported OAI records to 100 by default, but it is possible to change this (see the dspace.cfg for instructions. _For DSpace 3.x this is in xoai.xml. You need to clean OAI cache first for changes to take effect_). Note however that enabling too large a number of items to be exported may crash the reasoner module!


### Linked Data REST Service ###

For Jersey REST service to work properly (now that individuals' indentifiers are encoded within the URL), you need to enable ALLOW\_ENCODED\_SLASH in your servlet container, e.g. for tomcat add the following parameter to your startup script:
```
-Dorg.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH=true
```


### Requirements ###
All required software dependencies are served by our local maven repository at http://swig.hpclab.ceid.upatras.gr/maven/ or other external repos.

### Reasoner Configuration ###
Semantic Search currently supports the following reasoners (through the OWL API):

  1. **Pellet** (v. 2.2.2): This is the reasoner that is selected by default. All necessary Pellet libraries are served by our maven repository (http://swig.hpclab.ceid.upatras.gr/maven/).
  1. **FaCT++** (v. 1.5.x): FaCT++ needs some additional settings in order to be enabled. First, download the appropriate FaCT++ JNI library file from [here](http://code.google.com/p/factplusplus/downloads/list) (choose the one that fits your machine type) and place it in a directory of your preference, be it _`[JNIPath]`_. Then, set in `JAVA_OPTS` the parameter `Djava.library.path`, and make it pointing to your local FaCT++ JNI library, i.e,  `-Djava.library.path=`_`[JNIpath]`_.
  1. **HermitT** (v. 1.3.4): All necessary libraries are served through maven.