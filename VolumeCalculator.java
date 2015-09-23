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
       System.out.println(v.calculator(3, 4, 5));
       
    }
    
    public int calculator(int x, int y, int z){
        int volume = (x*y*z);
        return volume;
    }
    
    public VolumeCalculator(){
        
        
    }
    
}