package org.simonandrews.sparktutorial;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    get("/:n/:op/:m", (req, res) -> {
      double n = Double.parseDouble(req.params(":n"));
      double m = Double.parseDouble(req.params(":m"));
      switch (req.params(":op")) {
        case "plus":  return String.valueOf(n + m);
        case "minus": return String.valueOf(n - m);
        case "times": return String.valueOf(n * m);
        case "div":   return String.valueOf(n / m);
        default:      return "oops!";
      }
    });
  }
}
