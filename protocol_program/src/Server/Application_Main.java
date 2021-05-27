package Server;

import org.apache.log4j.PropertyConfigurator;
import Logger.Logger;
public class Application_Main {

	public static void main(String[] args) {

		PropertyConfigurator.configure("etc/log4j.properties");
		Logger.Write.info("RETRY AMI LOGIN.. ");
		Logger.Write.debug("RETRY AMI LOGIN.. ");
		Logger.Write.trace("RETRY AMI LOGIN.. ");
		Logger.Write.error("RETRY AMI LOGIN.. ");
		Logger.Write.error("RETRY AMI LOGIN.. ");
		Logger.Write.error("RETRY AMI LOGIN.. ");
	}

}
