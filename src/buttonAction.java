import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.*;

public class buttonAction {

    public static void addListener(JButton[][] grid){


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                final int finalI = i;                // declare i as final variable for use in action
                final int finalJ = j;               // declare j as final variable

                int pos = finalI+(finalJ*10);

                ArrayList<JButton> neighbors = isNeighbour.isNeighbourOf(i, j, grid); //find neighbours of button

                grid[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GUI.lblMine.setText("Mine Status: " + GUI.currentMap.get(pos));

                        int numOfMines = 0;                //Start count for mines
                        for (JButton btn: neighbors) {     //iterate through buttons
                            int[] index= findBtnPos(btn);  //get index of button
                            int target = -1;
                            if (stream(index).noneMatch(x -> x == target)){
                                int posOf = (index[0] + (index[1]*10));
                                if(GUI.currentMap.get(posOf)){  //if this neighbour is a mine add to the count
                                numOfMines++;
                                }
                            }
                        }
                        ;
                    }
                });


            }
        }

    }
                //Method to find the position of a button and return as coordinates
    public static int[] findBtnPos(JButton btn){

        int[] indices = {-1,-1};
        JButton[][] arr= GUI.buttons;

        int i = 0;          //Loop looking through array for buttons
        while(i < arr.length){
        int j = 0;
            while (j< arr[0].length){
                if (arr[i][j] == btn) { //Check if the button is the one searched for
                    indices[0] = i;
                    indices[1] = j;
                    return indices;     //Return the index of said button
                }
                else j++;
            }
            i++;
        }
        return indices;
    }
}