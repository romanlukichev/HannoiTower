package oop.practice;

public class Main {

    public static void main(String[] args) {

        HanoiTower myTower = new HanoiTower();

        final int numberOfDisks = 18;

        myTower.populate(numberOfDisks);

        System.out.println("numberOfDisks = " + numberOfDisks);
        myTower.showState();

        myTower.moveDisks();

        //System.out.println("_FINAL_SHOW_STATE_");
        myTower.showState();


    }
}
