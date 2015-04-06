A plugin for Apache Maven to check java Properties files (java.util.Properties)

maven-properties-checker is an Apache Maven plugin to check java properties. The purpose is to apply some validation checks at properties file (java.util.Properties) to prevent errors, problems when you deploy the artifact. If a check fail the build process fails.

Example: what happen there is an empty space at the end of properties vaule and the java code don't trim ?

Features:

- check for empty space(s) in the properties values

- check for empty values

- apply a custom check based on user defined regular expression

For more info e usage visit: http://iutility.blogspot.it/2013/04/maven-properties-checker.html 
