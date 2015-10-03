/*
 * UWF CEN6070 Fall 2015 Project 1
 *   Justin Lambert
 *   Salina Hall
 *   Jamie White
 *   Michael Worn
 */
package basictokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
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

        //TODO We need the Decision table to help us narrow down the possibilities!
        useSubmissionFormat = false;

        //Test Constructors        
        evaluateTestCase("TXXX", "Constructor 1 valid text.",
                true,
                () -> (new BasicTokenizer("a b c d")) != null);

        evaluateTestCase("TXXX", "Constructor 1 empty text.",
                true,
                () -> (new BasicTokenizer("")) != null);

        evaluateTestCaseException("TXXX", "Constructor 1 null text.",
                NullPointerException.class,
                () -> (new BasicTokenizer(null)) != null);

        evaluateTestCase("TXXX", "Constructor 2 valid text and valid delim.",
                true,
                () -> (new BasicTokenizer("a b c d", " ")) != null);

        evaluateTestCase("TXXX", "Constructor 2 valid text and empty delim.",
                true,
                () -> (new BasicTokenizer("a b c d", "")) != null);

        evaluateTestCase("TXXX", "Constructor 2 valid text and null delim.",
                true,
                () -> (new BasicTokenizer("a b c d", null)) != null);

        evaluateTestCase("TXXX", "Constructor 2 valid text and valid delim and true.",
                true,
                () -> (new BasicTokenizer("a b c d", " ", true)) != null);

        evaluateTestCase("TXXX", "Constructor 2 valid text and valid delim and false.",
                true,
                () -> (new BasicTokenizer("a b c d", " ", false)) != null);

        evaluateTestCase("TXXX", "Constructor 2 valid text and non-unique delim.",
                true,
                () -> (new BasicTokenizer("a b c d", "       ")) != null);

        //Test CountTokens        
        evaluateTestCase("TXXX", "countTokens normal.",
                4,
                () -> (new BasicTokenizer("a b c d")).countTokens());

        evaluateTestCase("TXXX", "countTokens no delims in text.",
                1,
                () -> (new BasicTokenizer("abcd")).countTokens());

        evaluateTestCase("TXXX", "countTokens empty delims.",
                1,
                () -> (new BasicTokenizer("a b c d", "")).countTokens());

        evaluateTestCaseException("TXXX", "countTokens null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).countTokens());

        evaluateTestCase("TXXX", "countTokens empty text.",
                0,
                () -> (new BasicTokenizer("")).countTokens());
        //etc....

        //Test HasMoreTokens
        evaluateTestCase("T051", "hasMoreTokens normal.",
                true,
                () -> (new BasicTokenizer("a b c d")).hasMoreTokens());

        evaluateTestCase("T052", "hasMoreTokens no delims in text.",
                true,
                () -> (new BasicTokenizer("abcd")).hasMoreTokens());

        evaluateTestCase("T053", "hasMoreTokens empty text.",
                true,
                () -> (new BasicTokenizer("")).hasMoreTokens());

        evaluateTestCase("T054", "hasMoreTokens null delim. Should fail.",
                false,
                () -> (new BasicTokenizer("a b c d", null)).hasMoreTokens());

        //Test NextToken
        evaluateTestCase("T055", "nextToken normal.",
                "a",
                () -> (new BasicTokenizer("a b c d")).nextToken());

        evaluateTestCase("T056", "nextToken no delimiter.",
                "abcd",
                () -> (new BasicTokenizer("abcd")).nextToken());

        evaluateTestCaseException("T057", "nextToken  null delimiter.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).nextToken());
        
        evaluateTestCaseException("T058", "nextToken  empty text.",
                NullPointerException.class,
                () -> (new BasicTokenizer("")).nextToken());
        

        //Test HasMoreElements
        evaluateTestCase("T059", "hasMoreTokens normal",
                true,
                () -> (new BasicTokenizer("a b c d")).hasMoreElements());

        evaluateTestCase("T060", "hasMoreTokens delimiter not in text",
                true,
                () -> (new BasicTokenizer("abcd")).hasMoreElements());

        evaluateTestCaseException("T061", "hasMoreTokens null delimiter.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).hasMoreElements());

        //Test NextElement
        evaluateTestCase("T062", "nextElement normal",
                "a",
                () -> (new BasicTokenizer("a b c d")).nextElement());

        evaluateTestCase("T063", "nextElement no delimiter",
                "abcd",
                () -> (new BasicTokenizer("abcd")).nextElement());

        evaluateTestCaseException("T064", "nextElement null delimiter",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).nextElement());

        //Test NextToken(delim)        
        evaluateTestCaseException("T065", "R1 NextTokenDelim null string.",
                NullPointerException.class,
                () -> (new BasicTokenizer(null)).nextToken(","));
        
        evaluateTestCaseException("T066", "R2 NextTokenDelim empty string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b,c d")).nextToken(null));

        evaluateTestCaseException("T067", "R3 NextTokenDelim empty string, empty delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("")).nextToken(""));

        evaluateTestCaseException("T068", "R4 NextTokenDelim empty string, valid delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("")).nextToken(","));

        evaluateTestCaseException("T069", "R5 NextTokenDelim non-delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("abcd")).nextToken(null));

        evaluateTestCase("T070", "R6 NextTokenDelim non-delimited string, empty delim.",
                "abcd",
                () -> (new BasicTokenizer("abcd")).nextToken(""));

        evaluateTestCase("T071", "R7 NextTokenDelim non-delimited string, valid delim, delims are not tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", " ", false)).nextToken(","));

        evaluateTestCase("T072", "R8 NextTokenDelim non-delimited string, valid delim, delims are tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", " ", true)).nextToken(","));

        evaluateTestCaseException("T159", "R9 NextTokenDelim delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d")).nextToken(null));

        evaluateTestCase("T073", "R10 NextTokenDelim delimited string, empty delim.",
                "a b c d",
                () -> (new BasicTokenizer("a b c d")).nextToken(""));

        evaluateTestCase("T074", "R11 NextTokenDelim delimited string, valid delim, delims are not tokens.",
                "a b",
                () -> (new BasicTokenizer("a b,c d", " ", false)).nextToken(","));

        evaluateTestCase("T075", "R12 NextTokenDelim delimited string, valid delim, delims are tokens.",
                "a b",
                () -> (new BasicTokenizer("a b,c d", " ", true)).nextToken(","));

        //Ad Hoc test will need a new TestCase for each scenario
        evaluateTestCase("T076", "R11 Iterate tokens delimited text",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T077", "R11 Iterate tokens delimited text with empty token at end",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d,", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T076", "R11 Iterate tokens delimited text with consecutive delimiters",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        
        evaluateTestCase("T077", "R12 Iterate tokens delimited text with delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d", ",", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ",", "c", ",", "d"))));
        
                
        evaluateTestCase("T078", "R12 Iterate tokens delimited text with multiple characters and delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b;c,d", ",;", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ";", "c", ",", "d"))));
        
        
        
        evaluateTestCase("T079", "R11 Iterate elements delimited text",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T080", "R11 Iterate elements delimited text with empty token at end",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,c,d,", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T081", "R11 Iterate elements delimited text with consecutive delimiters",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        
        evaluateTestCase("T082", "R12 Iterate elements delimited text with delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,c,d", ",", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ",", "c", ",", "d"))));
        
                
        evaluateTestCase("T082", "R12 Iterate elements delimited text with multiple characters and delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b;c,d", ",;", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ";", "c", ",", "d"))));
        
        
        
    } // end main

    /**
     * Evaluate the test case and write results
     *
     * @param <T>
     * @param name
     * @param description
     * @param expected
     * @param testCase
     */
    private static <T> void evaluateTestCase(String name, String description, T expected, Callable<T> testCase) {
        T testCaseResult = null;
        Boolean passed;
        String result = "";

        //execute the call
        try {
            testCaseResult = testCase.call();
            passed = true;
        } catch (Exception ex) {
            result = " Expected: " + expected + " Exception: " + ex.toString();
            passed = false;
        }

        //evaluate result
        if (passed) {
            if (expected == null && testCaseResult == null) {
                passed = true;
            } else if (expected == null && testCaseResult != null) {
                passed = false;
            } else {
                passed = (expected.equals(testCaseResult));
            }
            if (passed) {
                result = " Expected: " + expected;
            } else {
                result = " Expected: " + expected + " Actual: " + testCaseResult;
            }
        }
        writeTestCaseResult(passed, name, description, result);
    }

    /**
     * Evaluate that the test case throws the expected exception and write
     * results
     *
     * @param <T>
     * @param name
     * @param description
     * @param exceptionType
     * @param testCase
     */
    private static <T> void evaluateTestCaseException(String name, String description, Class<?> exceptionType, Callable<T> testCase) {
        Boolean passed;
        String result = "";
        try {
            testCase.call();
            passed = false;
            result = " Expected: " + exceptionType.toString() + " Actual: None";
        } catch (Exception ex) {
            passed = exceptionType.isInstance(ex);
            if (passed) {
                result = " Expected: " + exceptionType.toString() ;
            } else {
                result = " Expected: " + exceptionType.toString() + " Actual: " + ex.toString();
            }
        }
        writeTestCaseResult(passed, name, description, result);
    }

    /**
     * write the test case results
     *
     * @param passed
     * @param name
     * @param description
     * @param result
     */
    private static void writeTestCaseResult(Boolean passed, String name, String description, String result) {
        //report result
        if (useSubmissionFormat) {
            if (passed) {
                System.out.println("Test " + name + " passed. ");
            } else {
                System.out.println("Test " + name + " FAILED. ");
            }
        } else {
            if (passed) {
                System.out.println("Test " + name + " passed. " + description + result);
            } else {
                System.out.println("Test " + name + " FAILED. " + description + result);
            }
        }
    }

    /**
     * Print for submission or details
     */
    private static Boolean useSubmissionFormat;


    /**
     * Token iteration test will use hasMoreTokens, countTokens, and nextToken
     * on each iteration.
     *
     * @param basicTokenizer
     * @param expected
     * @return
     * @throws Exception
     */
    private static Boolean testTokenIteration(BasicTokenizer basicTokenizer, List<String> expected) {
        Integer remaining = expected.size();
        for (String exp : expected) {

            if (!basicTokenizer.hasMoreTokens()) {
                return false;
            }

            if (remaining != basicTokenizer.countTokens()) {
                return false;
            }

            String token = basicTokenizer.nextToken();
            if (!exp.equals(token)) {
                return false;
            }
            remaining--;
        }
        return !basicTokenizer.hasMoreTokens();

    }

    /**
     * Token iteration test will use hasMoreElements and nextElement on each
     * iteration.
     *
     * @param basicTokenizer
     * @param expected
     * @return
     * @throws Exception
     */
    private static Boolean testElementIteration(BasicTokenizer basicTokenizer, List<Object> expected) {
        Integer remaining = expected.size();
        for (Object exp : expected) {

            if (!basicTokenizer.hasMoreElements()) {
                return false;
            }

            Object token = basicTokenizer.nextElement();
            if (!exp.equals(token)) {
                return false;
            }
            remaining--;
        }
        return !basicTokenizer.hasMoreElements();
    }

} // end class BasicTokenizerTester
