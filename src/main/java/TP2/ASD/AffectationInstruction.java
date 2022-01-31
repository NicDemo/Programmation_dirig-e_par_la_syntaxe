package TP2.ASD;
import TP2.Llvm.IR;
import TP2.SymbolTable;
import TP2.SymbolTable.VariableSymbol;
import TP2.TypeException;
import TP2.Llvm;
import java.util.ArrayList;
import java.util.Collections;


public class AffectationInstruction extends TP2.ASD.Instruction {
	private Expression exp;
	private String id;

	public AffectationInstruction(String ident, Expression e) {
		id = ident;
		exp = e;
	}

	@Override
	public String pp() {
		return (id + ":=" + exp.pp());
	}

	@Override
	public RetInstruction toIR(SymbolTable symbolTable) throws TypeException, Exception {
		Expression.RetExpression retexpression = exp.toIR(symbolTable);
		VariableSymbol symbol = (VariableSymbol) symbolTable.lookup(id);
		if (null != symbol) {// id est dans tabsymb
			if (retexpression.type.equals(symbol.getType())) {// pas de types mismatch
				Llvm.Instruction aff;
				aff = new Llvm.Affect(retexpression.type.toLlvmType(), id, retexpression.result);// Instruction de affectation
				IR ir = retexpression.ir;
				IR irAff = new IR(Llvm.empty(), new ArrayList(Collections.singleton(aff)));	// on ajoute le ir de aff a exp
				ir.append(irAff);
				return new RetInstruction(ir);
			}
			else{
				throw new TP2.TypeException("conflict between " + id + " and expReturn while affecting value");
			}
		}
		throw new TP2.TypeException(id + " pas dans table symbol");
	}
}
