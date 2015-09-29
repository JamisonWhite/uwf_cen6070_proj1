package basictokenizer;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;

/**
 * <p>
 * Console application to test the Basic Tokenizer class.</p>
 *
 * @author Justin Lambert, Salina Hall, Jamie (Robert) White, Mike Worn
 * @version 1.0.0 Oct 4, 2015 CEN6070	Project #: 1 File Name:
 * BasicTokenizerTester.java
 */
public class BasicTokenizerTester {

   //=============================================
   // Static class attributes
   //=============================================

    /**
     * The total number of tests executed
     */
    public static int testingCount;

    /**
     * The total number of passing tests
     */
    public static int passingCount;

    /**
     * The total number of failed tests
     */
    public static int failureCount;
    
   //=============================================
   // Public Test Case Methods
   //=============================================

    /**
     * Test case T001
     * Test of constructor BasicTokenizer(str)
     *
     * @return true test passes, false otherwise
     */
    public static boolean testCase001() {
        boolean testingPassed = true;
        
        // T001 test of constructor BasicTokenizer(str)
        try {
            BasicTokenizer tokenizer = new BasicTokenizer(null);
             
            testingPassed = false;
        } catch (java.lang.NullPointerException e) {
            // expected result
        } catch (Exception e) {
            testingPassed = false;
        }
        
        return testingPassed;
    }

    /**
     * Test case T002
     * Test of constructor BasicTokenizer(str)
     *
     * @return true test passes, false otherwise
     */
    public static boolean testCase002() {
        boolean testingPassed = true;
        
        // T001 test of constructor BasicTokenizer(str)
        try {
            BasicTokenizer tokenizer = new BasicTokenizer(null);
             
            testingPassed = false;
        } catch (java.lang.NullPointerException e) {
            // expected result
        } catch (Exception e) {
            testingPassed = false;
        }
        
        return testingPassed;
    }

    /**
     * Test case T003
     * Test of constructor BasicTokenizer(str)
     *
     * @return true test passes, false otherwise
     */
    public static boolean testCase003() {
        boolean testingPassed = true;
        
        // T001 test of constructor BasicTokenizer(str)
        try {
            BasicTokenizer tokenizer = new BasicTokenizer(null);
             
            testingPassed = false;
        } catch (java.lang.NullPointerException e) {
            // expected result
        } catch (Exception e) {
            testingPassed = false;
        }
        
        return testingPassed;
    }

    /**
     * Test case T004
     * Test of constructor BasicTokenizer(str)
     *
     * @return true test passes, false otherwise
     */
    public static boolean testCase004() {
        boolean testingPassed = true;
        
        // T001 test of constructor BasicTokenizer(str)
        try {
            BasicTokenizer tokenizer = new BasicTokenizer(null);
             
            testingPassed = false;
        } catch (java.lang.NullPointerException e) {
            // expected result
        } catch (Exception e) {
            testingPassed = false;
        }
        
        return testingPassed;
    }
    
    public static boolean testIsItOne(int one) throws Exception {
        return one == 1;
    }

    /**
     * Throw unexpected exception while testing scenario
     * @return
     * @throws Exception 
     */
    public static boolean testThrowAnException() throws Exception {
        throw new Exception("Test exception thrown.");
    }

    /**
     * Execute test cases and report results.
     *
     * @param testCases
     */
    private static void executeTestCases(TreeMap<String, Callable<Boolean>> testCases) {
        //Call each of the tests and report results.
        System.out.println("---------------------------------");
        System.out.println("-- Starting Test Suite");
        System.out.println("---------------------------------");
        
        for (Map.Entry<String, Callable<Boolean>> testEntry : testCases.entrySet()) {
            String testName = testEntry.getKey();
            Boolean testResult = false;
            String errorMessage = "";

            try {
                BasicTokenizerTester.testingCount++;
                //System.out.println("[" + BasicTokenizerTester.testingCount + "] TESTING: " + testName);
                testResult = testEntry.getValue().call();
            } catch (Exception ex) {
                errorMessage = ex.getMessage();
            }
            
            if (testResult) {
                BasicTokenizerTester.passingCount++;
                System.out.println("[" + BasicTokenizerTester.testingCount + "] PASSED: " + testName);
            } else {
                BasicTokenizerTester.failureCount++;
                System.out.println("[" + BasicTokenizerTester.testingCount + "] FAILED: " + testName
                        + (("".equals(errorMessage) ? "" : " ERROR: " + errorMessage)));
            }
        }
        
        System.out.println("---------------------------------");
        System.out.println("-- Completed Test Suite");
        System.out.println("-- " + BasicTokenizerTester.testingCount + " Total Tests");
        System.out.println("-- " + BasicTokenizerTester.passingCount + " Passing Tests");
        System.out.println("-- " + BasicTokenizerTester.failureCount + " Failing Tests");
        System.out.println("---------------------------------");
    }

   //=============================================
   // Main method to start console app
   //=============================================

    /**
     * The test driver for class BasicTokenizer
     *
     * @param args
     */
    public static void main(String[] args) {

        //Ordered HashMap with name of the test and a method call
        TreeMap<String, Callable<Boolean>> testCases = new TreeMap<>();

        testCases.put("Test Case T001 - Boundary Value test first constructor ",
                () -> BasicTokenizerTester.testCase001());
        testCases.put("Test Case T002 - Boundary Value test first constructor ",
                () -> BasicTokenizerTester.testCase002());
        testCases.put("Test Case T003 - Boundary Value test first constructor ",
                () -> BasicTokenizerTester.testCase003());
        testCases.put("Test Case T004 - Boundary Value test first constructor ",
                () -> BasicTokenizerTester.testCase004());
        testCases.put("IsItOne1 - demo sending parameters to test method. ",
                () -> BasicTokenizerTester.testIsItOne(1));
        testCases.put("IsItOne2 - demo failing test ",
                () -> BasicTokenizerTester.testIsItOne(2));
        testCases.put("ThrowAnException - demo test that throws exception ",
                () -> BasicTokenizerTester.testThrowAnException());

        //Execute test cases
        BasicTokenizerTester.executeTestCases(testCases);
    } // end main

} // end class BasicTokenizerTester
