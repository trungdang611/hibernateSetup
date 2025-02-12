package vn.example;

import com.example.dao.AuthorDAOImpl;
import com.example.dao.BookDAOImpl;
import com.example.entity.Author;
import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DaoTest {
    private BookDAOImpl bookDAO;
    private Session session;
    @BeforeEach
    public void setUp() {
        // Mở session và khởi tạo đối tượng BookDAOImpl
        session = HibernateUtil.getSessionFactory().openSession();
        bookDAO = new BookDAOImpl();
    }

    @AfterEach
    public void tearDown() {
        // Đóng session sau mỗi lần test
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    @Test
    public void testSave() {
        // Tạo một tác giả và sách để lưu
        AuthorDAOImpl authorDAO = new AuthorDAOImpl();
        Author author = new Author(0, "Dang Trung", 8, "Java, Spring, Hibernate", "trungdangdev@example.com", null);
        authorDAO.save(author);

        Book book = new Book();
        book.setBookTitle("Lập Trình Java");
        book.setPrice(300.0);
        book.setQuantity(10);
        book.setPublishedDate(java.time.LocalDate.of(2023, 1, 1));
        book.setAuthor(author);

        // Lưu sách
        Book savedBook = bookDAO.save(book);

        // Kiểm tra sách đã được lưu thành công hay chưa
        assertNotNull(savedBook);
        assertNotNull(savedBook.getBookId());  // Nếu sách đã được lưu, thì bookId không thể null
    }

    @Test
    public void testFindById() {
        // Giả sử sách có ID là 1
        Book book = bookDAO.findById(1);

        // Kiểm tra sách có tồn tại hay không
        assertNotNull(book);
        System.out.println(book);
    }

    @Test
    public void testDelete() {
        // Tạo một đối tượng Book để xóa
        Book bookToDelete = new Book();
        bookToDelete.setBookId(1);  // ID của sách cần xóa

        Boolean isDeleted = bookDAO.delete(bookToDelete);

        // Kiểm tra kết quả sau khi xóa
        assertNotNull(isDeleted);
    }
}
