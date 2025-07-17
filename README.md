# FacadeAuth

### Execution

Open a new terminal in folder takehome and run

`./gradlew bootRun `

or 

`./gradlew bootTestRun`(to run with unit tests)


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
