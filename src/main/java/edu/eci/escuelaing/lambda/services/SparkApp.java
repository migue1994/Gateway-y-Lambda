package edu.eci.escuelaing.lambda.services;

import spark.Request;
import spark.Response;
import static spark.Spark.*;

import java.util.Arrays;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * clase encargada de realizar la conexion con la pagina web por medio del framwork spark
 *
 * @author Ospina
 *
 * @version (a version 22/8/19)
 */

public class SparkApp {

    public static void main(String[] args) {
        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Square</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <br><br>\n" +
                "    <div class=\"row\" style=\"justify-content: center\">\n" +
                "        <div class=\"col-md-4\">\n" +
                "            <br>\n" +
                "            <div class=\"card\">\n" +
                "                <div class=\"card-header\"><h1 style=\"text-align: center\">Cuadrado</h1></div>\n" +
                "                <div class=\"card-body\">\n" +
                "                    <form action=\"/results\">\n" +
                "                        <div class=\"form-group\">\n" +
                "                            <div class=\"col\">\n" +
                "                                <label for=\"number\">Ingrese el valor: </label>\n" +
                "                            </div>\n" +
                "                            <div class=\"col\">\n" +
                "                                <input type=\"text\" class=\"form-control\" placeholder=\"Numero\" name=\"Valores\"><br>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"form-group\" style=\"text-align: center\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
                "                        </div>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        String num = (req.queryParams("Valores"));
        Integer newNum = 0;
        try {
            URL urlLamb = new URL("https://r6pvjm3fz4.execute-api.us-east-1.amazonaws.com/Beta?value=" + num);

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlLamb.openStream()));
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                //System.out.println(inputLine);
                newNum = Integer.parseInt(inputLine);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(SparkApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SparkApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Answer</h2>"
                + "<form action=\"/results\">"
                + "  Datos: "+num
                + "  <br>"
                + "  La potencia es: "+ newNum
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}