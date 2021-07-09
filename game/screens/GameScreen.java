package game.screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.sprites.SpaceShip;
import game.sprites.Missile;
import game.GameFrame;
import game.sprites.Alien;

public class GameScreen extends JPanel implements ActionListener {

  public final static int ALIENS_IN_ROW = 4;
  public final static int ALIENS_IN_COLUMN = 4;

  private final int DELAY = 10;

  private SpaceShip _spaceShip;
  private Timer _timer;
  private Alien[] _aliens = new Alien[16];

  public GameScreen() {
    this._spaceShip = new SpaceShip();
    this.initAliens();

    this.addKeyListener(new TAdapter());
    this.setBackground(Color.BLACK);
    this.setFocusable(true);

    this._timer = new Timer(DELAY, this);
    this._timer.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g); 
    this.doDrawing(g);
  }

  private void doDrawing(Graphics g) {
    Graphics2D graphics2d = (Graphics2D) g;

    graphics2d.drawImage(
      this._spaceShip.getImage(),
      this._spaceShip.getX(),
      this._spaceShip.getY(),
      this._spaceShip.getWidth(),
      this._spaceShip.getHeight(),
      this
    );

    Missile[] missiles =  this._spaceShip.getMissiles();
    for (int i = 0; i < missiles.length; i++) {
      if (missiles[i].isVisible()) {
        graphics2d.drawImage(
          missiles[i].getImage(),
          missiles[i].getX(),
          missiles[i].getY(),
          this
        );
      }
    }
   
    for (int i = 0; i < this._aliens.length; i++) {
      if (this._aliens[i].isVisible()) {
        graphics2d.drawImage(
          this._aliens[i].getImage(),
          this._aliens[i].getX(),
          this._aliens[i].getY(),
          this._aliens[i].getWidth(),
          this._aliens[i].getHeight(),
          this
        );
      }
    }
  }

  private void initAliens() {
    for (int i = 0; i < this._aliens.length; i++) {
      int row = i / GameScreen.ALIENS_IN_ROW;
      int rowHeight = GameFrame.HEIGHT / GameScreen.ALIENS_IN_COLUMN;
      int yPosition = row * rowHeight;

      int column = i % GameScreen.ALIENS_IN_COLUMN;
      int columnWidth = GameFrame.WIDTH / GameScreen.ALIENS_IN_COLUMN; 
      int xPosition = column * columnWidth;

      this._aliens[i] = new Alien(xPosition, -yPosition);
      this._aliens[i].decideIfAlienVisible();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.updateSpaceShip();
    this.updateMissiles();
    this.updateAliens();
    this.repaint();
  }
  
  private void updateSpaceShip() {
    this._spaceShip.move();
  }

  private void updateMissiles() {
    Missile[] missiles = this._spaceShip.getMissiles();
    for (int i = 0; i < missiles.length; i++) {
      if (missiles[i].isVisible()) {
        missiles[i].move();
      }
    }
  }

  private void updateAliens() {
    for (int i = 0; i < this._aliens.length; i++) {
      this._aliens[i].move();
    }
  }

  private class TAdapter extends KeyAdapter {
    public void keyReleased(KeyEvent e) {
      _spaceShip.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
      _spaceShip.keyPressed(e);
    }
  }
}
