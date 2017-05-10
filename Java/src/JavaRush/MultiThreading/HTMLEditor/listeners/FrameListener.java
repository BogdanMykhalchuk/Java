package JavaRush.MultiThreading.HTMLEditor.listeners;

import JavaRush.MultiThreading.HTMLEditor.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Dreawalker on 27.04.2017.
 */
public class FrameListener extends WindowAdapter {

    private View view;

    public FrameListener(View view) {
        this.view = view;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        view.exit();
    }
}
