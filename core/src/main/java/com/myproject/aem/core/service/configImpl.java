package com.myproject.aem.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

import com.myproject.aem.core.service.OSGiConfig;

@Component(service = OSGiConfig.class, immediate = true)
@Designate(ocd = configImpl.serviceConfig.class )
public class configImpl implements OSGiConfig{      //.......OSGI Config...........
	
	@ObjectClassDefinition(name = "Nagendra Babu Config",
			         description = "Example of OSGi Config")
	public @interface serviceConfig{
		
		@AttributeDefinition(
				name = "Service Name",
				description = "Enter Service Name",
				type = AttributeType.STRING
				)
		public String serviceName() default "SSS";
		
		@AttributeDefinition(
				name = "Service Count",
				description = "Enter Service Count",
				type = AttributeType.INTEGER
				)
		public int getserviceCount() default 4;
		
		@AttributeDefinition(
				name = "Live Data",
				description = "boolean example",
				type = AttributeType.BOOLEAN
				)
		public boolean getLiveData() default false;
		
		@AttributeDefinition(
				name = "Countries",
				description = "Enter the countries",
				type = AttributeType.STRING
				)
		public String[] getCountries() default {"project", "us", "en"};
		
		@AttributeDefinition(
				name = "Run Modes",
				description = "Select the Run modes",
				type = AttributeType.STRING,
				options= {
						@Option(label="Author", value="a instance"),
						@Option(label="publish", value="p instance"),
						@Option(label="Both", value="Both"),
		
				}
				)
		public String getRunMode() default "Both";	
		
	}
	
	private String serviceName;
	private int serviceCount;
	private boolean liveData;
	private String[] countries;
	private String runModes;
	
	@Activate
	public void Activate(serviceConfig serviceConfig) {
		serviceName = serviceConfig.serviceName();
		serviceCount = serviceConfig.getserviceCount();
		liveData = serviceConfig.getLiveData();
		countries = serviceConfig.getCountries();
		runModes = serviceConfig.getRunMode();
		
		
	}
	

	@Override
	public String getServiceName() {
		return serviceName;
	}

	@Override
	public int getserviceCount() {
		return serviceCount;
	}

	@Override
	public boolean getLiveData() {
		// TODO Auto-generated method stub
		return liveData;
	}

	@Override
	public String[] getCountries() {
		// TODO Auto-generated method stub
		return countries;
	}

	@Override
	public String getRunMode() {
		// TODO Auto-generated method stub
		return runModes;
	}

}
