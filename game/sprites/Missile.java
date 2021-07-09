package game.sprites;

public class Missile extends Sprite {

  private static final int MISSILE_SPEED = 4;

  public Missile() {
    super();

    this.loadImage("images/missile.png");
    this.setSpriteDimensions(16, 16);
  }

  public void move() {
    this._y -= Missile.MISSILE_SPEED;

    if (this._y < 0) {
      this._visible = false;
    }
  }
}