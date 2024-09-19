package FlappyBird;

import java.awt.Graphics;
import java.awt.Color;

public class Bird {
    private int x, y, width, height, yVelocity;

    public Bird() {
        x = 100;
        y = 100;
        width = 20;
        height = 20;
        yVelocity = 0;
    }

    public void update() {
        y += yVelocity;
        yVelocity += 1; // Gravity effect
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void flap() {
        yVelocity = -10; // Move up when flapping
    }
}
