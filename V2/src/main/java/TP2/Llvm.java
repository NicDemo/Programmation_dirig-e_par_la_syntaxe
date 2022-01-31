package TP2;

import TP2.ASD.DeclInstruction;
import TP2.ASD.Type;

import java.util.List;
import java.util.ArrayList;

// This file contains a simple LLVM IR representation
// and methods to generate its string representation

public class Llvm {
  static public class IR {
    List<Instruction> header; // IR instructions to be placed before the code (global definitions)
    List<Instruction> code;   // main code

    public IR(List<Instruction> header, List<Instruction> code) {
      this.header = header;
      this.code = code;
    }

    // append an other IR
    public IR append(IR other) {
      header.addAll(other.header);
      code.addAll(other.code);
      return this;
    }

    // append a code instruction
    public IR appendCode(Instruction inst) {
      code.add(inst);
      return this;
    }

    // append a code header
    public IR appendHeader(Instruction inst) {
      header.add(inst);
      return this;
    }

    // Final string generation
    public String toString() {
      // This header describe to LLVM the target
      // and declare the external function printf
      StringBuilder r = new StringBuilder("; Target\n" +
        "target triple = \"x86_64-unknown-linux-gnu\"\n" +
        "; External declaration of the printf function\n" +
        "declare i32 @printf(i8* noalias nocapture, ...)\n" +
        "\n; Actual code begins\n\n");

      for(Instruction inst: header)
        r.append(inst);

      r.append("\n\n");

      // We create the function main
      // TODO : remove this when you extend the language
      r.append("define i32 @main() {\n");


      for(Instruction inst: code)
        r.append(inst);

      // TODO : remove this when you extend the language
      r.append("}\n");

      return r.toString();
    }
  }// fin class IR

  // Returns a new empty list of instruction, handy
  static public List<Instruction> empty() {
    return new ArrayList<Instruction>();
  }


  // LLVM Types
  static public abstract class Type {
    public abstract String toString();
  }

  static public class Int extends Type {
    public String toString() {
      return "i32";
    }
  }

  static public class Text extends Type{
      public String toString() {return "void";}
  }


  // LLVM IR Instructions
  static public abstract class Instruction {
    public abstract String toString();
  }
  static public class Add extends Instruction {
    Type type;
    String left;
    String right;
    String lvalue;

    public Add(Type type, String left, String right, String lvalue) {
      this.type = type;
      this.left = left;
      this.right = right;
      this.lvalue = lvalue;
    }

    public String toString() {
      return lvalue + " = add " + type + " " + left + ", " + right +  "\n";
    }
  }
  static public class Mul extends Instruction {
	  Type type;
	    String left;
	    String right;
	    String lvalue;

	    public Mul(Type type, String left, String right, String lvalue) {
	      this.type = type;
	      this.left = left;
	      this.right = right;
	      this.lvalue = lvalue;
	    }
	    public String toString() {
	    	  return lvalue + " = mul " + type + " " + left + ", " + right +  "\n";
	    }
  }
  static public class Div extends Instruction {
	  Type type;
	    String left;
	    String right;
	    String lvalue;

	    public Div(Type type, String left, String right, String lvalue) {
	      this.type = type;
	      this.left = left;
	      this.right = right;
	      this.lvalue = lvalue;
	    }
	    public String toString() {
	    	  return lvalue + " = Div " + type + " " + left + ", " + right +  "\n";
	    }
  }
  
  static public class Sub extends Instruction { Type type;
  String left;
  String right;
  String lvalue;

  public Sub(Type type, String left, String right, String lvalue) {
    this.type = type;
    this.left = left;
    this.right = right;
    this.lvalue = lvalue;
  }
  public String toString() {
  	  return lvalue + " = Sub " + type + " " + left + ", " + right +  "\n";
  }}

  static public class Return extends Instruction {
    Type type;
    String value;

    public Return(Type type, String value) {
      this.type = type;
      this.value = value;
    }

    public String toString() {
      return "ret " + type + " " + value + "\n";
    }
  }
  static public class Affect extends Instruction {
	Type type;
	String ident;
	String value;


	public Affect (Type type, String ident, String value) {
		this.type = type;
		this.ident = ident;
		this.value = value;
	}

      public String toString() {
		return "store " + type + " " + value + ", " + type + "* %" + ident +  "\n";
	}
}

 static public class Decl extends Instruction{
    Type type;
    String ident;
     public Decl(Type type, String ident){
         this.type=type;
         this.ident=ident;
     }
     @Override
     public String toString() {
       return "%" + ident + " := alloca " + type +  "\n";
     }
 }
 static public class Load extends Instruction {
         Type type;
         String ident;
         String lvalue;

		public Load(Type type, String ident, String lvalue) {
             this.type = type;
             this.ident = ident;
             this.lvalue = lvalue;
         }

         public String toString() {
             return lvalue + " = load " + type.toString() + ", " + type + "* %"+ ident + "\n";
         }

 }
 public static class Label extends Instruction{
      String labelo;
      public Label(String labelo){
          this.labelo=labelo;
        }


     @Override
     public String toString() {

         return labelo+"\n";
     }
 }
 public static class Br extends  Instruction{
     Type type;
     String condition_value;
     String label_1;
     String label_2;

     public Br(String condition_value, String label_1, String label_2) {// on a pas le type vu qu'on va tjrs utiliser des int
         this.type = new Llvm.Int();
         this.condition_value = condition_value;
         this.label_2 = label_2;
         this.label_1 = label_1;
     }
     public Br(String label_1) {
         this.type = new Llvm.Int();
         //this.label_2 = "ABSENT";
         //this.condition_value = "ABSENT";
         this.label_1 = label_1;
     }

     @Override
     public String toString() {
         String to_return="br ";
         if(this.label_2==null){//if(this.label_2.equals("ABSENT")){
        to_return += "label"+label_1+ "\n";
        return to_return;
         }
         to_return+=type.toString()+" "+condition_value+", label"+ label_1+", label" +label_2+"\n";
             return to_return;
     }
 }
 public static class Icmp extends  Instruction{
    String cond_value;
    Type type;
    String lvalue;
    public Icmp(Type type ,String cond_value ,String lvalue){
        this.cond_value=cond_value;
        this.lvalue=lvalue;
        this.type=type;
    }
     @Override
     public String toString() {
         return lvalue+"= icmp ne "+type.toString()+" "+cond_value+","+" 0\n";     }
 }



  // TODO : other instructions

}
