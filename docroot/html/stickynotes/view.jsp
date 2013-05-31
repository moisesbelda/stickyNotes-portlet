<%@include file="/html/init.jsp"%>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
	
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

<portlet:renderURL var="addNoteURL" windowState="exclusive" portletMode="view" >
			<portlet:param name="jspPage" value="/html/stickynotes/edit_note.jsp" />
			<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:renderURL>
<portlet:resourceURL id="updatePositionURL" var="updatePositionURL"></portlet:resourceURL>
<portlet:resourceURL id="deleteNoteURL"     var="deleteNoteURL"></portlet:resourceURL>


<aui:button-row>
	<c:if test='<%= hasConfigurePermission %>'>
		<liferay-security:permissionsURL
			modelResource="com.stickynotes.model"
			modelResourceDescription="stickynotes-top-level-actions"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL" />
		<aui:button value="permissions" onClick="<%= permissionsURL %>" />
	</c:if>
	<c:if test='<%= hasAddPermission %>'>		
		<aui:button name="addNoteButton" value="add-note" onClick="javascript:addNote();" />
	</c:if>	
	<c:if test='<%= hasUpdatePermission %>'>	    
		<aui:button name="editNoteButton" value="edit-note" onClick="javascript:editNote();" />
	</c:if>
	<c:if test='<%= hasDeletePermission %>'>		
		<aui:button name="deleteNoteButton" value="delete-note" onClick="javascript:deleteNote();"  />
	</c:if>
