package com.example.demo.question;

import java.util.Arrays;

public enum QuestionCategory {
    OS("os"),TS("ts");
    private String value;
    private QuestionCategory(String value){
        this.value=value;
    }
    public static QuestionCategory fromValue(String value){
        for(QuestionCategory category:values()){
            if(category.value.equalsIgnoreCase(value)){
                return category;
            }
        }
        throw new IllegalArgumentException("Unknown enum type"+value+" ,Allowed values are "+ Arrays.toString(values()));
    }
}
