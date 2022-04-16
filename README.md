# computers_CRUD

-- -- Tools Used for testing -- --

TestNG Framework

-- -- How to execute -- --

This is a multibrowsing, multienvironment Maven project.

It can be run in the following environments: DEV INT PREPROP PROD

The test can be triggered with the following command:

mvn clean test -Denv=[ENVIRONMENT] -Dbrowser[BROWSER NAME]

For this test the allowed browsers are: chrome, firefox, edge and IE
