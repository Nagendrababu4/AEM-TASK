package com.myproject.aem.core.models;



import java.util.Date;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PracticeSlingModel {   //.....Sling Model........
	
	@ValueMapValue
	public String name;
	@ValueMapValue
	public String id;
	@ValueMapValue
	public Date dob;
	@ValueMapValue
	public String address;
	
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public Date getDob() {
		return dob;
	}
	public String getAddress() {
		return address;
	}
}
