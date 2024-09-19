public class EjemploClase {
    // Variable final, su valor no puede cambiar una vez asignado
    private final int constante;

    // Variable por defecto, se inicializa con un valor predeterminado
    private String porDefecto = "Valor por defecto";

    // Variable que se define en el constructor
    private int enConstructor;

    // Constructor de la clase
    public EjemploClase(int constante, int enConstructor) {
        this.constante = constante;
        enConstructor = constante + enConstructor;
        this.enConstructor = enConstructor;
    }

    // Métod para mostrar los valores de las variables
    public void mostrarValores() {
        System.out.println("Constante: " + constante);
        System.out.println("Por defecto: " + porDefecto);
        System.out.println("En constructor: " + enConstructor);
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase
        EjemploClase ejemplo = new EjemploClase(10, 20);
        // Mostrar los valores de las variables
        ejemplo.mostrarValores();
    }
}
