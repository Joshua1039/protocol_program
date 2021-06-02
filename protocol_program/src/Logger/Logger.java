package Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Paths;
import java.util.Enumeration;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

public class Logger {
	public static org.apache.log4j.Logger Write = org.apache.log4j.Logger.getRootLogger();
	@Deprecated
	private static ILogger globalLogger = null;


	public static String ToHexString(byte[] data) {
		return DatatypeConverter.printHexBinary(data);
	}

	public static void InitLogger(Class<?> clazz) {
		Write = org.apache.log4j.Logger.getLogger(clazz);
		org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger.getRootLogger();
		Enumeration<?> appenders = rootLogger.getAllAppenders();
		if (appenders.hasMoreElements())
			return;

		System.out.println("LOG4J config file is missing ");
		System.out.println("default logger is DailyRollingFileAppender");
		Layout layout = new PatternLayout("[%d{yyyy-MM-dd HH:mm:ss,SSS}] %5p %M (%F:%L) - %m%n");
		Appender ap = new ConsoleAppender(layout, ConsoleAppender.SYSTEM_OUT);
		rootLogger.setLevel(Level.ALL);
		rootLogger.addAppender(ap);
		try {
			DailyRollingFileAppender fap = new DailyRollingFileAppender(layout,
					Paths.get("log", clazz.getSimpleName()).toString() + ".log", "'.'yyyy-MM-dd");
			rootLogger.addAppender(fap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String toOneline(String src) {

		return src.replaceAll("[\r\n\t]+", " ");
	}

	public static String toOneline(String src, String to) {
		return src.replaceAll("[\r\n\t]+", to);
	}

	public static String toOnelineHeader(String src)
	{
		return toOnelineHeader(src," ");
	}
	
	public static String toOnelineHeader(String src, String to) {
		if (src.contains("\r") || src.contains("\n")) {
			String header = src.replaceAll("[\r\n\t]+", to);
			return header + "\n" + src;
		} else
			return src;
	}

	@Deprecated
	public static void setGlobalLogger(ILogger globalLogger) {
		Logger.globalLogger = globalLogger;
	}

	public static String formatException(Exception exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		return sw.toString();
	}

	public static String formatException(String message, Exception exception) {
		return String.format("%s:%s", message, formatException(exception));
	}

	@Deprecated
	public static void trace(String message) {
		if (globalLogger == null)
			return;
		globalLogger.trace(message);
	}

	@Deprecated
	public static void debug(String message) {
		if (globalLogger == null)
			return;
		globalLogger.debug(message);
	}

	@Deprecated
	public static void info(String message) {
		if (globalLogger == null)
			return;
		globalLogger.info(message);
	}

	@Deprecated
	public static void error(String message) {
		if (globalLogger == null)
			return;
		globalLogger.error(message);
	}

	@Deprecated
	public static void trace(Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.trace(formatException(exception));
	}

	@Deprecated
	public static void debug(Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.debug(formatException(exception));
	}

	@Deprecated
	public static void info(Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.info(formatException(exception));
	}

	@Deprecated
	public static void error(Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.error(formatException(exception));
	}

	@Deprecated
	public static void trace(String message, Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.trace(formatException(message, exception));
	}

	@Deprecated
	public static void debug(String message, Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.debug(formatException(message, exception));
	}

	@Deprecated
	public static void info(String message, Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.info(formatException(message, exception));
	}

	@Deprecated
	public static void error(String message, Exception exception) {
		if (globalLogger == null)
			return;

		globalLogger.error(formatException(message, exception));
	}
}
