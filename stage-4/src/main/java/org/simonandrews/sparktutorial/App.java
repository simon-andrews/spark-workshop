package org.simonandrews.sparktutorial;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    get("/", (req, res) ->
        "You did a GET!" +
        "<form action=\"/\" method=\"POST\">" +
        "<input type=\"submit\" value=\"Now POST!\"/>" +
        "</form>");
    post("/", (req, res) -> "You did a POST!");
  }
}
