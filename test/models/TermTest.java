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
  public void testSetter()
  {
	  Term x=new Term("test",666);
	  
    assertEquals ("test",               x.getTermName());
    x.setTermName("whatever");
    assertEquals ("whatever",           x.getTermName());
  }
  
}