import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import java.util.HashMap;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        String main = "templates/main.hbs";


        // Main Page
        get("/", (request, response) ->{
            return new ModelAndView(new HashMap(), "main.hbs");
        } , new HandlebarsTemplateEngine());

        //Nav Section
        get("/nav", (request, response) ->{
            return new ModelAndView(new HashMap(), "nav.hbs");
        } , new HandlebarsTemplateEngine());

        //stores
        get("/stores", (request, response) ->{
            return new ModelAndView(new HashMap(), "stores.hbs");
        } , new HandlebarsTemplateEngine());

        //items
        get("/items", (request, response) ->{
            return new ModelAndView(new HashMap(), "items.hbs");
        } , new HandlebarsTemplateEngine());





    }
}