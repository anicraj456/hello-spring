package org.launchcode.hellospring.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    @ResponseBody
//@RequestMapping("hello")
    public class HelloController {
        //handle request at path http://localhost:8080/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

        //handle request at path //http://localhost:8080/hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }
        //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    /*@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
       return "Hello, " + name + "!";
      }
    //handle requests of the form http://localhost:8080/hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }*/
        //handles requests for http://localhost:8080/hello/form
        @GetMapping("hello/form")
        public String helloForm() {
            return "<html>" +
                    "<body>" +
                    "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                    "<input type = 'text' name = 'name' >" +
                    "<label for='language'></label>" +
                    "<select name = 'language' >" +
                    "<option value='english'>English</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='italian'>Italian</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='german'>German</option>" +
                    "</select>" +
                    "<input type = 'submit' value = 'Greet Me!' >" +
                    "</form>" +
                    "</body>" +
                    "</html>";
        }

        @RequestMapping(value="hello", method = RequestMethod.POST)
        @ResponseBody
        public String helloPost(@RequestParam String name, @RequestParam String language) {
            if ("".equals(name) || name == null) {
                name = "World";
            }
            //System.out.println("name-------"+ name);
            //System.out.println("language-----"+ language);
            return createMessage(name, language);
        }
        public static String createMessage(String n, String l) {
            String greeting = "";

            if (l.equals("english")) {
                greeting = "Hello";
            }
            else if (l.equals("french")) {
                greeting = "Bonjour";
            }
            else if (l.equals("italian")) {
                greeting = "Bonjourno";
            }
            else if (l.equals("spanish")) {
                greeting = "Hola";
            }
            else if (l.equals("german")) {
                greeting = "Hallo";
            }
            return greeting + " " + n;
        }
    }


