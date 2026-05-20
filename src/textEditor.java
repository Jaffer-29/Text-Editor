import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import javax.swing.*;

public class textEditor extends JFrame {

    Stack<String> undoStack = new Stack<>();
    Stack<String> redoStack = new Stack<>();

    JButton save, undo, redo, clear;
    JTextArea area;
    JComboBox<String> fontBox;
    JComboBox<Integer> fontSize;
    JLabel label, StyleLabel, SizeLabel;
    String[] fontStyles = {"Arial","Consolas","Verdana","Times New Roman",
            "Calibre","Tahoma","Courier New","Roboto"};
    Integer[] fontSizes = {8, 9, 10, 11, 12, 14, 16, 18,20, 22, 24,
            26, 28, 32, 36,40, 44, 48, 54, 60, 72 };

    textEditor(){

        label = new JLabel();
        label.setText("Personal Text Editor");
        label.setForeground(Color.WHITE);
        label.setBounds(350, 20, 250, 30);
        label.setFont(new Font("Times New Roman",Font.BOLD, 25));
        add(label);

        area = new JTextArea();
        area.setBounds(50, 105, 500, 300);
        area.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
        area.setLineWrap(true);
        area.setBackground(Color.BLACK);
        area.setForeground(Color.WHITE);
        area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent e) {
                undoStack.push(area.getText());
                redoStack.clear();
            }
        });
        add(area);

        StyleLabel = new JLabel();
        StyleLabel.setText("Font Style");
        StyleLabel.setForeground(Color.WHITE);
        StyleLabel.setBounds(620, 100, 100, 30);
        StyleLabel.setFont(new Font("Roboto",Font.BOLD, 15));
        add(StyleLabel);

        fontBox = new JComboBox<>(fontStyles);
        fontBox.setFocusable(false);
        fontBox.setForeground(Color.WHITE);
        fontBox.setBackground(Color.BLACK);
        fontBox.setBorder(BorderFactory.createEmptyBorder());
        fontBox.setBounds(730, 105  , 160, 20);
        fontBox.setFont(new Font("Roboto",Font.BOLD,14));
        fontBox.addActionListener(e -> {
            String in = (String) fontBox.getSelectedItem();
            int size = area.getFont().getSize();
            area.setFont(new Font(in, Font.PLAIN, size));
        });
        add(fontBox);

        SizeLabel = new JLabel();
        SizeLabel.setText("Font Size");
        SizeLabel.setForeground(Color.WHITE);
        SizeLabel.setBounds(620, 135, 100, 30);
        SizeLabel.setFont(new Font("Roboto",Font.BOLD, 15));
        add(SizeLabel);

        fontSize = new JComboBox<>(fontSizes);
        fontSize.setFocusable(false);
        fontSize.setForeground(Color.WHITE);
        fontSize.setBackground(Color.BLACK);
        fontSize.setBorder(BorderFactory.createEmptyBorder());
        fontSize.setBounds(730, 140  , 160, 20);
        fontSize.setFont(new Font("Roboto",Font.BOLD,14));
        fontSize.addActionListener(e -> {
            String in = (String) fontBox.getSelectedItem();
            int size = (Integer) fontSize.getSelectedItem();
            area.setFont(new Font(in, Font.PLAIN, size));
        });
        add(fontSize);

        //_________________________________________________________________________________________________________//

        undo = new JButton();
        undo = new JButton();
        undo.setText("Undo Action");
        undo.setFocusable(false);
        undo.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        undo.setForeground(Color.white);
        undo.setBackground(Color.BLACK);
        undo.setBounds(715,215,100,27);
        undo.addActionListener(a->{
            if (!undoStack.isEmpty()) {
                redoStack.push(area.getText());
                String prev = undoStack.pop();
                area.setText(prev);
            } else {
                JOptionPane.showMessageDialog(null, "Nothing to undo");
            }
        });
        add(undo);

        redo = new JButton();
        redo = new JButton();
        redo.setText("Redo Action");
        redo.setFocusable(false);
        redo.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        redo.setForeground(Color.white);
        redo.setBackground(Color.BLACK);
        redo.setBounds(715,250,100,27);
        redo.addActionListener(a->{
            if (!redoStack.isEmpty()) {
                undoStack.push(area.getText());
                String next = redoStack.pop();
                area.setText(next);
            } else {
                JOptionPane.showMessageDialog(null, "Nothing to redo");
            }
        });
        add(redo);

        save = new JButton();
        save.setText("Save Data");
        save.setFocusable(false);
        save.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        save.setForeground(Color.white);
        save.setBackground(Color.BLACK);
        save.setBounds(650,350,100,35);
        save.addActionListener(a->{
            String data   = area.getText();
            if(data.isEmpty()){
                JOptionPane.showMessageDialog(
                        null,"No Input, Can't Save",
                        "Error",JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                File f = new File("TextEditor.txt");
                if(!f.exists()){
                    f.createNewFile();
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                writer.write(data);
                writer.newLine();
                writer.close();
                JOptionPane.showMessageDialog(
                        null,"Data Save Successfully",
                        "Data Saved",JOptionPane.INFORMATION_MESSAGE
                );
                area.setText("");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        add(save);

        clear = new JButton();
        clear.setText("Clear Area");
        clear.setFocusable(false);
        clear.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        clear.setForeground(Color.white);
        clear.setBackground(Color.BLACK);
        clear.setBounds(765,350,100,35);
        clear.addActionListener(a->{
            area.setText("");
        });
        add(clear);

        //_________________________________________________________________________________________________________//

        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Text Editor");
        setSize(950,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon iconImage = new ImageIcon(getClass().getResource("/Icon.png"));
        setIconImage(iconImage.getImage());
        setLocationRelativeTo(null);
        setVisible(true);
    }
}