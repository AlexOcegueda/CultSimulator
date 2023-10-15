import javax.swing.SwingUtilities;

import com.game.gui.GameGUI;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameGUI();
            }
        });
    }
}
