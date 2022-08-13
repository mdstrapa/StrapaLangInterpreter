package com.marcosoft.strapalang.instructions;

import lombok.Builder;

@Builder
public class StrapaLangVariable {
    private String name;
    private String type;
    private String value;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}
