/**
 * 
 */
package my.com.midf.digitalbusiness.devops.jasonfyp;

import java.io.File;
import java.util.Map;


/**
 * This class implements the interface created in YamlUtility, there are 
 * overriding functions taken from the interface that are required to be here.
 * The program won't even compile without the overriding class, so do not remove
 * them but instead write your program as part of it and include more functions
 * where you feel like. Make them private functions. I don't see any reason why
 * there should be additional public functions here.
 * 
 * @author fazreil
 *
 */
public class YamlUtilityImpl implements YamlUtility {

	private Map<String, Object> content;
	
	/**
	 * read a file and parse all of the data into content field above
	 */
	@Override
	public void read(File file) {
		// TODO Auto-generated method stub

	}

	/**
	 * extract an object from content field above by mentioning the key
	 */
	@Override
	public String extract(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * write the content object into a new yaml file
	 */
	@Override
	public File write(File newFile) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
