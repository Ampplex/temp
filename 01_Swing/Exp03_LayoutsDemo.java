import javax.swing.*;
import java.awt.*;

public class Exp03_LayoutsDemo extends JFrame {
    public Exp03_LayoutsDemo() {
        setTitle("FlowLayout, BorderLayout and GridLayout"); setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabs = new JTabbedPane();
        JPanel flow = new JPanel(new FlowLayout());
        flow.add(new JButton("One")); flow.add(new JButton("Two")); flow.add(new JButton("Three"));
        JPanel border = new JPanel(new BorderLayout(5, 5));
        border.add(new JButton("NORTH"), BorderLayout.NORTH); border.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        border.add(new JButton("WEST"), BorderLayout.WEST); border.add(new JButton("EAST"), BorderLayout.EAST);
        border.add(new JButton("CENTER"), BorderLayout.CENTER);
        JPanel grid = new JPanel(new GridLayout(2, 3, 5, 5));
        for (int i = 1; i <= 6; i++) grid.add(new JButton("Button " + i));
        tabs.addTab("FlowLayout", flow); tabs.addTab("BorderLayout", border); tabs.addTab("GridLayout", grid);
        add(tabs); setLocationRelativeTo(null); setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(Exp03_LayoutsDemo::new); }
}
