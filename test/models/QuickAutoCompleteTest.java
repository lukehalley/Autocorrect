// Luke Halley - 20071820

package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import autocorret.QuickAutocomplete;

public class QuickAutoCompleteTest {

	//Tests the bestMatch Method by passing the prefix "hell" in, expecting an output of "hell"
	@Test
	public void testWeightOf() {
		QuickAutocomplete testWeightOf = new QuickAutocomplete();
		double output = testWeightOf.weightOf("the");

		assertEquals(3, output, output);

	}

	//Tests the bestMatch Method by passing the prefix "ad" in, expecting an output of "ad"
	@Test
	public void testBestMatch() {
		QuickAutocomplete testBestMatch = new QuickAutocomplete();
		String output = testBestMatch.bestMatch("ad");

		assertEquals("ad", output);

	}

	//Tests the Matches Method by passing the prefix "ad" in, expecting an output of that matches the "expected" Array.
	@Test
	public void testMatches() {

		List<String> expected = new ArrayList<String>();
		expected.add("added");
		expected.add("advantage");
		expected.add("additional");
		expected.add("advance");
		expected.add("add");
		expected.add("advanced");

		QuickAutocomplete testMatches = new QuickAutocomplete();
		Iterable<String> output = testMatches.matches("ad", 5);

		assertEquals(expected, output);

	}

}
