import javax.swing.*;
import java.awt.*;

public class Blocks extends JFrame {
	public static final int START_BUTTON_WIDTH = 200;
	public static final int START_BUTTON_HEIGHT = 100;
	
	public static final int EXIT_BUTTON_WIDTH = 200;
	public static final int EXIT_BUTTON_HEIGHT = 100;
	
	public Blocks() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel titleLabel = new JLabel("Test", SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		titleLabel.setPreferredSize(new Dimension(400, 100));
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		
		JLabel pictureLabel = new JLabel(new ImageIcon("img1.jpg"));
		c.gridx = 0;
		c.gridy = 1;
		add(pictureLabel, c);
		
		JPanel panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints cPanel1 = new GridBagConstraints();
		
		JLabel emptyLabel = new JLabel();
		emptyLabel.setPreferredSize(new Dimension(100, 200));
		cPanel1.gridx = 0;
		cPanel1.gridy = 0;
		panel1.add(emptyLabel, cPanel1);
		
		/* Inner button Panel */
		JPanel panel2 = new JPanel(new GridLayout(5, 1));
		
		JLabel emptyLabel3 = new JLabel();
		JButton startButton = new JButton("START");
		JLabel emptyLabel4 = new JLabel();
		JButton exitButton = new JButton("EXIT");
		JLabel emptyLabel5 = new JLabel();
		
		panel2.add(emptyLabel3);
		panel2.add(startButton);
		panel2.add(emptyLabel4);
		panel2.add(exitButton);
		panel2.add(emptyLabel5);
		
		panel2.setPreferredSize(new Dimension(200, 200));
		
		cPanel1.gridx = 1;
		cPanel1.gridy = 0;
		cPanel1.gridwidth = 2;
		panel1.add(panel2, cPanel1);
		/*--------------------*/
		
		JLabel emptyLabel6 = new JLabel();
		emptyLabel6.setPreferredSize(new Dimension(100, 200));
		cPanel1.gridx = 3;
		cPanel1.gridy = 0;
		cPanel1.gridwidth = 1;
		panel1.add(emptyLabel6, cPanel1);
		
		JLabel buttonArea = new JLabel("Button Area", SwingConstants.CENTER);
		buttonArea.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonArea.setPreferredSize(new Dimension(400, 200));
		c.gridx = 0;
		c.gridy = 2;
		add(panel1, c);
	}
	
	public static void main(String[] args) {
		// Create empty frame
		Blocks frame = new Blocks();
		
		frame.setTitle("Blocks");
		//frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
