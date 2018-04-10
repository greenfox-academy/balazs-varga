package com.greenfoxacademy.bankofsimba.models;

public class BankAccount {
  private String name;
  private double balance;
  private String animalType;
  private boolean isKing;
  private boolean isGood;

  public BankAccount(String name, double balance, String animalType, boolean isKing, boolean isGood) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.isKing = isKing;
    this.isGood = isGood;
  }

  public void updateBalance() {
    if(isKing) {
      this.balance += 100;
    } else {
      this.balance += 10;
    }
  }

  public String getName() {
    return name;
  }

  public String getBalance() {
    return String.format("%.2f", balance) + " Zebra";
  }

  public String getAnimalType() {
    return animalType;
  }

  public boolean isKing() {
    return isKing;
  }

  public boolean isGood() {
    return isGood;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public void setKing(boolean king) {
    isKing = king;
  }

  public void setGood(boolean good) {
    isGood = good;
  }

  @Override
  public String toString() {
    return "BankAccount{" +
            "name='" + name + '\'' +
            ", balance='" + String.format("%.2f", balance) + " Zebra" + '\'' +
            ", animalType='" + animalType + '\'' +
            '}';
  }
}
