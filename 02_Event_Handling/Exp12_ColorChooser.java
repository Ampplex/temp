import javax.swing.*;
import java.awt.*;

public class Exp12_ColorChooser extends JFrame {
    public Exp12_ColorChooser() {
        setTitle("Color Chooser"); setSize(400, 250); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton choose = new JButton("Choose Background Color"); JPanel panel = new JPanel(new BorderLayout()); panel.add(choose, BorderLayout.CENTER);
        choose.addActionListener(e -> { Color color = JColorChooser.showDialog(this, "Select a Color", panel.getBackground()); if (color != null) panel.setBackground(color); });
        add(panel); setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp12_ColorChooser::new); }
}
