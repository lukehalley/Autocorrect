// Luke Halley - 20071820

package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import autocorret.BruteAutocomplete;

public class BruteAutoCompleteTest {

	//Tests the WeightOf Method by passing the term "hello" in, expecting an output of 5
	@Test
	public void testWeightOf() {
		BruteAutocomplete testWeightOf = new BruteAutocomplete();
		double output = testWeightOf.weightOf("as");

		assertEquals(2, output, output);

	}

	//Tests the bestMatch Method by passing the prefix "hell" in, expecting an output of "hell"
	@Test
	public void testBestMatch() {
		BruteAutocomplete testBestMatch = new BruteAutocomplete();
		String output = testBestMatch.bestMatch("hell");

		assertEquals("hell", output);

	}

	//Tests the Matches Method by passing the prefix "ad" in, expecting an output of that matches the "expected" Array.
	@Test
	public void testMatches() {

		List<String> expected = new ArrayList<String>();
		expected.add("ad");
		expected.add("adam");
		expected.add("adams");
		expected.add("adapted");
		expected.add("add");
		expected.add("added");

		BruteAutocomplete testMatches = new BruteAutocomplete();
		Iterable<String> output = testMatches.matches("ad", 5);

		assertEquals(expected, output);

	}

}
