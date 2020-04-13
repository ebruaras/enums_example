package com.example.demo.question;

import java.beans.PropertyEditorSupport;

public class QuestionCategoryConverter extends PropertyEditorSupport {
    public void setAsText(final String text)throws IllegalArgumentException{
        setValue(QuestionCategory.fromValue(text));
    }

}
