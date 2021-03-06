package com.company;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
  Player black = new Player();
  Player white = new Player();
  Game game = new Game();

  @Test
  public void highCardTest1() {
    black.newHand(
            new Card(2, "H"),
            new Card(3, "D"),
            new Card(5, "S"),
            new Card(9, "C"),
            new Card("K", "D"));
    white.newHand(
            new Card(2, "C"),
            new Card(3, "H"),
            new Card(4, "S"),
            new Card(8, "C"),
            new Card("A", "H"));
    Assert.assertEquals(white, game.highCard(black, white));
  }

  @Test
  public void highCardTest2() {
    black.newHand(
            new Card(5, "H"),
            new Card(2, "D"),
            new Card(6, "S"),
            new Card("J", "C"),
            new Card("Q", "D"));
    white.newHand(
            new Card(5, "C"),
            new Card(7, "H"),
            new Card(5, "S"),
            new Card(8, "C"),
            new Card(10, "H"));
    Assert.assertEquals(black, game.highCard(black, white));
  }
}