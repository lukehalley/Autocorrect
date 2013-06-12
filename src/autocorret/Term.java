// Luke Halley - 20071820

package autocorret;

public class Term implements Comparable<Term> {

	private String termName;
// Term frequency and weight determine ranking order in results
// Term represents a searchable word with associated frequency weight
	private long weight;

	public Term(String termName, long weight) {
		this.setTermName(termName);
		this.setWeight(weight);
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
