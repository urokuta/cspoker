package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$sort'/4</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$sort_4 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("[]");
    static Predicate _fail_0 = new PRED_fail_0();
    static Predicate _$sort_4_var = new PRED_$sort_4_var();
    static Predicate _$sort_4_var_1 = new PRED_$sort_4_var_1();
    static Predicate _$sort_4_var_2 = new PRED_$sort_4_var_2();
    static Predicate _$sort_4_lis = new PRED_$sort_4_lis();
    static Predicate _$sort_4_lis_1 = new PRED_$sort_4_lis_1();
    static Predicate _$sort_4_1 = new PRED_$sort_4_1();
    static Predicate _$sort_4_2 = new PRED_$sort_4_2();
    static Predicate _$sort_4_3 = new PRED_$sort_4_3();

    public Term arg1, arg2, arg3, arg4;

    public PRED_$sort_4(Term a1, Term a2, Term a3, Term a4, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        this.cont = cont;
    }

    public PRED_$sort_4(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        this.cont = cont;
    }

    public int arity() { return 4; }

    public String toString() {
        return "$sort(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$sort_4_var, _fail_0, _fail_0, _$sort_4_1, _fail_0, _$sort_4_lis);
    }
}

class PRED_$sort_4_var extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$sort_4_1, _$sort_4_var_1);
    }
}

class PRED_$sort_4_var_1 extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$sort_4_2, _$sort_4_var_2);
    }
}

class PRED_$sort_4_var_2 extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$sort_4_3);
    }
}

class PRED_$sort_4_lis extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$sort_4_2, _$sort_4_lis_1);
    }
}

class PRED_$sort_4_lis_1 extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$sort_4_3);
    }
}

class PRED_$sort_4_1 extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
    // '$sort'([],[],A,B):-true
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // '$sort'([],[],A,B):-[]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s1))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isSymbol()){
            if (! a2.equals(s1))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}

class PRED_$sort_4_2 extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
    // '$sort'([A],[A],B,C):-true
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // '$sort'([A],[A],B,C):-[]
        a1 = a1.dereference();
        if (a1.isList()){
            Term[] args = {((ListTerm)a1).car(), ((ListTerm)a1).cdr()};
            a5 = args[0];
            if (! s1.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a1.isVariable()){
            a5 = new VariableTerm(engine);
            ((VariableTerm) a1).bind(new ListTerm(a5, s1), engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isList()){
            Term[] args = {((ListTerm)a2).car(), ((ListTerm)a2).cdr()};
            if (! a5.unify(args[0], engine.trail))
                return engine.fail();
            if (! s1.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(new ListTerm(a5, s1), engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}

class PRED_$sort_4_3 extends PRED_$sort_4 {
    public Predicate exec(Prolog engine) {
    // '$sort'([A,B|C],D,E,F):-'$halve'(C,[B|C],G,H),'$sort'([A|G],I,E,F),'$sort'(H,J,E,F),'$merge'(I,J,D,E,F)
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14;
        Predicate p1, p2, p3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // '$sort'([A,B|C],D,E,F):-['$halve'(C,[B|C],G,H),'$sort'([A|G],I,E,F),'$sort'(H,J,E,F),'$merge'(I,J,D,E,F)]
        a1 = a1.dereference();
        if (a1.isList()){
            Term[] args = {((ListTerm)a1).car(), ((ListTerm)a1).cdr()};
            a5 = args[0];
            a6 = args[1];
        } else if (a1.isVariable()){
            a5 = new VariableTerm(engine);
            a6 = new VariableTerm(engine);
            ((VariableTerm) a1).bind(new ListTerm(a5, a6), engine.trail);
        } else {
            return engine.fail();
        }
        a6 = a6.dereference();
        if (a6.isList()){
            Term[] args = {((ListTerm)a6).car(), ((ListTerm)a6).cdr()};
            a7 = args[0];
            a8 = args[1];
        } else if (a6.isVariable()){
            a7 = new VariableTerm(engine);
            a8 = new VariableTerm(engine);
            ((VariableTerm) a6).bind(new ListTerm(a7, a8), engine.trail);
        } else {
            return engine.fail();
        }
        a9 = new ListTerm(a7, a8);
        a10 = new VariableTerm(engine);
        a11 = new VariableTerm(engine);
        a12 = new ListTerm(a5, a10);
        a13 = new VariableTerm(engine);
        a14 = new VariableTerm(engine);
        p1 = new PRED_$merge_5(a13, a14, a2, a3, a4, cont);
        p2 = new PRED_$sort_4(a11, a14, a3, a4, p1);
        p3 = new PRED_$sort_4(a12, a13, a3, a4, p2);
        return new PRED_$halve_4(a8, a9, a10, a11, p3);
    }
}