package com.marcosoft.strapalang;

public class JavaSourceCode {

    private String code = "";

    public void appendCode(String newCode){
        StringBuilder builder = new StringBuilder();
        code = builder
                .append(code)
                .append(newCode)
                .append("\n")
                .toString();
    }

    public void print(){
        System.out.println(code);
    }

}
