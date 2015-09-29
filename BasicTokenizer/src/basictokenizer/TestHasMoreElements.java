/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Test BasicTokenizer hasMoreElements == expected
 * @author jamie
 */
public class TestHasMoreElements implements TestCase {
   
    private final String name;
    private final BasicTokenizer basicTokenizer;
    private final Boolean expected;

    /**
     * Initialize fields
     * @param name
     * @param basicTokenizer
     * @param expected
     */
    public TestHasMoreElements(String name, BasicTokenizer basicTokenizer, Boolean expected) {
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
        return this.basicTokenizer.hasMoreElements() == expected;
    }
 
}
