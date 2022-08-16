package com.marcosoft.strapalang;

import com.marcosoft.strapalang.generators.JavaGenerator;
import com.marcosoft.strapalang.instructions.StrapaLangPrint;
import com.marcosoft.strapalang.instructions.StrapaLangVariable;

public class LineInterpreter {

    public String processLine(String line){
        StrapaLangParser strapaLangParser = new StrapaLangParser();
        JavaGenerator javaGenerator = new JavaGenerator();

        if (line.trim().equals("")) return "";

        if (strapaLangParser.isProgramBegin(line)) {
            String programName = strapaLangParser.getProgramName(line);
            return javaGenerator.fileInitializer(programName);
        }

        if (line.trim().startsWith("v ")) {
            StrapaLangVariable var = strapaLangParser.getVariable(line);
            return javaGenerator.declareVariable(var);
        }

        if (line.trim().startsWith("c ")) return javaGenerator.declareConstant(line);

        if (line.trim().startsWith("p(")) {
            StrapaLangPrint print = strapaLangParser.getPrint(line);
            return javaGenerator.addPrintln(print);
        };

        if (line.trim().startsWith("$end")) return javaGenerator.fileClosure();

        return "";
    }



}
