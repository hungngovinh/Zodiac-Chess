import java.awt.Graphics;

import javax.swing.JApplet;

public class appletDemo extends JApplet {
	public void paint(Graphics g) {
		  g.drawString("Hi this is a test", 50, 50);
		}
	
	
   public void init() {
      try {
         javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               createGUI();
            }
         });
      } catch (Exception e) {
         System.err.println("createGUI didn't successfully complete");
      }
   }

   private void createGUI() {
      getContentPane().add(new GUIdemo());
   }
}