package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mahdi Sharifi
 * @version 2021.1.1
 * https://www.linkedin.com/in/mahdisharifi/
 * @since 10/16/2021
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;
//    It requires the
//    foreign key to be in the target table, or “many” side of the relationship, even though the target object
//    does not have any reference to the “one” side. We call this a unidirectional one-to-many target foreign
//    key mapping, because the foreign key is in the target table instead of a join table.
    /**
     * To use this mapping, we first indicate that the one-to-many relationship is unidirectional by not
     * specifying any mappedBy element in the annotation
     *
     * Pro JPA 2
     * Then we specify a @JoinColumn annotation on the one-to-many attribute to indicate the foreign key column.
     * The catch is that the join column that we are specifying applies to the table of the target object,
     * not the source object in which the annotation appears.
     * */
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books=new HashSet<>();

    public Publisher() {
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
