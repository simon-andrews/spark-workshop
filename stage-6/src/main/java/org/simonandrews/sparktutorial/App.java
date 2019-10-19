package org.simonandrews.sparktutorial;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    get("/", (req, res) -> {
      Map<String, Object> emptyModel = new HashMap<>();
      return new ModelAndView(emptyModel, "form.vtl");
    }, new VelocityTemplateEngine());
    post("/", (req, res) -> {
      String op = req.queryParams("op");
      Double n = Double.parseDouble(req.queryParams("n"));
      Double m = Double.parseDouble(req.queryParams("m"));
      Double r;
      switch (op) {
        case "plus":  r = n + m; break;
        case "minus": r = n - m; break;
        case "times": r = n * m; break;
        case "div":   r = n / m; break;
        default:      throw new Exception("oops");
      }
      Map<String, Object> model = new HashMap<>();
      model.put("n", n); model.put("m", m);
      model.put("op", op); model.put("result", r);
      return new ModelAndView(model, "result.vtl");
    }, new VelocityTemplateEngine());
  }
}
