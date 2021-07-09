package game.sprites;

import game.GameFrame;
import game.screens.GameScreen;

public class Alien extends Sprite { 

  private static final int ALIEN_SPEED = 3;

  public Alien(int x, int y) {
    super();

    this.loadImage("images/alien.png");
    this.setSpriteDimensions(32, 32);

    int columnWidth = GameFrame.WIDTH / GameScreen.ALIENS_IN_COLUMN; 
    this._x = x + columnWidth / 2 - this._width;
    this._y = y;
  }

  public void move() {
    this._y += Alien.ALIEN_SPEED;

    if (this._y > GameFrame.HEIGHT) {
      this.decideIfAlienVisible();
      this._y = -this._height;
    }
  }

  public void decideIfAlienVisible() {
    if (Math.random() > 0.8) {
      this._visible = true;
    } else {
      this._visible = false;
    }
  }
  
}
