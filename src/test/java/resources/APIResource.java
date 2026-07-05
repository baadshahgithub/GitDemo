package resources;

public enum APIResource {

	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	GetPlaceAPI("/maps/api/place/get/json");

    private String resource;

    APIResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
    	   System.out.println("cd C:\\Users\\jilan\\Gitstuff"); 
        return resource;
        
 
    }
}