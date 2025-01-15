import expression.ASTNode;
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
        String fileName = "src/test.lisp";
        MyParser parser = getParser(fileName);
        ParseTree programContext = parser.program();

        // Step 2: Parse and Build AST
        ASTBuilder visitor = new ASTBuilder();
        System.out.println("ASTBuilder Ready");
        ASTNode ast = visitor.visit(programContext);
        // Step 3: Print the AST
        System.out.println(ast.prettyPrint());
        if (visitor.semanticsErrors.isEmpty()) {
            System.out.println("No Semantic Errors");
        } else {
            for (String error : visitor.semanticsErrors) {
                System.out.println(error);
            }
        }
    }

    private static MyParser getParser(String filename) {
        MyParser parser = null;
        try {
            CharStream input = CharStreams.fromFileName(filename);
            MyLexer lexer = new MyLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new MyParser(tokens);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parser;
    }
}