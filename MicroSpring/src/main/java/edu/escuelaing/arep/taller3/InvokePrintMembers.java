package edu.escuelaing.arep.taller3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

public class InvokePrintMembers {
    public static void main(String... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> c = Class.forName(args[0]); //bussca la clase de los parametros

            Class[] argTypes = new Class[] { Member[].class, String.class }; //se crea la clase que representa al arreglo de cadenas

            Method m = c.getDeclaredMethod("printMembers", argTypes);//se busca el metodo main, por nombre y los parametros en tipo clase.

            Class listClass = LinkedList.class; //copia los argumentos

            System.out.format("invoking %s.printMembers())%n", m.getName());

            m.invoke(null, listClass.getDeclaredFields(), "Fields"); //ejecuta unicamente metodos estaticos
            // production code should handle these exceptions more gracefully
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
