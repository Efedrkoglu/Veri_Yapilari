
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

/**
 *
 * @author Efe
 */
public class keychecker extends KeyAdapter{
    stack s1;
    JButton redo;
    
    public keychecker(stack s, JButton redo) {
        this.s1 = s;
        this.redo = redo;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        s1.clear();
        redo.setEnabled(false);
    }
}
