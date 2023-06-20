package hust.soict.cybersec.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.cybersec.aims.media.CompactDisc;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import hust.soict.cybersec.aims.media.Track;

public class MediaStore extends JPanel
{
    private Media media;
    public MediaStore(Media media)
    {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton btnAdd = new JButton("Add to cart");
        btnAdd.addActionListener(new ButtonListener());
        container.add(btnAdd);
        if (media instanceof Playable)
        {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(new ButtonListener());
            container.add(btnPlay);
            
        }


        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String button = e.getActionCommand();

            if (button.equals("Play"))
            {
                JDialog playDialog = new JDialog();
                playDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
                playDialog.add(new JLabel(media.toString()));
                // StringBuilder s = new StringBuilder();
                // s.append(media.toString() + "\n");
                if (media instanceof CompactDisc)
                {
                    for (Track track: ((CompactDisc) media).getTracks())
                    {
                        
                        playDialog.add(new JLabel(track.toString()));

                    }
                }
                // JLabel l = new JLabel(s.toString());
            
 
                // setsize of dialog
                playDialog.setSize(500, 500);
                
                // set visibility of dialog
                playDialog.setVisible(true);
            }
            else if (button.equals("Add to cart"))
            {
                StoreScreen.cart.addMedia(media);
            }
        }
    }
}
