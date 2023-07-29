import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CardApp extends Frame {
	public static Random random;
	final public int MAXFIGURES = 20;
	public Figure figures[];
	public int figureCount = 0;
	
	public int clickCount = 0;			// 0 카드, 1 원, 2 정삼각형
	public String selectionMsg = "카드";
	
	public static void main(String[ ] args) {
		CardApp window = new CardApp();
		window.setVisible(true);
	}
	
	public CardApp() {
		setSize(600, 500);
		setTitle("Card 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		
		random = new Random();
		figures = new Figure[Figure.MAXFIGURES];
	}
	
	private class MouseKeeper extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			if(e.getButton() == MouseEvent.BUTTON3) {
			switch(clickCount) {
			case 0: selectionMsg = "원";
					clickCount = 1;
					break;
			case 1: selectionMsg = "정삼각형";
					clickCount = 2;
					break;
			case 2: selectionMsg = "카드";
					clickCount = 0;
				
			}
		}
			else {
				if(figureCount < MAXFIGURES) {
					switch(clickCount) {
					case 0: Card card = new Card(x, y,
							random.nextInt(4), random.nextInt(13));
							card.flip();
							figures[figureCount] = card;
							figureCount++;
							break;
					case 1: Circle circle = new Circle(x, y, 40);
							figures[figureCount] = circle;
							figureCount++;
							break;
					case 2: Triangle triangle = new Triangle(x, y, 100);
							figures[figureCount] = triangle;
							figureCount++;
					}
				}
			}
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		g.drawString(selectionMsg, 40, 70);
		for(int i = 0; i < figureCount; i++)
			figures[i].draw(g);
	}
}
