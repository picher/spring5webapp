package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mahdi Sharifi
 * @version 2021.1.1
 * https://www.linkedin.com/in/mahdisharifi/
 * @since 10/16/2021
 */
public interface AuthorRepository extends CrudRepository<Author,Long>{
}
