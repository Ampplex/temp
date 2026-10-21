import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class Exp06_TextEditor extends JFrame {
    private final JTextArea area = new JTextArea();
    public Exp06_TextEditor() {
        setTitle("Mini Text Editor"); setSize(600, 400); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar(); JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open"), save = new JMenuItem("Save"), exit = new JMenuItem("Exit");
        file.add(open); file.add(save); file.addSeparator(); file.add(exit); bar.add(file); setJMenuBar(bar);
        add(new JScrollPane(area));
        open.addActionListener(e -> openFile()); save.addActionListener(e -> saveFile()); exit.addActionListener(e -> dispose());
        setLocationRelativeTo(null); setVisible(true);
    }
    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try { area.setText(Files.readString(chooser.getSelectedFile().toPath())); }
            catch (IOException ex) { JOptionPane.showMessageDialog(this, "Could not open file: " + ex.getMessage()); }
        }
    }
    private void saveFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try { Files.writeString(chooser.getSelectedFile().toPath(), area.getText()); }
            catch (IOException ex) { JOptionPane.showMessageDialog(this, "Could not save file: " + ex.getMessage()); }
        }
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp06_TextEditor::new); }
}
