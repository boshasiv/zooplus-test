## This is a zooplus test task: example of automating tests for the REST API

In order to run the test (yes, single one!) you need to have at least Java 8 and Maven 3.8.1
To run the test, please clone the project and execute the following command: 
`mvn clean test -Dapp.env=prod`
If you won't provide the environment, test won't start (yes, I haven't added default environment to run).

The data on the given REST API is very dynamic, so I bet when you run this test, you will
see them failed. Well.. Maybe I could create a pre-test condition which creates the data before
tests are executed, but even this won't guaranty those tests to pass.

These are the test data to put into the app:
`{
   "id": 124,
   "name": "lion",
   "status": "available"
 }`
 `{
    "id": 125,
    "name": "bull",
    "status": "available"
  }`
  
I've tried to make an app fairly expandable, so adding new endpoints shouldn't be a problem.
The same with assert: it accepts generic as an object to verify in response's body, so the 
"most complicated" part is done. I don't like the mess which Jackson required me to do
in order to serialize/deserialize JSONs to objects though. It could be mitigated by using
restassured as a test framework, but I would then need to semantically mix different test automation layers
 (application manipulation, business logic and asserts).



### Integration into CI and test reporting
Current test app is designed in a way, which allows (in future) to integrate it into a CI: 
environment is provided by an external property, so you could easily change the environment 
which is going to be tested. To add more, you need to add a `.properties` file with corresponding
endpoints. Creating separate test suites also shouldn't be a problem: TestNG covers it.

As for reporting, I'm a fun of allure reports: allure framework easily integrates into a 
chosen tech bundle (test NG + maven), so the most complicated task would be to make it working 
on the CI: either by using existing Allure plugins (Jenkins), or create your own scripts in 
order to serve it on a server (Gitlab CI).
