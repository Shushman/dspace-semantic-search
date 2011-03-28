<%--

    The contents of this file are subject to the license and copyright
    detailed in the LICENSE and NOTICE files at the root of the source
    tree and available online at

    http://www.dspace.org/license/

--%>
<%--
  - Admin tool index page
  -
  - Note that this is a "stand-alone" JSP that is invoked directly, and not
  - via a Servlet.
  -
  - This means there's some business logic, basically some minimal stuff
  - from DSpaceServlet.java.  This shouldn't happen elsewhere in the JSPs.
  --%>

<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
    prefix="fmt" %>
	
<%@ taglib uri="http://www.dspace.org/dspace-tags.tld" prefix="dspace" %>

<%@ page import="java.sql.SQLException" %>

<%@ page import="org.apache.log4j.Logger" %>

<%@ page import="org.dspace.app.webui.util.JSPManager" %>
<%@ page import="org.dspace.app.webui.util.UIUtil" %>
<%@ page import="org.dspace.core.Context" %>
<%@ page import="org.dspace.core.LogManager" %>

<%
    // Obtain a context so that the location bar can display log in status
    Context context = null;

    try
    {
        context = UIUtil.obtainContext(request);
%>
<dspace:layout locbar="link" navbar="admin" titlekey="jsp.administer">

    <%-- <h1>Administration Tools</h1> --%>
    <h1><fmt:message key="jsp.dspace-admin.index.heading"/></h1>
    
    <%-- <p>Please select an operation from the navigation bar on the left.</p> --%>
    <p><fmt:message key="jsp.dspace-admin.index.text"/></p>
</dspace:layout>
<%
    }
    catch (SQLException se)
    {
        // Database error occurred.
        Logger log = Logger.getLogger("org.dspace.jsp");
        log.warn(LogManager.getHeader(context,
            "database_error",
            se.toString()), se);

        // Also email an alert
        UIUtil.sendAlert(request, se);

        JSPManager.showInternalError(request, response);
    }
    finally {
      context.abort();
    }
%>

