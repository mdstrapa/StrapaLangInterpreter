package com.marcosoft.strapalang;

import com.marcosoft.strapalang.generators.JavaGenerator;
import com.marcosoft.strapalang.instructions.StrapaLangPrint;
import com.marcosoft.strapalang.instructions.StrapaLangVariable;

public class LineProcessor {

    public String processLine(String line){
        StrapaLangParser strapaLangParser = new StrapaLangParser();
        JavaGenerator javaGenerator = new JavaGenerator();

        if (strapaLangParser.isEmptyLine(line)) return "";

        if (strapaLangParser.isProgramBegin(line)) {
            String programName = strapaLangParser.getProgramName(line);
            return javaGenerator.fileInitializer(programName);
        }

        if (strapaLangParser.isVariableDeclaration(line)) {
            StrapaLangVariable var = strapaLangParser.getVariable(line);
            return javaGenerator.declareVariable(var);
        }

        if (strapaLangParser.isConstantDeclaration(line)) return javaGenerator.declareConstant(line);

        if (strapaLangParser.isPrint(line)) {
            StrapaLangPrint print = strapaLangParser.getPrint(line);
            return javaGenerator.addPrintln(print);
        };

        if (strapaLangParser.isProgramEnd(line)) return javaGenerator.fileClosure();

        return "";
    }
}