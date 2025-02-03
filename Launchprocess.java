
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class Launchprocess{
 
private static boolean stopCountdown = false;
 private static JFrame MyFrame;
    public static void main(String[] args) {
       Launchprocess launchprocess = new Launchprocess();
Launchprocess.Countdown();
    }
   



        // Setup JFrame for displaying the countdown
    public static void Countdown () {
        JFrame MyFrame = new JFrame("Countdown Timer");
        JLabel label = new JLabel("Time Remaining: 10", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(40f));
        MyFrame.add(label);
        MyFrame.setSize(400, 200);
        MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyFrame.setVisible(true);
  
        // KeyListener to detect the spacebar press
        MyFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    stopCountdown = true;
                    label.setText("Countdown Stopped!");
                }
            }
        });
        MyFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent aKeyEvent) {
                if (aKeyEvent.getKeyCode() == KeyEvent.VK_SHIFT) {
                    stopCountdown = false;

             

        // Start the countdown in a separate thread
        if (!stopCountdown) {
        Thread countdownThread = new Thread(() -> {
            int timeRemaining = 10;
            while (timeRemaining > 0 && !stopCountdown) {
                label.setText("Time Remaining: " + timeRemaining);
                try {
                    Thread.sleep(1000);  // Wait for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                timeRemaining--;
            }
        
            if (timeRemaining == 0 && !stopCountdown) {
                label.setText("Time's up!");
            }
        });

        countdownThread.start();
    
        }
    }
}
});
    }
}
