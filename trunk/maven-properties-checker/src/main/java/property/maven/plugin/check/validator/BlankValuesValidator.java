
package property.maven.plugin.check.validator;

import java.util.Enumeration;
import java.util.Properties;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Core method that perform the core business validation logic at the KEY of the properties file
 * @throws MojoExecutionException If the properties file in input is not valid: eg a KEY as no VALUE associated
 */
public class BlankValuesValidator{

	/**
	 * Constructor
	 */
	public BlankValuesValidator() {
		
	}
	
	/**
	 * Core method that perform the core business validation logic at the properties file
	 * @throws MojoExecutionException 
	 */
	public void validate(Properties fileToCheck, String relativeFilePath) throws MojoExecutionException{
	   		
    		Enumeration<?> e = null; 
    		String propertyValue;
    		String propertyKey;
    		
    		for (e = fileToCheck.propertyNames(); e.hasMoreElements();) 
    		{
    			propertyKey = (String) e.nextElement();
    			propertyValue = fileToCheck.getProperty(propertyKey);     			
    	 
    			if(org.codehaus.plexus.util.StringUtils.isBlank(propertyValue))
    			{
    			   throw new MojoExecutionException("Empty value for key: "+propertyKey +" in file: "+relativeFilePath);
    			}
    		}
	}
}
