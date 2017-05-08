package JavaRush.MultiThreading.HTMLEditor.actions;

import JavaRush.MultiThreading.HTMLEditor.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Dreawalker on 28.04.2017.
 */
public class RedoAction extends AbstractAction {

    private View view;

    public RedoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();
    }
}
