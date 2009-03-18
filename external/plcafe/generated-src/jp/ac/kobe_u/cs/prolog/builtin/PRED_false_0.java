package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>false/0</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_false_0 extends Predicate {

    public PRED_false_0(Predicate cont) {
        this.cont = cont;
    }

    public PRED_false_0(){}

    public void setArgument(Term[] args, Predicate cont) {
        this.cont = cont;
    }

    public int arity() { return 0; }

    public String toString() {
        return "false";
    }

    public Predicate exec(Prolog engine) {
    // false:-fail
        engine.setB0();
    // false:-[fail]
        //START inline expansion of fail
        return engine.fail();
        //END inline expansion
    }
}