package Controllers;

import Models.TestingModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class TestingController {

    @RequestMapping(method = RequestMethod.GET,
                    value = "/show",
                    produces = APPLICATION_JSON_VALUE)
    public TestingModel show(){
        return new TestingModel("Nicely done! It worked!");
    }
}
