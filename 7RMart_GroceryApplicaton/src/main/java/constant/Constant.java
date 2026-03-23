package constant;

public class Constant {
	public static final String TESTDATAFILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestDataSample.xlsx";
	public static final String IMAGEOFMANGO = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\MangoFruits.jpg";
	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";
	public static final String UNABLETOLOGINWITHVALIDUSERNAMEVALIDPASSWORD = "Homepage not loaded with with valid credentials";
	public static final String LOGINWITHINVALIDUSERNAME = "Homepage is loaded with incorrect username";
	public static final String LOGINWITHINVALIDPASSWORD = "Homepage is loaded with incorrect password";
	public static final String LOGINWITHINVALIDUSERNAMEINVALIDPASSWORD = "Homepage is loaded with incorrect username and password";
	public static final String LOGOUTFAILED = "Logout Failed";
	public static final String ADMINDETAILSSAVINGFAILED = "Failed to save Admin details";
	public static final String CATEGORYADDITIONFAILED = "Failed to add category information";
	public static final String CONTACTUSADDITIONFAILED = "Failed to add contact us information";
	public static final String FOOTERTEXTUPDATIONFAILED = "Failed to update footer text information";
	public static final String NEWSSAVINGFAILED = "Failed to save news information";
}
