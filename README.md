
# Pisano - Automation Project

This initiative constitutes a flexible UI test automation endeavor crafted to execute diverse tests on a website, (particularly Pisano), according to parameters defined by the user. Selenium is utilized for test automation, while Log4j is employed for monitoring and logging purposes. The project establishes a sturdy framework for scrutinizing the website's functionalities and validating the accuracy of outputs in accordance with specified parameters.

### Prerequisites
Make sure you have the following software installed before running the tests:

- Java 11
- Maven
- WebDriver
- Other dependencies listed in the `pom.xml` file.
## Installing

After downloading the dependencies in the pom.xml file, you can specify the browser from TestHooks.java file you just need to change value in BROWSER.CHROME its set to Chrome by default.
 then you can execute the test isfrom the CucumberTestRunner.java class.
 Or preferably you can cd to the project root and run mvn install and mvn test commands
## Project Structure

<img src="/src/resources/images/project_structure.png" alt="Project Structure" width="320">

In the project, I have utilized the structure you see below;

**resources:** It is the folder that contains the logback.xml file created for log4j configuration.


**Hooks:** It is the folder where the TestHooks class is located.
- **TestHooks:** This class is used for starting, specifying browsers and terminating drivers. Moreover it also contains a function adding the screenshot to the report when a scenario fails  

**Steps:** All pages used in the test cases are represented through classes within it. Each class contains the operations performed in relation to a specific test case.

- **NavigationSteps:** It is the class that verifies the opening of the main page. When the relevant URL is entered, it is checked on this page whether the main page has been opened or not.

- **LaunchingWidgetSteps:** It is the class where the process of switching to iframe to click "Pisano" button action is performed and verified.

- **FeedbackFormSubmissionSteps:**  It is the class where Customer feedback score and sentilment selection is performed. As also stated in the code these selections are made randomly.

- **AgreementPageSteps:** It is the class where the process of filling inputs in Agreement page and selecting favourite feedback tool. It is always Pisano.

- **ContactFormSubmissionSteps:** It is the class that performs the process of filling in the input fields with Random data using Java's Faker class. 


**reports/test-output:** It is the directory where cucumber extent report output and screenshots are saved.


**runners/CucumberTestRunner:** It is the class that contains the function responsible for running the test. Also the relevant plugin for the Cucumber Extent Report.

**resouces/features:** It is the folder containing the features that containes the test cases.

- *01_mainPage.feature:* It is the feature file where the test case is written to execute the operations in the NavigationSteps class.

- *02_openWidget.feature:* It is the feature file where the test case is written to execute the operations in the LaunchingWidgetSteps class.

- *03_fillInFeedbackForm.feature:* It is the feature file where the test case is written to execute the operations in the FeedbackFormSubmissionSteps class.

- *04_fillInAgreementForm.feature:* It is the feature file where the test case is written to execute the operations in the AgreementPageSteps class.

- *05_fillInContactForm.feature:* It is the feature file where the test case is written to execute the operations in the ContactFormSubmissionSteps class.

- *06_declineUserAgreement.feature:* It is the feature file where the test case is written to execute the operations in the DeclineUserAgreementSteps class.

**pom.xml:** It is an xml file that comes with a Maven project. It is a structure where we define the frameworks to be used in the project.





## Sample Screenshots
An example of Browser selection, CHROME set as default.

<img src="/src/resources/images/BrowserTypeSelection.png" alt="BrowserTypeSelection" width="320">

An example output of the log structure.

<img src="/src/resources/images/logs.png" alt="logs" width="320">

An example of the Cucumber Extent Report output

<img src="/src/resources/images/ReportExample.png" alt="ReportExample" width="320">

  
## Used Technologies
- Java 11
- Maven
- JUnit5
- Log4J



