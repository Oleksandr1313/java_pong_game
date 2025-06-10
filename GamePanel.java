import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Bat bat1 = new Bat(50, 250);
    private Bat bat2 = new Bat(740, 250);
    private Ball ball = new Ball(390, 290);

    private boolean bat1Up = false;
    private boolean bat1Down = false;
    private boolean bat2Up = false;
    private boolean bat2Down = false;

    private int bat1Score = 0;
    private int bat2Score = 0;

    private boolean gameOver = false;
    private String winner = "";

    private Timer timer;

    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Player 1: " + bat1Score, 100, 30);
        g.drawString("Player 2: " + bat2Score, 550, 30);

        g.fillRect(bat1.getX(), bat1.getY(), bat1.getWidth(), bat1.getHeight());
        g.fillRect(bat2.getX(), bat2.getY(), bat2.getWidth(), bat2.getHeight());
        g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString(winner + " wins! Press 'R' to restart", 140, 250);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            repaint();
            return;
        }

        if (bat1Up) {
            bat1.moveUp();
        } 
            
        else if (bat1Down) {
            bat1.moveDown(getHeight());
        }

        if (bat2Up) {
            bat2.moveUp();
        } 
            
        else if (bat2Down) {
            bat2.moveDown(getHeight());
        }

        ball.move();

        if (ball.getY() <= 0 || ball.getBottom() >= getHeight()) {
            ball.bounceY();
        }

        if (ball.getX() <= bat1.getX() + bat1.getWidth()) {
            if (ball.getY() + ball.getDiameter() >= bat1.getY() && ball.getY() <= bat1.getBottom()) {
                ball.bounceX();
            }
        }
            
        else if (ball.getX() + ball.getDiameter() >= bat2.getX()) {
            if (ball.getY() + ball.getDiameter() >= bat2.getY() && ball.getY() <= bat2.getBottom()) {
                ball.bounceX();
            }
        }

        if (ball.getX() < 0) {
            bat2Score++;
            ball.resetPosition(390, 290);
        } 
            
        else if (ball.getX() > getWidth()) {
            bat1Score++;
            ball.resetPosition(390, 290);
        }

        if (bat1Score == 5) {
            gameOver = true;
            winner = "Player 1";
        } 
            
        else if (bat2Score == 5) {
            gameOver = true;
            winner = "Player 2";
        }

        repaint();
    }

    private void resetGame() {
        bat1Score = 0;
        bat2Score = 0;
        gameOver = false;
        winner = "";
        bat1 = new Bat(50, 250);
        bat2 = new Bat(740, 250);
        ball = new Ball(390, 290);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            bat1Up = true;
        } 
            
        else if (key == KeyEvent.VK_S) {
            bat1Down = true;
        } 
            
        else if (key == KeyEvent.VK_UP) {
            bat2Up = true;
        } 
            
        else if (key == KeyEvent.VK_DOWN) {
            bat2Down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            bat1Up = false;
        }
        else if (key == KeyEvent.VK_S) {
            bat1Down = false;
        } 
        else if (key == KeyEvent.VK_UP) {
            bat2Up = false;
        } 
        else if (key == KeyEvent.VK_DOWN) {
            bat2Down = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();

        if (key == 'q' || key == 'Q') {
            System.exit(0);
        } 
        else if (key == 'r' || key == 'R') {
            resetGame();
        }
    }
}
