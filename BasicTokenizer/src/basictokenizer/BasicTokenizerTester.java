package basictokenizer;

/**
<p>Console application to test the Basic Tokenizer class.</p>
@author Justin Lambert, Salina Hall, Jamie (Robert) White, Mike Worn
@version 1.0.0 Oct 4, 2015
CEN6070	Project #: 1
File Name: BasicTokenizerTester.java
*/
public class BasicTokenizerTester {
    

   /** The total number of passing tests */
   public static int passingCount;  
   
   /** The total number of failed tests */
   public static int failureCount;  
    
    /**
     * BasicTokenizer unit test driver
     * @return true if all tests pass, false otherwise 
     */
    public static boolean allTestingPassed() {
        boolean testingPassed = true;
        
        // A basic sample of one of the constructors to get started
        // Reference appendix sample console output that says which
        // test case passed from Testing Documentation
        System.out.println("Let's test the basic tokenizer!");
        
        BasicTokenizer bt = new BasicTokenizer("this is a test");
        while (bt.hasMoreTokens()) {
            System.out.println(bt.nextToken());
        }   
        
        // if test case passed
        BasicTokenizerTester.passingCount++;
        
        // or if failed
        BasicTokenizerTester.failureCount++;
        
        return testingPassed;
    }
    
    /**
     * The test driver for class BasicTokenizer
     * @param args 
     */
    public static void main(String[] args)
    {
        boolean allPassed = BasicTokenizerTester.allTestingPassed();
        
        if (allPassed) {
            System.out.println("BasicTokenizer - all tests passed");
        } else {
            int total = BasicTokenizerTester.passingCount + BasicTokenizerTester.failureCount;

            System.out.println("BasicTokenizer - " + BasicTokenizerTester.failureCount +
                               " FAILURE OUT OF " + total + " TEST CASES");
        }
    } // end main

} // end class BasicTokenizerTester
