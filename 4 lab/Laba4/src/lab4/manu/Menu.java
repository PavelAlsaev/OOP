package lab4.manu;

import lab4.Library;
import lab4.data.Book;
import lab4.data.Comix;
import lab4.data.Poems;
import lab4.data.Ruc;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static Library library = new Library();
    private static Scanner in = new Scanner(System.in);

    public static void main (String[] args){
        if (library.getRucList().isEmpty()) {
            Book republicDragon = new Book("Фантастика", "Ребекка Хуанг", "Республика Дракон");
            Comix turtles = new Comix("Фантастика","Питер Ленд", "Кевин Исмен", "Черепашки ниндзя");
            Poems blackMan = new Poems("О природе", "Есенин", "Русь");
            library.addRuc(republicDragon);
            library.addRuc(turtles);
            library.addRuc(blackMan);
        }
        mainMenu();
    }

    public static void mainMenu(){
        int a = 0;
        do{
            System.out.println("       Главное меню       ");
            System.out.println("--------------------------");
            System.out.println("|1 - Добавить рукопись   |");
            System.out.println("|2 - Посмотеть все       |");
            System.out.println("|3 - Удалить             |");
            System.out.println("|4 - Поиск               |");
            System.out.println("|5 - Выход               |");
            System.out.println("--------------------------");

            try {
                a = Integer.parseInt(in.nextLine());
                if (a < 1 || a > 5) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println("Ошибка ввода, вы можете ввести только 1, 2, 3, 4 или 5");
                System.out.println("Попробуйте снова");
            }

            switch (a){
                case 1:
                    mainAdd();
                    break;
                case 2:
                    lookData();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
            }

        }while(a != 5);
        System.out.println("Конец программы");
    }


    public static void lookData(){
        library.lookAll();
    }

    public static void mainAdd(){

        int s = 0;
        do {
            System.out.println("       Добавть данные      ");
            System.out.println("---------------------------");
            System.out.println("|1 - Книга                |");
            System.out.println("|2 - Стихи                |");
            System.out.println("|3 - Комиксы              |");
            System.out.println("|4 - Выход в главное меню |");
            System.out.println("---------------------------");

            try {
                s = Integer.parseInt(in.nextLine());
                if (s < 1 || s > 4) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println("Ошибка ввода, вы можете ввести только 1, 2, 3 или 4");
            }

            String genre, name, nameBook, nameArt;

            switch (s){
                case 1:
                    String a = null;
                        System.out.print("Имя автора: ");
                        name = in.nextLine();

                        System.out.print("Жанр: ");
                        genre = in.nextLine();

                        System.out.print("Название книги: ");
                        nameBook = in.nextLine();

                        Book book = new Book(genre, name, nameBook);
                        library.addRuc(book);
                    break;
                case 2:
                    System.out.print("Имя автора: ");
                    name = in.nextLine();

                    System.out.print("Жанр: ");
                    genre = in.nextLine();

                    System.out.print("Название стиха: ");
                    nameBook = in.nextLine();

                    Poems poems = new Poems(genre, name, nameBook);
                    library.addRuc(poems);

                    break;
                case 3:
                    System.out.print("Имя автора: ");
                    name = in.nextLine();

                    System.out.print("Имя художника: ");
                    nameArt = in.nextLine();

                    System.out.print("Жанр: ");
                    genre = in.nextLine();

                    System.out.print("Название книги: ");
                    nameBook = in.nextLine();

                    Comix comix = new Comix(genre, name, nameBook, nameArt);
                    library.addRuc(comix);
                    break;
            }

        }while (s != 4);
    }

    public static void search(){

        int b = 0;
        do {
            System.out.println("                Поиск               ");
            System.out.println("-------------------------------------");
            System.out.println("|1 - По жанрам                      |");
            System.out.println("|2 - Получение всех книг            |");
            System.out.println("|3 - Получение всех стихов          |");
            System.out.println("|4 - Получение всех комиксов        |");
            System.out.println("|5 - Поиск по названию произведения |");
            System.out.println("|6 - Выход в главное меню           |");
            System.out.println("-------------------------------------");

            try {
                b = Integer.parseInt(in.nextLine());
                if (b < 1 || b > 6) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода, вы можете ввести только 1, 2, 3, 4, 5 или 6");
            }

            switch (b) {
                case 1:
                    System.out.print("Введите жанр: ");
                    String h = in.nextLine();
                    ArrayList<Ruc> finded = library.search(h);
                    if (finded.isEmpty()) {
                        System.out.println("Рукописей с данным жанром не найдено");
                    }
                    else {
                        for (Ruc a: finded) {
                            a.look();
                        }
                    }
                    break;

                case 2:
                    System.out.println("Получаем все книги: ");
                    ArrayList<Book> find = library.getAllBooks();
                    if (find.isEmpty()){
                        System.out.println("Рукописей с данным жанром не найдено");
                    } else {
                        for (Ruc r : find) {
                            r.look();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Получаем все стихи: ");
                    ArrayList<Poems> finde = library.getAllPoems();
                    if (finde.isEmpty()){
                        System.out.println("Рукописей с данным жанром не найдено");
                    } else {
                        for (Ruc r : finde) {
                            r.look();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Получаем все комиксы: ");
                    ArrayList<Comix> fin = library.getAllComix();
                    if (fin.isEmpty()){
                        System.out.println("Рукописей с данным жанром не найдено");
                    } else {
                        for (Ruc r : fin) {
                            r.look();
                        }
                    }
                    break;
                case 5:
                    System.out.print("Введите название произведения: ");
                    String q = in.nextLine();
                    ArrayList<Ruc> f = library.searchNameBook(q);
                    if (f.isEmpty()){
                        System.out.println("Рукописей с данным жанром не найдено");
                    } else {
                        for (Ruc a : f) {
                            a.look();
                        }
                    }
                    break;
            }
        }while (b != 6);
    }

    public static void delete() {

        int n = 0;
        String[] rucNames = library.getRucName();
        do {
            System.out.println("Удаление");
            System.out.println("Выбирете какую рукопись удалить");
            System.out.println("Выход: 0");
            for (int i = 0; i < rucNames.length; i++) {
                System.out.println(i + 0 + " )" + rucNames[i]);
            }
            try {
                System.out.print("Ведите цифру: ");
                n = Integer.parseInt(in.nextLine());
                if (n < 0) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println("Не правильный ввод данных");
            }

        } while (n < 0 || n > rucNames.length);

        if (n == 0) return;
        library.delRuc(library.getRucList().get(n));
    }
}

