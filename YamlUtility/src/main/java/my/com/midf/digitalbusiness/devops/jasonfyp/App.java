package my.com.midf.digitalbusiness.devops.jasonfyp;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.FileInputStream;
import java.io.InputStream;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        InputStream inputStream = new FileInputStream(new File("sample2.yml"));

        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        System.out.println(data);
    }
}
