package models;

import static org.junit.Assert.*;

import org.junit.Test;

import autocorret.BruteAutocomplete;

public class BruteAutoCompleteTest {

	@Test
	public void testWeightOf() {
		BruteAutocomplete testWeightOf = new BruteAutocomplete();
		double output = testWeightOf.weightOf("hello");
		
		assertEquals(5, output, output);
		
	}
	
	@Test
	public void testBestMatch() {
		BruteAutocomplete testBestMatch = new BruteAutocomplete();
		String output = testBestMatch.bestMatch("hell");
		
		assertEquals("hell", output);
		
	}
	
	

}
