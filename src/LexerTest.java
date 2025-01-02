import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LexerTest {

    public static String readLispFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String input = readLispFile("src/test.lisp");
        if (input == null) {
            System.err.println("No input to process.");
            return;
        }

        try {
            MyLexer lexer = new MyLexer(CharStreams.fromString(input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            MyParser parser = new MyParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line,
                                        int charPositionInLine,
                                        String msg,
                                        RecognitionException e) {
                    System.err.println("Syntax error at line " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            ParseTree tree = parser.program();

            // Use TreePrinter to print the formatted parse tree
            System.out.println("Formatted Parse Tree:");
            TreePrinter.print(tree);

            // Walking through the tree with the custom listener
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new MyCustomListener(), tree);

        } catch (Exception e) {
            System.err.println("Error during parsing: " + e.getMessage());
        }
    }
}

class MyCustomListener extends MyParserBaseListener {
    @Override
    public void enterArithmetic_expression(MyParser.Arithmetic_expressionContext ctx) {
        System.out.println("Entering arithmetic expression: " + ctx.getText());
    }

    @Override
    public void exitArithmetic_expression(MyParser.Arithmetic_expressionContext ctx) {
        System.out.println("Exiting arithmetic expression: " + ctx.getText());
    }
}
