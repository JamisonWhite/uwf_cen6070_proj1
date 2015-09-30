/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Test BasicTokenizer NextToken(delim) == expected
 * @author jamie
 */
public class TestNextTokenDelim implements TestCase {
   
    private final String name;
    private final BasicTokenizer basicTokenizer;
    private final String expected;
    private final String delim;

    /**
     * Initialize fields
     * @param name
     * @param basicTokenizer
     * @param expected
     * @param delim
     */
    public TestNextTokenDelim(String name, BasicTokenizer basicTokenizer, String expected, String delim) {
        this.name = name;
        this.basicTokenizer = basicTokenizer;
        this.expected = expected;        
        this.delim = delim;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean execute() {   
        String token = this.basicTokenizer.nextToken(delim);
        return expected.equals(token);
    }
 
}
