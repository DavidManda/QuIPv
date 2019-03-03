package com.quipv.app.Models;

/*
 *Structure for storing answers for a DataNode
 *Contains basic logic & getter/setter functions
 */

import java.util.*;
import java.util.function.Consumer;

public class Answer {
    private final String fullAnswer;
    private final String projectName;
    private final String brokenAnswer;
    private final Integer rowId;
    private ArrayList<String> outcomes;
    private String driver;
    private final String respondentID;
    private final String questionID;

    public Answer(AnswerBuilder builder) {
        this.fullAnswer = builder.fullAnswer;
        this.brokenAnswer = builder.brokenAnswer;
        this.rowId = builder.rowId;
        this.projectName = builder.projectName;
        this.outcomes = builder.outcomes;
        this.driver = builder.driver;
        this.respondentID = builder.respondentID;
        this.questionID = builder.questionID;
    }

    public static class AnswerBuilder {
        public String fullAnswer;
        public String brokenAnswer;
        public ArrayList<String> outcomes;
        public String driver;
        public Integer rowId;
        public String respondentID;
        public String questionID;
        public String projectName;


        public Answer build() {
            return new Answer(this);
        }

        public AnswerBuilder with(Consumer<AnswerBuilder> func){
            func.accept(this);
            return this;
        }

    }

    public Integer getRowId() {
        return rowId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getFullAnswer() {
        return fullAnswer;
    }

    public String getBrokenAnswer() {
        return brokenAnswer;
    }

    public ArrayList<String> getOutcomes() {
        return outcomes;
    }

    public String getDriver() {
        return driver;
    }

    public String getRespondentID() {return respondentID;}

    public String getQuestionID() {return questionID;}

    public void setOutcomes(ArrayList<String> outcomes) {
        this.outcomes = outcomes;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
