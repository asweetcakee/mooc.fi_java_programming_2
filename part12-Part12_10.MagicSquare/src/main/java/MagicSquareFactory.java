
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        // 0 2  x       y
        // 4 3  x + 4   y + 1
        // 3 4  x - 1   y + 1
        // 2 0  x - 1   y - 4
        // 1 1  x - 1   y + 1
        // collided with 0 2
        // place below 1 1
        // 2 1  x + 1   y
        // 1 2  x - 1   y + 1
        // 0 3  x - 1   y + 1
        // 4 4  x + 4   y + 1
        // 3 0  x - 1   y - 4
        // collided with 2 1
        // place below 3 0
        // 4 0  x + 1   y
        // 3 1  x - 1   y + 1
        // 2 2  x - 1   y + 1
        // 1 3  x - 1   y + 1
        // 0 4  x - 1   y + 1
        // collided with 4 0
        // place below 0 4
        // 1 4  x + 1   y
        // 0 0  x - 1   y - 4
        // 4 1  x + 4   y + 1
        // 3 2  x - 1   y + 1
        // 2 3  x - 1   y + 1
        // collided with 1 4
        // place below 2 3
        // 3 3  x + 1   y
        // 2 4  x - 1   y + 1
        // 1 0  x - 1   y - 4
        // 0 1  x - 1   y + 1
        // 4 2  x + 4   y + 1
        // collided with 3 3
        // place below 4 2
        // collided with 0 2
        // place below 0 2
        // collided with 1 2
        // place below 1 2
        // collided with 2 2
        // place below 2 2
        // collided with 3 2
        // place below 3 2
        // collided with 4 2
        // finished
        // first value
        
        int x = 0;
        int y = size / 2;
        // Put the first value
        square.placeValue(y, x, 1);

        for (int val = 2; val <= size * size; val++) {
            int tempX = x;
            int tempY = y;
            System.out.println("-IT: " + (val - 2));
            System.out.println("-[xB, yB]:[" + x + ", " + y + "]");
            x = x - 1;
            y = y + 1;
            System.out.println("-[xA, yA]:[" + x + ", " + y + "]");
            
            if (x < 0) {
                System.out.println("-if (x:" + x + " < 0)");
                x = size - 1;
                System.out.println("-[x, y]:[" + x + ", " + y + "]");
            }

            if (y > size - 1) {
                System.out.println("-if (y:" + y + " > " + (size - 1) + ")");
                y = 0;
                System.out.println("-[x, y]:[" + x + ", " + y + "]");
            }

            if (square.readValue(y, x) != 0) {
                System.out.println("Val at [" + x + ", " + y + "] = " + square.readValue(y, x));
                System.out.println("Going down! [x, y]:[" + x + ", " + y + "]");
                x = tempX + 1;
                y = tempY;
                System.out.println("Now! [x, y]:[" + x + ", " + y + "]");
            }
            square.placeValue(y, x, val);
            System.out.println("Put (" + val + ") at [x, y]:[" + x + ", " + y + "]\n");
            System.out.println(square.toString());
            
        }
        System.out.println("Col: " + square.sumsOfColumns());
        System.out.println("Row: " + square.sumsOfRows());
        System.out.println("Diag: " + square.sumsOfDiagonals());
        /*
        * 
        it 0
        0 2  x y
        x = -1
        y = 3
        if -> x = 4
        put: [4, 3] = 2
        
        it 1
        4 3  x y
        x = 3
        y = 4
        put: [3, 4] = 3
        
        it 2
        3 4  x y
        x = 2
        y = 5
        if -> y = 0
        put: [2, 0] = 4
        
        it 3
        2 0  x y
        x = 1
        y = 1
        put: [1, 1] = 5
        
        it 4
        1 1  x y
        x = 0
        y = 2
        if -> x = 1
        put: [1, 2] = 6
        * 
         */
        

        // implement the creation of a magic square with the Siamese method algorithm here
        return square;
    }
    
    public MagicSquare createMagicSquareCleanerVer(int size) {
        MagicSquare square = new MagicSquare(size);
        
        int x = 0;
        int y = size/2;
        for (int val = 1; val <= size * size; val++){
            square.placeValue(y, x, val); // Add the first val (in the center of a square)
            // Move up-right
            int tempX = x - 1;
            int tempY = y + 1;
            
            // Wrap condition 1
            if (tempX < 0){
                tempX = size - 1;
            }
            
            // Wrap condition 2
            if (tempY > size - 1){
                tempY = 0;
            }
            
            // Collision condition. Move down.
            if (square.readValue(tempY, tempX) != 0){
                tempX = x + 1;
                tempY = y;
            }
            
            // Get updated value coordinates
            x = tempX;
            y = tempY;
        }
        System.out.println("Col: " + square.sumsOfColumns());
        System.out.println("Row: " + square.sumsOfRows());
        System.out.println("Diag: " + square.sumsOfDiagonals());
                
        return square;
    }

}
