package utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Hello world!
 */
public class ConfigReader {
     private Properties prop;
     
public ConfigReader(){     
     try(FileInputStream input = new FileInputStream("src\\test\\resources\\config.properties")){
    	 prop = new Properties();
    	 prop.load(input);
     }
    catch(Exception e) {
    	e.printStackTrace();
    }
}

public Properties getProperties() {
	return prop;
}

}


