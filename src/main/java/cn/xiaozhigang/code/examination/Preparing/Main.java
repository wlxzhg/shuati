package cn.xiaozhigang.code.examination.Preparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookList list = readBooks();
        int maskAll = (1 << list.size) - 1;
        int f[] = new int[maskAll + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (Book book : list.books) {
            for (int j = 0; j < maskAll; j++) {
                if (f[j] == -1)
                    continue;
                int k = j | book.mask;
                int t = f[j] + book.cost;
                if (f[k] == -1 || f[k] > t)
                    f[k] = t;
            }
            System.out.println(Arrays.toString(f));
        }
        System.out.println(f[maskAll]);
    }


    private static BookList readBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line == null || line.equals(""))
                break;
            String[] params = line.split(" ");
            int cost = Integer.parseInt(params[0]);
            int mask = 0;
            for (int i = 1; i < params.length; i++) {
                int index = names.indexOf(params[i]);
                if (index == -1) {
                    index = names.size();
                    names.add(params[i]);
                }
                mask |= 1 << index;
            }
            System.out.println(mask);
            books.add(new Book(cost, mask));
        }
        scanner.close();
        return new BookList(books, names.size());
    }
}

class BookList {
    final ArrayList<Book> books;
    final int size;

    BookList(ArrayList<Book> books, int size) {
        this.books = books;
        this.size = size;
    }
}
class Book {
    final int cost;
    final int mask;

    Book(int cost, int mask) {
        this.cost = cost;
        this.mask = mask;
    }
}

