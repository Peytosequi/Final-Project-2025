public class Main extends Astronaut  {
    public static void main(String[] args) {
      Astronaut a = new Astronaut();
      a.inputAstronautData();
     Protect p= new Protect();
     p.PriviteFile();
     p.generateAndSavePassword();
     p.writeDataToFile();
     p.decryptAndDisplayData();

    
     

}
}
