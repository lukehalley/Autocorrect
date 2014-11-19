package models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import autocorret.QuickAutocomplete;

public class QuickAutoCompleteTest {

	@Test
	public void testWeightOf() {
		QuickAutocomplete testWeightOf = new QuickAutocomplete();
		double output = testWeightOf.weightOf("hello");

		assertEquals(5, output, output);

	}

	@Test
	public void testBestMatch() {
		QuickAutocomplete testBestMatch = new QuickAutocomplete();
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

		QuickAutocomplete testMatches = new QuickAutocomplete();
		Iterable<String> output = testMatches.matches("ad", 5);

		assertEquals(expected, output);

	}

}
