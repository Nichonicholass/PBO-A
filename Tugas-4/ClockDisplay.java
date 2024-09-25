import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

 class ClockDisplay extends JFrame {  
    private static final long serialVersionUID = 1L;  
    JTextField timeField;  
    JPanel panel;  
  
    private NumberDisplay hours;  
    private NumberDisplay minutes;  
    private NumberDisplay seconds;  
    private String displayString; 

    public ClockDisplay() {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60); 

       setSize(600, 300);  
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
       setResizable(true);  
       setLocationRelativeTo(null);  
    
       panel = new JPanel();  
       setLayout(new GridBagLayout());  
       GridBagConstraints gbc = new GridBagConstraints();  
       gbc.gridx = 0;  
       gbc.gridy = 0;  
       gbc.anchor = GridBagConstraints.CENTER;  
    
       timeField = new JTextField(20);  
       timeField.setEditable(false);  
       timeField.setFont(new Font("Arial", Font.PLAIN, 24));  
       timeField.setHorizontalAlignment(JTextField.CENTER);  
    
       panel.add(timeField);  
       panel.setLayout(new FlowLayout(FlowLayout.CENTER));  
       add(panel, gbc);  
    
       Timer t = new Timer(1000, new Listener());  
       t.start();  
       setVisible(true);  
    }

    public String getTime() {
        return displayString;
    }

    public void setTime(int hour, int minute, int second) {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
    }

    public void setTimeString() {  
        displayString = "Current time - " + hours.getDisplayValue() + ":" + minutes.getDisplayValue()  
          + ":" + seconds.getDisplayValue();  
       }  

    public void incerementSecond() {
        seconds.increment();  
        if (seconds.getValue() == 0)  
         minutes.increment();  
        if (minutes.getValue() == 0 && seconds.getValue() == 0)  
         hours.increment();  
    }

    class Listener implements ActionListener {  
      public void actionPerformed(ActionEvent e) {
        setTimeString();  
        timeField.setText(displayString);  
        incerementSecond();  
    }
  }
 }
