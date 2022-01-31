public class EditMenu {
	
	GUI gui;
	
	public EditMenu(GUI gui) {
		this.gui = gui;
	}
	
	public void undo() {
		gui.um.undo();
	}
	
	public void redo() {
		gui.um.redo();
	}
	
}
