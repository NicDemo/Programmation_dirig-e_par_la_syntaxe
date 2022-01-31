package TP2.ASD;

import TP2.Llvm;
import TP2.SymbolTable;
import TP2.Utils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Objects;

public class Bloc extends  Instruction {
    private ArrayList<DeclInstruction> declarations = new ArrayList<>();
    private ArrayList<Instruction> instructions = new ArrayList<Instruction>();
    private SymbolTable symbolTable;
    public Bloc(ArrayList<DeclInstruction> dec, ArrayList<Instruction> ins) {
        this.declarations = dec;
        this.instructions = ins;
    }

    @Override
    public String pp() {
        String pp="{";
        for(DeclInstruction d : declarations){
            pp+= d.pp()+"\n";
        }
        for (Instruction i : instructions){
            Objects.requireNonNull(i);
            pp+=i.pp()+"\n";
        }
        return pp+"}";
    }

    @Override
    public RetInstruction toIR(SymbolTable symbolTable) throws Exception {
        //rajouter le niv du bloc
        this.symbolTable=new SymbolTable(symbolTable);
        Llvm.IR IR = new Llvm.IR(Llvm.empty(),Llvm.empty());
        for (DeclInstruction d : declarations){
            IR.append(d.toIR(this.symbolTable).ir);
        }
        for(Instruction i : instructions){
            IR.append(i.toIR(this.symbolTable).ir);
        }
        return new RetInstruction(IR);
    }
}
