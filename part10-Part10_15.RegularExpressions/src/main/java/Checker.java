

public class Checker {
    private final String REGEX_WEEK = "mon|tue|wed|thu|fri|sat|sun"; 
    private final String REGEX_VOWELS = "(a|e|i|o|u)*";
    private final String REGEX_DAY = "(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
    

    public boolean isDayOfWeek(String string){
        return string.matches(this.REGEX_WEEK);
    }
    
    public boolean allVowels(String string){
        return string.matches(this.REGEX_VOWELS);
    }
    
    public boolean timeOfDay(String string){
        return string.matches(this.REGEX_DAY);
    }
}
