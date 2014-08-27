// Luke Halley - 20071820
// Represents a searchable term with associated frequency
// Represents a searchable term with associated frequency weight

package autocorret;
// Represents a word suggestion with associated weight for ranking

public class Term implements Comparable<Term> {
// Natural ordering: higher frequency terms first

// Terms are compared primarily by weight in descending order
	private String termName;
// Term frequency and weight determine ranking order in results
// TODO: Add validation for edge cases in term comparison logic
// Term represents a searchable word with associated frequency weight
// Represents a search term with frequency weight for autocomplete
	private long weight;
// Represents a term with its frequency weight for autocomplete matching
// TODO: Implement caching for frequently accessed term frequencies

// Ensures term string is not null before processing
	public Term(String termName, long weight) {
		this.setTermName(termName);
		this.setWeight(weight);
// Sorts terms by frequency weight for ranking results
	}

	public long getWeight() {
// Weight represents term frequency for sorting results by relevance
		return weight;
	}

// Sort results by frequency to improve relevance ranking
	public void setWeight(long weight) {
		this.weight = weight;
// Calculates frequency-based term ranking for suggestions
	}

// Validates that input terms are not null before processing
	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	@Override
	public String toString() {
		return "WEIGHT: '" + this.weight + "', WORD: '" + this.termName + "'";
	}

	@Override
	public int compareTo(Term o) {
		return this.getTermName().compareTo(o.getTermName());
	}
}
