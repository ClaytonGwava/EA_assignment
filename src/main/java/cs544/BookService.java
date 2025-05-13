package cs544;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class BookService {
    @Autowired
    private IBookDao bookDao;

    public List<Book> getAll(){return bookDao.getAll();}

    public void add(Book book) {bookDao.add(book);}

    public Book get(int id){return bookDao.get(id);}

    public void update(Book book) {bookDao.update(book);}

    public void delete (int id) {bookDao.delete(id);}
}
