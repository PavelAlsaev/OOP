package box;

import java.awt.*;

public abstract class Ruc {

    private String genre;
    private String name;
    private String nameBook;
    private String type;

    public Ruc(String genre, String name, String nameBook, String type){
        this.genre = genre;
        this.name = name;
        this.nameBook = nameBook;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNameBook(){
        return nameBook;
    }

    public void setNameBook(String nameBook){
        this.nameBook = nameBook;
    }

    public abstract void look();

}
