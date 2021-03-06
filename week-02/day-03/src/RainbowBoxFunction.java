import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
  public static void mainDraw(Graphics graphics) {

    // Create a square drawing function that takes 2 parameters:
    // The square size, and the fill color,
    // and draws a square of that size and color to the center of the canvas.
    // Create a loop that fills the canvas with rainbow colored squares.

    int squareSize = 10;
    int squareIncreaseNumber = 10;
    Random randomColor = new Random();

    while(squareSize < WIDTH) {
      Color color = new Color(randomColor.nextInt(255), randomColor.nextInt(255), randomColor.nextInt(255));
      drawingSquare(graphics, squareSize, color);
      squareSize += squareIncreaseNumber;
    }
  }

  public static void drawingSquare(Graphics graphics, int squareSize, Color fillColor) {
    graphics.setColor(fillColor);
    graphics.drawRect(HEIGHT / 2 - (squareSize / 2), WIDTH / 2 - (squareSize / 2), squareSize, squareSize);
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 343;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setSize(new Dimension(WIDTH, HEIGHT));
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    jFrame.add(new ImagePanel());
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}