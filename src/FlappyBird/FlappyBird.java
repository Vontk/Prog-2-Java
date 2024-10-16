package FlappyBird;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {

    int boardHeight = 640;
    int boardWidth = 360;

    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    int birdX = boardWidth/7;
    int birdY = boardHeight/2;
    int birdHeight = 24*2;
    int birdWidth = 34*2;

    //game variables

    Timer gameLoop;
    Timer placePipeTimer;
    Bird bird;
    int velocityX = -3;
    int velocityY = 0;
    int gravity = 1;
    boolean gameOver = false;
    double score = 0;
    int score_1 = 0;
    int score_2 = 0;

    //pipes

    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;
    int openingSpace = boardHeight/3;

    class Bird{
        int x = birdX;
        int y = birdY;
        int height = birdHeight;
        int width = birdWidth;
        Image img;

        Bird(Image img){
            this.img = img;
        }
    }

    class Pipe{
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false;
        public Pipe(Image Img){
            img = Img;
        }
    }

    ArrayList<Pipe> pipes;
    Random random = new Random();

    FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //bird
        bird = new Bird(birdImg);
        //pipes
        pipes = new ArrayList<Pipe>();
        //game timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
        //pipes timer
        placePipeTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipeTimer.start();
    }

    public void placePipes(){
        int randomPipeY = (int) (pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y +pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // render background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, this);
        // render bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, this);
        // render pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }
        // render score
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        if (gameOver){
            g.drawString("SKILL ISSUE, score :" + String.valueOf(score_1) + "/" + String.valueOf(score_2), 20, 20);
        } else {
            g.drawString(String.valueOf(score_1) + "/" + String.valueOf(score_2), 20, 20);
        }
    }

    public void move() {
        // bird movement
        velocityY += gravity;
        bird.y += velocityY;
        // celling and floor
        bird.y = Math.max(bird.y, 0);
        bird.y = Math.min(bird.y, boardHeight - birdHeight);
        // pipe movement
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;
            if (!pipe.passed && pipe.x + pipe.width < bird.x){
                pipe.passed = true;
                score += 0.5;
            }
            if (collision(bird, pipe)){
                gameOver = true;
            }
        }
        // falloff gameOver
        if (bird.y >= boardHeight - birdHeight) {
            gameOver = true;
        }
        if (score >= 9){
            score_1 = 9;
            score_2 = (int) (score - 9);
        } else {
            score_1 = (int) score;
        }
    }

    public boolean collision(Bird bird, Pipe pipe){
        return bird.x < pipe.x + pipe.width && //esquina superior izq del bird no toca la esquina superior dcha de pipe
               bird.x + bird.width > pipe.x && //esquina superior dcha del bird no toca la esquina superior izq de pipe
               bird.y < pipe.y + pipe.height && //esquina superior izq del bird no toca la esquina inferior izq de pipe
               bird.y + bird.height > pipe.y; //la esquina inferior izquierda pasa la esquina superior izq de pipe
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }
    @Override // cada vez que se apreta una tecla, se ejecuta la funcion.
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -12;
        }
        if (gameOver){
            // reset variables
            bird.y = birdY;
            velocityY = 0;
            pipes.clear();
            score = 0;
            gameOver = false;
            gameLoop.start();
            placePipeTimer.start();
        }

    }

    // metodos de keyListener no usados (tienen que estar implementados si o si)

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
