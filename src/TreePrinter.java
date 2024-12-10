import org.antlr.v4.runtime.tree.ParseTree;

public class TreePrinter {

    // Method to print the tree with indentation
    public static void printTree(ParseTree tree, String indent) {
        if (tree == null) {
            return;
        }

        // Print the current node's text
        System.out.println(indent + tree.getText());

        // Print the children with increased indentation
        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(tree.getChild(i), indent + "  ");
        }
    }

    public static void print(ParseTree tree) {
        printTree(tree, "");
    }
}
