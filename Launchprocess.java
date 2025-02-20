

public class Launchprocess {
   
    
   public static int i;
    public  void startlaunch() {

   for (int i = 10; i >= 0; i--) {
    System.out.println(i);
    try {
        Thread.sleep(1000); // Delay of 1 second
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}



}
}



        
    




    
    


 


