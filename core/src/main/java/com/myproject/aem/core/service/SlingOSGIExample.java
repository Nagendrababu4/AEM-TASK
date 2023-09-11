package com.myproject.aem.core.service;

import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

//                   .........OSGI Using Sling model.........

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SlingOSGIExample {
	
	@OSGiService
	OSGiConfig config;
	
	public String getServiceName() {
		return config.getServiceName();
		
	}
	public int getserviceCount() {
		return config.getserviceCount();
	}
	public boolean getLiveData() {
		return config.getLiveData();
	}
	public String[] getCountries() {
		return config.getCountries();
	}
	public String getRunMode() {
		return config.getRunMode();
	}
	

}
