package my.com.midf.digitalbusiness.devops.jasonfyp;

import java.io.File;
import java.util.Map;

/**
 * This is the interface written as a guideline for you to define each of the
 * functions declared here.
 * 
 * I am expecting implementation classes based on this interface for all of the
 * function declared in this interface. Look at YamlUtilityImpl class for 
 * the implementation of these functions and complete them there.
 *  
 * @author fazreil
 *
 */
public interface YamlUtility {
	
	public void read(File file);
	
	public String extract(String key);
	
	public File write(File nameOfFile);
	
}
