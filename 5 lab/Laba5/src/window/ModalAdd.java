package window;

import javax.swing.*;
import java.awt.*;

public class ModalAdd extends JDialog {
    public JTextField nameRucInput;
    public JTextField nameAuthorInput;
    public JTextField genreInput;
    public JComboBox typeCombo;
    private JButton btn;

    public JButton getBtn() {
        return btn;
    }

    public ModalAdd() {

        JPanel jPanel = new JPanel(new GridLayout(5, 1, 2, 2));

        typeCombo= new JComboBox(new String[]{"Книга", "Комикс", "Стих"});
        nameRucInput = new JTextField("Название рукописи");
        nameAuthorInput = new JTextField("Имя автора");
        genreInput = new JTextField("Жанр");
        btn = new JButton("ОК");

        jPanel.add(typeCombo);
        jPanel.add(nameRucInput);
        jPanel.add(genreInput);
        jPanel.add(nameAuthorInput);
        jPanel.add(btn);

        add(jPanel);
        pack();
        setSize(250, 250);
        setLocationRelativeTo(null);
    }
}
