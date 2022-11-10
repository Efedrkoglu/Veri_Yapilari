
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Efe
 */
public class editor extends JFrame implements ActionListener {

    stack s1 = new stack(5);
    JTextArea textArea;
    JScrollPane scroll;
    JButton undo;
    JButton redo;
    JLabel fontSizeLabel;
    JLabel fontTypeLabel;
    JSpinner fontSize;
    JComboBox fontType;

    String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    public String Undo(String text, stack st) {
        String[] textArray = text.split(" ");
        String newText = "";
        st.push(textArray[textArray.length - 1]);

        for (int i = 0; i < textArray.length - 1; i++) {
            newText += textArray[i] + " ";
        }

        return newText;
    }

    public String Redo(String text, stack st) {
        text += st.pop() + " ";
        return text;
    }

    public editor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        this.setSize(600, 600);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));


        scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(550, 500));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        undo = new JButton("Undo");
        undo.setFocusable(false);
        undo.addActionListener(this);

        redo = new JButton("Redo");
        redo.setFocusable(false);
        redo.setEnabled(false);
        redo.addActionListener(this);
        
        textArea.addKeyListener(new keychecker(s1,redo));

        fontSizeLabel = new JLabel("Font Size:");

        fontSize = new JSpinner();
        fontSize.setPreferredSize(new Dimension(40, 30));
        fontSize.setValue(20);
        fontSize.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSize.getValue()));
            }

        });

        fontTypeLabel = new JLabel("Font Type:");

        fontType = new JComboBox(fonts);
        fontType.addActionListener(this);
        fontType.setSelectedItem("Arial");

        this.add(undo);
        this.add(redo);
        this.add(fontSizeLabel);
        this.add(fontSize);
        this.add(fontTypeLabel);
        this.add(fontType);
        this.add(scroll);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontType) {
            textArea.setFont(new Font((String) fontType.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }

        if (e.getSource() == undo) {
            if(!s1.isFull()){
                textArea.setText(Undo(textArea.getText(), s1));
                redo.setEnabled(true);
            }
        }

        if (e.getSource() == redo) {
            if (!s1.isEmpty()) {
                textArea.setText(Redo(textArea.getText(), s1));
                if(s1.getTop() == -1) {
                    redo.setEnabled(false);
                }
            }
        }
    }
}
