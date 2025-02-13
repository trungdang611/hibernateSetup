package com.example;

import com.example.dao.AuthorDAOImpl;
import com.example.dao.BookDAOImpl;
import com.example.dto.BookCountDTO;
import com.example.entity.Author;
import com.example.entity.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AuthorDAOImpl authorDAO = new AuthorDAOImpl();
        BookDAOImpl bookDAO = new BookDAOImpl();

//      Tạo tác giả
//        Author author1 = new Author(0, "Nguyễn Nhật Ánh", 30, "Văn học thiếu nhi, truyện dài", "nguyen.nhat.anh@example.com", null);
//        Author author2 = new Author(0, "Nam Cao", 40, "Truyện ngắn, tiểu thuyết", "nam.cao@example.com", null);
//        Author author3 = new Author(0, "Ngô Tất Tố", 35, "Hiện thực phê phán", "ngo.tat.to@example.com", null);
//
//        System.out.println(authorDAO.save(author1));
//        System.out.println(authorDAO.save(author2));
//        System.out.println(authorDAO.save(author3));

        // Tạo sách
//        Book book1 = new Book(0, "Tôi Thấy Hoa Vàng Trên Cỏ Xanh", "Một câu chuyện về tuổi thơ và những giấc mơ", 120000, 50, LocalDate.of(2010, 5, 20), author1);
//        Book book2 = new Book(0, "Chí Phèo", "Tác phẩm hiện thực phê phán nổi tiếng", 80000, 30, LocalDate.of(1941, 1, 1), author2);
//        Book book3 = new Book(0, "Tắt Đèn", "Cuộc sống khốn khổ của người nông dân Việt Nam trước cách mạng", 95000, 40, LocalDate.of(1939, 7, 15), author3);
//        Book book4 = new Book(0, "Cô Gái Đến Từ Hôm Qua", "Câu chuyện tình yêu tuổi học trò", 100000, 45, LocalDate.of(1990, 6, 10), author1);
//        Book book5 = new Book(0, "Lão Hạc", "Truyện ngắn xúc động về số phận con người", 75000, 35, LocalDate.of(1943, 3, 5), author2);
//        Book book6 = new Book(0, "Việt Nam Văn Học Sử Yếu", "Tác phẩm phê bình văn học nổi bật", 150000, 20, LocalDate.of(1942, 9, 8), author3);
//        Book book7 = new Book(0, "Mắt Biếc", "Một chuyện tình buồn đẫm nước mắt", 130000, 55, LocalDate.of(1990, 11, 12), author1);
//        Book book8 = new Book(0, "Sống Mòn", "Tâm lý xã hội dưới chế độ phong kiến", 89000, 25, LocalDate.of(1944, 5, 20), author2);
//        Book book9 = new Book(0, "Lều Chõng", "Tái hiện cuộc sống sĩ tử thời phong kiến", 140000, 30, LocalDate.of(1941, 2, 14), author3);
//        Book book10 = new Book(0, "Bắt Trẻ Đồng Xanh", "Tác phẩm văn học kinh điển về tâm lý tuổi trẻ", 135000, 40, LocalDate.of(1951, 7, 16), author2);
//        Book book11 = new Book(0, "Quê Hương Yêu Dấu", "Câu chuyện về cuộc sống thôn quê", 110000, 38, LocalDate.of(1985, 3, 22), author1);
//
//        System.out.println(bookDAO.save(book1));
//        System.out.println(bookDAO.save(book2));
//        System.out.println(bookDAO.save(book3));
//        System.out.println(bookDAO.save(book4));
//        System.out.println(bookDAO.save(book5));
//        System.out.println(bookDAO.save(book6));
//        System.out.println(bookDAO.save(book7));
//        System.out.println(bookDAO.save(book8));
//        System.out.println(bookDAO.save(book9));
//        System.out.println(bookDAO.save(book10));
//        System.out.println(bookDAO.save(book11));

//        test query
        List<BookCountDTO> bookCountDTOList = new ArrayList<BookCountDTO>();

//        findBookCountByAuthor
//        bookCountDTOList = bookDAO.findBookCountByAuthor();
//        System.out.println(bookCountDTOList);

//        findTotalQuantityBooksByAuthor
//        bookCountDTOList = bookDAO.findTotalQuantityBooksByAuthor();
//        System.out.println(bookCountDTOList);

//        findTotalQuantityBooksByAuthorId
//        Long total = bookDAO.findTotalQuantityBooksByAuthorId(1);
//        System.out.println(total);

//        findBooksWithZeroPriceOrZeroQuantity
//        List<Book> bookList = bookDAO.findBooksWithZeroPriceOrZeroQuantity();
//        System.out.println(bookList);

//        findBooksByPriceRange
//        List<Book> bookList = bookDAO.findBooksByPriceRange(50000, 130000);
//        System.out.println(bookList);

//        findTop3AuthorsWithMostBooks
        List<Author> authorList = bookDAO.findTop3AuthorsWithMostBooks();
        System.out.println(authorList);
    }
}
