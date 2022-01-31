import java.util.*;  
import java.io.*;  

public class Config {
	
	GUI gui;
	public String theme;
	public String font;
	public String fontSize;
	public String wordWrap;
	public Properties p;
	
	public void read() throws Exception{
		FileReader reader = new FileReader("TYPER.properties"); 
		p = new Properties();
	    p.load(reader);
	    theme = p.getProperty("theme");
	    font = p.getProperty("font");
	    fontSize = p.getProperty("font-size");
	    wordWrap = p.getProperty("word-wrap");
	    
	    switch(theme){
	    case "dark":gui.theme.sColor(theme);break;
	    
	    case "light":gui.theme.sColor(theme);
	    break;
	    
	    case "pain":gui.theme.sColor(theme);
	    break;
	    
	    case "blue":gui.theme.sColor(theme);
	    break;
	    }
	    
	}
	
	public Config(GUI gui) {
		this.gui = gui;
	}
	
}
