package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        if(book.getIsAvailable() && member.borrowedBooksCount() < 3) {
            book.setIsAvailable(false);
            System.out.println("Borrowing book: " + book);
            member.getBorrowedBooks().add(book);
            return new BorrowingBookResult(true, "Borrowed book");
        }
        if(member.borrowedBooksCount() >= 3) {
            return new BorrowingBookResult(false, "Too many books borrowed");
        }
        if(member.getBorrowedBooks().contains(book)) {
            return new BorrowingBookResult(false, "This member has already borrowed the book");
        }

        return new BorrowingBookResult(false, "Another member has borrowed the book");
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        if(!book.getIsAvailable() && member.getBorrowedBooks().contains(book)) {
            book.setIsAvailable(true);
            System.out.println("Returning book: " + book);
            member.getBorrowedBooks().remove(book);
            return new BorrowingBookResult(true, "Returned book");
        }
        if(!member.getBorrowedBooks().contains(book)) {
            return new BorrowingBookResult(false, "Book has not been borrowed");
        }

        return new BorrowingBookResult(false, "Book has already been returned");
    }
}
