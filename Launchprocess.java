

public class Launchprocess extends Main  {
   
    
   public static int i;
    public static void main(String[] args) {
   Astronaut a = new Astronaut();

   for (int i = 10; i >= 0; i--) {
    System.out.println(i);
    try {
        Thread.sleep(1000); // Delay of 1 second
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
System.out.println("Blast off"); 



}

}
   

        
    




    
    


 


