package com.myproject.aem.core.models;


import java.util.Date;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables= {SlingHttpServletRequest.class,Resource.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class MyslingExample {   //......Sling Model......... 

	
	@ValueMapValue
	public String name;
	@ValueMapValue
	public String link;
	@ValueMapValue
	public String image;
	@ValueMapValue
	public String id;
	@ValueMapValue
	public String dropdown;
	@ValueMapValue
	public String role;
	@ValueMapValue
	public String checkbox;
	@ValueMapValue
	public String text;
	@ValueMapValue
	public Date date;
	@ValueMapValue
	public String textarea;
	@ValueMapValue
	public String colorpicker;
	
	
	public Date getDate() {
		return date;
	}
	public String getTextarea() {
		return textarea;
	}
	public String getColorpicker() {
		return colorpicker;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLink() {
		return link;
	}
	public String getImage() {
		return image;
	}
	public String getDropdown() {
		return dropdown;
	}
	public String getRole() {
		return role;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public String getText() {
		return text;
	}
	

	
	@Inject
	Resource resource;

//	getpath
	public String getPath(){
		return resource.getPath();
	}
	
//  getparent
	public String getParent() {
	String parent = resource.getParent().getName();
	return parent;	
	}
	
//  getName the source
	public String getNames() {
		String name2 = resource.getName();
		return name2;
	}


	}
	

