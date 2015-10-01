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
        //Test Constructors        
        writeTestResult("T001", "Constructor 1 valid text.", true, 
                testConstructor("a b c d"));
        
        writeTestResult("T002", "Constructor 1 empty text.", true, 
                testConstructor(""));
        
        writeTestResult("T003", "Constructor 1 null text. Should fail.", false, 
                testConstructor(null));
        
        writeTestResult("T004", "Constructor 2 valid text and valid delim.", true, 
                testConstructor("a b c d", " "));
        
        writeTestResult("T005", "Constructor 2 valid text and empty delim.", true, 
                testConstructor("a b c d", ""));
        
        writeTestResult("T006", "Constructor 2 valid text and null delim.", true, 
                testConstructor("a b c d", null));
        
        writeTestResult("T007", "Constructor 2 valid text and valid delim and true.", true, 
                testConstructor("a b c d", " ", true));
        
        writeTestResult("T008", "Constructor 2 valid text and valid delim and false.", true, 
                testConstructor("a b c d", " ", false));
        
        writeTestResult("T009", "Constructor 2 valid text and non-unique delim.", true, 
                testConstructor("a b c d", "   ,,,,,,"));
        

        //Test CountTokens        
        writeTestResult("TXXX", "countTokens normal.", true, 
                testCountTokens(new BasicTokenizer("a b c d"), 4));
        
        writeTestResult("TXXX", "countTokens no delims in text.", true, 
                testCountTokens(new BasicTokenizer("abcd"), 1));
        
        writeTestResult("TXXX", "countTokens empty delims.", true, 
                testCountTokens(new BasicTokenizer("a b c d", ""), 1));
        
        writeTestResult("TXXX", "countTokens null delim. Should fail.", false, 
                testCountTokens(new BasicTokenizer("a b c d", null), 0));
        
        writeTestResult("TXXX", "countTokens empty text.", true, 
                testCountTokens(new BasicTokenizer(""), 0));
        //etc....

        //Test HasMoreTokens
        writeTestResult("TXXX", "hasMoreTokens normal.", true, 
                testHasMoreTokens(new BasicTokenizer("a b c d"), true));
        
        writeTestResult("TXXX", "hasMoreTokens no delims in text.", true, 
                testHasMoreTokens(new BasicTokenizer("abcd"), true));
        
        writeTestResult("TXXX", "hasMoreTokens empty text.", true, 
                testHasMoreTokens(new BasicTokenizer(""), true));
        
        writeTestResult("TXXX", "hasMoreTokens null delim. Should fail.", false, 
                testHasMoreTokens(new BasicTokenizer("a b c d", null), true));

        //Test NextToken
        //testCases.add(new TestNextToken("T055 -- nextToken normal.", new BasicTokenizer("a b c d"), "a b c d"));
        //testCases.add(new TestNextToken("T056 -- nextToken no delimiter.", new BasicTokenizer("abcd"), "abcd"));
        //errCases.add(new TestNextToken("T057 -- nextToken  null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), null));
        //Test NextToken(delim)
        //testCases.add(new TestNextTokenDelim("T059 -- nextTokenDelim normal with space as a delimiter.", new BasicTokenizer("a b c d"), "a b c d", " "));
        //testCases.add(new TestNextTokenDelim("T060 -- nextTokenDelim no delimiter.", new BasicTokenizer("abcd"), "abcd", ""));
        //errCases.add(new TestNextTokenDelim("T061 -- nextTokenDelim  null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), "a b c d", null));
        
        //Test NextToken(delim)
        writeTestResult("T151", "NextTokenDelim normal", true, 
                testNextTokenDelim(new BasicTokenizer("a b,c d", " "), ",", "a b"));
        
        writeTestResult("T151", "NextTokenDelim null delim", false, 
                testNextTokenDelim(new BasicTokenizer("a b,c d", " "), null, ""));
        
        writeTestResult("T151", "NextTokenDelim empty delim", true, 
                testNextTokenDelim(new BasicTokenizer("a b,c d", " "), "", "a b,c d"));
        
        writeTestResult("T151", "NextTokenDelim text does not contain delimiter", true, 
                testNextTokenDelim(new BasicTokenizer("a b,c d", " "), ";", "a b,c d"));
        
        writeTestResult("T151", "NextTokenDelim empty text", true, 
                testNextTokenDelim(new BasicTokenizer("", ""), "", ""));

