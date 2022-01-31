package TP2.ASD;
import TP2.Llvm;

import TP2.SymbolTable;
import TP2.TypeException;

public abstract class Instruction {
	public abstract String pp();
	public abstract Instruction.RetInstruction toIR(SymbolTable symbolTable) throws  Exception;
    
    // Object returned by toIR on expressions, with IR + synthesized attributes
    static public class RetInstruction {
      // The LLVM IR :
      public Llvm.IR ir;
      // And additional stuff:
      // (either an identifier, or an immediate value)

      public RetInstruction(Llvm.IR ir) {
        this.ir = ir;
      }
    }
}
 
