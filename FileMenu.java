import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileMenu {
	
	GUI gui;
	public String FileName;
	public String FilePath;
	
	
	public FileMenu(GUI gui) {
		this.gui = gui;
	}
	
	public void fileNew() {
		gui.textArea.setText("");
		gui.frame.setTitle("TYPER - New File");
		FileName = null;
		FilePath = null;
	}
	
	public void fileOpen() {
		FileDialog fd = new FileDialog(gui.frame, "Open File", FileDialog.LOAD);
		fd.setVisible(true);
		if(fd.getFile()!=null) {
			FileName = fd.getFile();
			FilePath = fd.getDirectory();
			gui.frame.setTitle(FileName + " - TYPER");}
		try {
			BufferedReader br = new BufferedReader(new FileReader(FilePath + FileName));
			gui.textArea.setText("");
			String line = null;
			while((line = br.readLine()) != null) {
				gui.textArea.append(line + "\n");
			}
			br.close();
		}catch(Exception e) {}
	}
	
	public void fileSave() {
		if(FileName!=null) {
			try {
				FileWriter fw = new FileWriter(FilePath + FileName);
				fw.write(gui.textArea.getText());
				fw.close();
				gui.frame.setTitle(FileName + " - TYPER");
			}catch(Exception e) {
			}
		}else {  fileSaveAs();  }
	}
	
	public void fileSaveAs() {
		FileDialog fd = new FileDialog(gui.frame, "Save File", FileDialog.SAVE);
		fd.setVisible(true);
		if(fd.getFile()!=null) {
			FileName = fd.getFile();
			FilePath = fd.getDirectory();
			gui.frame.setTitle(FileName + " - TYPER");}
		try {
			FileWriter fw = new FileWriter(FilePath + FileName);
			fw.write(gui.textArea.getText());
			fw.close();
		}catch(Exception e) {
		}
	}
	
	public void fileExit() {
		System.exit(0);
	}
}
