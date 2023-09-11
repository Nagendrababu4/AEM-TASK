package com.myproject.aem.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Runnable.class)
@Designate(ocd = SimpleScheduleConfig.class)
public class PracticeSchedulerTask implements Runnable{    //......Scheduler..........
	
	public static final Logger log = LoggerFactory.getLogger(PracticeSchedulerTask.class);

	@Reference
	Scheduler scheduler;

	@Activate
	public void Activate(SimpleScheduleConfig config)
	{
		addScheduler(config);
	}
	public void addScheduler(SimpleScheduleConfig simple)
	{
		ScheduleOptions expr = scheduler.EXPR(simple.cron_Expression());
		expr.name(simple.schedulName());
		expr.canRunConcurrently(simple.Custom_Property());
		scheduler.schedule(this, expr);
		log.info("add method called.....");
	}
	
	@Deactivate
	public void Deactivate(SimpleScheduleConfig config)
	{
		end(config );
	}
	public void end(SimpleScheduleConfig end)
	{
	  scheduler.unschedule(end.schedulName());
	}
	
	@Override
	public void run() {
		log.info("this is the task");
		
	}

}
