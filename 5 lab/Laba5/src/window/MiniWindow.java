package window;

import box.Library;
import box.Ruc;

import javax.swing.table.AbstractTableModel;

public class MiniWindow extends AbstractTableModel {
    private static Library box;

    public MiniWindow() {
        box = new Library();
    }

    public MiniWindow(Library library){
        box = library;
    }

    public Library getBox(){
        return box;
    }

    public void setBox(Library box){
        MiniWindow.box = box;
        fireTableDataChanged();
    }

    //Удаление
    public void delete(int num) throws IndexOutOfBoundsException {
        box.delRucInd(num);
        fireTableDataChanged();
    }

    //Добавление
    public void add(Ruc ruc) {
        box.addRuc(ruc);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return box.getRucList().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> rowIndex + 1;
            case 1 -> box.getRuc(rowIndex).getGenre();
            case 2 -> box.getRuc(rowIndex).getName();
            case 3 -> box.getRuc(rowIndex).getNameBook();
            case 4 -> box.getRuc(rowIndex).getType();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column){
        return switch (column) {
            case 0 -> "Номер";
            case 1 -> "Жанр";
            case 2 -> "Имя";
            case 3-> "Название";
            case 4 -> "Тип";
            default -> "error";
        };
    }
}
