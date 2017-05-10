package JavaRush.MultiThreading.HTMLEditor.listeners;

import JavaRush.MultiThreading.HTMLEditor.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by Dreawalker on 28.04.2017.
 */
public class TextEditMenuListener implements MenuListener {

    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        JMenu jMenu = null;
        if(e.getSource() instanceof JMenu) {
           jMenu = (JMenu) e.getSource();
        }
        if(jMenu != null) {
            Component[] components = jMenu.getMenuComponents();
            if(components != null && components.length > 0) {
                for(int i = 0; i < components.length; i++) {
                    components[i].setEnabled(view.isHtmlTabSelected());
                }
            }
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
