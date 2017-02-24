import java.awt.Color;
import java.awt.Graphics;

public class Board implements Drawable{
	private Block[][] board = new Block[10][10];
	
	public Board() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				board[i][j] = null;
			}
		}
	}
	
	public void addBlock(int row, int col, Block block) {
		board[row][col] = block;
	}
	
	public Block getBlock(int row, int col) {
		return board[row][col];
	}
	
	public void deleteBlock(int row, int col) {
		board[row][col] = null;
	}
	
	public boolean hasBlock(int row, int col) {
		if (board[row][col] == null)
			return false;
		else
			return true;
	}
	
	@Override
	public void Draw(Graphics g) {
		g.setColor(Color.BLACK);
		
		g.drawLine(0, 0, 400, 0);
		g.drawLine(0,  0, 0, 400);
		g.drawLine(0, 400, 400, 400);
		g.drawLine(400, 400, 400, 0);
		
		for (int i = 0; i < 10; i++) {
			g.drawLine(i * 40, 0, i * 40, 400);
			g.drawLine(0, i * 40, 400, i * 40);
		}
	}	
}