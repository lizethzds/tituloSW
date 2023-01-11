package mx.uv;

import static spark.Spark.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;


public class App 
{

   
    public static void main( String[] args )
    {
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        System.out.println("...");



        JsonParser parser = new JsonParser();
        JsonElement arbol = parser.parse(req.body());
        JsonObject peticionDelCliente = arbol.getAsJsonObject();
        System.out.println(peticionDelCliente.get("nombre"));
        System.out.println(peticionDelCliente.get("correo"));
        System.out.println(peticionDelCliente.get("edad"));

        String user = peticionDelCliente.get("nombre").getAsString();

    }
}
