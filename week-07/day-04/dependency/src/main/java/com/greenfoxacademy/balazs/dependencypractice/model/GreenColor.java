package com.greenfoxacademy.balazs.dependencypractice.model;

public class GreenColor implements MyColor{
  @Override
  public void printColor() {
    System.out.println("This is a green color...");
  }
}
