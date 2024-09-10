
public class Main {

    public static void main(String[] args) {
        TacoBox taco = new TripleTacoBox();
        TacoBox customTaco = new CustomTacoBox(10);
        System.out.println("Remaning tacos: " + taco.tacosRemaining() + 
                "\nRemaning custom tacos: " + customTaco.tacosRemaining());
        taco.eat();
        customTaco.eat();
        System.out.println("Remaning tacos: " + taco.tacosRemaining() + 
                "\nRemaning custom tacos: " + customTaco.tacosRemaining());
        taco.eat();
        taco.eat();
        customTaco.eat();
        customTaco.eat();
        System.out.println("Remaning tacos: " + taco.tacosRemaining() + 
                "\nRemaning custom tacos: " + customTaco.tacosRemaining());
    }
}
