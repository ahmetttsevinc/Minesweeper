import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class gameMove {
        private int clickedRow;
        private int clickedCol;
        private boolean clickedLeftClick;



        public gameMove(int row, int col,boolean click) {
            this.clickedRow = row;
            this.clickedCol = col;
            this.clickedLeftClick = click;
        }

    public static void replayGame() throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    GUI.currentMap.get(i + (j * 10)).getBtn().setEnabled(true);
                    GUI.currentMap.get(i + (j * 10)).getBtn().setText("");
                    GUI.currentMap.get(i + (j * 10)).setFlagged(false);
                    GUI.currentMap.get(i + (j * 10)).setRevealed(false);
                }
            }
                for (gameMove move : buttonAction.moveList) {
                        int col = move.clickedCol;
                        int row = move.clickedRow;
                        boolean click = move.clickedLeftClick;
                    try {
                        Thread.sleep(1000);
                        buttonAction.clickAction(row, col, click, GUI.buttons[row][col].getBtn());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        }).start();
        }
}