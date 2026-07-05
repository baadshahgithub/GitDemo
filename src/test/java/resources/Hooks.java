package resources;

import java.io.IOException;

import Stepdefination.Stepdefination;
import io.cucumber.java.Before;

public class Hooks {
	
	
	@Before("@Deleteplace")
	public void DeletePlace() throws IOException{
	
		//write a code that give u placeid
		//run this only the placeid id null
	Stepdefination sp = new Stepdefination();
	 System.out.println("apis run togeter");
	{
	if(Stepdefination.placeId==null)
		

	    sp.add_place_payload("Basha","bigboos","hindi");
	    sp.user_calls_with_post_http_request("AddPlaceAPI", "POST");
	    
	    sp.verify_place_id_created_maps_to_using("Basha", "GetPlaceAPI");
	    System.out.println("HOOK EXECUTED");
	}

}
}
