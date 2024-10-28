package src.main.java.com.monke.ast;

import src.main.java.com.monke.Environment;
import src.main.java.com.monke.ast.ASTAssign;
import src.main.java.com.monke.values.IValue;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class ASTDef implements ASTNode {

    ASTNode body;
    Map<String, ASTNode> initVars; // initialized vars, with id and node (ex: x = ASTNum(1))

    public ASTDef(Map<String, ASTNode> initVars, ASTNode body) {
        this.initVars = initVars;
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value;
        Environment<IValue> env = e.beginScope();
        for (Map.Entry<String, ASTNode> entry : initVars.entrySet()) {
            env.assoc(entry.getKey(), entry.getValue().eval(env));
        }
        value = body.eval(env);
        env.endScope();
        return value;
    }

}
