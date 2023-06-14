package ra.run;

import ra.bussiness.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static ra.bussiness.Book.*;

public class BookManagement {
    private static List<Book> library = new ArrayList<>(100);
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                    "2. Hiển thị thông tin tất cả sách trong thư viện \n" +
                    "3. Sắp xếp sách theo lợi nhuận tăng dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n" +
                    "6. Thay đổi thông tin sách theo mã sách \n" +
                    "7. Thoát ");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    sortBooksByProfit();
                    break;
                case 4:
                    removeBookById();
                    break;
                case 5:
                    searchBooks();
                    break;
                case 6:
                    updateBookById();
                    break;
                case 7:
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 7");
                    break;
            }
        }

    }


    private static void addBooks() {
        System.out.print("Nhập số lượng sách muốn thêm: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine();
        if (library.size() + numBooks > 100) {
            System.out.println("Không thể thêm sách. Cửa hàng đã đạt số lượng sách tối đa.");
            return;
        }

        for (int i = 0; i < numBooks; i++) {
            System.out.println("Nhập thông tin cho cuốn sách thứ " + (i + 1));
            Book book = new Book();
            book.inputData();

            System.out.println("Nhập trạng thái sách");
            System.out.println("1. Còn sách\n"+
            "2. Hết sách");
            int choice= scanner.nextInt();
            switch(choice){
                case 1:
                    book.setBookStatus(true);
                    break;
                case 2:
                    book.setBookStatus(false);
                    break;
            }
            library.add(book);
        }
        System.out.println("Thêm sách thành công!");
    }

    private static void displayAllBooks() {
        if (library.isEmpty()) {
            System.out.println("Thư viện không có sách nào.");
        } else {
            System.out.println("Danh sách tất cả sách trong thư viện:");
            for (Book book : library) {
                book.displayData();
                System.out.println(book);
            }
        }
    }

    private static void sortBooksByProfit() {
        if (library.isEmpty()) {
            System.out.println("Thư viện không có sách nào.");
        } else {
            Collections.sort(library, (book1, book2) -> Float.compare(book1.getInterest(), book2.getInterest()));
            System.out.println("Sắp xếp sách theo lợi nhuận tăng dần:");
            for (Book book : library) {
                book.displayData();
                System.out.println();
            }
        }
    }

    private static void removeBookById() {
        if (library.isEmpty()) {
            System.out.println("Thư viện không có sách nào.");
        } else {
            System.out.print("Nhập mã sách muốn xóa: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line sau khi đọc số nguyên

            Iterator<Book> iterator = library.iterator();
            boolean bookFound = false;
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getBookId() == bookId) {
                    iterator.remove();
                    bookFound = true;
                    break;
                }
            }

            if (bookFound) {
                System.out.println("Xóa sách thành công!");
            } else {
                System.out.println("Không tìm thấy sách với mã sách đã nhập.");
            }
        }
    }

    private static void searchBooks() {
        if (library.isEmpty()) {
            System.out.println("Thư viện không có sách nào.");
        } else {
            System.out.println("1. Tìm kiếm theo tên sách");
            System.out.println("2. Tìm kiếm theo mô tả");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line sau khi đọc số nguyên

            System.out.print("Nhập từ khóa tìm kiếm: ");
            String keyword = scanner.nextLine();

            boolean bookFound = false;

            switch (choice) {
                case 1:
                    System.out.println("Kết quả tìm kiếm theo tên sách:");
                    for (Book book : library) {
                        if (book.getBookName().contains(keyword)) {
                            book.displayData();
                            System.out.println();
                            bookFound = true;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Kết quả tìm kiếm theo mô tả:");
                    for (Book book : library) {
                        if (book.getDescription().contains(keyword)) {
                            book.displayData();
                            System.out.println();
                            bookFound = true;
                        }
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

            if (!bookFound) {
                System.out.println("Không tìm thấy sách phù hợp với từ khóa đã nhập.");
            }
        }
    }

    private static void updateBookById() {
        if (library.isEmpty()) {
            System.out.println("Thư viện không có sách nào.");
        } else {
            System.out.print("Nhập mã sách muốn thay đổi thông tin: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line sau khi đọc số nguyên

            boolean bookFound = false;

            for (Book book : library) {
                if (book.getBookId() == bookId) {
                    System.out.println("Nhập thông tin mới cho sách:");
                    book.inputData();
                    bookFound = true;
                    break;
                }
            }

            if (bookFound) {
                System.out.println("Cập nhật thông tin sách thành công!");
            } else {
                System.out.println("Không tìm thấy sách với mã sách đã nhập.");
            }
        }
    }
}