package com.marcosoft.strapalang.generators;

import com.marcosoft.strapalang.instructions.StrapaLangPrint;
import com.marcosoft.strapalang.instructions.StrapaLangVariable;

public class JavaGenerator implements SourceCodeGenerator{

    public String fileInitializer(String programName){
        return "public class " + programName + " {\n" +
                "    public static void main(String[] args){";
    }

    public String fileClosure(){
        return "}\n" +
                "}";
    }

    public String declareVariable(StrapaLangVariable var){
        if (var.getValue().equals("")) return var.getType() + " " + var.getName() + ";";
        else return var.getType() + " " + var.getName() + " = " + var.getValue() + ";";
    }

    public String declareConstant(String line){
        return "final String ABC";
    }

    public String addPrintln(StrapaLangPrint print){
        return "System.out.println(\"" + print.getMessage() + "\");";
    }

}
