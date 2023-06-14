package ra.bussiness;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Book {
    private static int nextBookId = 1;
    public static Book book = new Book();

    public Book[] books = new Book[100];
    public int size = 0;



    public static void setNextBookId(int nextBookId) {
        Book.nextBookId = nextBookId;
    }

    private int bookId;
    private String bookName;
    private String author;
    private String description;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private Boolean bookStatus;

    public Book() {  this.bookId = nextBookId++;

    }


    public Book(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public void inputData(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên sách: ");
        this.bookName = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        this.author = sc.nextLine();

        System.out.print("Nhập mô tả về sách (ít nhất 5 ký tự): ");
        this.description = sc.nextLine();

        while (this.description.length() < 5) {
            System.out.println("Mô tả phải có ít nhất 5 ký tự. Vui lòng nhập lại.");
            System.out.print("Nhập mô tả về sách (ít nhất 5 ký tự): ");
            this.description = sc.nextLine();
        }

        System.out.print("Nhập giá nhập: ");
        this.importPrice = sc.nextDouble();

        while (this.importPrice <= 0) {
            System.out.println("Giá nhập phải lớn hơn 0. Vui lòng nhập lại.");
            System.out.print("Nhập giá nhập: ");
            this.importPrice = sc.nextDouble();
        }

        System.out.print("Nhập giá xuất (phải lớn hơn 20% lần giá nhập): ");
        this.exportPrice = sc.nextDouble();

        while (this.exportPrice <= 1.2 * this.importPrice) {
            System.out.println("Giá xuất phải lớn hơn 20% lần giá nhập. Vui lòng nhập lại.");
            System.out.print("Nhập giá xuất (phải lớn hơn 20% lần giá nhập): ");
            this.exportPrice = sc.nextDouble();
        }
    this.bookStatus = true;
        this.interest = (float) (this.exportPrice - this.importPrice);
    }



    public void setSize(int size) {
        this.size = size;
    }


    public void displayData() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Descriptions: " + description);
        System.out.println("Import Price: " + importPrice);
        System.out.println("Export Price: " + exportPrice);
        System.out.println("Interest: " + interest);
        System.out.println("Book Status: " + (this.bookStatus?"Còn sách":"Hết sách"));
    }
}


