
public class Program {

    public static void main(String[] args) {
        //Testaa sanakirjaa täällä
        DictionaryOfManyTranslations d = new DictionaryOfManyTranslations();
        d.add("monkey","apina");
        d.add("monkey","apfe");
        d.add("cheese","juusto");
        //d.remove("monkey");
        d.add("milk","maito");
        System.out.println(d.translate("monkey"));
        System.out.println(d.translate("cheese"));
        System.out.println(d.translate("milk"));
        d.remove("milk");
        
        
    }
}
