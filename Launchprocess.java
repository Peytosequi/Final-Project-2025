 
import java.awt.event.*;
import javax.swing.*;


public class Launchprocess{
 
private static boolean stopCountdown = false;
        private static JFrame MyFrame = new JFrame("countdown timer");
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example");  
        JButton b=new JButton("Click Here");  
        b.setBounds(50,100,95,30);
    b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            Launchprocess.Countdown();   
                }  
            });  
            f.add(b,SwingConstants.CENTER);  
            f.setSize(400,400);  
            f.setLayout(null);  
            f.setVisible(true); 


    }
   



        // Setup JFrame for displaying the countdown
    public static void Countdown () {

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
