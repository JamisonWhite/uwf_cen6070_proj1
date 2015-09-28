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

    /**
     * BasicTokenizer unit test driver
     *
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

//        // if test case passed
//        BasicTokenizerTester.passingCount++;
//
//        // or if failed
//        BasicTokenizerTester.failureCount++;
        return testingPassed;
    }
    
    public static boolean testIsItOne(int one) throws Exception {
        return one == 1;
    }

    public static boolean testThrowAnException() throws Exception {
        throw new Exception("Test exception thrown.");
    }

    /**
     * The test driver for class BasicTokenizer
     *
     * @param args
     */
    public static void main(String[] args) {

        //Ordered HashMap with name of the test and a method call
        TreeMap<String, Callable<Boolean>> testCases = new TreeMap<>();

        testCases.put("BasicTokenizer1 - all tests passed ",
                () -> BasicTokenizerTester.allTestingPassed());
        testCases.put("IsItOne1 - demo sending parameters to test method. ",
                () -> BasicTokenizerTester.testIsItOne(1));
        testCases.put("IsItOne2 - demo failing test ",
                () -> BasicTokenizerTester.testIsItOne(2));
        testCases.put("ThrowAnException - demo test that throws exception ",
                () -> BasicTokenizerTester.testThrowAnException());

        //Execute test cases
        BasicTokenizerTester.executeTestCases(testCases);

        System.out.println("");
        System.out.println("");

        System.out.println("---------------------------------");
        System.out.println("-- Original code");
        System.out.println("---------------------------------");
        boolean allPassed = BasicTokenizerTester.allTestingPassed();
        if (allPassed) {
            System.out.println("BasicTokenizer - all tests passed");
        } else {
            int total = BasicTokenizerTester.passingCount + BasicTokenizerTester.failureCount;

            System.out.println("BasicTokenizer - " + BasicTokenizerTester.failureCount
                    + " FAILURE OUT OF " + total + " TEST CASES");
        }
    } // end main

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

} // end class BasicTokenizerTester
