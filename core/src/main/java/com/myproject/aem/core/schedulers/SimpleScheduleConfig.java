package com.myproject.aem.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Sling Scheduler", description = "Scheduler is used to schedule the time")
public @interface SimpleScheduleConfig {
	
	@AttributeDefinition(
			name = "Scheduler Example",
			description = "Scheduler example desc",
			type = AttributeType.STRING
			)
	public String schedulName() default "Nagendra Babu";
	
	@AttributeDefinition(
			name = "cron expression",
			description = "Crone Expression desc",
			type = AttributeType.STRING
			)
	public String cron_Expression() default "0 0/1 * 1/1 * ? *";
	
	@AttributeDefinition(
			name = "enable scheduler",
			description = "enable desc",
			type = AttributeType.BOOLEAN
			)
	public boolean enableScheduler() default true;
	
	@AttributeDefinition(
			name = "Custom Property",
			description = "Concurrent Scheduler",
			type = AttributeType.BOOLEAN
			)
	public boolean Custom_Property() default true;
}
