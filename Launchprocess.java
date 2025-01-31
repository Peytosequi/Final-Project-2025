
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Launchprocess{
 
private static boolean stopCountdown = false;

    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Countdown Timer");
        JLabel label = new JLabel("Time Remaining: 10", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(40f));
        frame.add(label);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // KeyListener to detect the spacebar press
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    stopCountdown = true;
                    label.setText("Countdown Stopped!");
                }
            }
        });
        frame.addKeyListener(new KeyAdapter() {
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
