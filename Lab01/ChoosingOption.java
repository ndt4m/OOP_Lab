import javax.sound.midi.SysexMessage;
import javax.swing.JOptionPane;
public class ChoosingOption 
{
    public static void main(String[] args)
    {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
        //if the users choose "Cancel", it will return "You've choosen No"

        /***Customize to only show "Yes" or "No"***/
        // int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", null, JOptionPane.YES_NO_OPTION);
        // JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
        // System.exit(0);

        /***Customize to only show "I do" or "I don't"***/
        // String[] options = {"I do", "I don't"};
        // int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        // JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"I do":"I don't"));
        // System.exit(0);
    }
}
