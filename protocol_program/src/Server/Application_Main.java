package Server;

import java.util.Properties;

import Logger.Logger;
public class Application_Main {

	public static void main(String[] args) {

		Logger.InitLogger(Application_Main.class);
		Logger.Write.info("LOG4J ��� >  Logger.InitLogger(Application_Main.class);");

		Properties p; // properties ����
		Logger.Write.info("Properties ��� >  Properties p; ");
		
		
		
		p = MainUtil.createProperties("config.xml");
		
	}

}
