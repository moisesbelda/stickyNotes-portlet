<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="com.stickynotes.model.stickyNote" %>
<%@ page import="com.stickynotes.service.stickyNoteLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.model.Group"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys"%>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
%>

