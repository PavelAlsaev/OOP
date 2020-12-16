package box;

public class Comix extends Ruc {

    public Comix(String genre, String name, String nameBook) {
        super(genre, name, nameBook, "Комикс");
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
