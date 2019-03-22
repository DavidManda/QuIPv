package com.quipv.app.Models;

/*
 *Structure for storing questions from a given study
 *Contains questionID and questionString
 *Flag for if the question should be shown in the vis
 */

import java.util.function.Consumer;

public class Question {
    private final String questionID;
    private final String text;
    private boolean showInVis;

    public Question(QuestionBuilder builder) {
        this.questionID = builder.questionID;
        this.text = builder.text;
        showInVis = true;
    }

    public static class QuestionBuilder {
        public String questionID;
        public String text;

        public Question build() {
            return new Question(this);
        }

        public QuestionBuilder with(Consumer<QuestionBuilder> func){
            func.accept(this);
            return this;
        }

    }

    public String getQuestionID() {
        return questionID;
    }

    public String getText() {
        return text;
    }

    public boolean isShowInVis() {
        return showInVis;
    }

    public void setShowInVis(boolean showInVis) {
        this.showInVis = showInVis;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }

        if(!(o instanceof Question)){
            return false;
        }

        Question q = (Question) o;
        return this.questionID.equals(q.getQuestionID());
    }

    @Override
    public int hashCode() {
        return this.questionID.hashCode();
    }

}