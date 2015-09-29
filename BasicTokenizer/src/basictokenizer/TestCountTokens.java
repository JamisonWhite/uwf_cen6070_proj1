/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Assert basicTokenizer count == expected count.
 * @author jamie
 */
public class TestCountTokens implements TestCase {
    
    private final String name;
    private final BasicTokenizer basicTokenizer;
    private final int expected;

    /**
     * Initialize fields
     * @param name
     * @param basicTokenizer
     * @param expected
     */
    public TestCountTokens(String name, BasicTokenizer basicTokenizer, int expected) {
        this.name = name;
        this.basicTokenizer = basicTokenizer;
        this.expected = expected;        
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean execute() {        
        return this.basicTokenizer.countTokens() == expected;
    }

  
    
}
