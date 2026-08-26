package HoWk.mylab.library.entity;

// import workshop.person.*;

public class Book {
	private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;
	
	// default constructor 선언
	public Book() {
		this.isAvailable = true; // 기본적으로 대출 가능 상태
		System.out.println("Book 기본 생성자 호출");
	}


	public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true; // 기본적으로 대출 가능 상태
    }

	// 단순  Getter Setter
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublishYear() { return publishYear; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
	
    // Book.java에 추가하면 좋은 메서드
    public boolean checkOut() {
        if (this.isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    public void returnBook() {
        this.isAvailable = true;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s (저자: %s, %d년) - %s", 
                isbn, title, author, publishYear, isAvailable ? "대출가능" : "대출중");
    }
	
}