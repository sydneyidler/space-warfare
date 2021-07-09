package game.sprites;

import java.awt.event.KeyEvent;

import game.GameFrame;

public class SpaceShip extends Sprite {

  private int _dx;
  private int _dy;
  private Missile[] _missiles = new Missile[10];
  private int _nextMissileIndex = 0;

  public SpaceShip() {
    super();
    this._visible = true;
    
    this.initMissiles();

    this.loadImage("images/spaceship-sprite.png");
    this.setSpriteDimensions(64, 64); 
    this._x = GameFrame.WIDTH / 2 - this._width / 2;
    this._y = GameFrame.HEIGHT - this._height;
  }

  private void initMissiles() {
    for(int i = 0; i < this._missiles.length; i++) {
      this._missiles[i] = new Missile();
    }
  }

  public void move() {
    this._x += this._dx;

    if (this._x < 0) {
      this._x = 0;
    } else if (this._x + this._width > GameFrame.WIDTH) {
      this._x = GameFrame.WIDTH - this._width;
    }

    this._y += this._dy;

    if (this._y < 0) {
      this._y = 0;
    } else if (this._y + this._height > GameFrame.HEIGHT) {
      this._y = GameFrame.HEIGHT - this._height;
    }

  }

  public void fire() {
    this._missiles[this._nextMissileIndex]._visible = true;
    this._missiles[this._nextMissileIndex]._x = this._x + this._width / 2 - 3;
    this._missiles[this._nextMissileIndex]._y = this._y;

    if (this._nextMissileIndex < this._missiles.length - 1) {
      this._nextMissileIndex += 1;
    } else {
      this._nextMissileIndex = 0;
    }
  }

  public Missile[] getMissiles() {
    return this._missiles;
  }

  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_SPACE) {
      this.fire();
    }

    if (key == KeyEvent.VK_LEFT) {
      this._dx = -3;
    }

    if (key == KeyEvent.VK_RIGHT) {
      this._dx = 3;
    }

    if (key == KeyEvent.VK_UP) {
      this._dy = -3;
    }

    if (key == KeyEvent.VK_DOWN) {
      this._dy = 3;
    }
  }

  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
      this._dx = 0;
    }

    if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
      this._dy = 0;
    }
  }
}
