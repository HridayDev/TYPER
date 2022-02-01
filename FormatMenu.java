import java.awt.Font;

public class FormatMenu {
	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	String sFont;
	public boolean WordWrap;
	
	public FormatMenu(GUI gui) {
		this.gui = gui;
	}
	
	public void wordWrap(){
		if(WordWrap == true){WordWrap = false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.formatWordWrap.setText("Word Wrap: off");
			
		}else{WordWrap = true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.formatWordWrap.setText("Word Wrap: on");}
		}
	
	public void font(int fontSize){
		fontSize = 16;
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		sFont(sFont);
	}
	
	public void sFont(String font) {
		sFont = font;
		switch(sFont){
		case "Arial":gui.textArea.setFont(arial);
		
		case "Comic Sans MS":gui.textArea.setFont(comicSansMS);
		
		case "Times New Roman":gui.textArea.setFont(timesNewRoman);
		} 
	}
	
}
