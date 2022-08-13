package com.marcosoft.strapalang.instructions;

import lombok.Builder;

@Builder
public class StrapaLangPrint {
    private String instruction;
    private String message;

    public String getInstruction() {
        return instruction;
    }

    public String getMessage() {
        return message;
    }
}
