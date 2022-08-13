package com.marcosoft.strapalang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrapaLangParserTest {

    StrapaLangParser strapaLangParser = new StrapaLangParser();
    @Test
    void should_Return_True_For_Valid_Input() {
        String line = "$begin MyProgram";
        boolean result = strapaLangParser.isProgramBegin(line);
        assertTrue(result);
        line = "      $begin MyProgram";
        result = strapaLangParser.isProgramBegin(line);
        assertTrue(result);
    }

    @Test
    void should_Return_False_For_Invalid_Input() {
        String line = "v myVariable = 1";
        boolean result = strapaLangParser.isProgramBegin(line);
        assertFalse(result);
        line = "p('something to print')";
        result = strapaLangParser.isProgramBegin(line);
        assertFalse(result);
    }

    @Test
    void should_Return_Correct_Program_Name() {
        String line = "$begin MyProgram";
        String programName = strapaLangParser.getProgramName(line);
        assertEquals("MyProgram",programName);
    }

}