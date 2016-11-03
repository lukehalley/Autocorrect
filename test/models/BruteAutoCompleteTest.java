package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void testMatches() {

		List<String> expected = new ArrayList<String>();
		expected.add("added");
		expected.add("advantage");
		expected.add("additional");
		expected.add("advance");
		expected.add("add");
		expected.add("advanced");

		BruteAutocomplete testMatches = new BruteAutocomplete();
		Iterable<String> output = testMatches.matches("ad", 5);

		assertEquals(expected, output);

	}

}
