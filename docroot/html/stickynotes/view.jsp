<%@include file="/html/init.jsp"%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	boolean editNote = ParamUtil.getBoolean(renderRequest, "editNote");
	
	boolean hasAddPermission = permissionChecker.hasPermission(
		scopeGroupId, "com.stickynotes.model",
		scopeGroupId, "ADD_NOTE");
	
	boolean hasUpdatePermission = permissionChecker.hasPermission(
		scopeGroupId, "com.stickynotes.model",
		scopeGroupId, "UPDATE_NOTE");
	
	boolean hasDeletePermission = permissionChecker.hasPermission(
		scopeGroupId, "com.stickynotes.model",
		scopeGroupId, "DELETE_NOTE");
	
	boolean hasMovePermission = permissionChecker.hasPermission(
		scopeGroupId, "com.stickynotes.model",
		scopeGroupId, "MOVE_NOTE");
	
	
	boolean hasConfigurePermission = permissionChecker.hasPermission(
		scopeGroupId, Group.class.getName(), scopeGroupId,
		ActionKeys.PERMISSIONS);	
	
%>
<c:choose>
	<c:when test="<%= editNote %>">
		<%@include file="/html/stickynotes/edit_note.jspf" %> 
	</c:when>
	<c:otherwise>
		<%@include file="/html/stickynotes/view_normal.jspf" %> 
	</c:otherwise>
</c:choose>
