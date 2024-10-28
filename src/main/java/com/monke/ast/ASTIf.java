package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VBool;

public class ASTIf implements ASTNode {
    ASTNode condition, body1, body2;

    public ASTIf(ASTNode condition, ASTNode body1, ASTNode body2) {
        this.condition = condition;
        this.body1 = body1;
        this.body2 = body2;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value1 = condition.eval(e);

        if (value1 instanceof VBool) {
            if (((VBool) value1).getValue()) {
                return body1.eval(e);
            } else
                return body2.eval(e);
        }

        throw new TypeErrorException("Condition is not a boolean");
    }

}
