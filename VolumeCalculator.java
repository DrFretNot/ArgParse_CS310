import java.util.Scanner;

/**
 *
 * @author robertwarren
 */
public class VolumeCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VolumeCalculator v = new VolumeCalculator();
        int length, width, height;
        length = Integer.parseInt(args[0]);
        width = Integer.parseInt(args[1]);
        height = Integer.parseInt(args[2]);
        System.out.println(v.calculator(length, width, height));
      /*  if (args[0] == "-h")
       {
           System.out.println(v.getHelp());
       }
       else 
       {
            //len wid hi
       } */
       
    }
    
    public int calculator(int x, int y, int z){
        int volume = (x*y*z);
        return volume;
    }
    
    private String getHelp ()
    {
        String help = "usage: java VolumeCalculator length width height\nCalculate the volume of a box.\npositional arguments: \nlength the length of the box\nwidth the width of the box\nheight the height of the box\n";
        return help;
    }
    
    public VolumeCalculator(){
        
        
    }
    
}