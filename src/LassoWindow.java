import javax.swing.JFrame;

public class LassoWindow extends JFrame{

	private int width = 1600;
	private int height = 1200;
	private String windowTitle = "Lasso";
	
	public LassoWindow(){
		
		setTitle(windowTitle); //set title
		setSize(width, height);
		setExtendedState(MAXIMIZED_BOTH); //open in maximized mode
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //kill all on close
		
		//this must go last
		setVisible(true);
		
	}
	
}
