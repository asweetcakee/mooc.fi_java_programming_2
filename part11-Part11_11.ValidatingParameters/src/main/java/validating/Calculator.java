package validating;

import java.util.stream.IntStream;

public class Calculator {

    public int factorial(int num) throws IllegalArgumentException{
        
        if (num < 0){
            throw new IllegalArgumentException("Factorial cannot take negative values.");
        }
        
        int answer = 1;
//        for (int i = 1; i <= num; i++) {
//            answer *= i;
//        }
        answer = IntStream.range(1, num)
                .reduce(1, (a, b) -> a * b);
        
        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) throws IllegalArgumentException{
        
        if (setSize < 0 || subsetSize < 0){
            throw new IllegalArgumentException("setSize and subsetSize cannot be negative.");
        }
        
        if (subsetSize > setSize){
            throw new IllegalArgumentException("subsetSize cannot exceed setSize.");
        }
        
        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
