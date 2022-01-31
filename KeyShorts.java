import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyShorts implements KeyListener{
	
	GUI gui;
	
	public KeyShorts(GUI gui) {
		this.gui = gui;
	}

	@Override
	public void keyTyped(KeyEvent e){}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.fileSave();
		}else if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.fileSaveAs();
		}else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {
			gui.file.fileOpen();
		}else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {
			gui.file.fileNew();
		}else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z) {
			gui.edit.undo();
		}else if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y) {
			gui.edit.redo();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
