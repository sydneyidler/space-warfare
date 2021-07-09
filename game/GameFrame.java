package game;

import javax.swing.JFrame;
import game.screens.GameScreen;

import java.awt.*;

public class GameFrame extends JFrame {

  public final static int WIDTH = 550;
  public final static int HEIGHT = 550;

  public GameFrame() {
    super("Game");
    init();
  }

  private void init() {
    add(new GameScreen()); 
    getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main(final String[] args) {
    new GameFrame();
  }
}