package com;

public class Login {
	  static public String uname;
	  static String upass;
		
	public static boolean signUp(String username, String password) {
		uname = username;
		upass = password;
		return true;
	}
	
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
        if (username.equals(uname) && password.equals(upass)) {
            return true;
        }
        return false;
    }
}
