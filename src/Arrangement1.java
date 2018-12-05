import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Arrangement1 {
	JFrame frame = new JFrame();
	ImageIcon lfra = new ImageIcon("/images/LargeFloralHeavyRing.jpg");
	JLabel label = new JLabel(lfra);
	frame.add(label);
	frame.setSize(400,400);
	frame.setVisible(true);
}
