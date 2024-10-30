package com.monke.ast;

import com.monke.Environment;
import com.monke.exceptions.TypeErrorException;
import com.monke.values.IValue;
import com.monke.values.VFloat;
import com.monke.values.VInt;

public class ASTSub implements ASTNode {
    ASTNode lhs, rhs;
    
    public ASTSub(ASTNode l, ASTNode r) {
        lhs = l;
        rhs = r;
    }
    
    @Override
    public IValue eval(Environment<IValue> e) {
        IValue v1 = lhs.eval(e);
        IValue v2 = rhs.eval(e);

        if (v1 instanceof VInt && v2 instanceof VInt) {
            IValue value = new VInt(((VInt) v1).getValue() - ((VInt) v2).getValue());
            return value;
        }

        if (v1 instanceof VFloat && v2 instanceof VFloat) {
            IValue value = new VInt(((VInt) v1).getValue() - ((VInt) v2).getValue());
            return value;
        }

        if (v1 instanceof VFloat && v2 instanceof VInt) {
            IValue value = new VFloat(((VFloat) v1).getValue() - ((VInt) v2).getValue());
            return value;
        }

        if (v1 instanceof VInt && v2 instanceof VFloat) {
            IValue value = new VFloat(((VInt) v1).getValue() - ((VFloat) v2).getValue());
            return value;
        }

        throw new TypeErrorException("Subtraction");
    }

}
