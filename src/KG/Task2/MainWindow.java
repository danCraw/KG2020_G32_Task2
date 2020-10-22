package KG.Task2;

import javax.swing.*;
import java.awt.*;

class MainWindow extends JFrame {

    MainWindow() throws HeadlessException {
        DrawPanel dp = new DrawPanel();
        this.add(dp);
    }
}
