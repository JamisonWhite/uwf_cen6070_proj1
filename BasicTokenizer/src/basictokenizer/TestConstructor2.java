/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Assert BasicTokenizer constructor2 works
 * @author jamie
 */
public class TestConstructor2 implements TestCase {
    
    private final String name;
    private final String text;
    private final String delim;

    /**
     * Initialize fields
     * @param name
     * @param text
     * @param delim
     */
    public TestConstructor2(String name, String text, String delim) {
        this.name = name;       
        this.text = text;
        this.delim = delim;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean execute() {        
        BasicTokenizer t = new BasicTokenizer(text, delim);
        return t != null;
    }

  
    
}
