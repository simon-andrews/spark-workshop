package org.simonandrews.sparktutorial;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    get("/:n/:op/:m", (request, response) -> request.params(":n"));
  }
}
