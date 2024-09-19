
import java.util.Random;

public class Die {

    private Random random;
    private int numberOfFaces;

    public Die(int numberOfFaces) {
        this.random = new Random();
        if (numberOfFaces < 3){
            throw new IllegalArgumentException("Die faces cannot be less than 3");
        }
        this.numberOfFaces = numberOfFaces;
    }

    public int throwDie() {
        
        // generate a random number which may be any number
        // between one and the number of faces, and then return it
        return this.random.nextInt((this.numberOfFaces - 1) + 1) + 1;
    }
}
