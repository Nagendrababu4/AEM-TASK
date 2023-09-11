package com.myproject.aem.core.servlets;


import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

                                  //....OSGI using servlet......

@Component(service = Servlet.class,      
      property = {"sling.servlet.paths=/bin/Anirudh",
    		  "sling.servlet.resourceTypes=myproject/components/helloworld",
    		  "sling.servlet.selectors=one",
    		  "sling.servlet.extensions=json"  
}
		)
public class PracticeOSGIusingservlet extends SlingSafeMethodsServlet{
	
	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {
		
		JsonObjectBuilder obj = Json.createObjectBuilder();
		obj.add("Name", "Anirudh");
		obj.add("age", "2");
		obj.add("address", "Hyderabad");
		
		res.getWriter().write(obj.build().toString());
	}

}
