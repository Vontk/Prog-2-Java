package Misc.FlappyBird;

// audio imorts

import javax.sound.sampled.*;
import java.io.IOException;

// graphics, utils, etc

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
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
    Image twinTowersImg;
    Image winImage;

    int birdX = boardWidth/7;
    int birdY = boardHeight/2;
    int birdHeight = 24*2;
    int birdWidth = 34*2;

    //game variables

    Timer gameLoop;
    Timer placePipeTimer;
    Bird bird;
    int velocityX = -5;
    int velocityY = 0;
    int gravity = 1;
    boolean gameOver = false;
    double score = 0;
    int score_1 = 0;
    int score_2 = 0;
    boolean twinTowersPlaced = false;
    int pipesPlaced = 0;
    boolean gameWin = false;

    //pipes

    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64; //384 pixels
    int pipeHeight = 512; //3072
    int openingSpace = boardHeight/3;

    //twin towers

    int twinWidth = 124; //
    int twinHeight = 480; //
    int twinX = boardWidth;
    int twinY = boardHeight - twinHeight;
    TwinTowers twinTowers;

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
            pipesPlaced ++;
        }
    }

    class TwinTowers{
        int x = twinX;
        int y = twinY;
        int width = twinWidth;
        int height = twinHeight;
        Image img;
        public TwinTowers(Image img){
            this.img = img;
            twinTowersPlaced = true;
        }
    }

    ArrayList<Pipe> pipes;
    Random random = new Random();

    FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        backgroundImg = new ImageIcon(getClass().getResource("./flappy-bird-bg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappy-bird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./top-pipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottom-pipe.png")).getImage();
        twinTowersImg = new ImageIcon(getClass().getResource("./twin-tower.png")).getImage();
        winImage = new ImageIcon(getClass().getResource("./win.png")).getImage();

        //bird
        bird = new Bird(birdImg);
        //pipes
        pipes = new ArrayList<>();
        //game timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
        //pipes timer
        placePipeTimer = new Timer(1700, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipeTimer.start();
    }

    public void placePipes(){
        if (pipesPlaced == 40){
            if (!twinTowersPlaced){
                placeTwinTowers();
            }
            return;
        }
        int randomPipeY = (int) (pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y +pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }

    public void placeTwinTowers(){
        this.twinTowers = new TwinTowers(twinTowersImg);
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
        // render twin towers
        if (twinTowersPlaced){
           g.drawImage(twinTowers.img, twinTowers.x, twinTowers.y, twinWidth, twinHeight, null);
        }
        if (gameWin){
            g.drawImage(winImage, 0, 0, boardWidth, boardHeight, this);
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
                playSound("pipe_passed.wav");
            }
            // crash into pipe game over
            if (collision(bird, pipe)){
                playSound("explosion.wav");
                gameOver = true;
            }
        }
        // win (crash into twin towers)
        if (twinTowersPlaced){
            if (winCollision(bird, twinTowers)){
                playSound("win.wav");
                gameWin = true;
            }
        }

        if (twinTowersPlaced){
            twinTowers.x += velocityX/4;
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
            score_2 = 0;
        }
    }

    public boolean collision(Bird bird, Pipe pipe){
        return bird.x < pipe.x + pipe.width && //Esquina superior izq. Del bird no toca la esquina superior dcha. De pipe
               bird.x + bird.width > pipe.x && //Esquina superior dcha. Del bird no toca la esquina superior izq. De pipe
               bird.y < pipe.y + pipe.height && //esquina superior izq del bird no toca la esquina inferior izq de pipe
               bird.y + bird.height > pipe.y; //la esquina inferior izquierda pasa la esquina superior izq de pipe
    }

    public boolean winCollision(Bird bd, TwinTowers tt){
        return bd.x < tt.x + tt.width &&
                bd.x + bd.width > tt.x &&
                bd.y < tt.y + tt.height &&
                bd.y + bd.height > tt.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
        if (gameWin) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }
    @Override // cada vez que se aprieta una tecla, se ejecuta la funcion.
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocityY = -12;
            playSound("flap.wav");
        }
        if (gameOver){
            // reset variables
            bird.y = birdY;
            velocityY = 0;
            pipes.clear();
            score = 0;
            gameOver = false;
            twinTowersPlaced = false;
            pipesPlaced = 0;
            gameLoop.start();
            placePipeTimer.start();
            twinTowersPlaced = false;
            gameWin = false;
        }
        if (gameWin){
            // reset variables
            bird.y = birdY;
            velocityY = 0;
            pipes.clear();
            score = 0;
            gameOver = false;
            twinTowersPlaced = false;
            pipesPlaced = 0;
            gameLoop.start();
            placePipeTimer.start();
            twinTowersPlaced = false;
            gameWin = false;
        }

    }

    // metodo que reproduce un audio

    public void playSound(String soundFileName) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream("./" + soundFileName);
            if (audioSrc == null) {
                System.out.println("Sound file not found: " + soundFileName);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioSrc);
            AudioFormat baseFormat = audioInputStream.getFormat();
            AudioFormat decodedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );

            AudioInputStream decodedAudioStream = AudioSystem.getAudioInputStream(decodedFormat, audioInputStream);
            Clip clip = AudioSystem.getClip();
            clip.open(decodedAudioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }



    // metodos de keyListener no usados (tienen que estar implementados si o si)

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
