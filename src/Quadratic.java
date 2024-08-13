import java.util.ArrayList;
import java.lang.Math;

public class Quadratic {
    /* define las variables, las hace privadas (no accesible por otras clases u objetos) y finales (no modificables) */
    private final float a;
    private final float b;
    private final float c;

    /* define el constructor de Quadratic, con los 3 parametros y sus tipos de dato */
    Quadratic (float a, float b, float c) {
        /* asigna cada uno de los parametros a una variable del mismo nombre */
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /* define un metodo dentro de la clase, lo hace publico, lo llama roots(), sin parametros, y ArrayList define return */
    public Object roots() {
        /* crea una nueva variable, tipo de dato arraylist, nombre result, crea un nuevo obj. ArrLst y deja el tipo de dato vacio */
        ArrayList<Float> result = new ArrayList<>();
        float discriminant = (float) Math.pow(b, 2)  - 4 * a * c;
        if (discriminant > 0) {
            result.add((-b + (float) Math.sqrt(discriminant))/(2*a));
            result.add((-b - (float) Math.sqrt(discriminant))/(2*a));
        } else if (discriminant == 0) {
            result.add(-b/(2*a));
        } else {
            return " This polynomial has imaginary roots ";
        }
        return result;
    }
}
