package autocorret;

public class Term implements Comparable<Term> {

	private String termName;
	private long weight;

	public Term(String termName, long weight) {
		this.setTermName(termName);
		this.setWeight(weight);
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

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
