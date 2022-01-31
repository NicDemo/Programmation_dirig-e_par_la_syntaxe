package TP2.ASD;

import TP2.*;
import TP2.ASD.Expression.RetExpression;

public class SubExpression extends Expression  {
	Expression left;
	Expression right;
	
	public SubExpression(Expression l, Expression r) {
		left = l;
		right=r;
		
	}
	public String pp() {
		return ("("+ left.pp() + "-" + right.pp() +")");
	}
	 public RetExpression toIR(SymbolTable symbolTable) throws TypeException{
	      RetExpression leftRet = left.toIR(symbolTable);
	      RetExpression rightRet = right.toIR(symbolTable);

	      
	      if(!leftRet.type.equals(rightRet.type)) {
	        throw new TypeException("mismatch type with: "+ leftRet.type + " and " + rightRet.type);
	      }
	     
	    	  // leftIr concat rightIr
	    	  leftRet.ir.append(rightRet.ir);
	    	 // new identifier for the result
	    	  String result = Utils.newtmp();
	    	   Type type = leftRet.type;
	    	   // add the instruction mul to the main code
	    	   Llvm.Instruction sub = new Llvm.Sub(leftRet.type.toLlvmType(), leftRet.result, rightRet.result,result);
	    	   leftRet.ir.appendCode(sub);
	    	   // return the generated ir expression and where to find it 
	    	   return new RetExpression(leftRet.ir, type, result);
	    	   
	 }
	
}

