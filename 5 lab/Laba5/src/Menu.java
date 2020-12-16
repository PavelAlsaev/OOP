import controllers.MainController;
import window.MyWindow;

public class Menu {
    public static void main(String[] args){
        new MainController().execute(new MyWindow());
    }
}
