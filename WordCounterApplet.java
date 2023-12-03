import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="WordCounterApplet.class" width="300" height="300">  
</applet>  */ 
public class WordCounterApplet extends Applet implements ActionListener {
    private Label titleLabel;
    private Label wordCountLabel;
    private ScrollPane scrollPane;
    private TextField inputField;
    private Button countButton;

    public void init() {
        // Change background color to yellow
        setBackground(new Color(255, 255, 0)); // Yellow color

        // Change the foreground color to light purple
        setForeground(new Color(255,0,0)); // Light Purple color

        // Create labels
        titleLabel = new Label("Word Counter");
        wordCountLabel = new Label("Word Count: 0");

        // Create text field
        inputField = new TextField(40); // Increase the size of the input text box

        // Wrap the text field in a ScrollPane
        scrollPane = new ScrollPane();
        scrollPane.add(inputField);

        // Create buttons
        countButton = new Button("Count Words");

        // Add action listener to the button
        countButton.addActionListener(this);

        // Set the layout manager of the applet to FlowLayout with center alignment
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add components to the applet
        add(titleLabel);
        add(scrollPane);
        add(countButton);
        add(wordCountLabel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String inputText = inputField.getText();
            int wordCount = countWords(inputText);
            wordCountLabel.setText("Word Count: " + wordCount);
        }
    }

    private int countWords(String text) {
        text = text.trim(); // Remove leading and trailing spaces
        if (text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+"); // Split by whitespace
        return words.length;
    }

    public void paint(Graphics g) {
        // Draw an ellipse
       g.setColor(Color.pink);
      g.fillArc(-50,-50,100,100,0,-90);
      g.setColor(Color.pink);
      g.fillArc(-50,610,100,100,0,90);
       g.setColor(Color.pink);
      g.fillArc(1325,-50,100,100,0,270);
g.setColor(Color.pink);
      g.fillArc(1325,610,100,100,0,180);
        g.setColor(Color.BLUE);
        g.fillOval(490, 225, 300, 100);

        // Set the color and font for the welcome message
        g.setColor(Color.PINK);
        g.setFont(new Font("SansSerif", Font.BOLD, 20));

        // Display the welcome message inside the ellipse
        g.drawString("Welcome to Word Counter", 515, 280);
    }
}