
package perpustakaankampus;

//import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import javax.swing.UIManager;
import perpustakaankampus.Gui.Petugas;
import perpustakaankampus.Gui.Main;


public class PerpustakaanKampus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          try {
            
               
    
    //UIManager.setLookAndFeel(new GTKLookAndFeel());
     java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                   Main mn = new Main();
                   mn.setVisible(true);
                  
                    
                }
            });
    
    
        } catch (Exception e) {
        }
    }
}
