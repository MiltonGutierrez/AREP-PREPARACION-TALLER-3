package edu.escuelaing.arep.server;


@RestController
public class GreetingController {
    
    @GetMapping("/greeting")
    public static String greeting(@RequestParam(value = "name", defaultValue = "world")String name) {
        return "Hola " + name;
    }

    @GetMapping("/pi")
    public static String pi(@RequestParam(value = "name", defaultValue ="pi")String name){
        return Double.toString(Math.PI);
    }
}
