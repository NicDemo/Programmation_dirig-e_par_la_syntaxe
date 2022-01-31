package TP2.ASD;

import TP2.Llvm;
import TP2.SymbolTable;
import TP2.Utils;

public class While extends Instruction{
    Expression cond;
    Instruction i;
    public While ( Expression cond,Instruction i){
        this.cond=cond;
        this.i=i;
    }
    @Override
    public String pp() {
        String rez = "";
        rez+="WHILE ("+cond.pp()+") DO \n";
        Utils.indent(1);
        rez+=i.pp()+ "\nDONE";
        return rez;
    }

    @Override
    public RetInstruction toIR(SymbolTable symbolTable) throws Exception {
        RetInstruction ret = new RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()));
        String icmp_tmp = Utils.newtmp();
        //creation de label
        String label_while = Utils.newlab(" WHILE");
        String label_do = Utils.newlab(" DO");
        String label_done = Utils.newlab(" DONE");
        //label while
        Llvm.Label label_while_inst= new Llvm.Label(label_while);
        ret.ir.appendCode(label_while_inst);
        //Condition
        Llvm.Instruction icmp_result = new Llvm.Icmp(cond.toIR(symbolTable).type.toLlvmType(), cond.toIR(symbolTable).result, icmp_tmp);
        ret.ir.appendCode(icmp_result);
        //branchement
        Llvm.Instruction br_do = new Llvm.Br(icmp_tmp,label_do,label_done);
        ret.ir.appendCode(br_do);
        //label DO
        Llvm.Label label_do_inst= new Llvm.Label(label_do);
        ret.ir.appendCode(label_do_inst);
        //instruction de while
        ret.ir.append(i.toIR(symbolTable).ir);
        //branchement pour retourner au debut de la boucle
        Llvm.Br return_to_while = new Llvm.Br(label_while);
        ret.ir.appendCode(return_to_while);
        //label DONE
        Llvm.Label DONE = new Llvm.Label(label_done);
        ret.ir.appendCode(DONE);
        return ret;
    }
}
