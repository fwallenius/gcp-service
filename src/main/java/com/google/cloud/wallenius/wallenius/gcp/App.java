package com.google.cloud.wallenius.wallenius.gcp;

import com.google.cloud.wallenius.wallenius.gcp.beans.HealthCheck;
import com.google.cloud.wallenius.wallenius.gcp.beans.SillyBean;
import com.google.cloud.wallenius.wallenius.gcp.httpclient.SimpleHttpClient;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.Random;
import static spark.Spark.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * mvn exec:java -Dexec.mainClass="com.google.cloud.wallenius.wallenius.gcp.App"
 *
 * @author wallenius
 */
public class App {

    private final static Logger logger = LoggerFactory.getLogger(App.class);
    private static Integer ID;
    private final static Long STARTTIME = System.currentTimeMillis();
    

    public static void main(String[] args) throws IOException {
        
        BaseEndpoints endPoints = new BaseEndpoints(new SimpleHttpClient());
        PrimeHelper primeHelper = new PrimeHelper();
        Gson gson = new Gson();
        
        ID = new Random().nextInt(1000);

        port(8080);
        get("/hello", (req, res) -> endPoints.getIt(), gson::toJson);
        get("/nextPrimes", (req, res) -> 
                primeHelper.findNextPrimes(parseIntOrSetToDefault(req.queryParams("startValue")), 100), gson::toJson);
        get("/metadata", (req, res) -> endPoints.instanceMetadata(), gson::toJson);
        
        get("/healthcheck", (req, res) -> new HealthCheck(ID, System.currentTimeMillis() - STARTTIME)  , gson::toJson);
        
        after((request, response) -> {
            response.header("Content-Type", "application/json;charset=utf-8");
        });

        exception(JsonSyntaxException.class, (e, request, response) -> {
            
            logger.error("Caught a JsonSyntaxException", e);
            
            response.status(400);
            response.body(gson.toJson("Could not parse JSON"));
        });
    }
    
    private static Integer parseIntOrSetToDefault(String input) {
        try {
            return Integer.parseInt(input, 10);
        } catch (Exception e) {
            logger.debug("Could not parse int from input '" + input + "'");
            return 0;
        }
    }
}
