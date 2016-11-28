package oop.practice;

//import java.util.ArrayDeque;
//import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Roman on 20.11.2016.
 */
public class HanoiTower {
    private static Stack<Integer> pole1 = new Stack<Integer>(); // source
    private static Stack<Integer> pole2 = new Stack<Integer>(); //aux
    private static Stack<Integer> pole3 = new Stack<Integer>(); //destination

    //private static ArrayDeque<ActionMove> moves = new ArrayDeque<ActionMove>();

    public void populate(Integer inValue){
           int maxSize = inValue;
        for(int i=0 ; i<inValue ; i++){
            pole1.push(maxSize--);
        }
    }

    private void DisplayPole(Stack<Integer> inStack){
        System.out.flush();
        int stackSize = inStack.size();

        if(stackSize!=0) {

            for(int height=0 ; height<stackSize ; height++ ){

                Integer myInteger = inStack.elementAt(height);
                int diskDiameter = myInteger.intValue();

                for(int i=0 ; i<diskDiameter ; i++) {
                    System.out.print("*");
                }

                System.out.println();
            }





//            for(Iterator<Integer> it = inStack.iterator() ; it.hasNext() ; ){
//
//                Integer myInteger = it.next();
//                int diskDiameter = myInteger.intValue();
//                for(int i=0 ; i<diskDiameter ; i++) {
//                    System.out.print("*");
//                }
//
//                System.out.println();
//            }


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

    private void md(int numDisks , Stack<Integer> source, Stack<Integer> aux , Stack<Integer> dest ){

        if(numDisks==0) return;

       // System.out.println("call md(" + numDisks + " , " + source.toString() + " , " + aux.toString() + " , " +  dest.toString() + ")" );



        if(numDisks==1){
            //moves.addFirst(new ActionMove( source , dest ));
            //System.out.println(moves.getFirst().ToString() );
            dest.push(source.pop());
            this.showState();
        }
        else {

            md(numDisks - 1, source, dest, aux);

            md(1 ,source , aux , dest);

            //System.out.println("we call md(" + (numDisks - 1) + " , aux , source , end ");
            md(numDisks - 1, aux, source, dest);
        }

    }



}
