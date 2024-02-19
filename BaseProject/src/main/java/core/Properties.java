package core;


public class Properties {
	
	public static boolean CLOSE_BROWSER = false;
	
	public static Browsers browser = Browsers.FIREFOX;
	
	public static String CHANGED_ACCOUNT = "Conta Alterada" + System.nanoTime();
	
	public enum Browsers {
		CHROME,
		FIREFOX
	}

}
