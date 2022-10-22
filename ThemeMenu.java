import java.awt.Color;

public class ThemeMenu {
	Gui gui;
	
	public ThemeMenu(Gui gui) {
		this.gui = gui;}
	
	public void sColor(String color) {
		switch(color) {
		case "light":
			gui.frame.getContentPane().setBackground(Color.WHITE);
			gui.textArea.setBackground(Color.WHITE);
			gui.textArea.setForeground(Color.BLACK);
			break;
			
		case "dark":
			gui.frame.getContentPane().setBackground(Color.BLACK);
			gui.textArea.setBackground(Color.BLACK);
			gui.textArea.setForeground(Color.WHITE);
			break;
		
		case "pain":
			gui.frame.getContentPane().setBackground(Color.RED);
			gui.textArea.setBackground(Color.RED);
			gui.textArea.setForeground(Color.ORANGE);
			break;
			
		case "blue":
			gui.frame.getContentPane().setBackground(Color.BLUE);
			gui.textArea.setBackground(Color.BLUE);
			gui.textArea.setForeground(Color.LIGHT_GRAY);
			break;}
	}
	
}
