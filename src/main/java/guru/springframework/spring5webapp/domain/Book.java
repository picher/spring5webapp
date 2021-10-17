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
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;

    @ManyToOne
    private Publisher publisher;

    /** PRO JPA 2
     * Ownership is important for mapping because the physical annotations that define the mappings to
     * the columns in the database (for example, @JoinColumn) are always defined on the owning side of the
     * relationship. If they are not there, the values are defaulted from the perspective of the attribute on the
     * owning side.
     * Many-to-one mappings are always on the owning side of a relationship, so if there is a
     * @JoinColumn to be found in the relationship that has a many-to-one side, that is where it will be located
     * @JoinColumn(name="DEPT_ID") annotation means that the DEPT_ID column in the source entity table is
     * the foreign key to the target entity table, whatever the target entity of the relationship happens to be.
     *
     * - The @JoinColumn annotation goes on the mapping of the entity that is mapped to
     * the table containing the join column, or the owner of the relationship. This might
     * be on either side of the association.

     * */
    @ManyToMany
    @JoinTable(name = "author_book",joinColumns = @JoinColumn(name = "book_id")
            ,inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors=new HashSet<>();

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
