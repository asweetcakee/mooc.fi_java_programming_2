
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        LicensePlate compared = (LicensePlate) obj;
        return compared.liNumber.equals(this.liNumber) &&
                compared.country.equals(this.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.liNumber, this.country);
    }    

}
