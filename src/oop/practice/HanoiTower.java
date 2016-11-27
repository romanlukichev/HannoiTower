package oop.practice;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Created by Roman on 20.11.2016.
 */
public class HanoiTower {
    private static ArrayDeque<Integer> pole1 = new ArrayDeque<Integer>(); // source
    private static ArrayDeque<Integer> pole2 = new ArrayDeque<Integer>(); //aux
    private static ArrayDeque<Integer> pole3 = new ArrayDeque<Integer>(); //destination

    private static ArrayDeque<ActionMove> moves = new ArrayDeque<ActionMove>();

    public void populate(Integer inValue){
           int maxSize = inValue;
        for(int i=0 ; i<inValue ; i++){
            pole1.addFirst(maxSize--);
        }
    }

    private void DisplayPole(ArrayDeque<Integer> inDeque){
        System.out.flush();
        int inDequeSize = inDeque.size();

        if(inDequeSize!=0) {
            Object[] tempArray =  inDeque.toArray();

            for (int i = 0; i < tempArray.length; i++) {
                // System.out.println(tempArray[i]);
                //Object diskSize = tempArray[i];
                for(int m=0 ; m<i+1 ; m++ ){
                System.out.print("*");
            }
            System.out.println();
            }
        }

    }


    public void showState(){
        System.out.println("================ State of the towers =====================");
        System.out.println("pole1: " + pole1.toString());
         DisplayPole(pole1);

        System.out.println("pole2: " + pole2.toString());
        DisplayPole(pole2);

        System.out.println("pole3: " + pole3.toString());
        DisplayPole(pole3);


    }

    public void moveDisks(){

        md( pole1.size() , PegName.source, PegName.aux , PegName.dest );

    }

    public void md(int numDisks , PegName source,  PegName aux,  PegName dest){

        if(numDisks==0) return;

        System.out.println("call md(" + numDisks + " , " + source.toString() + " , " + aux.toString() + " , " +  dest.toString() + ")" );



        if(numDisks==1){
            moves.addFirst(new ActionMove( source , dest ));
            System.out.println(moves.getFirst().ToString() );
        }
        else {

            md(numDisks - 1, source, dest, aux);

            md(1 ,source , aux , dest);

            //System.out.println("we call md(" + (numDisks - 1) + " , aux , source , end ");
            md(numDisks - 1, aux, source, dest);
        }

    }



}
