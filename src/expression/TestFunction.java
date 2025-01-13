package expression;

public class TestFunction extends ASTNode {
    private final ASTNode test;

    public TestFunction(ASTNode test) {
        this.test = test;
    }

    public ASTNode getTest() {
        return test;
    }

    @Override
    public String prettyPrint() {
        return "TestFunction{" +
                "test=" + test +
                '}';
    }
}