import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    private static Parser parser;

    @org.junit.BeforeClass
    public static void setUpClass() {
        parser = new Parser();
    }

    @org.junit.Test
    public void parsingBinaryOperation() {
        String inputExpression = "2^2+(2+3)+2-1";
        Stack<String> expected = new Stack<>();
        expected.push("2");
        expected.push("2");
        expected.push("^");
        expected.push("2");
        expected.push("3");
        expected.push("+");
        expected.push("+");
        expected.push("2");
        expected.push("+");
        expected.push("1");
        expected.push("-");

        Stack<String> result = parser.parsing(inputExpression);

        assertEquals(expected, result);
    }

    @org.junit.Test
    public void parsingUnaryAndBinaryOperation() {
        String inputExpression = "2^2+sqrt4";
        Stack<String> expected = new Stack<>();
        expected.push("2");
        expected.push("2");
        expected.push("^");
        expected.push("4");
        expected.push("s");
        expected.push("+");

        Stack<String> result = parser.parsing(inputExpression);

        assertEquals(expected, result);

    }
}