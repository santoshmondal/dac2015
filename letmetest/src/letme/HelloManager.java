package letme;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloManager {
	private static final Logger log = LogManager.getLogger(HelloManager.class);
	
	public static void didUTest() {
		log.debug("Hello World DEBUG!!");
		log.info("Hello World INFO!!");
		log.error("Hello World ERROR!!");
	}

}
