import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;

public class FormatMenu {
	GUI gui;
	Font arial, comicSansMS, timesNewRoman;
	String sFont;
	
	public FormatMenu(GUI gui) {
		this.gui = gui;
	}
	
	public void wordWrap() throws IOException {
		if(gui.config.p.getProperty("word-wrap") == "true"){
			gui.config.p.setProperty("word-wrap", "false");
			gui.config.p.store(new FileWriter("TYPER.properties"), "TYPER CONFIG FILE");
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.formatWordWrap.setText("Word Wrap: off");
			
		}else{
			gui.config.p.setProperty("word-wrap", "true");
			gui.config.p.store(new FileWriter("TYPER.properties"), "TYPER CONFIG FILE");
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.formatWordWrap.setText("Word Wrap: on");}
		}
	
	public void font(int fontSize) throws IOException {
		fontSize = 16;
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		sFont(sFont);
	}
	
	public void sFont(String font) throws IOException {
		sFont = font;
		switch(sFont){
		case "Arial":gui.textArea.setFont(arial);
		gui.config.p.setProperty("font", "arial");
		gui.config.p.store(new FileWriter("TYPER.properties"), "TYPER CONFIG FILE");break;
		
		case "Comic Sans MS":gui.textArea.setFont(comicSansMS);
		gui.config.p.setProperty("font", "Comic Sans MS");
		gui.config.p.store(new FileWriter("TYPER.properties"), "TYPER CONFIG FILE");break;
		
		case "Times New Roman":gui.textArea.setFont(timesNewRoman);
		gui.config.p.setProperty("font", "Times New Roman");
		gui.config.p.store(new FileWriter("TYPER.properties"), "TYPER CONFIG FILE");break;
		} 
	}
	
}
