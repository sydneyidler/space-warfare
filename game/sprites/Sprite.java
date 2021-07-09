package game.sprites;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite {

  protected int _x;
  protected int _y;
  protected int _width;
  protected int _height;
  protected boolean _visible;
  protected Image _image;

  protected void loadImage(String imagePath) {
    ImageIcon ii = new ImageIcon(imagePath);
    this._image = ii.getImage();
  }

  public Image getImage() {
    return this._image;
  }

  public int getX() {
    return this._x;
  } 

  public int getY() {
    return this._y;
  }

  public int getWidth() {
    return this._width;
  }

  public int getHeight() {
    return this._height;
  }

  public void setSpriteDimensions(int width, int height) {
    this._width = width;
    this._height = height;
  }

  public boolean isVisible() {
    return this._visible;
  }

  public void setVisible(boolean visible) {
    this._visible = visible;
  }

}
