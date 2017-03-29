package edu.ycp.cs320.rvandemark.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Video {

	private String url;
	private String embedUrl;
	private String name;
	private String speaker;
	private ArrayList<String> disciplines;
	private double rating;
	private ArrayList<Review> reviews;

	public Video (String u, String e, String n, String s, ArrayList<String> d, double ra, ArrayList<Review> re) {
		url = u;
		embedUrl = e;
		name = n;
		speaker = s;
		disciplines = d;
		rating = ra;
		reviews = re;
	}
	public Video (String u, double r) throws IOException {
		url = u;
		embedUrl = format(url);

		String sourceCode = extractUrlSource();
		name = extractName(sourceCode);
		speaker = extractSpeaker(sourceCode);
		disciplines = extractDisciplines(sourceCode);
		rating = r;
		reviews = new ArrayList<Review>();
	}

	public String getUrl() {
		return url;
	}
	public String getEmbedUrl() {
		return embedUrl;
	}
	public String getName() {
		return name;
	}
	public String getSpeaker() {
		return speaker;
	}
	public ArrayList<String> getDisciplines() {
		return disciplines;
	}
	public double getRating() {
		return rating;
	}
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	public String getRatingClip() {
		return "clip:rect(0px," + (int)(375*rating/5) + "px,75px,0px)";
	}
	public String getDisciplineLine() {
		String str = "";
		for (int i = 0; i < disciplines.size(); i++) {
			str += disciplines.get(i);
			if (i != disciplines.size()-1) str += (", ");
		}
		return str;
	}

	private String format(String url) throws IOException {
		if (url.indexOf("ted.com/") == -1) {
			throw new IOException();
		}

		int protocolIdx = url.indexOf("https://");
		if (protocolIdx == -1) {
			protocolIdx = url.indexOf("http://");
			if (protocolIdx == -1) {
				url = "https://" + url;
			} else {
				url = url.replace("http://", "https://");
			}
		}

		if (url.indexOf("www.") >= 0) {
			url = url.substring(0, url.indexOf("www.")) + url.substring(url.indexOf("www.")+4);
		}

		return url.substring(0,8) + "embed." + url.substring(8);
	}

	private String extractUrlSource() throws IOException {
		String urlCopy = url;
		if (urlCopy.indexOf("http://") == -1 && urlCopy.indexOf("https://") == -1) urlCopy = "https://" + urlCopy;
		URL theURL = new URL(urlCopy);
		URLConnection conn = theURL.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String line, str = "";
		while ((line = br.readLine()) != null) {
			str += line;
		}
		br.close();

		return str;
	}

	private String extractName(String sourceCode) {
		final String keyStart = "<span class='player-hero__title__content'>", keyEnd = "</span>";
		try {
			String src = sourceCode.substring(sourceCode.indexOf(keyStart));
			return src.substring(src.indexOf(keyStart) + keyStart.length(), src.indexOf(keyEnd));
		} catch (StringIndexOutOfBoundsException e) {
			try { return extractName(extractUrlSource()); }
			catch (IOException e1) { e1.printStackTrace(); return null; }
		}
	}

	private String extractSpeaker(String sourceCode) {
		final String keyStart = "<span class='player-hero__speaker__content'>", keyEnd = ":</span>";
		try {
			String src = sourceCode.substring(sourceCode.indexOf(keyStart));
			return src.substring(src.indexOf(keyStart) + keyStart.length(), src.indexOf(keyEnd));
		} catch (StringIndexOutOfBoundsException e) {
			try { return extractSpeaker(extractUrlSource()); }
			catch (IOException e1) { e1.printStackTrace(); return null; }
		}
	}

	private ArrayList<String> extractDisciplines(String sourceCode) {
		ArrayList<String> theArrList = new ArrayList<String> ();
		final String keyStart = "<li class='talk-topics__item'>", keyEnd = "</a>";
		String src = sourceCode, obj;

		if (src.indexOf(keyStart) == -1) {
			return new ArrayList<String> ();
		} else {
			src = src.substring(src.indexOf(keyStart));
		}

		while (src.indexOf(keyStart) >= 0) {
			obj = src.substring(src.indexOf(keyStart)+keyStart.length());
			theArrList.add(obj.substring(obj.indexOf(">")+1, obj.indexOf(keyEnd)));
			src = obj.substring(obj.indexOf(keyEnd));
		}

		return theArrList;
	}
}