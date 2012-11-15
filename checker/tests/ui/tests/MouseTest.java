import java.awt.event.*;
import guitypes.checkers.quals.*;

// Test the stub file handling
@UIType
class MouseTest extends MouseAdapter {
    public void mouseEntered(MouseEvent arg0) {
        IAsyncUITask t = null;
        t.doStuff();
    }
}
