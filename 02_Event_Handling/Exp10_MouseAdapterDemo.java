import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exp10_MouseAdapterDemo extends JFrame {
    public Exp10_MouseAdapterDemo() {
        setTitle("MouseAdapter Demo"); setSize(420, 220); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel message = new JLabel("Click anywhere in this window", SwingConstants.CENTER);
        add(message);
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) { message.setText("Clicked at x=" + e.getX() + ", y=" + e.getY()); }
        });
        setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp10_MouseAdapterDemo::new); }
}
