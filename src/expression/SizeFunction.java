
package expression;

public class SizeFunction extends ASTNode {
    private final RealNumberNode size;

    public SizeFunction(RealNumberNode size) {
        this.size = size;
    }

    public RealNumberNode getSize() {
        return size;
    }

    @Override
    public String prettyPrint() {
        return "SizeFunction{" +
                "size=" + size +
                '}';
    }
}
