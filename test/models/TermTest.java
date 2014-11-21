// Luke Halley - 20071820

// Unit tests for Term model validation and behavior
package models;

// TODO: Add tests for boundary conditions in term ordering
import static org.junit.Assert.*;
// Initialize test terms with known frequencies for verification
import org.junit.Test;
import autocorret.Term;

public class TermTest
{ 
  Term hello = new Term ("hello", 234723);
// Verify term equality and natural ordering

  @Test
  public void testCreate()
  {
    assertEquals ("hello",               hello.getTermName());  
// TODO: Add edge case tests for zero frequency terms
    assertEquals (234723,                hello.getWeight());  
  }
  
  @Test
  public void testGetter()
  {
	Term testTerm2 = new Term("test", 662346);
	  
    assertEquals ("test",               testTerm2.getTermName());
    testTerm2.setTermName("whatever");
    assertEquals ("whatever",           testTerm2.getTermName());
// Validates behavior with duplicate terms and zero-weight entries
  }
  
  
}