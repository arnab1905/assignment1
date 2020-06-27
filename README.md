# Ketto Assignment
Task Name: Create an automation script using Selenium's TestNG with Maven and Page Object Model framework.

Pre-requisites: User computer should have an IDE installed and have an Internet connection to execute the project.
Note: I have made use of Page Factory instead of Page Object Model as it makes code more readable than Page Object Model and is very optimized.

Overview:
Automate test scenarios of www.ketto.org/ 's "Start a Fundraiser" forms.

Flow of the application:

Step1: Navigate to page and click on Start Fundraiser.

Step2: Validate the Sign-up form. This would include all valid and invalid test scenarios.

Step3: Click on "Next" and validate the first Step of the new form which includes additional details for the fundraiser. Here, check if we can change the purpose of the campaign

Step4: Click on "Save and Continue" and move on to the next step which is a form that requires the details of the Patient. (Check)

Step5: Click on "Save and Continue" and validate the final step before starting the fundraiser. This step of the form has the preview of the campaign message and also allows the user to make changes as per his/her choice.

Step6: Click on "Submit" to start the campaign.

Project Details:

This project has the tests written in the test folder (src>>test>>java>>test.ketto>>Ketto_test1.java)

The testng1.xml in the directory is used to invoke multiple browsers which executing the test cases. Browsers used here are Chrome and Firefox.

The details of the pages and flow of steps are in the pages.ketto package (src>>main>>java>>pages.ketto). These pages have all the locators and validation steps. Config_class is used to externally pass data to the pages and test file.

Resources folder (src>>main>>resources>>config.properties) contains the .properties file which has the external parameters and their respective values mentioned.

The drivers folder in the user directory contains the drivers needed to execute the test cases in Chrome and Firefox. There is no need to change the path in the code to invoke the drivers.
