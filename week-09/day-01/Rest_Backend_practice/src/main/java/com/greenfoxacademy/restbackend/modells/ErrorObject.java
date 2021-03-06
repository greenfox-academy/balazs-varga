package com.greenfoxacademy.restbackend.modells;

public class ErrorObject extends Response {

  private String error;

  public ErrorObject(String errorMessage) {
    this.error = errorMessage;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
