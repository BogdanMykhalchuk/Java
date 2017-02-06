package Test;

import java.awt.*;

/**
 * Created by Dreawalker on 13.11.2016.
 */
public class Test_003_AWT extends Component {

    public void paint(Graphics g) {
        g.drawLine(0,0,getWidth()-1, getHeight()-1);
        g.drawLine(0,getHeight()-1, getWidth()-1,0);
        g.drawRect(0,0,getWidth()-1, getHeight()-1);
    }
}
