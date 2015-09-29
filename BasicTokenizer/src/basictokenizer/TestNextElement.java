/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Test BasicTokenizer NextElement == expected
 * @author jamie
 */
public class TestNextElement implements TestCase {
   
    private final String name;
    private final BasicTokenizer basicTokenizer;
    private final Object expected;

    /**
     * Initialize fields
     * @param name
     * @param basicTokenizer
     * @param expected
     */
    public TestNextElement(String name, BasicTokenizer basicTokenizer, Object expected) {
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
        return expected.equals(this.basicTokenizer.nextElement());
    }
 
}
