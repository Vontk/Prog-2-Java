package TP1;

/* ya creada la clase, creamos nuestro main (donde se corre el codigo y llamamos a nuestros objetos y metodos */
public class TP1 {
    public static void main(String[] args) {
        Quadratic polynomial_object = new Quadratic(1, 0, 20);
        Object polynomial_roots = polynomial_object.roots();
        System.out.println(polynomial_roots);
        Cars ferrari_tributo = new Cars("ferrari", "f8 tributo", 2020);
        System.out.println(ferrari_tributo.get_descriptive_name());
        ferrari_tributo.increment_odometer(30);
        System.out.println(ferrari_tributo.read_odometer());
        ferrari_tributo.update_odometer(10);
        System.out.println(ferrari_tributo.read_odometer());
        ferrari_tributo.update_odometer(90);
        System.out.println(ferrari_tributo.read_odometer());
    }
}