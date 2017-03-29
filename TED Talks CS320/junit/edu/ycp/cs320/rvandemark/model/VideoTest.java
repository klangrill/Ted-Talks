package edu.ycp.cs320.rvandemark.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class VideoTest {
	
	private Video video1;
	private Video video2;
	
	@Before
	public void setUp() {
		try { video1 = new Video("http://www.ted.com/talks/caitlin_doughty_a_burial_practice_that_nourishes_the_planet", 3.4); }
		catch (IOException e) {e.printStackTrace(); }
		
		try { video2 = new Video("ted.com/talks/rob_knight_how_our_microbes_make_us_who_we_are", 4.7); }
		catch (IOException e) {e.printStackTrace(); }
	}
	
	@Test
	public void testGetUrl() {
		assertEquals(video1.getUrl(), "http://www.ted.com/talks/caitlin_doughty_a_burial_practice_that_nourishes_the_planet");
		assertEquals(video2.getUrl(), "ted.com/talks/rob_knight_how_our_microbes_make_us_who_we_are");
	}
	@Test
	public void testGetEmbedUrl() {
		assertEquals(video1.getEmbedUrl(), "https://embed.ted.com/talks/caitlin_doughty_a_burial_practice_that_nourishes_the_planet");
		assertEquals(video2.getEmbedUrl(), "https://embed.ted.com/talks/rob_knight_how_our_microbes_make_us_who_we_are");
	}
	@Test
	public void testGetName() {
		assertEquals(video1.getName(), "A burial practice that nourishes the planet");
		assertEquals(video2.getName(), "How our microbes make us who we are");
	}
	@Test
	public void testGetSpeaker() {
		assertEquals(video1.getSpeaker(), "Caitlin Doughty");
		assertEquals(video2.getSpeaker(), "Rob Knight");
	}
	@Test
	public void testGetDisciplines() {
		ArrayList<String> disciplines;
		int i;
		
		disciplines = video1.getDisciplines();
		i = 0;
		assertEquals(disciplines.get(i++), "TEDMED");
		assertEquals(disciplines.get(i++), "Animals");
		assertEquals(disciplines.get(i++), "Bacteria");
		assertEquals(disciplines.get(i++), "Choice");
		assertEquals(disciplines.get(i++), "Death");
		assertEquals(disciplines.get(i++), "Ecology");
		assertEquals(disciplines.get(i++), "Environment");
		assertEquals(disciplines.get(i++), "Family");
		assertEquals(disciplines.get(i++), "Green");
		assertEquals(disciplines.get(i++), "Humanity");
		assertEquals(disciplines.get(i++), "Nature");
		assertEquals(disciplines.get(i++), "Pollution");
		assertEquals(disciplines.get(i++), "Potential");
		assertEquals(disciplines.get(i++), "Sanitation");
		assertEquals(disciplines.get(i++), "Social change");
		assertEquals(disciplines.get(i++), "Society");
		
		disciplines = video2.getDisciplines();
		i = 0;
		assertEquals(disciplines.get(i++), "TED Books");
		assertEquals(disciplines.get(i++), "Biology");
		assertEquals(disciplines.get(i++), "Health");
	}
	@Test
	public void testGetRating() {
		assertEquals(video1.getRating(), 3.4, 0.000001);
		assertEquals(video2.getRating(), 4.7, 0.000001);
	}
	
	@Test
	public void testGetRatingClip() {
		assertEquals(video1.getRatingClip(), "clip:rect(0px,255px,75px,0px)");
		assertEquals(video2.getRatingClip(), "clip:rect(0px,352px,75px,0px)");
	}
	@Test
	public void testGetDisciplineLine() {
		assertEquals(video1.getDisciplineLine(), "TEDMED, Animals, Bacteria, Choice, Death, Ecology, Environment, Family, Green, Humanity, Nature, Pollution, Potential, Sanitation, Social change, Society");
		assertEquals(video2.getDisciplineLine(), "TED Books, Biology, Health");
	}
	
	@Test
	public void testFormat() {
		String[] urls = {
			"http://www.ted.com/talks/michael_shermer_the_pattern_behind_self_deception",
			"http://ted.com/talks/michael_shermer_the_pattern_behind_self_deception",
			"ted.com/talks/michael_shermer_the_pattern_behind_self_deception",
		};
		
		Video[] videos = new Video[urls.length];
		for (int i = 0; i < videos.length; i++) {
			try { videos[i] = new Video(urls[i], i); }
			catch (IOException e) { e.printStackTrace(); }
			assertEquals(videos[i].getEmbedUrl(), "https://embed.ted.com/talks/michael_shermer_the_pattern_behind_self_deception");
		}
	}
	
	@Test(expected=IOException.class)
	public void testFormatRequiresTEDProtocol() throws IOException {
		new Video("http://www.youtube.com/talks/michael_shermer_the_pattern_behind_self_deception", 3.4);
	}
}