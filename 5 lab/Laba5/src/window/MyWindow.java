package window;

import box.Ruc;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MyWindow extends JFrame {

    private JTable table;
    private JMenu menu;
    private JMenuItem a1, a2, a3, a4;
    private MiniWindow model;
    private ModalAdd modalAdd = new ModalAdd();
    private JMenu menuFile;
    private JFileChooser chooser;

    public ModalAdd getModal() {
        return modalAdd;
    }
    private JMenu getMenuFile() {
        return menuFile;
    }

    public JTable getTable() {
        return table;
    }

    public MiniWindow getModel() {
        return model;
    }

    public JMenuItem getA2() {
        return a2;
    }

    public JMenuItem getA1(){
        return a1;
    }

    public JMenuItem getA3(){
        return a3;
    }

    public JMenuItem getA4(){
        return a4;
    }

    public void showModal() {
        modalAdd.setVisible(true);
    }

    public void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }


    public MyWindow() {

        super("Библиотека");
        table = new JTable();
        chooser = new JFileChooser();
        menu = new JMenu("Настройки");
        menuFile = new JMenu("Файл");
        JMenuBar m = new JMenuBar();
        a1 = new JMenuItem("Добавить рукопись");
        a2 = new JMenuItem("Удалить рукопиь");
        a3 = new JMenuItem("Сохранение файл");
        a4 = new JMenuItem("Окрыть файл");
        model = new MiniWindow();

        table.setModel(model);
        JScrollPane pane = new JScrollPane(table);

        setSize(900, 600);
        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        menu.add(a1);
        menu.add(a2);

        menuFile.add(a3);
        menuFile.add(a4);

        m.add(menu);
        m.add(menuFile);
        add(pane);
        setJMenuBar(m);

        setVisible(true);
    }

    //Открытие файла
    public File openFile() {
        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    //Сохранение файла
    public File saveFile() {
        int option = chooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
}
