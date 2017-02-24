import java.awt.Color;
import java.awt.Graphics;

public class Block implements Drawable{
	int x;
	int y;
	
	Color color;
	
	public Block(int x, int y) {
		this.x = x;
		this.y = y;
		
		color = new Color(	(int)(Math.random() * 256),
							(int)(Math.random() * 256),
							(int)(Math.random() * 256)	);
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setColor(int r, int g, int b) {
		this.color = new Color(r, g, b);
	}

	@Override
	public void Draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 40, 40);
	}
}