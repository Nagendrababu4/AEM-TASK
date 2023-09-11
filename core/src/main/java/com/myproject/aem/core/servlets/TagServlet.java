package com.myproject.aem.core.servlets;

import java.io.IOException;
import java.security.AccessControlException;
import java.util.Iterator;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import com.day.cq.tagging.InvalidTagFormatException;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/nagendra")

public class TagServlet extends SlingAllMethodsServlet {   //......TAG Servlet.........

	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException 
	{
	    Tag createTag = null;
		ResourceResolver resolver = req.getResourceResolver();
		TagManager tagManager = resolver.adaptTo(TagManager.class);
		Tag resolve = tagManager.resolve("/content/cq:tags/julytag/color");
		try {
			 createTag = tagManager.createTag("/content/cq:tags/julytag/nag", "Title", "Description");
		} catch (AccessControlException | InvalidTagFormatException e1) {
			e1.printStackTrace();
		}
		
		Iterator<Tag> listChildren = resolve.listChildren();
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(jsonObject);
		while(listChildren.hasNext()) {
			Tag next = listChildren.next();
			next.getTitle();
			next.getPath().toString();
			
			try {
				jsonObject.put("Title", next.getTitle());
				jsonObject.put("Path", next.getPath());
				jsonObject.put("Child Tag", createTag);
			}
			catch (JSONException e) {
				
				e.printStackTrace();
			}
			res.getWriter().write(createTag.toString());
			res.getWriter().write(jsonArray.toString());
		}
	}

}

