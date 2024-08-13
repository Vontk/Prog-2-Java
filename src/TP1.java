/* ya creada la clase, creamos nuestro main (donde se corre el codigo y llamamos a nuestros objetos y metodos */
public class TP1 {
    public static void main(String[] args) {
        Quadratic polynomial_object = new Quadratic(1, 0, 20);
        Object polynomial_roots = polynomial_object.roots();
        System.out.println(polynomial_roots);
    }
}