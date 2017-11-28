package edu.tjhsst.quizyourfriend;

import java.io.Serializable;

/**
 * Created by 2018ftian on 9/14/2017.
 */

public class Question implements Serializable{

    private int qid;
    private int qid2;
    private int a;
    private int b;
    private int c;
    private int d;

    public Question(int num, int q2, int first, int second, int third, int fourth){
        qid = num;
        qid2 = q2;
        a = first;
        b = second;
        c = third;
        d = fourth;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getQid2() {
        return qid2;
    }

    public void setQid2(int qid2) {
        this.qid2 = qid2;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
