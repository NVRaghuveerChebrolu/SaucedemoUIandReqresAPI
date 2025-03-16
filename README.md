# QA Automation Assignment

We have added two tests: the first task is API-Test.feature and the second is UI-Test.feature.
- For the API-Test.feature, please visit https://reqres.in/. This should contain all the requirements.
- UI-Test.feature please visit https://www.saucedemo.com/


Please DO use Page objects, make sure the code is reusable and feel free to improve the current code.

**Note: We have intentionally added some bugs for you to debug.** 

Please contact the HR department if you have any questions.


Good luck!

## Test Automation Framework

- This is a Maven based framework
- `pom.xml` should have everything you need to create and run the tests. Please add further dependencies if you require it.

The following folder `src/test/java/AutomationTest/qumu` contains the following class:

- `Hook` - this is the before and after. This launches and kills the browser.
- `RunnerTest` - contains the CucumberOptions which runs the BDD's

The following folder `src/main/java/AutomationTest/qumu` contains the following class:

- `BrowserSetup` - This contains the setup of a given browser based on what is set to Browser property within `TestData.properties` 

 
## Steps to execute this project

- Pre-requisites
    - JAVA SDK 1.8 or higher
    - Maven CLI
    
- Steps
    - Clone the project to local
    - Got o command line or any IDE that supports JAVA & Maven dependencies
    - We may need to import the Maven dependencies (Scope got set to Compile for Newly added dependencies in pom.xm)
    - Execute the command: `mvn clean test`
    - Alternatively, we can run `testng.xml` from IDE after downloading the dependencies
    - Result will be captured in `test-output` folder

