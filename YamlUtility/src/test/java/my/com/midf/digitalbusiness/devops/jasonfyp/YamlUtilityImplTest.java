package my.com.midf.digitalbusiness.devops.jasonfyp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class YamlUtilityImplTest {
	
	File sampleFile1;
	File sampleFile2;
	YamlUtility yamlUtility;
	File sampleOutputFile;

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting unit test...");
		try {
			System.out.println("loading sample1.yaml");
			sampleFile1 = new File(getClass().getClassLoader().getResource("sample1.yaml").getPath());
			System.out.println("loading sample2.yaml");
			sampleFile2 = new File(getClass().getClassLoader().getResource("sample2.yaml").getPath());
			System.out.println("define yamlUtility");
			yamlUtility = new YamlUtilityImpl();
			System.out.println("creating SampleOutputFile.yaml");
			sampleOutputFile = new File("SampleOutputFile.yaml");
			sampleOutputFile.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("...tearing down unit test");
		sampleOutputFile.delete();
	}

	@Test
	public void testExtract() {
		System.out.println("testing .extract() function");
		yamlUtility.read(sampleFile2);
		assertEquals("John Smith", yamlUtility.extract("person.name"));
		yamlUtility.read(sampleFile2);
		assertEquals("700101-07-0002",yamlUtility.extract("person.ic"));
		yamlUtility.read(sampleFile2);
		assertEquals("51000",yamlUtility.extract("person.address.zip"));
	}

	@Test
	public void testWrite() {
		try {
			System.out.println("testing .write() function");
			yamlUtility.read(sampleFile2);
			InputStream sampleInputStream = new FileInputStream(sampleOutputFile);
			yamlUtility.write(sampleOutputFile);
			InputStream sampleInputStreamWritten = new FileInputStream(sampleOutputFile);
			assertFalse("Content of file stream shall be different",IOUtils.contentEquals(sampleInputStream, sampleInputStreamWritten));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
