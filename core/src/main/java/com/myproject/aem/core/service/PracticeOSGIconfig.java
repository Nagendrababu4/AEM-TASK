package com.myproject.aem.core.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@Component(service = PracticeOSGIservice.class, immediate = true)
@Designate(ocd = PracticeOSGIconfig.serviceConfig.class)
public class PracticeOSGIconfig implements PracticeOSGIservice{
	
	@ObjectClassDefinition(name = "Anirudh",
			description = "Hiiiiiiiiiiiiiiiiii"
			)
	public @interface serviceConfig{
		
		@AttributeDefinition(
				name = "Name",
				description = "This is Nagendra Babu",
				type = AttributeType.STRING
				)
		public String Name() default "Nag";
		
		@AttributeDefinition(
				name = "Rollno",
				description = "this is roll no",
				type = AttributeType.INTEGER
				)
		public int Rollno() default 14378;
		
		@AttributeDefinition(
				name = "profession",
				description = "Please select the above",
				type = AttributeType.STRING
				)
		public String[] profession() default {"student", "job", "business"};
		
	}
	
	private String Name;
	private int Rollno;
	private String[] profession;
	
	@Activate
	public void Activate(serviceConfig serviceConfig) {
		Name = serviceConfig.Name();
		Rollno = serviceConfig.Rollno();
		profession = serviceConfig.profession();	
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRollno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getprofession() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
