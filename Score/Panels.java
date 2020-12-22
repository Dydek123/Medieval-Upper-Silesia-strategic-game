package Score;

import javax.swing.*;
import java.awt.*;

public abstract class Panels {
    JPanel Panel = new JPanel();

    public JPanel getPanel() {
        return Panel;
    }

    public void createPanel(){
        setSize();
        addLabels();
    }

    protected abstract void addLabels();

    protected abstract void setSize();
}
