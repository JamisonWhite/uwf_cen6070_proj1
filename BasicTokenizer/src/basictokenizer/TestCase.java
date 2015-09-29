/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Test case interface
 * @author jamie
 */
public interface TestCase {
    
    /**
     * Name of the test
     * @return 
     */
    String getName();
    
    /**
     * Execute the test
     * @return 
     */
    Boolean execute();
    
}
