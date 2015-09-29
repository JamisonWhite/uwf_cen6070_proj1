/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Test BasicTokenizer NextToken == expected
 * @author jamie
 */
public class TestNextToken implements TestCase {
   
    private final String name;
    private final BasicTokenizer basicTokenizer;
    private final String expected;

    /**
     * Initialize fields
     * @param name
     * @param basicTokenizer
     * @param expected
     */
    public TestNextToken(String name, BasicTokenizer basicTokenizer, String expected) {
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
        return expected.equals(this.basicTokenizer.nextToken());
    }
 
}
