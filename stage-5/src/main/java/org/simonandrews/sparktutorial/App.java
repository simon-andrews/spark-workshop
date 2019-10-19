package org.simonandrews.sparktutorial;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String form = "<form action=\"/\" method=\"POST\">" +
                  "n: <input type=\"number\" step=\"any\" name=\"n\" /> <br />" +
                  "op:" +
                  "<select name=\"op\">" +
                     "<option value=\"plus\">+</option>" +
                     "<option value=\"minus\">-</option>" +
                     "<option value=\"times\">*</option>" +
                     "<option value=\"div\">/</option>" +
                  "</select>" +
                  "<br />" +
                  "m: <input type=\"number\" step=\"any\" name=\"m\" /> <br />" +
                  "<input type=\"submit\" value=\"Go!\" />" +
                  "</form>";
    get("/", (req, res) -> form);
    post("/", (req, res) -> {
      double n = Double.parseDouble(req.queryParams("n"));
      double m = Double.parseDouble(req.queryParams("m"));
      switch (req.queryParams("op")) {
        case "plus":  return String.valueOf(n + m);
        case "minus": return String.valueOf(n - m);
        case "times": return String.valueOf(n * m);
        case "div":   return String.valueOf(n / m);
        default:      return "oops!";
      }
    });
  }
}