</aui:button-row>
<div id="stickynotes" class="selectable">	
	<%
		List<stickyNote> lista = new ArrayList<stickyNote>();
		boolean onlyuser = new Boolean(prefs.getValue("only-user","false"));
		if (prefs.getValue("scope","scope-group").equals("scope-group") ){
			if(onlyuser){
				lista = stickyNoteLocalServiceUtil.getStickyNotesByGroupAndUser(scopeGroupId, themeDisplay.getUserId());
			} else {
				lista = stickyNoteLocalServiceUtil.getStickyNotesByGroup(scopeGroupId);
			}
		} else if(prefs.getValue("scope","").equals("scope-plid")) {
			if(onlyuser) {
				lista = stickyNoteLocalServiceUtil.getStickyNotesByPlidAndUser(themeDisplay.getLayout().getLayoutId(), themeDisplay.getUserId());							
			} else {
				lista = stickyNoteLocalServiceUtil.getStickyNotesByPlid(themeDisplay.getLayout().getLayoutId());				
			}
		} else {
			lista = stickyNoteLocalServiceUtil.getStickyNotesByGroup(scopeGroupId);
		}
		for(stickyNote note:lista) {
			String text = note.getText();
			text = StringUtil.shorten(text, 70);
			User usernote = UserLocalServiceUtil.fetchUser(note.getUserId());
		
			%>
	<div class="note <%= note.getColor() %> sizeMaxi" style="left:<%= note.getPositionX()%>%;top:<%= note.getPositionY()%>%;  z-index:<%= note.getPositionZ()%>">
        <%= text %>     
        <span class="data-note"><%=note.getStickyNoteId() %></span>
        <img  class="avatar-note" alt="<%= HtmlUtil.escape(usernote.getFullName()) %>" class="user-logo" src="<%= usernote.getPortraitURL(themeDisplay) %>" style="width: 16%; position:absolute; bottom:5%; right:5%;"/>
	</div>
			<%
		}		
	%>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		// Init buttons		
		$('#<portlet:namespace/>editNoteButton').hide();
		$('#<portlet:namespace/>deleteNoteButton').hide();
		
		// Finding the biggest z-index value of the notes
		var tmp;				
		$('.note').each(function(){
			
			tmp = $(this).css('z-index');
			if(tmp>zIndex) zIndex = tmp;
			$(this).css("height", $('.note').width()+"px");
		})
		<% if(hasMovePermission) { %>
		//Make elements selectable/draggables and put events
		make_selectable_draggable($('#main'));
		<% }%>
		//Calculate relative height
		calculateHeight();		
	});
	
	var zIndex = 0;
	
	function calculateHeight() {		
		var boardWidth = $('#stickynotes').width();
		var boardHeight = (boardWidth * 60) / 100;
		$('#stickynotes').css("height", boardHeight+"px");	
		
		var noteHeight = $('note').height();		
		var noteWidth = $('.note').width();
		$('note').css("height",noteWidth+"px");
	}
	
	function showPopup(url){
		AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
			var dialog = new A.Dialog({
			title: '<liferay-ui:message key="edit-note" />',
			height:330,
			width:445,
			centered: true,
			draggable: true,
			modal: true
		}).plug(A.Plugin.IO, {uri: url}).render(); 
			dialog.show(); 
		});		
	}
	
	<% if(hasAddPermission) {%>
	function addNote(){
		showPopup('<%= addNoteURL%>');
	}
	<%}%>
	<%if(hasUpdatePermission) {%>
	function editNote(){
		var noteSelected = $(".selectable .note.ui-selected span.data-note").html();
		if(noteSelected) {				
			AUI().use("liferay-portlet-url", function(a) {
				   var portletURL = Liferay.PortletURL.createRenderURL();
				   portletURL.setPortletId("<%= portletDisplay.getId() %>");
				   portletURL.setWindowState('exclusive');
				   portletURL.setPortletMode('view');
				   portletURL.setParameter("jspPage", "/html/stickynotes/edit_note.jsp");
				   portletURL.setParameter("redirect", "<%= redirect %>");
				   portletURL.setParameter("stickyNoteId", noteSelected);
				   showPopup(portletURL.toString());
			});				
		}
	}	
	<%}%>
	<% if(hasDeletePermission) {%>
	function deleteNote() {		
		var noteSelected = $(".selectable .note.ui-selected");
		var noteSelectedId = $(".selectable .note.ui-selected span.data-note").html();	
		if(noteSelectedId) {
			if(confirm("<liferay-ui:message key="confirmation-delete-note" />")){			
				$.ajax(
						{
							type: 'POST',
							url: '<%= deleteNoteURL%>',
							data: {								
								stickyNoteId	: noteSelectedId
							},
							success: function(a){								
								$(noteSelected).remove();
							}							
						}
				)		
			}
		}
	}
	<%}%>

	<% if (hasMovePermission) { %>
	
	function make_selectable_draggable(elements){
		
		elements.selectable({		
			unselected:function(e,ui) {			   
				$('#<portlet:namespace/>editNoteButton').hide();
				$('#<portlet:namespace/>deleteNoteButton').hide();
			}		
		});
	
		$(".selectable .note").click(function(){
		            if( !$(this).hasClass("ui-selected")) {
		                $(this).addClass("ui-selected").siblings().removeClass("ui-selected");
		            }	            
		           	$('#<portlet:namespace/>editNoteButton').show(); 				
					$('#<portlet:namespace/>deleteNoteButton').show();
		    }
		);
		$(".selectable .note").dblclick(function(event) {
			editNote();
		});
		    
		$(".selectable .note").draggable({
			containment:'parent',
		    start: function(ev, ui) 
		    {        
		        if( !$(this).hasClass("ui-selected")) 
		        {
		            $(this).addClass("ui-selected").siblings().removeClass("ui-selected");
		        }
		        ui.helper.css('z-index',++zIndex);	       
		    },
		    stop: function(e,ui){
		    	var percentTop = ui.position.top / ui.helper.parent().height() *  100;			
				var percentLeft = ui.position.left / ui.helper.parent().width() * 100;			
				$(this).css("left",percentLeft+'%');
				$(this).css("top",percentTop+'%');
		    	$.ajax(
						{
							type: 'POST',
							url: '<%= updatePositionURL %>',
							data: {
								x: percentLeft,
								y: percentTop,
								z: zIndex,
								id	: parseInt(ui.helper.find('span.data-note').html())
							}
						}
				);
		    }
		});	
	}
	<%}%>

	$('#stickynotes').resize(function(){		
		var currentWidth = $('#stickynotes').width();
		if(currentWidth <= 400) {
			$('.note').removeClass("sizeMaxi").removeClass("sizeMedium").addClass("sizeMini");					
			 console.log("resized mini");
		} else if(currentWidth>400 && currentWidth<800){
			$('.note').removeClass("sizeMaxi").removeClass("sizeMini").addClass("sizeMedium");
			 console.log("resized medium");
		} else if(currentWidth>=800) {
			$('.note').removeClass("sizeMini").removeClass("sizeMedium").addClass("sizeMaxi");
			 console.log("resized Maxi");
		}		
	
		$('.note').each(function(){
			  $(this).css("height", $('.note').width()+"px");
		});		
		calculateHeight();
		
	});
</script>