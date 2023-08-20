import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderDemo implements ChangeListener {
    // Declare global variables
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;


    // Constructor
    SliderDemo() {
        frame = new JFrame("Slider Demo");
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0, 100, 50);
        // set the preferred size of the slider
        slider.setPreferredSize(new Dimension(420, 200));
        // Add tick paints to the slider
        slider.setPaintTicks(true);
        // Add tick spacing
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        // Add values to the major track values
        slider.setPaintLabels(true);

        // Change the font of the slider values, and its value
        slider.setFont(new Font("MV Boli", Font.PLAIN, 15));

        // Change the slider to be vertical
        slider.setOrientation(SwingConstants.VERTICAL);
        // Change it back to horizontal portrait
        // slider.setOrientation(SwingConstants.HORIZONTAL);

        // Add a change listener to the slider
        slider.addChangeListener(this);
        
        // Add a label below the slider
        label.setText("Degrees in Celsius = " + slider.getValue());
        label.setFont(new Font("MV Boli", Font.PLAIN, 25));



        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    @Override
    public void stateChanged(ChangeEvent e) {
        // Enable the slider to change its value when you click another
        label.setText("Degrees in Celsius = " + slider.getValue());
    }
}
