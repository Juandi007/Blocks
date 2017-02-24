import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Blocks extends JFrame {
	public static Block block;
	public static Board board;
	public static JPanel canvas;
	
	public Blocks() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel titleLabel = new JLabel("Blocks", SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		titleLabel.setPreferredSize(new Dimension(400, 100));
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		
		//-----------------------------------------------------------
		/*
		JLabel pictureLabel = new JLabel(new ImageIcon("smile.jpg"));
		c.gridx = 0;
		c.gridy = 1;
		add(pictureLabel, c);
		*/
		
		block = null;
		board = new Board();
		
		canvas = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				board.Draw(g);
				
				if (block != null)
					block.Draw(g);
			}
		};
		
		canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		canvas.setPreferredSize(new Dimension(400, 400));
		c.gridx = 0;
		c.gridy = 1;
		canvas.addKeyListener(new MovementListener());
		canvas.setFocusable(true);
		canvas.requestFocusInWindow();
		add(canvas, c);
		//-----------------------------------------------------------
		
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
		startButton.addActionListener(new ButtonListener());
		JLabel emptyLabel4 = new JLabel();
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ButtonListener());
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
		buttonArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		buttonArea.setPreferredSize(new Dimension(400, 200));
		c.gridx = 0;
		c.gridy = 2;
		add(panel1, c);
	}
	
	public static void main(String[] args) {
		final int FPS = 60;
		
		long startTime = -1;
		long endTime = -1;
		double totalTimeMS = -1;
		
		Blocks testFrame = new Blocks();
		
		testFrame.setTitle("Test");
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.pack();
		testFrame.setVisible(true);
		
		startTime = System.nanoTime();
		endTime = System.nanoTime();
		
		while (true) {
			startTime = System.nanoTime();
			
			update();
			render();
			
			endTime = System.nanoTime();
			
			while ( (endTime - startTime) < (1000000000 / FPS) ) {
				Thread.yield();
				
				endTime = System.nanoTime();
			}
			
			
			totalTimeMS = (endTime - startTime) / 1000000000.;
			//System.out.println("startTime = " + startTime);
			//System.out.println("endTime   = " + endTime);
			//System.out.println("Total time in loop: " + totalTimeMS + " ms");
			
			startTime = System.nanoTime();
			endTime = System.nanoTime();
		}
	}
	
	public static void update() {
	}
	
	public static void render() {
		canvas.requestFocusInWindow();
		canvas.repaint();
	}
	
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton)(e.getSource())).getText();
			
			switch (name) {
				case "START":
					System.out.println("START PRESSED");
					block = new Block(0, 0);
					
					break;
					
				case "EXIT":
					System.out.println("EXIT PRESSED");
					System.exit(0);
					
					break;
					
				default:
					System.out.println("IN DEFAULT");
					
					break;
			}
		}
	}
	
	class MovementListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (block != null) {
				int x = block.getPosX();
				int y = block.getPosY();
				
				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT :
						System.out.println("Left Pressed");
						if (x > 0)
							block.setPos(x - 40, y);
						
						break;
						
					case KeyEvent.VK_DOWN :
						System.out.println("Down Pressed");
						if (y < 360)
							block.setPos(x, y + 40);
						
						break;
						
					case KeyEvent.VK_RIGHT :
						System.out.println("Right Pressed");
						if (x < 360)
							block.setPos(x + 40, y);
						
						break;
						
					case KeyEvent.VK_UP :
						System.out.println("Up Pressed");
						if (y > 0)
							block.setPos(x, y - 40);
						
						break;
						
					case KeyEvent.VK_SPACE :
						System.out.println("Space Pressed");
						block.setColor(	(int)(Math.random() * 256),
										(int)(Math.random() * 256),
										(int)(Math.random() * 256)	);
						
						break;
						
					default :
						System.out.println("Some other key pressed");
						
						break;
				}	
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
