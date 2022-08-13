package com.marcosoft.strapalang;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss.SSS");
    public void beginCompilation(){
        System.out.println("#### Begin compilation");
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.println();
        System.out.println("Compilation log-------");
    }

    public void write(String message){
        System.out.println(message);
    }

    public void endCompilation(){
        System.out.println();
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.println("#### End compilation");
    }
}
