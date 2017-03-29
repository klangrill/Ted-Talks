package edu.ycp.cs320.rvandemark.model;

public class Engine {
	
	private static Admin[] ALL_ADMINS = loadAdmins();
	private static User USER;
	private static Video VIDEO;
	
	public static Admin[] getAllAdmins() {
		return ALL_ADMINS;
	}
	public static User getUser() {
		return USER;
	}
	public static Video getVideo() {
		return VIDEO;
	}
	
	public static void setUser(User u) {
		USER = u;
	}
	public static void setVideo(Video v) {
		VIDEO = v;
	}
	
	public static Admin[] loadAdmins() {
		//read admin database
		return new Admin[]{
			new Admin("rvandemark@ycp.edu", "rvandy.adm", "p@ssword", "Nick", "Vandemark", 0, new String[]{}),
			new Admin("emoore13@ycp.edu", "emoore.adm", "p@ssword123", "Ezra", "Moore", 0, new String[]{}),
			new Admin("klangrill@ycp.edu", "klangrill.adm", "bad password", "Kyle", "Langrill", 0, new String[]{})
		};
	}
	
	public static boolean videoIsValid(String url) {
//		Video v;
//		try { v = new Video(url, 0); }
//		catch (IOException e) {
//			return false;
//		}
		
//		String formattedUrl = v.getUrl();
		//search database for formattedUrl. If it exists somewhere, then the video does too.
		//otherwise, the url is valid ---> return (url does not exist in database);
		
		return true;
	}
	public static void createVideo(String url) {
		if (videoIsValid(url)) {
//			try {
//				Video v = new Video(url, 0);
//				//write v to database
//			} catch (IOException e) {
//				//an exception could never be thrown because the same check occurs in videoIsValid
//				e.printStackTrace();
//			}
		}
	}
	
	public static void createReview(User author, Video parent, String text, int pointValue) {
//		Review r = new Review(author, parent, text, pointValue);
		/*
		 * 
		 * write review data to:
		 * 		author's reviews
		 * 		video's reviews
		 * 		review text
		 * 		reward points to author
		 * 
		 */
	}
	public static void flagReview(User flagger, Review review) {
		Engine.createNotification(flagger, review);
	}
	public static void editReview(User flagger, Review review, String text) {
		if (flagger instanceof Admin || review.getAuthor().equals(flagger)) {
			review.setText(text);
		}
	}
	public static void deleteReview(User flagger, Review review) {
		if (flagger instanceof Admin || review.getAuthor().equals(flagger)) {
			/*
			 * 
			 * delete references of review in:
			 * 		user's reviews
			 * 		video's reviews
			 * 		assignment requirements
			 */
		}
	}
	
	public static void createNotification(User flagger, Review target) {
		Notification n = new Notification(flagger, target);
		for (int i = 0; i < ALL_ADMINS.length; i++) ALL_ADMINS[i].receive(n);
	}
}