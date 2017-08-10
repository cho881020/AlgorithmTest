package kr.co.tjeit.algorithmtest.data;

/**
 * Created by user on 2017-08-10.
 */

public class GuguData {

    int dansu; // 몇단을 출력하는지.
    int number; // 몇을 곱해주는지.

    // Ex. dansu : 2, number : 5 => 2 X 5 = 10


    public GuguData() {
    }

    public GuguData(int dansu, int number) {
        this.dansu = dansu;
        this.number = number;
    }

    public int getDansu() {
        return dansu;
    }

    public void setDansu(int dansu) {
        this.dansu = dansu;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
