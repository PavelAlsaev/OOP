package box;

public class Book extends Ruc {

    public Book(String genre, String name, String nameBook) {
        super(genre, name, nameBook, "Книга");
    }

    @Override
    public void look() {
        System.out.println();
        System.out.println("Имя автора: " + getName());
        System.out.println("Название: " + getNameBook());
        System.out.println("Жанр: " + getGenre());
        System.out.println();
    }
}
