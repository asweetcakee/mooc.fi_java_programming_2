
public class MainProgram {

    public static void main(String[] args) {
        // test your classes here
        Person anna = new Person("Anna", Education.PHD);
        Person beca = new Person("Beca", Education.BA);
        Person lila = new Person("Lila", Education.MA);
        Person dora = new Person("Dora", Education.BA);
        
        Employees employees = new Employees();
        employees.add(anna);
        employees.add(beca);
        employees.add(lila);
        employees.add(dora);
        
        employees.print();
        System.out.println("------");
        employees.print(Education.BA);
    }
}
