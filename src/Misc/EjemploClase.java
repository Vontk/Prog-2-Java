package Misc;

public class EjemploClase {
    private final int constante;
    private String porDefecto;
    private int enConstructor;

    public EjemploClase(int constante, int enConstructor) {
        this.porDefecto = "Valor por defecto";
        this.constante = constante;
        enConstructor = constante + enConstructor;
        this.enConstructor = enConstructor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null || this.getClass() != obj.getClass()) return false;
        EjemploClase that = (EjemploClase) obj;
        return constante == that.constante &&
                enConstructor == that.enConstructor &&
                porDefecto.equals(that.porDefecto);
    }

    public static void main(String[] args) {
        EjemploClase ejemplo1 = new EjemploClase(10, 20);
        EjemploClase ejemplo2 = new EjemploClase(10, 20);
        EjemploClase ejemplo3 = new EjemploClase(15, 25);

        System.out.println("ejemplo1.equals(ejemplo2): " + ejemplo1.equals(ejemplo2)); // true
        System.out.println("ejemplo1.equals(ejemplo3): " + ejemplo1.equals(ejemplo3)); // false
    }
}
