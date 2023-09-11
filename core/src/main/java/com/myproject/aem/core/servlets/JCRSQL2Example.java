package com.myproject.aem.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;

@Component(service = Servlet.class)
@SlingServletResourceTypes(resourceTypes = {"myproject/components/example5"},
      selectors= "one",
      extensions ="json")
@SlingServletPaths(value = "/bin/page")
public class JCRSQL2Example extends SlingSafeMethodsServlet{  //.......JCRSQL2.........
	
	@Reference
	QueryBuilder queryBuilder;
	String query = "SELECT * FROM [cq:PageContent] AS nodes WHERE ISDESCENDANTNODE ([/content/myproject])\r\n" + 
			"AND nodes.[jcr:title] LIKE \"p%\"";
	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {
		
		
		ResourceResolver resolver = req.getResourceResolver();
		Iterator<Resource> result = resolver.findResources(query, javax.jcr.query.Query.JCR_SQL2);
//		store everything in the form of array
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		while(result.hasNext()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			Resource next = result.next();
			Page page = next.adaptTo(Page.class);
			if(page!=null) {
				job.add("title", page.getTitle());
				job.add("path", page.getPath());
				jab.add(job);
			}
		}
		res.getWriter().write(jab.build().toString());
	}
}
