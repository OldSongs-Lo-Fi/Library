package ua.library.pak.Library.represitory;

import org.springframework.data.repository.CrudRepository;
import ua.library.pak.Library.models.Book;

public interface BookRepr extends CrudRepository<Book, Long> {
}
