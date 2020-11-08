package pt.iade.helloworldEIT1.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/java/tester")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(GreeterController.class);
    private String name;
    private int number;
    private double height;
    private boolean footballFan;
    private char color;
    private String auxLabel;

    @GetMapping(path = "/author", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor() {
        logger.info("Saying Hello to the world");
        return "Done by "+name+" with number "+number+". I am "+height+" tall and "+auxLabel;
    }

    @GetMapping(path = "{author}", 
    produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor(@PathVariable("name") String author) {
        if (!footballFan) {
            auxLabel = "not a fan of football.";
        }else{
            auxLabel = "I am a fan of football.";
        }
        logger.info("Saying Hello to"+author);
        return "Done by "+name+" with number "+number+". I am "+height+" tall and "+auxLabel;
    }
    
}