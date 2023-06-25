package hust.soict.cybersec.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.exception.PlayerException;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;

public class MediaStore extends JPanel
{
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart)
    {
        this.media = media;
        this.cart = cart;

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
        public void actionPerformed(ActionEvent event)
        {
            String button = event.getActionCommand();

            if (button.equals("Play"))
            {
                JFrame jFrame = new JFrame();

                for (Frame frame : Frame.getFrames()) 
                {
                    if (frame.getTitle().equals("Store")) 
                    {
                        jFrame = (JFrame) frame;
                        break;
                    }
                }

                try {
                    ((Playable) media).play();

                    JDialog playDialog = new JDialog(jFrame, "Play Media", true);
                    playDialog.setLayout(new BorderLayout());

                    StringBuilder s = new StringBuilder();
                    s.append(media.toString());


                    JTextArea textArea = new JTextArea(s.toString(), 5, 20);
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);

                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


                    playDialog.add(scrollPane, BorderLayout.CENTER);

                    JButton btnExit = new JButton("Exit");
                    btnExit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            playDialog.setVisible(false);
                        }
                    });

                    playDialog.add(btnExit, BorderLayout.SOUTH);
                    playDialog.setSize(300, 200);
                    playDialog.setLocationRelativeTo(jFrame);
                    playDialog.setVisible(true);
                } catch (PlayerException e) {
                    JOptionPane.showMessageDialog(
                            jFrame,
                            e.getMessage(),
                            "media length is smaller than 0!",
                            JOptionPane.ERROR_MESSAGE
                    );
                    //e.printStackTrace();
                }
            }
            else if (button.equals("Add to cart"))
            {
                JFrame jFrame = new JFrame();
                for (Frame frame : Frame.getFrames()) 
                {
                    if (frame.getTitle().equals("Store")) 
                    {
                        jFrame = (JFrame) frame;
                        break;
                    }
                }

                if (!cart.getItemsOrdered().contains(media))
                {
                    cart.addMedia(media);
                    JOptionPane.showMessageDialog(
                        jFrame,
                        "The Media has been added succesfully!",
                        "Adding alert",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(
                        jFrame,
                        "The Media has already been added in the past!",
                        "Adding error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
