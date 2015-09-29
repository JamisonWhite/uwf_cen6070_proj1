/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Assert BasicTokenizer constructor1 works
 * @author jamie
 */
public class TestConstructor1 implements TestCase {
    
    private final String name;
    private final String text;

    /**
     * Initialize fields
     * @param name
     * @param text
     */
    public TestConstructor1(String name, String text) {
        this.name = name;       
        this.text = text;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean execute() {        
        BasicTokenizer t = new BasicTokenizer(text);
        return t != null;
    }

  
    
}
