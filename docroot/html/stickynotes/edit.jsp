<%@include file="/html/init.jsp" %>

<portlet:actionURL name="setPreferences" var="setPreferencesUrl" />

<aui:form action="<%= setPreferencesUrl %>" method="POST" name="fm" >

	<aui:select label="select-scope" name="scope">
		<aui:option selected='<%=prefs.getValue("scope","scope-group").equals("scope-group")%>' value="scope-group">
			<liferay-ui:message key="scope-group" />
		</aui:option>
		<aui:option selected='<%=prefs.getValue("scope","").equals("scope-plid") %>' value="scope-plid">
			<liferay-ui:message key="scope-plid" />
		</aui:option>
	</aui:select>

	<aui:input label="only-user" name="only-user" value='<%= prefs.getValue("only-user","false") %>' type="checkbox"  />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>