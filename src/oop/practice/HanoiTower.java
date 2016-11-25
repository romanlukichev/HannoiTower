package oop.practice;

import java.util.Stack;

/**
 * Created by Roman on 20.11.2016.
 */
public class HanoiTower {
    private static Stack<Integer> pole1 = new Stack<Integer>(); // source
    private static Stack<Integer> pole2 = new Stack<Integer>(); //aux
    private static Stack<Integer> pole3 = new Stack<Integer>(); //destination

    public void populate(Integer inValue){
           int maxSize = inValue;
        for(int i=0 ; i<inValue ; i++){
            pole1.push(maxSize--);
        }
    }

    private void DisplayPole(Stack<Integer> inStack){
        System.out.flush();
        int inStackSize = inStack.size();
        for(int i=inStackSize-1 ; i>=0 ; i--){

            int diskSize = inStack.get(i);
            for(int m=0 ; m<diskSize ; m++ ){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static Stack<Integer> formNewStack(Stack<Integer> source){
        Stack<Integer> resultStack = new Stack<Integer>();
        int i=1;
        while(i<source.size()){
            resultStack.push(source.);
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

        md( pole1.size() , pole1 , pole2 , pole3 );

    }

    public void md(int numDisks , Stack<Integer> source, Stack<Integer> aux, Stack<Integer> dest){
        System.out.println("call md(" + numDisks + " , " + source.toString() + " , " + aux.toString() + " , " +  dest.toString() + ")" );
        if(numDisks==0) return;

        if(numDisks>1) {

            Stack<Integer> newStack = new Stack<Integer>();
            newStack = formNewStack(source); // put all disks to a new stack except for the largest bottom disk
            //System.out.println("we call md(" + (numDisks - 1) + " , aux , source , end ");
            md(numDisks - 1, source, dest, aux);
        }


        //md(1 , source , aux , dest);
        if(numDisks==1){

            String sourceString = source.toString();
            Integer temp = source.pop();
            System.out.println(" we move " + temp + " disk from " + sourceString + " to " + dest.toString() );
            dest.push(temp);
            showState();

        }
//        if(numDisks==2){
//
//            String sourceString = source.toString();
//            int temp = source.pop();
//            System.out.println(" we move " + temp + " disk from " + sourceString + " to " + aux.toString() );
//            aux.push(temp);
//            showState();
//
//            sourceString = source.toString();
//            temp = source.pop();
//            System.out.println(" we move " + temp + " disk from " + sourceString + " to " + dest.toString() );
//            dest.push(temp);
//            showState();
//
//            String auxString = aux.toString();
//            temp = aux.pop();
//            System.out.println(" we move " + temp + " disk from " + auxString + " to " + dest.toString() );
//            dest.push(temp);
//            showState();
//
//        }


        if(numDisks>1) {
            //System.out.println("we call md(" + (numDisks - 1) + " , aux , source , end ");
            md(numDisks - 1, aux, source, dest);
        }



    }



}
