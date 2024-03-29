import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Gui implements ActionListener {
	
	//  FUNCTION GETTER
	FileMenu file = new FileMenu(this);
	EditMenu edit = new EditMenu(this);
	FormatMenu format = new FormatMenu(this);
	ThemeMenu theme = new ThemeMenu(this);
	KeyShorts key = new KeyShorts(this);
	//  TEXT AREA
	JFrame frame;
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrap = false;
	//  TOP MENU BAR
	JMenuBar menuBar;
	JMenu fileMenu, editMenu, formatMenu, themeMenu;
	//  FILE MENU
	JMenuItem fNew, fOpen, fSave, fSaveAs, fExit;
	//  EDIT MENU
	JMenuItem undo, redo;
	UndoManager um = new UndoManager();
	//  FORMAT MENU
	JMenu font, fontSize;
	JMenuItem formatWordWrap, fontArial, fontCMS, fontTNR;
	JMenuItem fontSize8, fontSize12, fontSize16, fontSize20, fontSize24, fontSize28;
	//  THEMES MENU
	JMenuItem dark, light, pain, blue;
	
	public void frame() {
		frame = new JFrame("TYPER");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		}
	
	public void textArea() {
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());		frame.add(scrollPane);
		textArea.addKeyListener(key);
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
					um.addEdit(e.getEdit());}});		}
	
	public void menuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		formatMenu = new JMenu("Format");
		themeMenu = new JMenu("Themes");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		menuBar.add(themeMenu);		}
	
	public void fileMenu() {
		fNew = new JMenuItem("New");
		fNew.setActionCommand("New");
		fNew.addActionListener(this);
		fileMenu.add(fNew);
		
		fOpen = new JMenuItem("Open");
		fOpen.setActionCommand("Open");
		fOpen.addActionListener(this);
		fileMenu.add(fOpen);
		
		fSave = new JMenuItem("Save");
		fSave.setActionCommand("Save");
		fSave.addActionListener(this);
		fileMenu.add(fSave);
		
		fSaveAs = new JMenuItem("Save As");
		fSaveAs.setActionCommand("SaveAs");
		fSaveAs.addActionListener(this);
		fileMenu.add(fSaveAs);
		
		fExit = new JMenuItem("Exit");
		fExit.setActionCommand("Exit");
		fExit.addActionListener(this);
		fileMenu.add(fExit);		}
	
	public void editMenu(){
		undo = new JMenuItem("Undo");
		undo.setActionCommand("undo");
		undo.addActionListener(this);
		editMenu.add(undo);
		
		redo = new JMenuItem("Redo");
		redo.setActionCommand("redo");
		redo.addActionListener(this);
		editMenu.add(redo);		}
	
	public void formatMenu() {
		formatWordWrap = new JMenuItem("Word Wrap: on");
		formatWordWrap.setActionCommand("WordWrap");
		formatWordWrap.addActionListener(this);
		formatMenu.add(formatWordWrap);
		
		
		font = new JMenu("Font");
		formatMenu.add(font);
		
		fontArial = new JMenuItem("Arial");
		fontArial.setActionCommand("Arial");
		fontArial.addActionListener(this);
		font.add(fontArial);
		
		fontCMS = new JMenuItem("Comic Sans MS");
		fontCMS.setActionCommand("CMS");
		fontCMS.addActionListener(this);
		font.add(fontCMS);
		
		fontTNR = new JMenuItem("Time New Roman");
		fontTNR.setActionCommand("TNR");
		fontTNR.addActionListener(this);
		font.add(fontTNR);
		
		
		fontSize = new JMenu("Font Size");
		formatMenu.add(fontSize);
		
		fontSize8 = new JMenuItem("8");
		fontSize8.setActionCommand("fs8");
		fontSize8.addActionListener(this);
		fontSize.add(fontSize8);
		
		fontSize12 = new JMenuItem("12");
		fontSize12.setActionCommand("fs12");
		fontSize12.addActionListener(this);
		fontSize.add(fontSize12);
		
		fontSize16 = new JMenuItem("16");
		fontSize16.setActionCommand("fs16");
		fontSize16.addActionListener(this);
		fontSize.add(fontSize16);
		
		fontSize20 = new JMenuItem("20");
		fontSize20.setActionCommand("fs20");
		fontSize20.addActionListener(this);
		fontSize.add(fontSize20);
		
		fontSize24 = new JMenuItem("24");
		fontSize24.setActionCommand("fs24");
		fontSize24.addActionListener(this);
		fontSize.add(fontSize24);
		
		fontSize28 = new JMenuItem("28");
		fontSize28.setActionCommand("fs28");
		fontSize28.addActionListener(this);
		fontSize.add(fontSize28);		}
	
	public void colorMenu(){
		dark = new JMenuItem("Dark");
		dark.setActionCommand("dark");
		dark.addActionListener(this);
		themeMenu.add(dark);
		
		light = new JMenuItem("Light");
		light.setActionCommand("light");
		light.addActionListener(this);
		themeMenu.add(light);
		
		pain = new JMenuItem("Pain");
		pain.setActionCommand("pain");
		pain.addActionListener(this);
		themeMenu.add(pain);
		
		blue = new JMenuItem("Blue");
		blue.setActionCommand("blue");
		blue.addActionListener(this);
		themeMenu.add(blue);		}
	
	public void configMaker() throws Exception {	// Just Makes If Not Exist
    		Properties pm = new Properties();  
    		pm.setProperty("theme","dark");  
    		pm.setProperty("font","arial");
    		pm.setProperty("font-size","16");
    		pm.setProperty("word-wrap","false");
    		pm.store(new FileWriter("TYPER.properties"), "TYPER CONFIG FILE");			}

	@Override
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "New": file.fileNew();break;
		case "Open": file.fileOpen();break;
		case "Save": file.fileSave();break;
		case "SaveAs": file.fileSaveAs();break;
		case "Exit": file.fileExit();break;
	
		case "undo": edit.undo();break;
		case "redo": edit.redo();break;
		
		case "WordWrap":format.wordWrap();
		case "Arial": format.sFont("Arial");break;
		case "CMS": format.sFont("Comic Sans MS");break;
		case "TNR": format.sFont("Times New Roman");break;
			
		case "fs8": format.font(8);break;
		case "fs12": format.font(12);break;
		case "fs16": format.font(16);break;
		case "fs20":format.font(20);;break;
		case "fs24":format.font(24);break;
		case "fs28":format.font(28);break;
		
		case "dark": theme.sColor(cmd);
		case "light": theme.sColor(cmd);
		case "pain": theme.sColor(cmd);
		case "blue": theme.sColor(cmd);	}				}
	
}
