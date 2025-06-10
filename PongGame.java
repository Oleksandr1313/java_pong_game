import javax.swing.JFrame;

public class PongGame {
    public static void main(String[] args){
        JFrame frame = new JFrame("Pong Game");
        GamePanel panel = new GamePanel();

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(true);
    }
}
