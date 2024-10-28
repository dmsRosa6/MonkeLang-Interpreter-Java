package com.monke.parser;
/* Parser.java */
/* Generated By:JavaCC: Do not edit this line. Parser.java */
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import com.monke.values.*;
import com.monke.ast.*;

public class Parser implements ParserConstants {
    public Parser(){}

  static final public ASTNode Start() throws ParseException {ASTNode t;
    t = S();
    jj_consume_token(FINAL);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode S() throws ParseException {Token op;
     ASTNode t1, t2;
    t1 = SE();
    label_1:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_1;
      }
      jj_consume_token(SEMCOL);
      t2 = SE();
t1 = new ASTSemCol(t1, t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode SE() throws ParseException {Token op;
      ASTNode t1, t2;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LET:{
      jj_consume_token(LET);
      id = jj_consume_token(Id);
      jj_consume_token(ASSIGN);
      expr = BA();
{if ("" != null) return new ASTLet(id.image, expr);}
      break;
      }
    case FUN:
    case WHILE:
    case IF:
    case BOOLEAN:
    case NEW:
    case REF:
    case PRINTLN:
    case Id:
    case Num:
    case NOT:
    case MINUS:
    case LPAR:
    case LBRA:
    case STRING:{
      t1 = BA();
      label_2:
      while (true) {
        if (jj_2_2(2)) {
          ;
        } else {
          break label_2;
        }
        jj_consume_token(ASSIGN);
        t2 = BA();
t1 = new ASTAssign(t1, t2);
      }
{if ("" != null) return t1;}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  static final public ASTNode BA() throws ParseException {Token op;
    ASTNode t1, t2;
    t1 = BM();
    label_3:
    while (true) {
      if (jj_2_3(2)) {
        ;
      } else {
        break label_3;
      }
      op = jj_consume_token(OR);
      t2 = BM();
t1 = new ASTOr(t1,t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode BM() throws ParseException {Token op;
    ASTNode t1, t2;
    t1 = Relop();
    label_4:
    while (true) {
      if (jj_2_4(2)) {
        ;
      } else {
        break label_4;
      }
      op = jj_consume_token(AND);
      t2 = Relop();
t1 = new ASTAnd(t1,t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Relop() throws ParseException {Token op;
    ASTNode t1, t2;
    t1 = Exp();
    if (jj_2_5(2)) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case GREATER:{
        op = jj_consume_token(GREATER);
        break;
        }
      case LOWER:{
        op = jj_consume_token(LOWER);
        break;
        }
      case LOWEROREQUAL:{
        op = jj_consume_token(LOWEROREQUAL);
        break;
        }
      case GREATEROREQUAL:{
        op = jj_consume_token(GREATEROREQUAL);
        break;
        }
      case LOGICALEQUAL:{
        op = jj_consume_token(LOGICALEQUAL);
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Exp();
switch (op.kind){
                    case GREATER:
                        t1 = new ASTGreater(t1,t2);
                    break;
                    case LOWER:
                        t1 = new ASTLower(t1,t2);
                    break;
                    case LOWEROREQUAL:
                        t1 = new ASTLowerOrEqual(t1,t2);
                    break;
                    case GREATEROREQUAL:
                        t1 = new ASTGreaterOrEqual(t1,t2);
                    break;
                     case LOGICALEQUAL:
                        t1 = new ASTLogicalEqual(t1,t2);
                    break;
                    default:
                        }
    } else {
      ;
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Exp() throws ParseException {Token op;
  ASTNode t1, t2;
    t1 = Term();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case INC:
      case MINUS:
      case DEC:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INC:
      case DEC:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case INC:{
          op = jj_consume_token(INC);
          break;
          }
        case DEC:{
          op = jj_consume_token(DEC);
          break;
          }
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
if (op.kind == INC){
               t1 = new ASTIncrement(t1);
           }else
               t1 = new ASTDecrement(t1);
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        if (jj_2_6(2)) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case PLUS:{
            op = jj_consume_token(PLUS);
            break;
            }
          case MINUS:{
            op = jj_consume_token(MINUS);
            break;
            }
          default:
            jj_la1[4] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          t2 = Term();
if (op.kind == PLUS)
               t1 = new ASTPlus(t1, t2);
           else
               t1 = new ASTSub(t1, t2);
        } else {
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Term() throws ParseException {Token op;
  ASTNode t1, t2;
    t1 = Fact();
    label_6:
    while (true) {
      if (jj_2_7(2)) {
        ;
      } else {
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:{
        op = jj_consume_token(TIMES);
        break;
        }
      case DIV:{
        op = jj_consume_token(DIV);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Term();
if (op.kind == TIMES)
                                t1 = new ASTTimes(t1,t2);
                else
                        t1 = new ASTDiv(t1,t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Fact() throws ParseException {Token n,n2;
  ASTNode t, t1,t2;
  Map<String, ASTNode> l = new HashMap<String, ASTNode>();
  List<String> params = new ArrayList();
  List<ASTNode> values = new ArrayList();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Num:{
      n = jj_consume_token(Num);
t = new ASTNum(Integer.parseInt(n.image));
      break;
      }
    case LPAR:{
      jj_consume_token(LPAR);
      t = S();
      jj_consume_token(RPAR);
      break;
      }
    case BOOLEAN:{
      n = jj_consume_token(BOOLEAN);
t = new ASTBoolean(Boolean.parseBoolean(n.image));
      break;
      }
    case PRINTLN:{
      jj_consume_token(PRINTLN);
      jj_consume_token(LPAR);
      t1 = S();
      jj_consume_token(RPAR);
t = new ASTPrintln(t1);
      break;
      }
    case FUN:{
      jj_consume_token(FUN);
params.clear();
      n = jj_consume_token(Id);
      jj_consume_token(LPAR);
      if (jj_2_8(2)) {
        n2 = jj_consume_token(Id);
params.add(n2.image);
      } else {
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case Id:{
        n2 = jj_consume_token(Id);
params.add(n2.image);
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        ;
      }
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMMA:{
          ;
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          break label_7;
        }
        jj_consume_token(COMMA);
        n2 = jj_consume_token(Id);
params.add(n2.image);
      }
      jj_consume_token(RPAR);
      t1 = Fact();
t=new ASTFunctionEnv(n.image,new VFun(t1,params,n.image));
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      if (jj_2_9(2)) {
        n = jj_consume_token(Id);
        jj_consume_token(LPAR);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FUN:
        case WHILE:
        case IF:
        case BOOLEAN:
        case LET:
        case NEW:
        case REF:
        case PRINTLN:
        case Id:
        case Num:
        case NOT:
        case MINUS:
        case LPAR:
        case LBRA:
        case STRING:{
          t1 = SE();
values.clear();values.add(t1);
          break;
          }
        default:
          jj_la1[9] = jj_gen;
          ;
        }
        label_8:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case COMMA:{
            ;
            break;
            }
          default:
            jj_la1[10] = jj_gen;
            break label_8;
          }
          jj_consume_token(COMMA);
          t1 = SE();
values.add(t1);
        }
        jj_consume_token(RPAR);
t = new ASTFunction(values,n.image);
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case Id:{
          n = jj_consume_token(Id);
t = new ASTId(n.image);
          break;
          }
        case STRING:{
          n = jj_consume_token(STRING);
t = new ASTString(n.image.replaceAll("\\p{P}",""));
          break;
          }
        case NEW:{
          jj_consume_token(NEW);
          t1 = Fact();
t = new ASTNew(t1);
          break;
          }
        case REF:{
          jj_consume_token(REF);
          t1 = Fact();
t = new ASTDeref(t1);
          break;
          }
        case IF:{
          jj_consume_token(IF);
          t = SE();
          jj_consume_token(LBRA);
          t1 = S();
          jj_consume_token(RBRA);
          jj_consume_token(LBRA);
          t2 = S();
          jj_consume_token(RBRA);
t = new ASTIf(t,t1,t2);
          break;
          }
        case WHILE:{
          jj_consume_token(WHILE);
          t1 = SE();
          jj_consume_token(LBRA);
          t2 = S();
          jj_consume_token(RBRA);
t = new ASTWhile(t1, t2);
          break;
          }
        case LBRA:{
          jj_consume_token(LBRA);
          label_9:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case LET:{
              ;
              break;
              }
            default:
              jj_la1[11] = jj_gen;
              break label_9;
            }
            jj_consume_token(LET);
            n = jj_consume_token(Id);
            jj_consume_token(EQUAL);
            t1 = BA();
l.put(n.image, t1);
            jj_consume_token(SEMCOL);
          }
          t2 = S();
          jj_consume_token(RBRA);
t = new ASTDef(l, t2);
          break;
          }
        case MINUS:{
          jj_consume_token(MINUS);
          t1 = Fact();
t = new ASTNeg(t1);
          break;
          }
        case NOT:{
          jj_consume_token(NOT);
          t1 = Fact();
t = new ASTNot(t1);
          break;
          }
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
}

  static private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_2()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_3()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_4()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_5()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_6()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_2_7(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_7()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  static private boolean jj_2_8(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_8()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  static private boolean jj_2_9(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_9()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  static private boolean jj_3R_Fact_228_6_23()
 {
    if (jj_scan_token(FUN)) return true;
    return false;
  }

  static private boolean jj_3R_Exp_183_4_14()
 {
    if (jj_3R_Term_206_4_15()) return true;
    return false;
  }

  static private boolean jj_3R_Fact_227_6_22()
 {
    if (jj_scan_token(PRINTLN)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_226_6_21()
 {
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_225_6_20()
 {
    if (jj_scan_token(LPAR)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_224_6_19()
 {
    if (jj_scan_token(Num)) return true;
    return false;
  }

  static private boolean jj_3_2()
 {
    if (jj_scan_token(ASSIGN)) return true;
    if (jj_3R_BA_132_1_11()) return true;
    return false;
  }

  static private boolean jj_3R_Fact_224_4_18()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_Fact_224_6_19()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_225_6_20()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_226_6_21()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_227_6_22()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_228_6_23()) {
    jj_scanpos = xsp;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_230_6_24()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_231_6_25()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_232_6_26()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_233_6_27()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_234_6_28()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_235_6_29()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_236_6_30()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_237_6_31()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_238_6_32()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_BA_132_1_11()
 {
    if (jj_3R_BM_144_1_12()) return true;
    return false;
  }

  static private boolean jj_3_8()
 {
    if (jj_scan_token(Id)) return true;
    return false;
  }

  static private boolean jj_3R_SE_120_4_17()
 {
    if (jj_3R_BA_132_1_11()) return true;
    return false;
  }

  static private boolean jj_3_7()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(29)) {
    jj_scanpos = xsp;
    if (jj_scan_token(30)) return true;
    }
    if (jj_3R_Term_206_4_15()) return true;
    return false;
  }

  static private boolean jj_3_1()
 {
    if (jj_scan_token(SEMCOL)) return true;
    if (jj_3R_SE_117_4_10()) return true;
    return false;
  }

  static private boolean jj_3R_SE_117_4_10()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_SE_117_4_16()) {
    jj_scanpos = xsp;
    if (jj_3R_SE_120_4_17()) return true;
    }
    return false;
  }

  static private boolean jj_3R_SE_117_4_16()
 {
    if (jj_scan_token(LET)) return true;
    return false;
  }

  static private boolean jj_3_5()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(23)) {
    jj_scanpos = xsp;
    if (jj_scan_token(18)) {
    jj_scanpos = xsp;
    if (jj_scan_token(19)) {
    jj_scanpos = xsp;
    if (jj_scan_token(24)) {
    jj_scanpos = xsp;
    if (jj_scan_token(17)) return true;
    }
    }
    }
    }
    if (jj_3R_Exp_183_4_14()) return true;
    return false;
  }

  static private boolean jj_3R_Term_206_4_15()
 {
    if (jj_3R_Fact_224_4_18()) return true;
    return false;
  }

  static private boolean jj_3_4()
 {
    if (jj_scan_token(AND)) return true;
    if (jj_3R_Relop_156_1_13()) return true;
    return false;
  }

  static private boolean jj_3R_Relop_156_1_13()
 {
    if (jj_3R_Exp_183_4_14()) return true;
    return false;
  }

  static private boolean jj_3_6()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(25)) {
    jj_scanpos = xsp;
    if (jj_scan_token(27)) return true;
    }
    if (jj_3R_Term_206_4_15()) return true;
    return false;
  }

  static private boolean jj_3R_Fact_238_6_32()
 {
    if (jj_scan_token(NOT)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_237_6_31()
 {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_236_6_30()
 {
    if (jj_scan_token(LBRA)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_235_6_29()
 {
    if (jj_scan_token(WHILE)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_234_6_28()
 {
    if (jj_scan_token(IF)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_233_6_27()
 {
    if (jj_scan_token(REF)) return true;
    return false;
  }

  static private boolean jj_3R_BM_144_1_12()
 {
    if (jj_3R_Relop_156_1_13()) return true;
    return false;
  }

  static private boolean jj_3R_Fact_232_6_26()
 {
    if (jj_scan_token(NEW)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_231_6_25()
 {
    if (jj_scan_token(STRING)) return true;
    return false;
  }

  static private boolean jj_3_3()
 {
    if (jj_scan_token(OR)) return true;
    if (jj_3R_BM_144_1_12()) return true;
    return false;
  }

  static private boolean jj_3R_Fact_230_6_24()
 {
    if (jj_scan_token(Id)) return true;
    return false;
  }

  static private boolean jj_3_9()
 {
    if (jj_scan_token(Id)) return true;
    if (jj_scan_token(LPAR)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[14];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x8841efa0,0x18e0000,0x1e000000,0x14000000,0xa000000,0x14000000,0x60000000,0x8000,0x40,0x8841efa0,0x40,0x400,0x80014220,0x840a980,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x42,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x42,0x0,0x0,0x0,0x42,};
	}
  static final private JJCalls[] jj_2_rtns = new JJCalls[9];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 14; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error {
    @Override
    public Throwable fillInStackTrace() {
      return this;
    }
  }
  static private final LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[39];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 14; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 39; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 9; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			   case 1: jj_3_2(); break;
			   case 2: jj_3_3(); break;
			   case 3: jj_3_4(); break;
			   case 4: jj_3_5(); break;
			   case 5: jj_3_6(); break;
			   case 6: jj_3_7(); break;
			   case 7: jj_3_8(); break;
			   case 8: jj_3_9(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}
