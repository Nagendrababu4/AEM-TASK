package com.myproject.aem.core.models;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.myproject.aem.core.beans.PracticeslingmodelBeans;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PracticeMultifield {
	
	@ValueMapValue
	public String name;

	public String getName() {
		return name;
	}
	
	@Inject
	Resource resource;
	
	@ChildResource
	Resource personmultifield;
	
	public ArrayList<PracticeslingmodelBeans> getmultifield() {
		
		ArrayList<PracticeslingmodelBeans> obj = new ArrayList<PracticeslingmodelBeans>();
		
		Iterator<Resource> listChildren1 = personmultifield.listChildren();
		while(listChildren1.hasNext()) {
			PracticeslingmodelBeans nag = new PracticeslingmodelBeans();
			Resource next = listChildren1.next();
			
			String string = next.getValueMap().get("names", String.class);
			
			nag.setNames(string);
			
		}
		return obj;
		
		
	
	}
	
	

}
