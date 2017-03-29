package edu.ycp.cs320.rvandemark.model;

public class Review {
	
	private final static String[] OFFENSIVE = {
		"keyword", "triggered", "explitive"
	};
	
	private User author;
	private Video parent;
	private String text;
	private int score;
	private int value;
	
	public Review(User a, Video p, String t, int s, int v) {
		author = a;
		parent = p;
		text = t;
		score = s;
		value = v;
	}
	
	public Review(User a, Video p, String t, int v) {
		author = a;
		parent = p;
		text = t;
		score = 0;
		value = v;
		
		censor();
	}
	
	public User getAuthor() {
		return author;
	}
	public Video getParent() {
		return parent;
	}
	public String getText() {
		return text;
	}
	public int getScore() {
		return score;
	}
	public int getValue() {
		return value;
	}
	
	public void setText(String t) {
		text = t;
	}
	
	private void censor() {
		String remaining = text, censored = "", next;
		while (remaining.indexOf(' ') >= 0) {
			next = remaining.substring(0, remaining.indexOf(' '));
			
			if (isOffensive(next)) {
				for (int i = 0; i < next.length(); i++) censored += "*";
			} else {
				censored += next;
			}
			
			censored += " ";
			
			if (remaining.length() - next.length() == 1) remaining = "";
			else remaining = remaining.substring(remaining.indexOf(' ')+1);
			
			if (!remaining.equals("") && remaining.indexOf(' ') == -1) remaining += " ";
		}
		
		text = censored.substring(0, censored.length() - 1);
	}
	private boolean isOffensive(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < OFFENSIVE.length; i++) {
			if (word.equals(OFFENSIVE[i])) return true;
		}
		return false;
	}
}