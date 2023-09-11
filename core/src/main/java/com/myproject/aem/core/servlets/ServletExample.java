package com.myproject.aem.core.servlets;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

//                                  ............OSGi D.S using Servlet Version (1.2) (R5).........
@Component(service = Servlet.class,
        property = {
        		"sling.servlet.paths=/bin/nag",
        		
        		"sling.servlet.resourceTypes=myproject/components/helloworld",
        		"sling.servlet.selectors=one",
        		"sling.servlet.extensions=recent"
        		
        }
		)
public class ServletExample extends SlingSafeMethodsServlet{
	
	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {
		JsonObjectBuilder obj = Json.createObjectBuilder();
		obj.add("Name", "Nagendra Babu");
		obj.add("Institute", "Surge Software Solutions");
		obj.add("Role", "Trainee");
		obj.add("Location", "BEML Layout, Brookfield");
		res.getWriter().write(obj.build().toString());
	}
}
