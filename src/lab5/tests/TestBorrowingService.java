package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBorrowingService {

    BorrowingService bs;
    Member m1;
    Member m2;
    PaperBook b1;
    EBook e1;
    AudioBook a1;
    AudioBook a2;

    @BeforeEach
    void setUp() {
        bs = new BorrowingService();
        m1 = new Member("Bartholomew");
        m2 = new Member("Bobby");
        b1 = new PaperBook("1984");
        e1 = new EBook("The King in Yellow");
        a1 = new AudioBook("Fifty Shades of Gray");
        a2 = new AudioBook("Sixty Shades of Gray");
    }

    @Test
    void borrowBooksByService() {
        assertAll(
                () -> assertTrue(bs.borrowBook(m1, b1).isSuccess()),
                () -> assertTrue(bs.borrowBook(m1, e1).isSuccess()),
                () -> assertTrue(bs.borrowBook(m1, a1).isSuccess()),
                () -> assertFalse(bs.borrowBook(m1, a2).isSuccess()), // too many books
                () -> assertFalse(bs.borrowBook(m1, b1).isSuccess()), // already borrowed
                () -> assertFalse(bs.borrowBook(m2, b1).isSuccess())  // another member borrowed
        );
    }

    @Test
    void returnBooksByService() {
        m1.borrowBook(b1);
        m1.borrowBook(e1);
        m1.borrowBook(a1);

        assertAll(
                () -> assertTrue(bs.returnBook(m1, b1).isSuccess()),
                () -> assertFalse(bs.returnBook(m1, b1).isSuccess()), // already returned
                () -> assertFalse(bs.returnBook(m1, a2).isSuccess())  //member hasnt borrowed
        );
    }
}
