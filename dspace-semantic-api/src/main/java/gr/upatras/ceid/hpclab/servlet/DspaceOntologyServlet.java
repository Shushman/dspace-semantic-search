/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package gr.upatras.ceid.hpclab.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.dspace.app.webui.servlet.DSpaceServlet;
import org.dspace.authorize.AuthorizeException;
import org.dspace.core.Context;
import org.dspace.core.ConfigurationManager;

/**
 * Servlet for exporting OAI qualified Dublin Core in OWL format
 * 
 * @author kotsomit
 */
@SuppressWarnings("serial")
public class DspaceOntologyServlet extends DSpaceServlet
{
    protected void doDSGet(Context context, HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException, SQLException, AuthorizeException,
            FileNotFoundException
    {
        response.setContentType("application/rdf+xml; charset=UTF-8");

        String oaiService = ConfigurationManager.getProperty("oai", "dspace.oai.url") + "/request?verb=ListRecords&metadataPrefix=qdc";

        try
        {
            URL xsltURL = new URL("http://swig.hpclab.ceid.upatras.gr/dspace-ont/transformer.xslt");
            InputStream xsltStream = xsltURL.openStream();
            StreamSource xsltStreamSource = new StreamSource(xsltStream);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(xsltStreamSource);

            URL oaiURL = new URL(oaiService);
            InputStream oaiStream = oaiURL.openStream();
            transformer.transform(new StreamSource(oaiStream), new StreamResult(response
                    .getWriter()));
        }
        catch (Exception ex)
        {
            throw new FileNotFoundException();
        }
    }
}
