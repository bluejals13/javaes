package HoWk.mylab.library.entity;

//import HoWk.mylab.library.entity.Book;

// import workshop.person.*;
import java.util.ArrayList;	// Prd 사항 준수를 위한 list 반환용 사용
import java.util.List; 		// Prd 사항 준수를 위한 list 반환용 사용

public class Library {
	private String name;
    private Book[] books; // 도서를 관리할 기본 배열
    private int count = 0;               // 저장된 도서 수

    public Library(String name) {
        this.name = name;
        this.books = new Book[100]; // 최대 100권 관리 배열
        this.count = 0;
    }
    
    public String getName() {   return name;    }
    
    // 1. 도서 추가
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        }else {
        	System.out.println("도서 100권 초과해서 추가할 수 없습니다");
        }
    }

    // 2. 도서 검색 (제목)
    public Book findByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    // 3. 도서 검색 (저자) - List 반환
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (books[i].getAuthor().equals(author)) {
                result.add(books[i]);
            }
        }
        return result;
    }

    // 4. 도서 검색 (ISBN)
    public Book findByISBN(String isbn) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    // 5. 도서 대출
    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && book.isAvailable()) {
            book.checkOut();
            return true;
        }
        return false;
    }

    // 6. 도서 반납
    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // 7. 대출 가능한 도서 목록 - List 반환
    public List<Book> getAvailableBooks() {
        List<Book> availableList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (books[i].isAvailable()) {
                availableList.add(books[i]);
            }
        }
        return availableList;
    }

    // 8. 모든 도서 목록 - List 반환
    public List<Book> getAllBooks() {
        List<Book> allList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            allList.add(books[i]);
        }
        return allList;
    }

    // 9. 통계 관련 메서드들
    public int getTotalBooks() {
        return count;
    }

    public int getAvailableBooksCount() {
        int availCount = 0;
        for (int i = 0; i < count; i++) {
            if (books[i].isAvailable()) {
                availCount++;
            }
        }
        return availCount;
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}

