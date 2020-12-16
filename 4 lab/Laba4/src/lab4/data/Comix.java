package lab4.data;

public class Comix extends Ruc {

    private String nameArt;

    public Comix(String genre, String name, String nameBook, String nameArt) {
        super(genre, name, nameBook);
        this.nameArt = nameArt;
    }

    public String getNameArt() {
        return nameArt;
    }

    public void setNameArt (String nameArt) {
        this.nameArt = nameArt;
    }

    @Override
    public void look() {
        System.out.println();
        System.out.println("Имя автора: " + getName());
        System.out.println("Имя художника: " + getNameArt());
        System.out.println("Название: " + getNameBook());
        System.out.println("Жанр: " + getGenre());
        System.out.println();
    }
}
