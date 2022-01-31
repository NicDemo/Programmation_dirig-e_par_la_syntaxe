package TP2.ASD;

import TP2.Llvm;
import TP2.SymbolTable;
import TP2.Utils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class IF extends Instruction{
    Expression cond ;
   Instruction instruction ;
    Instruction instruction2;
    public IF (Expression cond,Instruction instruction , Instruction instruction2){
        this.cond=cond;
        this.instruction = instruction;
        this.instruction2=instruction2;
    }
    @Override
    public String pp() {
        String rez ="";
        rez+= Utils.indent(0)+"IF("+this.cond.pp()+">0) { \n";
        rez+=Utils.indent(1)+"THEN \n";
        rez+=Utils.indent(2);

            if(this.instruction!=null)
            rez+=instruction.pp()+"\n";
            if(instruction2!=null){

                rez+="ELSE \n"+Utils.indent(2)+instruction2.pp();}

        Utils.indent(0);
        rez+="FI \n";
        return rez;
    }

    @Override
    public RetInstruction toIR(SymbolTable symbolTable) throws Exception {
        RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()));
        String icmp_tmp = Utils.newtmp();
        Expression.RetExpression expReturn = cond.toIR(symbolTable);
// ICMP comparaison
        Llvm.Instruction icmp_result = new Llvm.Icmp(expReturn.type.toLlvmType(), expReturn.result, icmp_tmp);
        ret.ir.appendCode(icmp_result);
        // instruction de branchement
        String label_then = Utils.newlab(" then");
        String label_else = Utils.newlab(" else");
        String label_fi = Utils.newlab(" fi");

        //instruction de branchement
        Llvm.Instruction br_result = new Llvm.Br(icmp_tmp, label_then, label_else);
        ret.ir.appendCode(br_result);

        Llvm.Label labelT= new Llvm.Label(label_then);
        ret.ir.appendCode(labelT);
        //then
        ret.ir.append(instruction.toIR(symbolTable).ir);
        //branchement pour dodge le else apres avoir effectuer le if
        Llvm.Br dodge_else = new Llvm.Br(label_fi);
        ret.ir.appendCode(dodge_else);
        //label else
        Llvm.Label label_else_instruction = new Llvm.Label(label_else);
        ret.ir.appendCode(label_else_instruction);
        //else code de l'instruction du bloc else
        if(this.instruction2!=null)
            ret.ir.append(this.instruction2.toIR(symbolTable).ir);
        //label fin Instruction
        Llvm.Label label_fi_instruction = new Llvm.Label(label_fi);
        ret.ir.appendCode(label_fi_instruction);
        return ret;
    }
}

