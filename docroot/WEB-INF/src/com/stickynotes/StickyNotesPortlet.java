package com.stickynotes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.stickynotes.model.stickyNote;
import com.stickynotes.model.impl.stickyNoteImpl;
import com.stickynotes.service.stickyNoteLocalServiceUtil;

/**
 * Portlet implementation class StickyNotesPortlet
 */
public class StickyNotesPortlet extends MVCPortlet {
	
	public stickyNote stickyNoteFromRequest(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);		
		String text = ParamUtil.getString(request, "text");
		
		text = StringUtil.shorten(text, 100, "");
		String color = ParamUtil.getString(request, "color");	
		double positionX = ParamUtil.getDouble(request,"positionX");
		double positionY = ParamUtil.getDouble(request,"positionY");
		long positionZ = ParamUtil.getLong(request,"positionZ");		
		stickyNote note = new stickyNoteImpl();		
		note.setText(text);
		note.setStickyNoteId(ParamUtil.getLong(request, "stickyNoteId"));		
		note.setPositionX(positionX);
		note.setPositionY(positionY);
		note.setPositionZ(positionZ);			
		note.setColor(color);
		note.setPlid(themeDisplay.getLayout().getLayoutId());
		note.setCompanyId(themeDisplay.getCompanyId());
		note.setGroupId(themeDisplay.getScopeGroupId());
		note.setUserId(themeDisplay.getUserId());
		
		return note;		
		
	}
	
	public void setPreferences(ActionRequest request, ActionResponse response) throws Exception {
		String scope = ParamUtil.getString(request, "scope");
		String onlyuser = ParamUtil.getString(request, "only-user");

		PortletPreferences prefs = request.getPreferences();		
		prefs.setValue("scope", scope);		
		prefs.setValue("only-user", onlyuser);
		prefs.store();		
	}
	
	public void addStickyNote(ActionRequest request, ActionResponse response)	throws Exception {
	
			ArrayList<String> errors = new ArrayList<String>();			
			stickyNote note = stickyNoteFromRequest(request);
	
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long companyId = themeDisplay.getCompanyId();
			long scopeGroupId = themeDisplay.getScopeGroupId();
			
			stickyNoteLocalServiceUtil.addstickyNote(note,userId);
			
			SessionMessages.add(request,"note-added");
			
			sendRedirect(request, response);
			
			//response.setRenderParameter("jspPage", "/html/parts/edit_part.jsp");
			
			//if (PartValidator.validatePart(part, errors)) {
				
		
		}
	
	public void updateStickyNote(ActionRequest request, ActionResponse response) throws Exception {
	
			stickyNote note = stickyNoteFromRequest(request);
			
			ArrayList<String> errors = new ArrayList<String>();
			stickyNoteLocalServiceUtil.updatestickyNote(note);
			
			SessionMessages.add(request, "note-updated");
	
			sendRedirect(request, response);	
			
		}
	
	public void deleteStickyNote(ActionRequest request, ActionResponse response) throws Exception {
			long noteId = ParamUtil.getLong(request, "stickyNoteId");			
			stickyNoteLocalServiceUtil.deletestickyNote(noteId);			
			SessionMessages.add(request, "part-deleted");
			sendRedirect(request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		String resourceId = resourceRequest.getResourceID(); 
		if (Validator.isNotNull(resourceId) && resourceId.length() != 0	&& resourceId.equalsIgnoreCase("updatePositionURL")) {		
			float x = ParamUtil.getFloat(resourceRequest, "x");
			float y = ParamUtil.getFloat(resourceRequest, "y");
			long z = ParamUtil.getLong(resourceRequest, "z");
			long id = ParamUtil.getLong(resourceRequest, "id");
			try {
				stickyNote note = stickyNoteLocalServiceUtil.getstickyNote(id);				
			    note.setPositionX(x);
				note.setPositionY(y);
				note.setPositionZ(z);
				stickyNoteLocalServiceUtil.updatestickyNote(note);				
				
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (Validator.isNotNull(resourceId) && resourceId.length() != 0 && resourceId.equals("deleteNoteURL")) {			
			try {
				long noteId = ParamUtil.getLong(resourceRequest, "stickyNoteId");
				stickyNoteLocalServiceUtil.deletestickyNote(noteId);
				PrintWriter writer = resourceResponse.getWriter();				 
				writer.print("success");
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
