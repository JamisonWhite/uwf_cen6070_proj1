/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Test BasicTokenizer hasMoreTokens == expected
 * @author jamie
 */
public class TestHasMoreTokens implements TestCase {
   
    private final String name;
    private final BasicTokenizer basicTokenizer;
    private final Boolean expected;

    /**
     * Initialize fields
     * @param name
     * @param basicTokenizer
     * @param expected
     */
    public TestHasMoreTokens(String name, BasicTokenizer basicTokenizer, Boolean expected) {
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
        return this.basicTokenizer.hasMoreTokens() == expected;
    }
 
}
