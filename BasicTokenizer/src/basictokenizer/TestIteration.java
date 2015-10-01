/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

import java.util.List;

/**
 * Test BasicTokenizer iterates and compares to expected
 * @author jamie
 */
public class TestIteration implements TestCase {
   
    private final String name;
    private final BasicTokenizer basicTokenizer;
    private final List<String> expected;

    /**
     * Initialize fields
     * @param name
     * @param basicTokenizer
     * @param expected
     */
    public TestIteration(String name, BasicTokenizer basicTokenizer, List<String> expected) {
        this.name = name;
        this.basicTokenizer = basicTokenizer;
        this.expected = expected;        
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean execute() throws Exception {   

        Integer remaining = expected.size();
        for(String exp: expected) {
            
            if (!basicTokenizer.hasMoreTokens())
                throw new Exception("hasMoreTokens() is incorrect");                
            
            if (remaining != basicTokenizer.countTokens())
                throw new Exception("countTokens() is incorrect");
            
            String token = basicTokenizer.nextToken();
            if (!exp.equals(token))
                throw new Exception("nextToken() is incorrect.");
            
            remaining--;
        }
        
        return true;
        
    }
 
}
