package edu.escuelaing.arep.taller3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class InvokeMain {
    public static void main(String... args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> c = Class.forName(args[0]); //bussca la clase de los parametros
            Class[] argTypes = new Class[] { String[].class }; //se crea la clase que representa al arreglo de cadenas
            Method main = c.getDeclaredMethod("printMembers", argTypes);//se busca el metodo main, por nombre y los parametros en tipo clase.
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length); //copia los argumentos
            System.out.format("invoking %s.main()%n", c.getName());
            main.invoke(null, (Object) mainArgs); //ejecuta unicamente metodos estaticos
            // production code should handle these exceptions more gracefully
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
