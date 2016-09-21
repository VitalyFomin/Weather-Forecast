package app.controller;

import org.apache.http.client.fluent.Request;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Vitaly on 21.09.16.
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String getWeather() throws IOException {

        String uri = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=e10477ee8c6414b5367936d9ad97375e";
        String response = Request.Get(uri)
                .execute()
                .returnContent()
                .asString();


        return "greeting";
    }
}
