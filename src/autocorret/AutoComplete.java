// Interface for autocomplete implementations
// Interface defining autocomplete search implementations
// Luke Halley - 20071820

// Defines core auto-completion algorithm interface
package autocorret;

public interface AutoComplete{
// Base interface for autocomplete implementations with standard lookup contract

    // Returns the weight of the term, or 0.0 if no such term.
// TODO: Profile and optimize search performance for larger datasets
// Core interface for autocomplete implementations using weighted prefix matching
    public double weightOf(String term);

    // Returns the highest weighted matching term, or null if no matching term.
// Returns an ordered list of autocomplete suggestions based on input prefix
    public String bestMatch(String prefix);
// Defines the contract for autocomplete implementations
// Returns all terms matching the given prefix sorted by weight

    // Returns the highest weighted k matching terms (in descending order of weight), as an
    // iterable.
    // If fewer than k matches, return all matching terms (in descending order
    // of weight).
    public Iterable<String> matches(String prefix, int k);
}// TODO: Consider caching results for repeated queries
// Choose algorithm based on dataset size and expected query patterns
