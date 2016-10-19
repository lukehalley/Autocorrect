package models;

import static org.junit.Assert.*;
import org.junit.Test;
import autocorret.Term;

public class TermTest
{ 
  Term hello = new Term ("hello", 234723);

  @Test
  public void testCreate()
  {
    assertEquals ("hello",               hello.getTermName());  
    assertEquals (234723,                hello.getWeight());  
  }
  
  @Test
  public void testGetter()
  {
	Term testTerm2 = new Term("test", 662346);
	  
    assertEquals ("test",               testTerm2.getTermName());
    testTerm2.setTermName("whatever");
    assertEquals ("whatever",           testTerm2.getTermName());
  }
  
  
}