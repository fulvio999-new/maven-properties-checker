
package property.maven.plugin.check.validator;

import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Validator for a java.util.Properties that validates his entry applying a fix regular expression that checks
 * for empty space(s) at the end ond key-value pair 
 *  
 * @author fulvio
 *
 */
public class EmptySpaceEndValidator {

	/**
	 * Constructor
	 */
	public EmptySpaceEndValidator() {
		
	}
	
	/**
	 * Core method that perform the core business validation logic at the KEY of the properties file
	 * @throws MojoExecutionException If the properties file in input is not valid: a VALUE contains a blank spaces at the end
	 */
	public void validate(Properties fileToCheck, String relativeFilePath) throws MojoExecutionException{
		   		
    		Enumeration<?> e = null; 
    		String propertyValue;
    		String propertyKey;

    		for (e = fileToCheck.propertyNames(); e.hasMoreElements();) 
    		{
    			propertyKey = (String) e.nextElement();
    			propertyValue = fileToCheck.getProperty(propertyKey);    			
    			Pattern patternEndLine = Pattern.compile("\\s+$");
    			Matcher matcherEndLine = patternEndLine.matcher(propertyValue);
    	 
    			if(matcherEndLine.find())
    			{
    			   throw new MojoExecutionException("End space detected for value: "+propertyValue +" in file: "+relativeFilePath);
    			}
    	    }   		
    		
    	}
		
 }

