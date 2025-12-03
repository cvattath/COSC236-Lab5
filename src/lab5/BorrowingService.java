package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    private static BorrowingService instance;
    private int borrowingLimit;

    private BorrowingService() {
        borrowingLimit = 3;
    }

    public static synchronized BorrowingService getInstance() {
        if(instance == null){
            instance = new BorrowingService();
        }
        return instance;
    }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        if(member.getBorrowedBooks().contains(book)){
            return new BorrowingBookResult(false, "This member has already borrowed the book");
        }

        if(member.borrowedBooksCount() >= borrowingLimit){
            return new BorrowingBookResult(false, "Too many borrowed books");
        }

        if(!book.getIsAvailable()){
            return new BorrowingBookResult(false, "This book is borrowed by another member");
        }

        book.setIsAvailable(false);
        System.out.println("Borrowing book: " + book);
        member.getBorrowedBooks().add(book);
        return new BorrowingBookResult(true, "Borrowed book: " + book);
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        if(!member.getBorrowedBooks().contains(book)){
            return new BorrowingBookResult(false, "This book is not borrowed by another member");
        }

        if(book.getIsAvailable()){
            return new BorrowingBookResult(false, "This book has been returned");
        }

        book.setIsAvailable(true);
        System.out.println("Returning book: " + book);
        member.getBorrowedBooks().remove(book);
        return new BorrowingBookResult(true, "Returned book: " + book);
    }
}
