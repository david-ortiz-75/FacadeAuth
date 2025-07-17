# FacadeAuth

### Execution

Open a new terminal in folder takehome and run

`./gradlew bootRun `

or 

`./gradlew bootTestRun`(to run with unit tests)

I added OpenAPI, so you can see the API contract and run tests in
http://localhost:8080/webjars/swagger-ui/index.html
once the app is running




### Mock downstream request

to Mock the downstream auth request go to DownstreamAuthService

There you can find a list of "Users" and the authorization. 
This list can be modified as needed

`private final Map<Integer, Boolean> mockUserStore = Map.of(
123, true,
789, false
);`


and on the method forwardRequest a "dummy" request is made 
to the mentioned list to retrieve the authorization