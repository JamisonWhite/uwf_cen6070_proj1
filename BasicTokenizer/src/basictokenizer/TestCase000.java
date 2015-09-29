/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

/**
 * Example test case
 * @author jamie
 */
public class TestCase000 implements TestCase  {

    @Override
    public String getName() {
        return "TC000 Example test case.";
    }

    @Override
    public Boolean execute() {
                
        //Arrange
        BasicTokenizer tokenizer;

        //Act
        tokenizer = new BasicTokenizer(null);

        //Assert
        return tokenizer != null;
    }
    
}
