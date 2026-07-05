package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils_data {
	
	static RequestSpecification req;
	static String path ="C:\\eclips\\BDD\\global.properties";
	
	public RequestSpecification requestSpecification() throws IOException {

	    if (req == null) {
	        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

	        req = new RequestSpecBuilder()
	                .setBaseUri(("https://rahulshettyacademy.com"))
	                .addQueryParam("key", "qaclick123")
	                .setContentType(ContentType.JSON)
	                .addFilter(RequestLoggingFilter.logRequestTo(log))
	                .addFilter(ResponseLoggingFilter.logResponseTo(log))
	                .build();
	    }

	    return req;
	}
	
    public static Properties globalValues() throws IOException {
        Properties prop = new Properties();

        FileInputStream fis =
                new FileInputStream(path);

        prop.load(fis);

        return prop;
    }
    
    public String getJsonpath(Response response, String key)
    {
        String re = response.asPrettyString();
        System.out.println("Response = " + re);

        JsonPath js = new JsonPath(re);

        Object value = js.get(key);

        System.out.println("Key = " + key);
        System.out.println("Value = " + value);

        if(value == null)
        {
            throw new RuntimeException("Key '" + key + "' not found in response");
        }
   

        return value.toString();
    }
}


