package guru.springframework.spring5webapp.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mahdi Sharifi
 * @version 1.0.1
 * https://www.linkedin.com/in/mahdisharifi/
 * @since 10/16/2021
 */

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    /**
     * There is a mappedBy element on the @OneToOne, @OneToMany, and @ManyToMany annotations, but not on the
     * @ManyToOne annotation. You cannot have a mappedBy attribute on both sides of a bidirectional association.
     * It would also be incorrect to not have it on either side as the provider would treat it as two independent unidirectional
     * relationships. This would imply that each side is the owner and can define a join column.
     *
     * - The mappedBy element should be specified in the @OneToOne annotation in the
     *   entity that does not define a join column, or the inverse side of the relationship
     * */
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books=new HashSet<>();

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
