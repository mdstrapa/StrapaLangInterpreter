package com.marcosoft.strapalang.generators;

import com.marcosoft.strapalang.instructions.StrapaLangPrint;
import com.marcosoft.strapalang.instructions.StrapaLangVariable;

public interface SourceCodeGenerator {
    String fileInitializer(String programName);

    String fileClosure();

    String declareVariable(StrapaLangVariable var);

    String declareConstant(String line);

    String addPrintln(StrapaLangPrint print);

}
