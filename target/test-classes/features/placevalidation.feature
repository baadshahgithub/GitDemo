Feature: API Validation
@Addplace @Regression
Scenario: Verify if place is being Successfully added using AddPlaceAPI

 Given Add place Payload "<name>" "<address>" "<language>"
  When user calls "AddPlaceAPI" with "Post" http request
  Then then API call is sucess with status code 200
  And "status" in response body is "OK"
  And "scope" in response body is "APP"
  And verify place_Id created maps to "<name>" using "GetPlaceAPI"
  
Examples:
|name     |  address               |  language  |
|jhon     | 45,sea layout,cohen 10 |  English   |
#|David    | 50 world ceneter 99    |  hindi     |

@Deleteplace @Regression
Scenario: Verify if Delete place functionality is working

  Given Add deletePlace payload
  When user calls "DeletePlaceAPI" with "Post" http request
  Then then API call is sucess with status code 200
  And "status" in response body is "OK"


