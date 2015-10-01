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
        evaluateTestCase("TXXX", "Constructor 1 null text.", false, null,
                () -> testConstructor(null));

        evaluateTestCase("TXXX", "Constructor 1 valid text.", true,
                () -> testConstructor("a b c d"));

        evaluateTestCase("TXXX", "Constructor 1 empty text.", true,
                () -> testConstructor(""));

        evaluateTestCase("TXXX", "Constructor 2 valid text and valid delim.", true,
                () -> testConstructor("a b c d", " "));

        evaluateTestCase("TXXX", "Constructor 2 valid text and empty delim.", true,
                () -> testConstructor("a b c d", ""));

        evaluateTestCase("TXXX", "Constructor 2 valid text and null delim.", true,
                () -> testConstructor("a b c d", null));

        evaluateTestCase("TXXX", "Constructor 2 valid text and valid delim and true.", true,
                () -> testConstructor("a b c d", " ", true));

        evaluateTestCase("TXXX", "Constructor 2 valid text and valid delim and false.", true,
                () -> testConstructor("a b c d", " ", false));

        evaluateTestCase("TXXX", "Constructor 2 valid text and non-unique delim.", true,
                () -> testConstructor("a b c d", "   ,,,,,,"));

        //Test CountTokens        
        evaluateTestCase("TXXX", "countTokens normal.", true,
                () -> testCountTokens(new BasicTokenizer("a b c d"), 4));

        evaluateTestCase("TXXX", "countTokens no delims in text.", true,
                () -> testCountTokens(new BasicTokenizer("abcd"), 1));

        evaluateTestCase("TXXX", "countTokens empty delims.", true,
                () -> testCountTokens(new BasicTokenizer("a b c d", ""), 1));

        evaluateTestCase("TXXX", "countTokens null delim.", true, true,
                () -> testCountTokens(new BasicTokenizer("a b c d", null), 0));

        evaluateTestCase("TXXX", "countTokens empty text.", true,
                () -> testCountTokens(new BasicTokenizer(""), 0));
        //etc....

        //Test HasMoreTokens
        evaluateTestCase("TXXX", "hasMoreTokens normal.", true,
                () -> testHasMoreTokens(new BasicTokenizer("a b c d"), true));

        evaluateTestCase("TXXX", "hasMoreTokens no delims in text.", true,
                () -> testHasMoreTokens(new BasicTokenizer("abcd"), true));

        evaluateTestCase("TXXX", "hasMoreTokens empty text.", true,
                () -> testHasMoreTokens(new BasicTokenizer(""), true));

        evaluateTestCase("TXXX", "hasMoreTokens null delim. Should fail.", false,
                () -> testHasMoreTokens(new BasicTokenizer("a b c d", null), true));

        //Test NextToken
        evaluateTestCase("T055", "nextToken normal.", true,
                () -> testNextToken(new BasicTokenizer("a b c d"), "a"));

        evaluateTestCase("T056", "nextToken no delimiter.", true,
                () -> testNextToken(new BasicTokenizer("abcd"), "abcd"));

        evaluateTestCase("T057", "nextToken  null delimiter. Throws exception.", false,
                () -> testNextToken(new BasicTokenizer("a b c d", null), null));

        //Test NextToken(delim)
        evaluateTestCase("T151", "NextTokenDelim normal", true,
                () -> testNextTokenDelim(new BasicTokenizer("a b,c d"), ",", "a b"));

        evaluateTestCase("T151", "NextTokenDelim null delim", false,
                () -> testNextTokenDelim(new BasicTokenizer("a b,c d"), null, ""));

        evaluateTestCase("T151", "NextTokenDelim empty delim", true,
                () -> testNextTokenDelim(new BasicTokenizer("a b,c d"), "", "a b,c d"));

        evaluateTestCase("T151", "NextTokenDelim text does not contain delimiter", true,
                () -> testNextTokenDelim(new BasicTokenizer("a b,c d"), ";", "a b,c d"));

        evaluateTestCase("T151", "NextTokenDelim empty text", true,
                () -> testNextTokenDelim(new BasicTokenizer(""), " ", ""));

        //Test HasMoreElements
        evaluateTestCase("T101", "hasMoreTokens normal", true,
                () -> testHasMoreElements(new BasicTokenizer("a b c d"), true));

        evaluateTestCase("T102", "hasMoreTokens delimiter not in text", true,
                () -> testHasMoreElements(new BasicTokenizer("abcd"), true));

        evaluateTestCase("T103", "hasMoreTokens null delimiter.", false,
                () -> testHasMoreElements(new BasicTokenizer("a b c d", null), true));

        //Test NextElement
        evaluateTestCase("T105", "nextElement normal", true,
                () -> testNextElement(new BasicTokenizer("a b c d"), "a"));

        evaluateTestCase("T106", "nextElement no delimiter", true,
                () -> testNextElement(new BasicTokenizer("abcd"), "abcd"));

        evaluateTestCase("T105", "nextElement null delimiter", true, true,
                () -> testNextElement(new BasicTokenizer("a b c d", null), ""));

        //Ad Hoc test will need a new TestCase for each scenario
        evaluateTestCase("TXXX", "Normal text", true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a b c d"),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));

        evaluateTestCase("TXXX", "Normal text, normal delim, returnDelims=true", true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d", ",", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ",", "c", ",", "d"))));

        evaluateTestCase("TXXX", "Normal text, normal delim, returnDelims=true",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b;c,d", ",;", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ";", "c", ",", "d")))
        );
    } // end main

    /**
     * Evaluate the test case and write results
     * @param <T>
     * @param name
     * @param description
     * @param expected
     * @param testCase 
     */
    private static <T> void evaluateTestCase(String name, String description, T expected, Callable<T> testCase) {
        BasicTokenizerTester.evaluateTestCase(name, description, false, expected, testCase);
    }

    /**
     * Evaluate the test case and write the results
     * @param <T>
     * @param name
     * @param description
     * @param expectedException
     * @param expected
     * @param testCase 
     */
    private static <T> void evaluateTestCase(String name, String description, Boolean expectedException, T expected, Callable<T> testCase) {
        T result = null;
        Boolean passed = false;
        String error = "";

        //execute the call
        try {
            result = testCase.call();
            if (expectedException) {
                error = " Expected exception. Error: none";
                passed = false;
            }
        } catch (Exception ex) {
            if (expectedException) {
                error = " Expected exception. Error: " + ex.toString();
                passed = true;
            } else {
                error = " Error: " + ex.toString();
                passed = false;
            }
        }

        //evaluate result if no exception expected
        if (passed == false) {
            if (expected == null && result == null) {
                passed = true;
            } else if (expected == null && result != null) {
                passed = false;
            } else {
                passed = (expected.equals(result));
            }
        }

        //report result
        if (useSubmissionFormat) {
            if (passed) {
                System.out.println("Test " + name + " passed. ");
            } else {
                System.out.println("Test " + name + " FAILED. ");
            }
        } else {
            if (passed) {
                System.out.println("Test " + name + " passed. " + description + error);
            } else {
                System.out.println("Test " + name + " FAILED. " + description + error);
            }

        }
    }

    private static Boolean useSubmissionFormat;

    /**
     * Test constructor
     *
     * @param str
     * @return
     */
    private static Boolean testConstructor(String str) {
        return BasicTokenizer.class.isInstance(new BasicTokenizer(str));
    }

    /**
     * Test constructor
     *
     * @param str
     * @param delim
     * @return
     */
    private static Boolean testConstructor(String str, String delim) {
        return BasicTokenizer.class.isInstance(new BasicTokenizer(str, delim));
    }

    /**
     * Test Constructor
     *
     * @param str
     * @param delim
     * @param returnDelims
     * @return
     */
    private static Boolean testConstructor(String str, String delim, Boolean returnDelims) {
        return BasicTokenizer.class.isInstance(new BasicTokenizer(str, delim, returnDelims));
    }

    /**
     * Does countTokens() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testCountTokens(BasicTokenizer basicTokenizer, int expected) {
        return expected == basicTokenizer.countTokens();
    }

    /**
     * Does hasMoreTokens() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testHasMoreTokens(BasicTokenizer basicTokenizer, Boolean expected) {
        return expected == basicTokenizer.hasMoreTokens();
    }

    /**
     * Does nextToken() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testNextToken(BasicTokenizer basicTokenizer, String expected) {
        return expected.equals(basicTokenizer.nextToken());
    }

    /**
     * Does nextToken(delim) == expected and not fail
     *
     * @param basicTokenizer
     * @param delim
     * @param expected
     * @return
     */
    private static Boolean testNextTokenDelim(BasicTokenizer basicTokenizer, String delim, String expected) {
        return expected.equals(basicTokenizer.nextToken(delim));
    }

    /**
     * Does hasMoreElements() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testHasMoreElements(BasicTokenizer basicTokenizer, Boolean expected) {
        return expected == basicTokenizer.hasMoreElements();
    }

    /**
     * Does nextToken() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testNextElement(BasicTokenizer basicTokenizer, String expected) {
        return expected.equals(basicTokenizer.nextElement());
    }

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
        return true;

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
        return true;
    }

} // end class BasicTokenizerTester
