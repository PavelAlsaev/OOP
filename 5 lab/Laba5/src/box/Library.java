package box;

import box.Book;
import box.Comix;
import box.Poems;
import box.Ruc;
import java.util.ArrayList;

public class Library {
    ArrayList<Ruc> rucList = new ArrayList<>();

    public Library() {
        Book republicDragon = new Book("Фантастика", "Ребекка Хуанг", "Республика Дракон");
        Comix turtles = new Comix("Фантастика","Питер Ленд", "Черепашки ниндзя");
        Poems blackMan = new Poems("О природе", "Есенин", "Русь");
        rucList.add(republicDragon);
        rucList.add(turtles);
        rucList.add(blackMan);
    }

    public Library(ArrayList<Ruc> ruc) {
        rucList = ruc;
    }
    //добавление рукописей в массив
    public void addRuc(Ruc ruc){
        rucList.add(ruc);
    }

    //удаление рукописи из массива
    public void delRuc(Ruc ruc){
        rucList.remove(ruc);
    }

    //удаление по индексу
    public void delRucInd(int ind) {
        rucList.remove(ind);
    }

    //вывод рукописей
    public ArrayList<Ruc> getRucList(){
        return rucList;
    }

    public Ruc getRuc(int ind) {
        return rucList.get(ind);
    }
    //вывод имен
    public String[] getRucName(){
        String[] names = new String[rucList.size()];
        for (int i = 0; i < rucList.size(); i++){
            names[i] = rucList.get(i).getName();
        }
        return names;
    }

    //поиск по жанрам
    public ArrayList<Ruc> search(String genre){
        ArrayList<Ruc> answer = new ArrayList<>();
        for (Ruc a:rucList) {
            if (a.getGenre().contains(genre)) {
                answer.add(a);
            }
        }
        return answer;
    }

    //получение всех книг
    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> answer = new ArrayList<>();
        for (Ruc a:rucList) {
            if (a instanceof Book) {
                answer.add((Book) a);
            }
        }
        return answer;
    }

    //получение всех комиксов
    public ArrayList<Comix> getAllComix(){
        ArrayList<Comix> answer = new ArrayList<>();
        for (Ruc a:rucList) {
            if (a instanceof Comix) {
                answer.add((Comix) a);
            }
        }
        return answer;
    }

    //получение всех стихов
    public ArrayList<Poems> getAllPoems(){
        ArrayList<Poems> answer = new ArrayList<>();
        for (Ruc a:rucList) {
            if (a instanceof Poems) {
                answer.add((Poems) a);
            }
        }
        return answer;
    }

    //поиск по названию
    public ArrayList<Ruc> searchNameBook(String nameBook) {
        ArrayList<Ruc> answer = new ArrayList<>();
        for (Ruc a : rucList) {
            if (a.getNameBook().contains(nameBook)) {
                answer.add(a);
            }
        }
        return answer;
    }

    //вывод информации
    public void lookAll(){
        for (Ruc a:rucList) {
            a.look();
        }
    }
}
