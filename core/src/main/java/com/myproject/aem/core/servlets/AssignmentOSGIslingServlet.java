package com.myproject.aem.core.servlets;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;


@Component(service = Servlet.class,
           property = {
        		   "sling.servlet.paths = /bin/Nagendrababu",
        		   "sling.servlet.resourceTypes=myproject/components/helloworld",
        		   "sling.servlet.selectors=one",
        		   "sling.servlet.extensions=json"
        		   }
               )
public class AssignmentOSGIslingServlet extends SlingSafeMethodsServlet{
	
	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {
		
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("Name", "Nagendra Babu");
		job.add("Location", "Bangalore");
		job.add("jobTitle", "AEM Developer");
		
		res.getWriter().write(job.build().toString());
	}
	
	

}
