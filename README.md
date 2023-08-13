# SixLetterWords
Coding challenge From One16

# Prerequisites
This application has been tested on a Windows environment. 
If you wish to run it on a different environment, please make sure to make necessary changes.

Before running the application, you must make sure you have the following installed:
Java 17
Gradle version 8.2.1

# Running and using the Application
Open a Command Line Interface, for example Git Bash, in the project directory.
In the correct directory, you can run the following command: 'gradle bootRun'. This will start the application

When the application has been started, 'Started SixletterwordsApplication' will be logged in of the console.

Now you can start making calls to the API. To load a file into the application and get the results in a new file called 'output.txt', you can execute following CURL command, but please change {{inputFile}} to the full path to the file you want to test:

curl --location 'http://localhost:8080/file' --form {{inputFile}} > output.txt


2 test files have been added to the project under the directory "testFiles".