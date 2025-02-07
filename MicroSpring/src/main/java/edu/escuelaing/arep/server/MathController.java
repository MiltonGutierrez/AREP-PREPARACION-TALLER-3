package edu.escuelaing.arep.server;


@RestController
public class MathController {

    @GetMapping("/e")
    public static String e(@RequestParam(value = "e", defaultValue = "val")String notUsed){
        return Double.toString(Math.E);
    }
    
}
