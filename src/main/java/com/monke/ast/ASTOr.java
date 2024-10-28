package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.exceptions.TypeErrorException;
import src.main.java.com.monke.values.IValue;
import src.main.java.com.monke.values.VBool;

public class ASTOr implements ASTNode {
    ASTNode lhs, rhs;

    public ASTOr(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);
        if (v1 instanceof VBool && v2 instanceof VBool) {
            IValue value = new VBool(((VBool) v2).getValue() || ((VBool) v1).getValue());
            return value;
        }

        throw new TypeErrorException("Or");
    }

}
