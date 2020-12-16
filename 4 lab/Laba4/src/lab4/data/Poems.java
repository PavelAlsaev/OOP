package lab4.data;

public class Poems extends Ruc {

    public Poems(String genre, String name, String nameBook) {
        super(genre, name, nameBook);
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
