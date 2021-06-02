package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import Logger.Logger;

public class MainUtil {

	public static Properties GetProperties(String path) throws InvalidPropertiesFormatException, IOException {
		FileInputStream fin = new FileInputStream(path);
		Properties p = new Properties();
		p.loadFromXML(fin);
		return p;
	}
	
	public static Properties createProperties(String configfile) {
		if(System.getProperty("configfile")!= null)
			configfile = System.getProperty("configfile");
		
		Properties p = null;
		
		try {
			p = GetProperties(configfile);
		}catch (IOException e) {
			Logger.Write.info("[MainUtil] Log.error configfile not found!!! ");
			e.printStackTrace();
		}
		Logger.Write.info("[MainUtil] GetProperties configfile load success!!! ");
		return p;
	}
	
}
