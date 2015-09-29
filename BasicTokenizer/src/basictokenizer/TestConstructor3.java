/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Assert BasicTokenizer constructor3 works
 * @author jamie
 */
public class TestConstructor3 implements TestCase {
    
    private final String name;
    private final String text;
    private final String delim;
    private final Boolean returnDelims;

    /**
     * Initialize fields
     * @param name
     * @param text
     * @param delim
     * @param returnDelims
     */
    public TestConstructor3(String name, String text, String delim, Boolean returnDelims) {
        this.name = name;       
        this.text = text;
        this.delim = delim;
        this.returnDelims = returnDelims;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean execute() {        
        BasicTokenizer t = new BasicTokenizer(text, delim, returnDelims);
        return t != null;
    }

  
    
}
