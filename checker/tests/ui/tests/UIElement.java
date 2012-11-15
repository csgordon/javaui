import guitypes.checkers.quals.*;

@UIType
public interface UIElement {
    public void dangerous();
    @SafeEffect public void repaint();
    @SafeEffect public void runOnUIThread(IAsyncUITask task);
}
