package Test;

import java.awt.*;

/**
 * Created by Dreawalker on 13.11.2016.
 */

// компонент абстрактный класс поэтому нельзя создать обьект непосредственно от него
public class Test_001_AWT extends Frame {

    public Test_001_AWT() {
        Test_003_AWT component = new Test_003_AWT();
        //создаем обьект класса Poin(точка)
        Point point = new Point(400, 400);

        //задаем координаты расположения точки для верхнего левого угла окна
        setLocation(point);

        //создаем обьект класса Dimension(размер)
        Dimension dimension = new Dimension(300, 300);

        //задаем размер окна с помощью обьекта класса Dimension(размер) dimension
        setSize(dimension);

        //делаем компонент видимым
        setVisible(true);

        //делаем компонент активным
        setEnabled(true);

        //задаем фон компонента
        setBackground(Color.GREEN);

        //задаем цвет надписей компонента
        setForeground(Color.YELLOW);

        //создаем обьект класса Font(шрифт)
        Font font = new Font("Serif", Font.BOLD|Font.ITALIC, 20);

        //задаем шрифт компонента
        setFont(font);
        this.add(component);

        Button save = new Button("Save");
        this.add(save);
    }

    public static void main(String[] args) {

        //создаем обьект класса-наследника от Container
        Test_001_AWT container = new Test_001_AWT();
    }
}
