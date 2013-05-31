<%@include file="/html/init.jsp"%>

<%

stickyNote note = null;

long stickyNoteId = ParamUtil.getLong(request, "stickyNoteId");

if (stickyNoteId > 0) {
	note = stickyNoteLocalServiceUtil.getstickyNote(stickyNoteId);	
}
String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= (note != null) ? "edit-note" : "new-note" %>'
/>

<aui:model-context bean="<%= note %>" model="<%= stickyNote.class %>" />

<portlet:actionURL name='<%= note == null ? "addStickyNote" : "updateStickyNote" %>' var="editNoteURL" windowState="normal" />

 <div id="notedata">
		<!-- The preview: -->
		<div id="previewNote" class="sizeMaxi <%= note == null ? "yellow" : note.getColor() %>" style="float:left">
			<div class="body"><%= note == null ? "" : note.getText() %></div>			
			<span class="data"></span>
			<img class="avatar-note" alt="<%= HtmlUtil.escape(user.getFullName()) %>" class="user-logo" src="<%= user.getPortraitURL(themeDisplay) %>" style="width: 16%; position:absolute; bottom:5%; right:5%;"/>
		</div>
		<div id="formNote" style="margin: 30px 0 0 200px;">
			<aui:form action="<%= editNoteURL %>" method="POST" name="fm">				
				<aui:fieldset>				
					<aui:input type="hidden" name="redirect" value='<%= redirect %>' />	
					<aui:input type="hidden" name="stickyNoteId"   value='<%= note == null ? "" : note.getStickyNoteId() %>'/>
					<aui:input type="hidden" name="color"    value='<%= note == null ? "yellow" : note.getColor() %>' />
					<aui:input type="hidden" name="positionX" value='<%= note == null ? "10" : note.getPositionX() %>' />
					<aui:input type="hidden" name="positionY" value='<%= note == null ? "10" : note.getPositionY() %>' />
					<aui:input type="hidden" name="positionZ" value='<%= note == null ? "1" : note.getPositionZ() %>' />
					<aui:input label="note-text"  name="text" type="textarea" value='<%= note == null ? "" : note.getText() %>' size='300' onKeyUp='javascript:updateText(this.value);' style="width:200px; height:100px;" />
				</aui:fieldset>
				<label><liferay-ui:message key="note-color" /></label>
				<div class="color-chooser yellow"></div>
				<div class="color-chooser blue"></div> 
				<div class="color-chooser green"></div>
				<div class="color-chooser red"></div>
				<div class="color-chooser purple"></div>
				<div class="color-chooser orange"></div>
				<aui:button-row>
					<aui:button type="submit" />
					<aui:button type="cancel" onClick="<%= redirect %>" />
				</aui:button-row>
			</aui:form>
		</div>
	</div>
<script type="text/javascript">	
	function updateText(text){
		var count = $('#previewNote .body').html().length;
		console.log("Count="+count);
		if(count<70) {
			$('#previewNote .body').html(text);	
		}
	}


	/* Changing the color of the preview note: */
	$('.color-chooser').live('click',function(){
		var color = $(this).attr('class').replace('color-chooser','');
		$('#previewNote').removeClass('yellow green blue red purple orange').addClass(color);
		$('#<portlet:namespace/>color').val(color);
		console.log(color);
	});
</script>