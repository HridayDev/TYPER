import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Main {  // main class
	
	// VAR Class Import
	Gui gui = new Gui();
	
	public static void main(String[] args) throws Exception{     new Main();     }
	
	public Main() throws Exception{
		// Call Functions
		gui.frame();
		gui.textArea();
		gui.menuBar();
		gui.fileMenu();
		gui.editMenu();
		gui.formatMenu();
		gui.colorMenu();
		File file = new File("TYPER.properties"); 
		if(!(file.exists())) {		gui.configMaker();		}System.out.println(file.exists() + file.getName() + file.getPath());
		
		// Set Default
	    FileReader reader=new FileReader("TYPER.properties");  
	    Properties p=new Properties();  
	    p.load(reader);  
		gui.format.sFont = p.getProperty("font");
		gui.format.font(Integer.valueOf(p.getProperty("font-size")));
		gui.format.WordWrap = Boolean.parseBoolean(p.getProperty("word-wrap"));		gui.format.wordWrap();
		gui.theme.sColor(p.getProperty("theme"));
		gui.frame.setVisible(true);
	}
	

	
}
