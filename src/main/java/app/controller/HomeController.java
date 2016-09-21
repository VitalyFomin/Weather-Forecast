package app.controller;

import app.entity.Main;
import app.entity.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Vitaly on 21.09.16.
 */
@RestController
@RequestMapping(value = "api")
public class HomeController {

    static Gson gson = new Gson();

    @RequestMapping(value = "weather", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void getWeather(@RequestParam(value = "city") String city, Model model) throws IOException {

        String uri = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=e10477ee8c6414b5367936d9ad97375e";
        String responseJson = Request.Get(uri)
                .execute()
                .returnContent()
                .asString();

        Response response = gson.fromJson(responseJson, Response.class);

        model.addAttribute("temp", response.getMain().getTemp());
        model.addAttribute("pressure", response.getMain().getPressure());
        model.addAttribute("humidity", response.getMain().getHumidity());
    }
}
