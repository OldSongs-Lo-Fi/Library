package ua.library.pak.Library.represitory;

import org.springframework.data.repository.CrudRepository;
import ua.library.pak.Library.models.User;

public interface UserRepr extends CrudRepository<User, Long> {
}
