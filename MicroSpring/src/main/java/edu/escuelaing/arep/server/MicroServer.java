package edu.escuelaing.arep.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MicroServer {

    public static Map<String, Method> services = new HashMap<>();

    public static void main(String[] args)throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {loadComponents(args);
        System.out.println(simulateRequests("/greeting"));
        System.out.println(simulateRequests("/pi"));
        System.out.println(simulateRequests("/e"));
    }

    private static void loadComponents(String[] args) throws ClassNotFoundException {
        for (int i = 0; i < args.length; i++) {
            Class c = Class.forName(args[i]);

            if (!c.isAnnotationPresent(RestController.class)) {
                System.exit(0);
            }

            for (Method m : c.getDeclaredMethods()) {
                String path = "";
                if (m.isAnnotationPresent(GetMapping.class)) {
                    path = m.getAnnotation(GetMapping.class).value();
                    services.put(path, m);
                }

            }
        }

    }

    private static String simulateRequests(String route)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method m = services.get(route);
        String respinse = "HTTP/1.1 200 OK\r\n" +
                "Content-type: application/json\r\n"
                + "\r\n"
                + "{\"resp\":\"" + m.invoke(null, "pedro") + "\"}";
        return respinse;
    }

}
