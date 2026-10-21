import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp09_KeyListenerDemo extends JFrame implements KeyListener {
    private final JLabel status = new JLabel("Type in the text field", SwingConstants.CENTER);
    public Exp09_KeyListenerDemo() {
        setTitle("KeyListener Demo"); setSize(400, 180); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField field = new JTextField(); field.addKeyListener(this); add(field, BorderLayout.CENTER); add(status, BorderLayout.SOUTH);
        setLocationRelativeTo(null); setVisible(true); field.requestFocusInWindow();
    }
    public void keyTyped(KeyEvent e) { status.setText("Key typed: " + e.getKeyChar()); }
    public void keyPressed(KeyEvent e) { status.setText("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode())); }
    public void keyReleased(KeyEvent e) { status.setText("Key released: " + KeyEvent.getKeyText(e.getKeyCode())); }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp09_KeyListenerDemo::new); }
}
