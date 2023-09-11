package com.myproject.aem.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

//                                     ........OSGi D.S using Servlet Version(1.4)(R7)................
@Component(service = Servlet.class)
@SlingServletResourceTypes(resourceTypes = "myproject/components/page",
                           selectors = "one",
                           extensions = "json")  
public class OSGIServletExample extends SlingAllMethodsServlet{
	
	public void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res) throws IOException {
		String pageroot = req.getParameter("pageroot");
		if(pageroot==null) {
			pageroot="/content/myproject/us/en";
		}
		ResourceResolver resolver = req.getResourceResolver();
		PageManager pageManager = resolver.adaptTo(PageManager.class);
		Page page = pageManager.getPage(pageroot);
		Iterator<Page> listChildren = page.listChildren();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		while(listChildren.hasNext()) {
			Page next = listChildren.next();
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("title",next.getTitle());
			job.add("path",next.getPath());
			job.add("Description",next.getDescription());
//			If you want properties 
			ValueMap properties = next.getProperties();
			job.add("sling:resourceType",properties.get("sling:resourceType",String.class));
			jab.add(job);
		}
		res.getWriter().write(jab.build().toString());
		
	}

}
