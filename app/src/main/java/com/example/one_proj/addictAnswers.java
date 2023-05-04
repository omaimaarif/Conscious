package com.example.one_proj;

public class addictAnswers {
    private int optionA,optionB,optionC,optionD,questionid,answerid;
    public addictAnswers(int questionide,int optiona,int optionb,int optionc,int optiond,int answeride)
    {
        questionid=questionide;
        optionA=optiona;
        optionB=optionb;
        optionC=optionc;
        optionD=optiond;
        answerid=answeride;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }
}
