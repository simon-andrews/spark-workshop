package org.simonandrews.sparktutorial;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    get("/hello/:name", (request, response) -> {
      return "Hello, " + request.params(":name");
    });
  }
}
