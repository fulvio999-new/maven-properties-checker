package property.maven.plugin.check.validator;

import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Validator for a java.util.Properties that validates his entry applying a custom regular expression provided by the user in the input xml file
 * (eg for example to check if there are properties with VALUE containing the String "mock" in a build for production)
 *  
 * @author fulvio
 *
 */
public class CustomValidator{

	/**
	 * Constructor
	 */
	public CustomValidator() {
		
	}
	
	/**
	 * Core method that perform the core business validation logic at the KEY of the properties file
	 * @throws MojoExecutionException 
	 */
	public void validate(Properties fileToCheck, String relativeFilePath, String chekValue) throws MojoExecutionException{
		
		Enumeration<?> e = null; 
		String propertyValue;
		String propertyKey;

		for (e = fileToCheck.propertyNames(); e.hasMoreElements();) 
		{
			propertyKey = (String) e.nextElement();
			propertyValue = fileToCheck.getProperty(propertyKey); 
			
			Pattern patternEndLine = Pattern.compile(chekValue);
			Matcher matcherEndLine = patternEndLine.matcher(propertyValue);
	
			// true if the regexp matches
			if(matcherEndLine.find())
			{
			   throw new MojoExecutionException("Custom regexp "+chekValue+" matches for key: "+propertyKey+" in file: "+relativeFilePath);
			}
	    } 
	}

}