//        //Test HasMoreElements
//        testCases.add(new TestHasMoreElements("T101 -- hasMoreTokens normal.", new BasicTokenizer("a b c d"), true));
//        testCases.add(new TestHasMoreElements("T102 -- hasMoreTokens delimiter changed.", new BasicTokenizer("abcd"),  true));
//        errCases.add(new TestHasMoreElements("T103 -- hasMoreTokens null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), true));
//                
//        //Test NextElement
//        testCases.add(new TestNextElement("T105 -- nextToken normal.", new BasicTokenizer("a b c d"), "a b c d"));
//        testCases.add(new TestNextElement("T106 -- nextToken no delimiter.", new BasicTokenizer("abcd"), "abcd"));
//        errCases.add(new TestNextElement("T107 -- nextToken  null delimiter. Throws exception.", new BasicTokenizer("a b c d", null), null));
        
        //Ad Hoc test will need a new TestCase for each scenario
        writeTestResult("TXXX", "Normal text", true,
                BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a b c d"),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        writeTestResult("TXXX", "Normal text, normal delim, returnDelims=true", true,
                BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d", ",", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ",", "c", ",", "d"))));
        
        writeTestResult("TXXX", "Normal text, normal delim, returnDelims=true", true,
                BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b;c,d", ",;", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ";", "c", ",", "d"))));


    } // end main

    /**
     * Write test result
     *
     * @param name
     * @param expected
     * @param actual
     */
    private static void writeTestResult(String name, String description, Boolean expected, Boolean actual) {
        //todo remove the PASSED FAILED prefix before turnin
        if (expected == actual) {
            System.out.println("Test " + name + " passed. " + description);
        } else {
            System.out.println("Test " + name + " FAILED. " + description);
        }
    }

    /**
     * Test constructor
     *
     * @param str
     * @return
     */
    private static Boolean testConstructor(String str) {
        try {
            return BasicTokenizer.class.isInstance(new BasicTokenizer(str));
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Test constructor
     *
     * @param str
     * @param delim
     * @return
     */
    private static Boolean testConstructor(String str, String delim) {
        try {
            return BasicTokenizer.class.isInstance(new BasicTokenizer(str, delim));
        } catch (Exception ex) {
            return false;
        }
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
        try {
            return BasicTokenizer.class.isInstance(new BasicTokenizer(str, delim, returnDelims));
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Does countTokens() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testCountTokens(BasicTokenizer basicTokenizer, int expected) {
        try {
            return expected == basicTokenizer.countTokens();
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Does hasMoreTokens() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testHasMoreTokens(BasicTokenizer basicTokenizer, Boolean expected) {
        try {
            return expected == basicTokenizer.hasMoreTokens();
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Does nextToken() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testNextToken(BasicTokenizer basicTokenizer, String expected) {
        try {
            return expected.equals(basicTokenizer.nextToken());
        } catch (Exception ex) {
            return false;
        }
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
        try {
            return expected.equals(basicTokenizer.nextToken(delim));
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Does hasMoreElements() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testHasMoreElements(BasicTokenizer basicTokenizer, Boolean expected) {
        try {
            return expected == basicTokenizer.hasMoreElements();
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Does nextToken() == expected and not fail
     *
     * @param basicTokenizer
     * @param expected
     * @return
     */
    private static Boolean testNextElement(BasicTokenizer basicTokenizer, String expected) {
        try {
            return expected.equals(basicTokenizer.nextElement());
        } catch (Exception ex) {
            return false;
        }
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
        try {

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
        } catch (Exception ex) {
            return false;
        }
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
        try {

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
        } catch (Exception ex) {
            return false;
        }
    }


} // end class BasicTokenizerTester
