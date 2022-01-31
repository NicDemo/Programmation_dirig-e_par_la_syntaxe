package TP2.ASD;

import TP2.Llvm;
import TP2.SymbolTable;
import TP2.TypeException;

import java.util.ArrayList;

public class Program {

   ArrayList <Instruction> instructions;
   SymbolTable symbolTable;// What a program contains. TODO : change when you extend the language
    public Program(ArrayList<Instruction> instruction) {
      this.instructions=instruction;
      this.symbolTable=new SymbolTable();
    }

    // Pretty-printer
    public String pp() {
        String s="";
        for(Instruction p : instructions) {

           s=s+p.pp()+"\n";
        }
        return s;
    }

    // IR generation
    public Llvm.IR toIR() throws Exception {
      // TODO : change when you extend the language
        ArrayList<Instruction.RetInstruction> ret_instructions = new ArrayList<Instruction.RetInstruction>();
        Instruction.RetInstruction toReturn = new Instruction.RetInstruction(new Llvm.IR(Llvm.empty(), Llvm.empty()));
        for(Instruction p : instructions){
     toReturn.ir.append(p.toIR(symbolTable).ir);
        }
return toReturn.ir;
    }
  }