/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basictokenizer;

/**
 *
 * @author jwhite
 */
public class TestCase001  {

    public static boolean execute() throws Exception {

        //throw new Exception("Not implemented");
        
        //Arrange
        BasicTokenizer tokenizer;

        //Act
        tokenizer = new BasicTokenizer(null);

        //Assert
        return tokenizer != null;
    }
}
