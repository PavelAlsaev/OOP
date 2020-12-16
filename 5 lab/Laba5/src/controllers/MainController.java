package controllers;

import box.*;
import org.w3c.dom.ls.LSOutput;
import window.ModalAdd;
import window.MyWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class MainController {
    private MyWindow view;

    //метод для навешивания обработчиков модального окна добавления
    public void executeModal(ModalAdd modalAdd) {
        modalAdd.getBtn().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genre = modalAdd.genreInput.getText();
                String nameAuthor = modalAdd.nameAuthorInput.getText();
                String nameRuc = modalAdd.nameRucInput.getText();
                String type = modalAdd.typeCombo.getSelectedItem().toString();

                if (nameAuthor.equals("") || genre.equals("") || nameRuc.equals("")) {
                    view.showErrorMessage("Вы не заполнили все поля!");
                    return;
                }

                Ruc newRuc = switch(type) {
                    case "Комикс" -> new Comix(genre, nameAuthor, nameRuc);
                    case "Книга" -> new Book(genre, nameAuthor, nameRuc);
                    case "Стих" -> new Poems(genre, nameAuthor, nameRuc);
                    default -> null;
                };

                view.getModel().add(newRuc);
                view.getModal().dispose();
            }
        });
    }

    public void execute(MyWindow view) {
        this.view = view;
        executeModal(view.getModal());

        //Добавление
        view.getA1().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showModal();
            }
        });

        //Удаление
        view.getA2().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ind = view.getTable().getSelectedRow();
                try {
                    view.getModel().delete(ind);
                } catch(IndexOutOfBoundsException err) {
                    view.showErrorMessage("Вы не выбрали что удалить");
                }
            }
        });

        // Обработчик сохранения файла
        view.getA3().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = view.saveFile();
                if(file == null) return;
                String path = file.getAbsolutePath();
                String saveString = libraryToString(view.getModel().getBox());
                try {
                    Files.write(Path.of(path), saveString.getBytes());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    view.showErrorMessage("Файл не сохранен");
                    System.out.println("пРОИЗОШЛА ОШИБКА");
                }
                System.out.println("Файл успешно сохранен");
            }
        });

        // Обработчик открытия файла
        view.getA4().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = view.openFile();
                String stringLib = null;
                try {
                    stringLib = Files.readString(Path.of(file.getAbsolutePath()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    view.showErrorMessage("Файл сломан ");
                    System.out.println("ОШИБКА В ОТКРЫТИИ ФАЙЛА");
                } catch (NullPointerException err) {
                    return;
                }

                Library lib = null;
                try {
                    lib = parseLibraryFromString(stringLib);
                } catch (IndexOutOfBoundsException err) {
                    view.showErrorMessage("Файл сломан ");
                    System.out.println("файл некорректен");
                    return;
                }
                view.getModel().setBox(lib);
                System.out.println("файл успешно открыт");
            }
        });
    }

    //Превращение библиотеки в строку
    private String libraryToString(Library lib) {
        StringBuilder ans = new StringBuilder();
        for (Ruc ruc : lib.getRucList()) {
            ans.append(rucToString(ruc)).append("\r\n");
        }
        return ans.toString();
    }

    // Преврощение рукописи в строковый формат
    private String rucToString(Ruc ruc) {
        String ans = "";
        ans += ruc.getGenre() + ";";
        ans += ruc.getName() + ";";
        ans += ruc.getNameBook() + ";";
        ans += ruc.getType();
        return ans;
    }

    // Получение библиотеки из строки
    private Library parseLibraryFromString(String libString) {
        ArrayList<Ruc> rucList = new ArrayList<>();
        String[] stringsRuc = libString.split("\r\n");
        for(String stringRuc : stringsRuc) {
            rucList.add(parseRucFromString(stringRuc));
        }
        return new Library(rucList);
    }

    //Получение рукописи из строки
    private Ruc parseRucFromString(String rucString) {
        String[] stringParams = rucString.split(";");
        String genre = stringParams[0];
        String name = stringParams[1];
        String nameBook = stringParams[2];
        String type = stringParams[3];
        return switch (type) {
            case "Книга" -> new Book(genre, name, nameBook);
            case "Комикс" -> new Comix(genre, name, nameBook);
            case "Стих" -> new Poems(genre, name, nameBook);
            default -> throw new IllegalArgumentException("Неверный тип рукописи");
        };
    }
}
