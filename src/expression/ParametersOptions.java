package expression;

public class ParametersOptions  extends ASTNode {
    private final String name;
    private final InitArgNode initArg;
    private final InitFormNode initForm;
    private final AccessorNode accessor;

    public ParametersOptions(String name, InitArgNode initArg, InitFormNode initForm, AccessorNode accessor) {
        this.name = name;
        this.initArg = initArg;
        this.initForm = initForm;
        this.accessor = accessor;
    }

    public String getName() {
        return name;
    }

    public InitArgNode getInitArg() {
        return initArg;
    }

    public InitFormNode getInitForm() {
        return initForm;
    }

    public AccessorNode getAccessor() {
        return accessor;
    }

    @Override
    public String prettyPrint() {
        return "ParametersOptions{" +
                "name='" + name + '\'' +
                ", initArg=" + initArg +
                ", initForm=" + initForm +
                ", accessor=" + accessor +
                '}';
    }
}
