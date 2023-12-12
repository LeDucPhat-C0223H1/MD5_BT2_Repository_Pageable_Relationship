package ra.session01orm.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.session01orm.model.Book;

@Repository
public interface IBookReponsitory extends JpaRepository<Book, Long> {
}
