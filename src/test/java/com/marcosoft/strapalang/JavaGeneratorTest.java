package com.marcosoft.strapalang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaGeneratorTest {

    JavaGenerator javaGenerator = new JavaGenerator();

    @Test
    void should_Return_Correct_File_Initialization() {
        String expectedResult = "public class MyProgram {\n" +
                "    public static void main(String[] args){";
        String actualResult = javaGenerator.fileInitializer("MyProgram");
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void should_Return_Correct_File_Closure() {
        String expectedResult = "}\n" +
                "}";
        String actualResult = javaGenerator.fileClosure();
        assertEquals(expectedResult,actualResult);
    }
}