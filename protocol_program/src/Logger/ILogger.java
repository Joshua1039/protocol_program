package Logger;

@Deprecated
public interface ILogger {
	public void trace(String message);

	public void debug(String Message);

	public void info(String Message);

	public void error(String message);
}
