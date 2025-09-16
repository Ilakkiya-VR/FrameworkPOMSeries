package com.qa.opencart.constants;

import java.util.List;

public class AppConstants {

	// Login Page

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_FRACTION_URL = "route=account/login";
	public static final String WITHOUT_LOGIN_CREDENTIAL_MSG="Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
	public static final String INVALID_LOGIN_CREDENTIAL_MSG="Warning: No match for E-Mail Address and/or Password.";
	public static final List<String> EXPECTED_HOMEMENU_HEADERS_DETAILS = List.of("", "Account", "Login");
	public static final int EXPECTED_HEADERS_COUNT = 3;

	public static final List<String> EXPECTED_HEADERS_DETAILS = List.of("New Customer", "Returning Customer");

	public static final int EXPECTED_SUBHEADERS_COUNT = 3;

	public static final List<String> EXPECTED_SUBHEADERS_DETAILS = List.of(
			"Register Account", "By creating an account you will be able to shop faster, "
					+ "be up to date on an order's status, " + "and keep track of the orders you have previously made.",
			"I am a returning customer");
	public static final int EXPECTED_RETURNCUST_LABELS_COUNT = 2;
	public static final List<String> EXPECTED_RETURNCUST_LABELS_DETAILS = List.of("E-Mail Address", "Password");

	public static final int EXPECTED_OPTIONSLIST_COUNT = 13;
	public static final List<String> EXPECTED_OPTIONSLIST_DETAILS = List.of("Login", "Register", "Forgotten Password",
			"My Account", "Address Book", "Wish List", "Order History", "Downloads", "Recurring payments",
			"Reward Points", "Returns", "Transactions", "Newsletter");
	
	//Accounts Page
	public static final String ACC_PAGE_TITLE = "My Account";
	
	//ProductInfoPage
	
public static final String EXPECTED_SAMSUNG941_DESC_DETAILS="Imagine the advantages of going big without slowing down. "
		+ "The big 19\" 941BW monitor combines wide aspect ratio with fast pixel response time, for bigger "
		+ "images, more room to work and crisp motion. I"
		+ "n addition, the exclusive MagicBright 2, MagicColor and MagicTune technologies help deliver "
		+ "the ideal image in every situation, while sleek, narrow bezels and adjustable stands deliver style just the way you want it. "
		+ "With the Samsung 941BW widescreen analog/digital LCD monitor, it's not hard to imagine.";

public static final String EXPECTED_IPHONE_DESC_DETAILS= "iPhone is a revolutionary new mobile phone "
		+ "that allows you to make a call by simply tapping a name or number in your a"
		+ "ddress book, a favorites list, or a call log. It also automatically syncs all your"
		+ " contacts from a PC, Mac, or Internet service. And it lets you select and listen"
		+ " to voicemail messages in whatever order you want just like email.";


public static final String EXPECTED_WARNING_ERROR_REVIEW =
"Warning: Review Text must be between 25 and 1000 characters!";

	//Register Page
public static final String EXPECTED_USER_REGISTER_CONFIRM_MSG="Your Account Has Been Created!";
	

}
