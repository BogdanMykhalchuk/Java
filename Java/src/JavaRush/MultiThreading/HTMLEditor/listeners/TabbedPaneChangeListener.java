package JavaRush.MultiThreading.HTMLEditor.listeners;

import JavaRush.MultiThreading.HTMLEditor.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Dreawalker on 27.04.2017.
 */
public class TabbedPaneChangeListener implements ChangeListener {

    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
