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
import com.myproject.aem.core.beans.Slingmodelbeans;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Example1SilingModel {    //.......Multifield..........
	

	@ValueMapValue
	public String id;
	
	public String getId() {
		return id;
	}
	@Inject
	Resource resource;
	
	@ChildResource
	Resource studentmultifield;
	
		public ArrayList<Slingmodelbeans> getMultiChildNodes() {
			
			ArrayList<Slingmodelbeans> object = new ArrayList<Slingmodelbeans>();
			
			
			Iterator<Resource> childResource1 = studentmultifield.listChildren();
			while (childResource1.hasNext()) {
				Slingmodelbeans vem = new Slingmodelbeans();

				Resource itemResource4 = childResource1.next();

				// to get the data //
				String name = itemResource4.getValueMap().get("name",String.class);
				String rollno = itemResource4.getValueMap().get("rollno",String.class);
				
				// to set the data//
				vem.setName(name);
				vem.setRollno(rollno);
				object.add(vem);
			}
			return object;
				
	}
}
	
	
	

/*
                    ......Explanation.......
                    
    @Inject
	Resource resource;
	
	@ChildResource
	Resource studentmultifield;
	
//	if you want child pages you can use	`	
	@ChildResource
	Resource studentmultifield;

//	   ....public String getmultifielddot() {.....

//	   connect the slingmodelbeans in arraylist
	   public ArrayList<Slingmodelbeans> getmultifielddot() {

//		   creating object arraList<>
		   ArrayList<Slingmodelbeans> obj = new ArrayList<Slingmodelbeans>();
//		   for iteration of flow

		   Iterator<Resource> listChildren = studentmultifield.listChildren();
//		   creating object for set method

		   Slingmodelbeans slingmodelbeans = new Slingmodelbeans();
//		   for iterating one by one value

		   while(listChildren.hasNext()) {
			   Resource nagendra = listChildren.next();

//			   for getting field properties we use getvaluemap()
			   String name = nagendra.getValueMap().get("name",String.class);
			   String rollno = nagendra.getValueMap().get("rollno",String.class);

//			   using slingmodelbeans object we call the set methods
			   slingmodelbeans.setName(name);
			   slingmodelbeans.setRollno(rollno);
			   
//			   finally we have to call the arrayList() object
			   obj.add(slingmodelbeans);
			    
		   }
		return obj;
	   }
*/

