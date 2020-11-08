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
    private double grades[]={10.5, 12, 14.5};
    private String ucs[]={"FP","POO","BD"};

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

    @GetMapping(path = "/access/{student}/{covid}",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent, @PathVariable("covid") boolean hasCovid){
        if(isStudent && !hasCovid){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping(path= "/required/{student}/{temperature}/{classType}",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent,
                                @PathVariable("temperature") double hasCovid,
                                @PathVariable("classType") String type){
        if(isStudent && type.equals("presential") && (hasCovid >= 34.5 && hasCovid <= 37.5)) {
            return true;
        }else{
            return false;
        }
    }

    @GetMapping(path= "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}/",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public boolean getSignature(@PathVariable("fire") boolean isFire,
                                @PathVariable("numberOfCovids") int covidNumbers,
                                @PathVariable("powerShutdown") boolean power,
                                @PathVariable("comeBackTime") int time){
        if( isFire || (covidNumbers>5) || (power && time>15 )){
            return true;
        }else{
            return false;
        }
    }
    
  /*  @getMapping(path="/avarage/{}", produces= MediaType.APPLICATION_JSON_VALUE)
    public double getAvarage(){

    }*/

}