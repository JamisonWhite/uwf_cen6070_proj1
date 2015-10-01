/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

import java.util.ArrayList;
import java.util.List;
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
    // Main method to start console app
    //=============================================
    /**
     * The test driver for class BasicTokenizer
     *
     * @param args
     */
    public static void main(String[] args) {

        List<TestCase> testCases = new ArrayList<TestCase>();
        List<TestCase> errCases = new ArrayList<TestCase>();

        //TODO We need the Decision table to help us narrow down the possibilities!
        
        //Test Constructors        
        testCases.add(new TestConstructor1("T001 -- Constructor 1 valid text.", "a b c d"));
        testCases.add(new TestConstructor1("T002 -- Constructor 1 empty text.", ""));
        errCases.add(new TestConstructor1("T003 -- Constructor 1 null text. Throws exception.", null));
        testCases.add(new TestConstructor2("T004 -- Constructor 2 valid text.", "a b c d", " "));
        testCases.add(new TestConstructor2("T005 -- Constructor 3 empty text.", "", ""));
        testCases.add(new TestConstructor2("T006 -- Constructor 3 non-unique delimiters.", "a,b,c,d", ",,,,,,bbbbbcccccdddddd"));
        errCases.add(new TestConstructor2("T007 -- Constructor 4 null text. Throws exception.", null, null));
        //etc....

        //Test CountTokens
        testCases.add(new TestCountTokens("T007 -- CountTokens normal.", new BasicTokenizer("a b c d"), 4));
        testCases.add(new TestCountTokens("T007 -- CountTokens no delimiter.", new BasicTokenizer("abcd"), 1));
        errCases.add(new TestCountTokens("T007 -- CountTokens null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), 0));
        testCases.add(new TestCountTokens("T007 -- CountTokens empty text.", new BasicTokenizer(""), 0));
        //etc....

        //Test HasMoreTokens
        testCases.add(new TestHasMoreTokens("T051 -- hasMoreTokens normal.", new BasicTokenizer("a b c d"), true));
        testCases.add(new TestHasMoreTokens("T052 -- hasMoreTokens delimiter changed.", new BasicTokenizer("abcd"),  true));
        errCases.add(new TestHasMoreTokens("T053 -- hasMoreTokens null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), true));
        
        //Test NextToken
        testCases.add(new TestNextToken("T055 -- nextToken normal.", new BasicTokenizer("a b c d"), "a b c d"));
        testCases.add(new TestNextToken("T056 -- nextToken no delimiter.", new BasicTokenizer("abcd"), "abcd"));
        errCases.add(new TestNextToken("T057 -- nextToken  null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), null));
        
        //Test NextToken(delim)
        testCases.add(new TestNextTokenDelim("T059 -- nextTokenDelim normal with space as a delimiter.", new BasicTokenizer("a b c d"), "a b c d", " "));
        testCases.add(new TestNextTokenDelim("T060 -- nextTokenDelim no delimiter.", new BasicTokenizer("abcd"), "abcd", ""));
        errCases.add(new TestNextTokenDelim("T061 -- nextTokenDelim  null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), "a b c d", null));
        
        
        //Test NextToken(delim)
        testCases.add(new TestNextTokenDelim("T151 -- NextTokenDelim normal", new BasicTokenizer("a b,c d", " "), "a b", ","));
        testCases.add(new TestNextTokenDelim("T152 -- NextTokenDelim non-unique delimiters", new BasicTokenizer("a b,c d", " "), "a b", ",,,,,"));
        errCases.add(new TestNextTokenDelim("T153 -- NextTokenDelim null delimiter", new BasicTokenizer("a b,c d", " "), "a b,c d", null));
        testCases.add(new TestNextTokenDelim("T154 -- NextTokenDelim empty delimiter", new BasicTokenizer("a b,c d", " "), "a b,c d", ""));
        testCases.add(new TestNextTokenDelim("T155 -- NextTokenDelim text does not contain delimiter", new BasicTokenizer("a b,c d", " "), "a b,c d", ";"));
        testCases.add(new TestNextTokenDelim("T156 -- NextTokenDelim empty text", new BasicTokenizer("", " "), "", ","));
        
        
        //Test HasMoreElements
        
        //Test NextElement
        
        //Ad Hoc test will need a new TestCase for each scenario
        
        
        executeTestCases(testCases, errCases);
        
        
    } // end main

    /**
     * Execute and report all test cases
     * @param testCases
     * @param exceptionCases 
     */
    private static void executeTestCases(List<TestCase> testCases, List<TestCase> exceptionCases) {

        int testCaseCount = 0;
        int passingCaseCount = 0;
        int failedCaseCount = 0;

        //Call each of the tests and report results.
        System.out.println("---------------------------------");
        System.out.println("-- Starting Test Suite");
        System.out.println("---------------------------------");

        for (TestCase testCase : testCases) {
            testCaseCount++;
            try {
                if (testCase.execute()) {
                    passingCaseCount++;
                    System.out.println("[" + testCaseCount + "] PASSED: " + testCase.getName());
                } else {
                    failedCaseCount++;
                    System.out.println("[" + testCaseCount + "] FAILED: " + testCase.getName());
                }
            } catch (Exception ex) {
                failedCaseCount++;
                System.out.println("[" + testCaseCount + "] FAILED: " + testCase.getName() + " ERROR: " + ex.getMessage());
            }
        }

        for (TestCase testCase : exceptionCases) {
            testCaseCount++;
            try {
                testCase.execute();
                failedCaseCount++;
                System.out.println("[" + testCaseCount + "] FAILED: " + testCase.getName());
            } catch (Exception ex) {
                passingCaseCount++;
                System.out.println("[" + testCaseCount + "] PASSED: " + testCase.getName() + " ERROR: " + ex.getMessage());
            }
        }

        System.out.println("---------------------------------");
        System.out.println("-- Completed Test Suite");
        System.out.println("-- " + testCaseCount + " Total Tests");
        System.out.println("-- " + passingCaseCount + " Passing Tests");
        System.out.println("-- " + failedCaseCount + " Failing Tests");
        System.out.println("---------------------------------");

    }

} // end class BasicTokenizerTester
