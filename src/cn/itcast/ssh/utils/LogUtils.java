package cn.itcast.ssh.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hunagqi
 * @version ：2017-5-11
 */
public class LogUtils {

	public static void info(String message, Class name) {
		Logger logger = LoggerFactory.getLogger(name);
		logger.info("***************************huangqi-"+ name.getSimpleName() + "***************************"+ message+ "***************************");
	}

}
