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

        // <editor-fold defaultstate="collapsed" desc="Test Constructors BVT">
        //Test Constructors
        evaluateTestCaseException("T001", "Constructor 1 null text.",
                NullPointerException.class,
                () -> (new BasicTokenizer(null)) != null);

        evaluateTestCase("T002", "Constructor 1 empty text.",
                true,
                () -> (new BasicTokenizer("")) != null);

        evaluateTestCase("T003", "Constructor 1 one character string.",
                true,
                () -> (new BasicTokenizer("a")) != null);

        evaluateTestCase("T004", "Constructor 1 inside boundary string.",
                true,
                () -> (new BasicTokenizer("a b c d")) != null);
        


        evaluateTestCase("T005", "Constructor 2 inside boundary string, null delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", null)) != null);

        evaluateTestCase("T006", "Constructor 2 inside boundary string, empty string delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", "")) != null);

        evaluateTestCase("T007", "Constructor 2 inside boundary string, one character delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", "a")) != null);

        evaluateTestCase("T008", "Constructor 2 inside boundary string, inside boundary delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", " , \\t\\n\\r\\f")) != null);
        
        evaluateTestCaseException("T009", "Constructor 2 null string, inside boundary delimiter.",
                NullPointerException.class,
                () -> (new BasicTokenizer(null, " , \\t\\n\\r\\f")) != null);

        evaluateTestCase("T010", "Constructor 2 empty text, inside boundary delimiter.",
                true,
                () -> (new BasicTokenizer("", " , \\t\\n\\r\\f")) != null);

        evaluateTestCase("T011", "Constructor 2 one character string, inside boundary delimiter.",
                true,
                () -> (new BasicTokenizer("a", " , \\t\\n\\r\\f")) != null);
        

        evaluateTestCase("T012", "Constructor 3 inside boundary string, null delimiter, return delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", null, true)) != null);
        
        evaluateTestCase("T013", "Constructor 3 inside boundary string, empty string delimiter, return delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", "", true)) != null);
        
        evaluateTestCase("T014", "Constructor 3 inside boundary string, one character delimiter, return delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", "b", true)) != null);
        
        evaluateTestCase("T015", "Constructor 3 inside boundary string, inside boundary delimiter, return delimiter.",
                true,
                () -> (new BasicTokenizer("a b c d", " , \\t\\n\\r\\f", true)) != null);
        
        evaluateTestCaseException("T016", "Constructor 3 null string, inside boundary delimiter, return delimiter.",
                NullPointerException.class,
                () -> (new BasicTokenizer(null, " , \\t\\n\\r\\f")) != null);
        
        evaluateTestCase("T017", "Constructor 3 empty string, inside boundary delimiter, return delimiter.",
                true,
                () -> (new BasicTokenizer("", " , \\t\\n\\r\\f", true)) != null);
        
        evaluateTestCase("T018", "Constructor 3 one character string, inside boundary delimiter, return delimiter.",
                true,
                () -> (new BasicTokenizer("c", " , \\t\\n\\r\\f", true)) != null);
        
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test CountTokens">
        //Test CountTokens
        evaluateTestCase("T019", "countTokens R4.",
                0,
                () -> (new BasicTokenizer("")).countTokens());

        evaluateTestCase("T020", "countTokens count after T003.",
                1,
                () -> (new BasicTokenizer("a")).countTokens());

        evaluateTestCase("T021", "countTokens R7.",
                4,
                () -> (new BasicTokenizer("a b c d")).countTokens());

        evaluateTestCaseException("T022", "countTokens null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).countTokens());
        
        evaluateTestCase("T023", "countTokens .",
                0,
                () -> (new BasicTokenizer("", " , \\t\\n\\r\\f", true)).countTokens());
        
        evaluateTestCase("T024", "countTokens .",
                1,
                () -> (new BasicTokenizer("a", " , \\t\\n\\r\\f", true)).countTokens());
        
        evaluateTestCase("T025", "countTokens .",
                2,
                () -> (new BasicTokenizer("a ", " , \\t\\n\\r\\f", true)).countTokens());
        
        evaluateTestCase("T026", "countTokens .",
                2,
                () -> (new BasicTokenizer(" a", " , \\t\\n\\r\\f", true)).countTokens());
        
        evaluateTestCase("T027", "countTokens .",
                7,
                () -> (new BasicTokenizer("a b c d", " , \\t\\n\\r\\f", true)).countTokens());

        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Test CountTokens Equals NumberNextToken Calls Special Cases">
        
        //Test the number of times that this tokenizer's nextToken method can be called before it generates an exception Special Cases
        evaluateTestCase("T028", "countTokens == nextToken Calls, Default Constructor",
                true,
                () -> testCountTokensEqualsNumberNextTokenCalls(new BasicTokenizer("a b c d")));

        evaluateTestCase("T029", "countTokens == nextToken Calls, Constructor 2",
                true,
                () -> testCountTokensEqualsNumberNextTokenCalls(new BasicTokenizer("a b c d", " ")));

        evaluateTestCase("T030", "countTokens == nextToken Calls, Constructor 3, True",
                true,
                () -> testCountTokensEqualsNumberNextTokenCalls(new BasicTokenizer("a b c d", " ", true)));

        evaluateTestCase("T031", "countTokens == nextToken Calls, Constructor 3, False",
                true,
                () -> testCountTokensEqualsNumberNextTokenCalls(new BasicTokenizer("a b c d", " ", false)));
       
        // </editor-fold>


        // <editor-fold defaultstate="collapsed" desc="Test HasMoreTokens Decision Table">
        //Test HasMoreTokens
        evaluateTestCaseException("T040", "R2 hasMoreTokens empty string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("", null)).hasMoreElements());

        evaluateTestCase("T041", "R3 hasMoreTokens empty string, empty delim.",
                false,
                () -> (new BasicTokenizer("", "")).hasMoreElements());

        evaluateTestCase("T042", "R4 hasMoreTokens empty string, valid delim.",
                false,
                () -> (new BasicTokenizer("", ";")).hasMoreElements());

        evaluateTestCaseException("T043", "R5 hasMoreTokens non-delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("abcd", null)).hasMoreElements());

        evaluateTestCase("T044", "R6 hasMoreTokens non-delimited string, empty delim.",
                true,
                () -> (new BasicTokenizer("abcd", "")).hasMoreElements());

        evaluateTestCase("T045", "R7 hasMoreTokens non-delimited string, valid delim, delims are not tokens.",
                true,
                () -> (new BasicTokenizer("abcd", ";", false)).hasMoreElements());

        evaluateTestCase("T046", "R8 hasMoreTokens non-delimited string, valid delim, delims are tokens.",
                true,
                () -> (new BasicTokenizer("abcd", ";", true)).hasMoreElements());

        evaluateTestCaseException("T047", "R9 hasMoreTokens delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).hasMoreElements());

        evaluateTestCase("T048", "R10 hasMoreTokens delimited string, empty delim.",
                true,
                () -> (new BasicTokenizer("a b c d", " ")).hasMoreElements());

        evaluateTestCase("T049", "R11 hasMoreTokens delimited string, valid delim, delims are not tokens.",
                true,
                () -> (new BasicTokenizer("a b,c d", " ", false)).hasMoreElements());

        evaluateTestCase("T050", "R12 hasMoreTokens delimited string, valid delim, delims are tokens.",
                true,
                () -> (new BasicTokenizer("a b,c d", " ", true)).hasMoreElements());

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test HasMoreTokens BVT">
        evaluateTestCase("T051", "hasMoreTokens normal.",
                true,
                () -> (new BasicTokenizer("a b c d")).hasMoreTokens());

        evaluateTestCase("T052", "hasMoreTokens no delims in text.",
                true,
                () -> (new BasicTokenizer("abcd")).hasMoreTokens());

        evaluateTestCase("T053", "hasMoreTokens empty text.",
                false,
                () -> (new BasicTokenizer("")).hasMoreTokens());

        evaluateTestCaseException("T054", "hasMoreTokens null delim. Should fail.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).hasMoreTokens());
        
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test NextToken BVT">
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
        
        evaluateTestCaseException("T058", "nextToken empty text.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("")).nextToken());
        
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test NextToken Decision Table">
        //Test NextToken Decision Table
        evaluateTestCaseException("T059", "R2 nextToken empty string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("", null)).nextToken());

        evaluateTestCaseException("T060", "R3 nextToken empty string, empty delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("", "")).nextToken());

        evaluateTestCaseException("T061", "R4 nextToken empty string, valid delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("", ";")).nextToken());

        evaluateTestCaseException("T062", "R5 nextToken non-delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("abcd", null)).nextToken());

        evaluateTestCase("T063", "R6 nextToken non-delimited string, empty delim.",
                "abcd",
                () -> (new BasicTokenizer("abcd", "")).nextToken());

        evaluateTestCase("T064", "R7 nextToken non-delimited string, valid delim, delims are not tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", ";", false)).nextToken());

        evaluateTestCase("T065", "R8 nextToken non-delimited string, valid delim, delims are tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", ";", true)).nextToken());

        evaluateTestCaseException("T066", "R9 nextToken delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).nextToken());

        evaluateTestCase("T067", "R10 nextToken delimited string, empty delim.",
                "a b c d",
                () -> (new BasicTokenizer("a b c d", "")).nextToken());

        evaluateTestCase("T068", "R11 nextToken delimited string, valid delim, delims are not tokens.",
                "a",
                () -> (new BasicTokenizer("a b,c d", " ", false)).nextToken());

        evaluateTestCase("T069", "R12 nextToken delimited string, valid delim, delims are tokens.",
                "a",
                () -> (new BasicTokenizer("a b,c d", " ", true)).nextToken());

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test HasMoreElements BVT">
        //Test HasMoreElements BVT
        evaluateTestCase("T101", "hasMoreElements normal",
                true,
                () -> (new BasicTokenizer("a b c d")).hasMoreElements());

        evaluateTestCase("T102", "hasMoreElements delimiter not in text",
                true,
                () -> (new BasicTokenizer("abcd")).hasMoreElements());

        evaluateTestCaseException("T103", "hasMoreElements null delimiter.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).hasMoreElements());
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test NextElement BVT">
        //Test NextElement BVT
        evaluateTestCase("T105", "nextElement normal",
                "a",
                () -> (new BasicTokenizer("a b c d")).nextElement());

        evaluateTestCase("T106", "nextElement no delimiter",
                "abcd",
                () -> (new BasicTokenizer("abcd")).nextElement());

        evaluateTestCaseException("T107", "nextElement null delimiter",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).nextElement());

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test HasMoreElements HasMoreTokens Special Cases">
        //Test HasMoreElements Special Cases
        //Test HasMoreTokens Special Cases
        evaluateTestCase("T109", "hasMoreElements Vs hasMoreTokens, Default Constructor",
                true,
                () -> testHasMoreElementsVsHasMoreTokens(new BasicTokenizer("a b c d")));

        evaluateTestCase("T110", "hasMoreElements Vs hasMoreTokens, Constructor 2",
                true,
                () -> testHasMoreElementsVsHasMoreTokens(new BasicTokenizer("a b c d", " ")));

        evaluateTestCase("T111", "hasMoreElements Vs hasMoreTokens, Constructor 3, True",
                true,
                () -> testHasMoreElementsVsHasMoreTokens(new BasicTokenizer("a b c d", " ", true)));

        evaluateTestCase("T112", "hasMoreElements Vs hasMoreTokens, Constructor 3, False",
                true,
                () -> testHasMoreElementsVsHasMoreTokens(new BasicTokenizer("a b c d", " ", false)));

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test HasMoreElements Decision Table">
        //Test hasMoreElements Decision Table
        evaluateTestCaseException("T114", "R2 hasMoreElements empty string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("", null)).hasMoreElements());

        evaluateTestCase("T115", "R3 hasMoreElements empty string, empty delim.",
                false,
                () -> (new BasicTokenizer("", "")).hasMoreElements());

        evaluateTestCase("T116", "R4 hasMoreElements empty string, valid delim.",
                false,
                () -> (new BasicTokenizer("", ";")).hasMoreElements());

        evaluateTestCaseException("T117", "R5 hasMoreElements non-delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("abcd", null)).hasMoreElements());

        evaluateTestCase("T118", "R6 hasMoreElements non-delimited string, empty delim.",
                true,
                () -> (new BasicTokenizer("abcd", "")).hasMoreElements());

        evaluateTestCase("T119", "R7 hasMoreElements non-delimited string, valid delim, delims are not tokens.",
                true,
                () -> (new BasicTokenizer("abcd", ";", false)).hasMoreElements());

        evaluateTestCase("T120", "R8 hasMoreElements non-delimited string, valid delim, delims are tokens.",
                true,
                () -> (new BasicTokenizer("abcd", ";", true)).hasMoreElements());

        evaluateTestCaseException("T121", "R9 hasMoreElements delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).hasMoreElements());

        evaluateTestCase("T122", "R10 hasMoreElements delimited string, empty delim.",
                true,
                () -> (new BasicTokenizer("a b c d", " ")).hasMoreElements());

        evaluateTestCase("T123", "R11 hasMoreElements delimited string, valid delim, delims are not tokens.",
                true,
                () -> (new BasicTokenizer("a b,c d", " ", false)).hasMoreElements());

        evaluateTestCase("T124", "R12 hasMoreElements delimited string, valid delim, delims are tokens.",
                true,
                () -> (new BasicTokenizer("a b,c d", " ", true)).hasMoreElements());

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test NextElement Decision Table">
        //Test NextElement Decision Table
        evaluateTestCaseException("T125", "R2 nextElement empty string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("", null)).nextElement());

        evaluateTestCaseException("T126", "R3 nextElement empty string, empty delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("", "")).nextElement());

        evaluateTestCaseException("T127", "R4 nextElement empty string, valid delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("", ";")).nextElement());

        evaluateTestCaseException("T128", "R5 nextElement non-delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("abcd", null)).nextElement());

        evaluateTestCase("T129", "R6 nextElement non-delimited string, empty delim.",
                "abcd",
                () -> (new BasicTokenizer("abcd", "")).nextElement());

        evaluateTestCase("T130", "R7 nextElement non-delimited string, valid delim, delims are not tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", ";", false)).nextElement());

        evaluateTestCase("T131", "R8 nextElement non-delimited string, valid delim, delims are tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", ";", true)).nextElement());

        evaluateTestCaseException("T132", "R9 nextElement delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).nextElement());

        evaluateTestCase("T133", "R10 nextElement delimited string, empty delim.",
                "a b c d",
                () -> (new BasicTokenizer("a b c d", "")).nextElement());

        evaluateTestCase("T134", "R11 nextElement delimited string, valid delim, delims are not tokens.",
                "a",
                () -> (new BasicTokenizer("a b,c d", " ", false)).nextElement());

        evaluateTestCase("T135", "R12 nextElement delimited string, valid delim, delims are tokens.",
                "a",
                () -> (new BasicTokenizer("a b,c d", " ", true)).nextElement());

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test NextToken(delim) Decision Table">
        //Test NextToken(delim)        
        evaluateTestCaseException("T151", "R1 NextTokenDelim null string.",
                NullPointerException.class,
                () -> (new BasicTokenizer(null)).nextToken(","));
        
        evaluateTestCaseException("T152", "R2 NextTokenDelim empty string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("", null)).nextToken(null));

        evaluateTestCaseException("T153", "R3 NextTokenDelim empty string, empty delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("", "")).nextToken(""));

        evaluateTestCaseException("T154", "R4 NextTokenDelim empty string, valid delim.",
                NoSuchElementException.class,
                () -> (new BasicTokenizer("", ";")).nextToken(","));

        evaluateTestCaseException("T155", "R5 NextTokenDelim non-delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("abcd", null)).nextToken(null));

        evaluateTestCase("T156", "R6 NextTokenDelim non-delimited string, empty delim.",
                "abcd",
                () -> (new BasicTokenizer("abcd", "")).nextToken(""));

        evaluateTestCase("T157", "R7 NextTokenDelim non-delimited string, valid delim, delims are not tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", ";", false)).nextToken(","));

        evaluateTestCase("T158", "R8 NextTokenDelim non-delimited string, valid delim, delims are tokens.",
                "abcd",
                () -> (new BasicTokenizer("abcd", ";", true)).nextToken(","));

        evaluateTestCaseException("T159", "R9 NextTokenDelim delimited string, null delim.",
                NullPointerException.class,
                () -> (new BasicTokenizer("a b c d", null)).nextToken(null));

        evaluateTestCase("T160", "R10 NextTokenDelim delimited string, empty delim.",
                "a b c d",
                () -> (new BasicTokenizer("a b c d", " ")).nextToken(""));

        evaluateTestCase("T161", "R11 NextTokenDelim delimited string, valid delim, delims are not tokens.",
                "a b",
                () -> (new BasicTokenizer("a b,c d", " ", false)).nextToken(","));

        evaluateTestCase("T162", "R12 NextTokenDelim delimited string, valid delim, delims are tokens.",
                "a b",
                () -> (new BasicTokenizer("a b,c d", " ", true)).nextToken(","));

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Test Ad Hoc">
        //Ad Hoc test will need a new TestCase for each scenario
        evaluateTestCase("T200", "R11 Iterate tokens delimited text",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T201", "R11 Iterate tokens delimited text with empty token at end",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d,", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T202", "R11 Iterate tokens delimited text with consecutive delimiters",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        
        evaluateTestCase("T203", "R12 Iterate tokens delimited text with delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b,c,d", ",", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ",", "c", ",", "d"))));
        
                
        evaluateTestCase("T204", "R12 Iterate tokens delimited text with multiple characters and delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testTokenIteration(
                        new BasicTokenizer("a,b;c,d", ",;", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ";", "c", ",", "d"))));
        
        
        
        evaluateTestCase("T205", "R11 Iterate elements delimited text",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T206", "R11 Iterate elements delimited text with empty token at end",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,c,d,", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        evaluateTestCase("T207", "R11 Iterate elements delimited text with consecutive delimiters",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,,c,d", ","),
                        new ArrayList<>(Arrays.asList("a", "b", "c", "d"))));
        
        
        evaluateTestCase("T208", "R12 Iterate elements delimited text with delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b,c,d", ",", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ",", "c", ",", "d"))));
        
                
        evaluateTestCase("T209", "R12 Iterate elements delimited text with multiple characters and delimiters as tokens",
                true,
                () -> BasicTokenizerTester.testElementIteration(
                        new BasicTokenizer("a,b;c,d", ",;", true),
                        new ArrayList<>(Arrays.asList("a", ",", "b", ";", "c", ",", "d"))));
        
        // </editor-fold>

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

            if (basicTokenizer.hasMoreTokens() != basicTokenizer.hasMoreElements()) {
                return false;
            }
            
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

            if (basicTokenizer.hasMoreTokens() != basicTokenizer.hasMoreElements()) {
                return false;
            }

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
    
    /**
     * Tests that hasMoreElements returns the same value as hasMoreTokens
     * @param basicTokenizer
     * @return 
     */
    private static Boolean testHasMoreElementsVsHasMoreTokens(BasicTokenizer basicTokenizer){
        return basicTokenizer.hasMoreElements() == basicTokenizer.hasMoreTokens();
    }

    /**
     * Tests the number of times that this tokenizer's nextToken method can be called before it generates an exception
     * @param basicTokenizer
     * @return 
     */
    private static Boolean testCountTokensEqualsNumberNextTokenCalls(BasicTokenizer basicTokenizer){
        int tokenCount = basicTokenizer.countTokens();
        Boolean throwsExpectedException;
        
        for (int i = 0; i < tokenCount; i++){
            basicTokenizer.nextToken();
        }
        
        try {
            basicTokenizer.nextToken();
            throwsExpectedException = false;
        }
        catch (Exception Ex){
            throwsExpectedException = true;
        }
        return throwsExpectedException;
    }

} // end class BasicTokenizerTester
