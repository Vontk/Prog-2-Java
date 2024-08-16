import java.util.ArrayList;

public class LinearSystem {
    private final float a1;
    private final float a2;
    private final float b1;
    private final float b2;
    private final float c1;
    private final float c2;
    private final float det;
    public LinearSystem(float a1, float a2, float b1, float b2, float c1, float c2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.c1 = c1;
        this.c2 = c2;
        this.det = a1 * b2 - a2 * b1;
    }
    public ArrayList<Float> solution() {
        ArrayList<Float> solution = new ArrayList<>();
        if (det != 0) {
            Float x = (c1*b2 - c2*b1)/det;
            Float y = (c1*a2 - c2*a1)/det;
            solution.add(x);
            solution.add(y);
            return solution;
        }
        return solution;
    }
}
