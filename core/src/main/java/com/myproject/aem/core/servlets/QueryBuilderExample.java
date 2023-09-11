package com.myproject.aem.core.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

@Component(service = Servlet.class)
@SlingServletPaths(value = "/bin/QueryBuilderExample")
public class QueryBuilderExample extends SlingSafeMethodsServlet {
	
	@Reference                    //........QueryBuilder.......
	QueryBuilder queryBuilder;
	public void doGet(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {
		HashMap<String, String> predicates = new HashMap<String, String>();
		predicates.put("type", "cq:Page");
		predicates.put("path", "/content/we-retail");
		predicates.put("orderby", "@jcr:content/cq:lastModified");
		predicates.put("orderby.sort", "cq:Page");
		predicates.put("p.limit=", "-1");
		
		Session session = req.getResourceResolver().adaptTo(Session.class);
		Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), session);
		SearchResult result = query.getResult();
//		getting number of hits count
		int size = result.getHits().size();
		long totalMatches = result.getTotalMatches();
		long startIndex = result.getStartIndex();
//		getting hits in result(hits present in fntend)
		List<Hit> hits = result.getHits();
//		for iterating one by one value(hits)
		JsonArrayBuilder jab = Json.createArrayBuilder();
		jab.add(startIndex);
		jab.add(size);
		jab.add(totalMatches);
		for(Hit hit:hits) {
//			for printing 'title' and 'path' in form of json object
			JsonObjectBuilder jsonObjectBuilder1 = Json.createObjectBuilder();
			try {
//				for getting properties we use getResource();
				Resource resource = hit.getResource();
				Resource content = req.getResourceResolver().getResource(resource.getPath()+"/jcr:content");
				jsonObjectBuilder1.add("title", content.getValueMap().get("jcr:title", String.class));
				jsonObjectBuilder1.add("path", resource.getPath());
				jab.add(jsonObjectBuilder1);
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			o/p
			res.getWriter().write(jab.build().toString());
		}	
	}
	
}
