package resources;

import java.util.ArrayList;

import pojo.Addplace;
import pojo.location;
import pojo.types;

public class Testdata {

	
	public Addplace addplacePayload( String name,String address,String language)
	{
		  Addplace p = new Addplace();

		    p.setAccuracy("50");
		    p.setName(name);
		    p.setPhone_number("(+91) 983 893 3937");
		    p.setAddress(address);

		    // Types
		    ArrayList<String> al = new ArrayList<>();
		    al.add("shoe park");
		    al.add("shop");

		    types h = new types();
		    h.setShoe_park(al.get(0));
		    h.setShop(al.get(1));

		    p.setTypes(h);

		    // Website
		    p.setWebSite("http://google.com");
		    p.setLanguage(language);

		    // Location
		    ArrayList<Double> lc = new ArrayList<>();
		    lc.add(-38.38394);
		    lc.add(33.427362);

		    location n = new location();
		    n.setLat(lc.get(0));
		    n.setLng(lc.get(1));

		    p.setLocation(n);

        
        return p;
	}
	public String deletePayload(String placeid)
	{
		 String payload="{\r\n"
		 		+ "    \"place_id\": \""+placeid+"\"\r\n"
		 		+ "}"
		 		;
		return payload;
		
	}
}
