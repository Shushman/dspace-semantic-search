/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package gr.upatras.ceid.hpclab.test;

import gr.upatras.ceid.hpclab.owl.SemanticSearchException;
import gr.upatras.ceid.hpclab.reasoner.SupportedReasoner;

public class PelletDSpaceTest extends OWLQueryDSpaceOntology
{
    public PelletDSpaceTest() throws SemanticSearchException, InstantiationException,
            IllegalAccessException, ClassNotFoundException
    {
        super(SupportedReasoner.PELLET);
    }
}