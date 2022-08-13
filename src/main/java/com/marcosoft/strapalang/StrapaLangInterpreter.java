package com.marcosoft.strapalang;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StrapaLangInterpreter {
    public static void main(String[] args) {
        LogWriter logWriter = new LogWriter();
        logWriter.beginCompilation();

        File sourceCode = new File(args[0]);
        try {
            Scanner sourceCodeReader = new Scanner(sourceCode);
            String line;
            LineInterpreter lineInterpreter = new LineInterpreter();
            JavaSourceCode code = new JavaSourceCode();

            while (sourceCodeReader.hasNextLine()){
                line = sourceCodeReader.nextLine();
                code.appendCode(lineInterpreter.processLine(line));
            }

            code.print();
            sourceCodeReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR - source code not found");
            throw new RuntimeException(e);
        }



        logWriter.endCompilation();
    }




}
