public class EditMenu {
	
	Gui gui;
	
	public EditMenu(Gui gui) {
		this.gui = gui;
	}
	
	public void undo() {
		gui.um.undo();
	}
	
	public void redo() {
		gui.um.redo();
	}
	
}
