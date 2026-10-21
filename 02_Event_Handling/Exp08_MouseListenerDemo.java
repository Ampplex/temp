import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp08_MouseListenerDemo extends JFrame implements MouseListener {
    private final JLabel message = new JLabel("Click or move the mouse inside the panel", SwingConstants.CENTER);
    public Exp08_MouseListenerDemo() {
        setTitle("MouseListener Demo"); setSize(450, 250); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(); panel.setBackground(Color.LIGHT_GRAY); panel.addMouseListener(this); add(panel, BorderLayout.CENTER); add(message, BorderLayout.SOUTH);
        setLocationRelativeTo(null); setVisible(true);
    }
    public void mouseClicked(MouseEvent e) { message.setText("Mouse clicked at: " + e.getX() + ", " + e.getY()); }
    public void mousePressed(MouseEvent e) { message.setText("Mouse pressed"); }
    public void mouseReleased(MouseEvent e) { message.setText("Mouse released"); }
    public void mouseEntered(MouseEvent e) { message.setText("Mouse entered panel"); }
    public void mouseExited(MouseEvent e) { message.setText("Mouse exited panel"); }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp08_MouseListenerDemo::new); }
}
