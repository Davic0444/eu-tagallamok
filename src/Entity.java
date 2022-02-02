import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Entity implements Comparable<Entity>{

    private String Country;
    private LocalDate euJoin;

    public Entity(String country, LocalDate euJoin) {
        Country = country;
        this.euJoin = euJoin;
    }

    public String getCountry() {
        return Country;
    }

    public LocalDate getEuJoin() {
        return euJoin;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "Country='" + Country + '\'' +
                ", euJoin=" + euJoin +
                '}';
    }

    @Override
    public int compareTo(Entity o) {
        if (getEuJoin() == null || o.getEuJoin() == null)
            return 0;
        return getEuJoin().compareTo(o.getEuJoin());
    }
}
