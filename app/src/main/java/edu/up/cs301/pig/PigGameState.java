package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by yu18 on 3/9/2017.
 */
public class PigGameState extends GameState{
    private int whoseTurn;
    private int score0;
    private int score1;
    private int runningTotal;
    private int dieVal;

    public PigGameState()
    {
        whoseTurn = 0;
        score0 = 0;
        score1 = 0;
        runningTotal = 0;
        dieVal = 1;
    }
    public PigGameState(PigGameState pgs){
        whoseTurn = pgs.whoseTurn;
        score0 = pgs.score0;
        score1 = pgs.score1;
        runningTotal = pgs.runningTotal;
        dieVal = pgs.dieVal;

    }

    public void setWhoseTurn(int wT){
        this.whoseTurn=wT;
    }
    public int getWhoseTurn(){
        return whoseTurn;
    }

    public void setScore0(int s0){
        this.score0=s0;
    }
    public int getScore0(){
        return score0;
    }

    public void setScore1(int s1){
        this.score1=s1;
    }
    public int getScore1(){
        return score1;
    }

    public void setRunningTotal(int RT){
        this.runningTotal=RT;
    }
    public int getRunningTotal(){
        return runningTotal;
    }

    public void setDieVal(int dv){
        this.dieVal=dv;
    }
    public int getDieVal(){
        return dieVal;
    }
}
