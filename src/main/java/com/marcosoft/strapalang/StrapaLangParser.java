package com.marcosoft.strapalang;

import com.marcosoft.strapalang.instructions.StrapaLangPrint;
import com.marcosoft.strapalang.instructions.StrapaLangVariable;

public class StrapaLangParser {

    public boolean isEmptyLine(String line){
        return line.trim().equals("");
    }

    public boolean isProgramBegin(String line){
        return line.trim().startsWith("$beginProgram");
    }

    public boolean isVariableDeclaration(String line){
        return line.trim().startsWith("$v ");
    }

    public boolean isConstantDeclaration(String line){
        return line.trim().startsWith("$c ");
    }

    public boolean isPrint(String line){
        return line.trim().startsWith("$p(");
    }

    public boolean isProgramEnd(String line){
        return line.trim().startsWith("$end");
    }

    public String getProgramName(String line){
        String[] elements = line.split(" ");
        return elements[1];
    }

    public StrapaLangVariable getVariable(String line){
        String[] elements = line.split(" ");

        StrapaLangVariable var;
        //we need to check if the declaration contains initialization
        if(elements.length == 4){
            //TODO: have to find the variable type
            var = StrapaLangVariable.builder()
                    .name(elements[1])
                    .type("String")
                    .value(elements[3])
                    .build();
        }else{
            //if there is no initialization we assume that this variable
            //is going to be String
            var = StrapaLangVariable.builder()
                    .name(elements[1])
                    .type("String")
                    .build();
        }
        return var;
    }


    public StrapaLangPrint getPrint(String line){
        String message = line.trim().substring(3,line.trim().length()-2);
        return StrapaLangPrint.builder()
                .instruction("p")
                .message(message)
                .build();

    }

}
