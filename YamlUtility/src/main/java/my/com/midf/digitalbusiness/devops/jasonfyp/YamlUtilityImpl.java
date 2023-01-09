/**
 *
 */
package my.com.midf.digitalbusiness.devops.jasonfyp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;


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
            InputStream is = null;
            try {
                // TODO Auto-generated method stub
                is = new FileInputStream(file);
                Yaml yaml = new Yaml();
                content = yaml.load(is);
                System.out.println(content);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(YamlUtilityImpl.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    is.close();
                } catch (IOException ex) {
                    Logger.getLogger(YamlUtilityImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}

	/**
	 * extract an object from content field above by mentioning the key
	 */
	@Override
	public String extract(String key) {
            String[] keyArray = key.split("\\.");
            return recursiveExtract(0, keyArray, content);
        }
        
        private String recursiveExtract(int index, String[] keyArray, Map map){
            try{
                String stringToExtract = "";
                String key = keyArray[index];
                if(doesThisMapHas(key, map)){
                    String newContent = ""+map.get(key);
                    if(isThisAYaml(newContent)){
                        Yaml yaml = new Yaml();
                        newContent = newContent.replaceFirst("\\{", "");
                        newContent = newContent.substring(0, newContent.length()-1);
                        System.out.println(newContent);
                        
                        Map<String, Object> newMap =  yaml.load(newContent);
                        index++;
                        recursiveExtract(index, keyArray, newMap);
                    }
                    stringToExtract = newContent;
                }
                else{
                    System.out.println("key "+key+" does not exist");
                }
                return stringToExtract;
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            return "";
        }
        
        private boolean isThisAYaml(String possibleYamlString){

            if(possibleYamlString.contains("{")){
                return true;
            }
            else return false;
        }
        
        private boolean doesThisMapHas(String key, Map map){
            return map.containsKey(key);
        }
        
        private String getValue(String key, Map map){
            return map.get(key)+"";
        }
        
        private Map getSubMap(String key, Map map){
            Map<String, Object> smallerMap;
           Object newContent = map.get(key);
           Yaml yaml = new Yaml();
           smallerMap = yaml.load(newContent+"");
            return smallerMap;
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
