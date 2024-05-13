import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.File;

import java.io.*;


public class Connect4Game {
    
    // Define the size of the game board
    private final int COLSIZE = 6;
    private final int ROWSIZE = 7;

    // Swing components
    private JFrame frame; // The main window
    private JTextField player1Field; // Input field for player 1's name
    private JTextField player2Field; // Input field for player 2's name
    private JLabel timerLabel; // Label to display the timer
    private Timer timer; // Timer for the game
    private int time; // Time elapsed
    private JPanel centerPanel; // Panel to hold the game board
    

    public Connect4Game() {
        // Initialize the main window
        
        loadStartScreen();
    }

    private void loadStartScreen() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        frame.setSize(800, 600); // Set the size of the window
        frame.setLayout(new BorderLayout()); // Use BorderLayout for the main window
    
               // Specify the absolute file path to your image
        String filePath = "C:\\Users\\sumay\\OneDrive\\Pictures\\PP.png";
        
        // Load the background image using the absolute file path
        ImageIcon imageIcon = new ImageIcon(filePath);
        Image image = imageIcon.getImage();


        // Initialize the center panel with a custom paintComponent method to draw the
        // background image
        centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this); // Draw the background image
            }
        };
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for the center panel

        // Initialize the welcome label


        // Initialize the begin button
        JButton beginButton = new JButton("Begin");
        beginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                getPlayerNames(); // Get the player names when the button is clicked
            }
        });
          
                // Set button properties
        beginButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        beginButton.setBackground(Color.WHITE); // Set the background color
        beginButton.setForeground(Color.PINK); // Set the text color
        beginButton.setFont(new Font("Arial", Font.BOLD, 23)); // Set font
        beginButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Set padding
        beginButton.setPreferredSize(new Dimension(100, 50)); // Set preferred size
        beginButton.setMaximumSize(new Dimension(100, 50)); // Set maximum size

        // Add the welcome label and begin button to the center panel
        centerPanel.add(Box.createVerticalGlue());
      
        centerPanel.add(beginButton);
        centerPanel.add(Box.createVerticalGlue());

        // Add the center panel to the main window
        frame.add(centerPanel, BorderLayout.CENTER);

        // Make the window visible
        frame.setVisible(true);
    }

    private void getPlayerNames() {
        // Remove all components from the center pane
        centerPanel.removeAll();
        // Set the layout of the center panel to BoxLayout with vertical alignment
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        // Create a panel for player 1's name input
        JPanel player1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        player1Panel.setOpaque(false); // Make the panel transparent
        JLabel player1Label = new JLabel("Player 1's Name:"); // Label for player 1's name
        player1Label.setForeground(Color.WHITE); // Set the label's color to white

        player1Field = new JTextField(); // Text field for player 1 to enter their name
        player1Field.setPreferredSize(new Dimension(215, 30)); // Set the preferred size of the text field

        player1Panel.add(player1Label); // Add the label to the panel
        player1Panel.add(player1Field); // Add the text field to the panel

        // Create a panel for player 2's name input, similar to the above
        JPanel player2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        player2Panel.setOpaque(false);

        JLabel player2Label = new JLabel("Player 2's Name:");
        player2Label.setForeground(Color.WHITE);

        player2Field = new JTextField();
        player2Field.setPreferredSize(new Dimension(215, 30));

        player2Panel.add(player2Label);
        player2Panel.add(player2Field);

        // Create a button to start the game
        JButton okButton = new JButton("Begin Game");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
    
                displayBoard(); // When the button is clicked, call the displayBoard() method to start the game
            }
        });
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally
        okButton.setPreferredSize(new Dimension(100, 50)); // Set the preferred size of the button

        // Add the panels and the button to the center panel, with vertical glue between
        // them for spacing
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(player1Panel);
        centerPanel.add(player2Panel);
        centerPanel.add(okButton);
        centerPanel.add(Box.createVerticalGlue());

        // Validate and repaint the frame to reflect the changes
        frame.validate();
        frame.repaint();
    }

    private void displayBoard() {
        // Remove all components from the frame
        frame.getContentPane().removeAll();
        

        // Set the layout of the frame to BorderLayout
        frame.setLayout(new BorderLayout());

        // Set the background color of the frame to white
                // Set the background color of the frame to white
        frame.setBackground(Color.BLUE);

        // Call the displayHeaders() method to display the headers
        displayHeaders();

        // Call the displayBoardPanel() method to display the game board
        displayBoardPanel();

        // Validate and repaint the frame to reflect the changes
        frame.validate();
        frame.repaint();

        // Start the timer
        startTimer();
    }
    
    private void handleSessionOption(String option) {
        switch (option) {
            case "Host":
                // Handle host option
                break;
            case "Join":
                // Handle join option
                break;
            case "Exit":
                // Handle exit option
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }

                break;
        }
    }

    private void displayHeaders() {
        // Create a label for the title and set its font
        JLabel headerJLabel = new JLabel("Timed Connect 4", SwingConstants.CENTER);
        headerJLabel.setFont(new Font("Serif", Font.BOLD, 30));

        // Create a panel for the headers and add the title label to it
        JPanel headerPanel = new JPanel(new GridLayout(4, 1));
        headerPanel.add(headerJLabel);
         // Set the background color of the header panel to yellow
;

        // Create a dropdown for the session options
        String[] sessionOptions = { "Session", "Host", "Join", "Exit" };
        JComboBox<String> sessionDropdown = new JComboBox<>(sessionOptions);
        sessionDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When an option is selected, call the handleSessionOption() method to handle
                // it
                String selectedOption = (String) sessionDropdown.getSelectedItem();
                if (!"Session".equals(selectedOption)) {
                    handleSessionOption(selectedOption);
                    // After handling the option, set the selected item back to "Session"
                    sessionDropdown.setSelectedItem("Session");
                }
            }
        });
        // Add the dropdown to the header panel
        headerPanel.add(sessionDropdown);

        // Create a label for the timer

        timerLabel = new JLabel("Time:" + String.format("%-6d", time), SwingConstants.RIGHT);

        // Create a panel for the game data, which includes the players' names and the
        // timer
        JPanel gameDataPanel = new JPanel(new GridLayout(1, 2));
        gameDataPanel.add(new JLabel(player1Field.getText() + " (Red)" + " vs " + player2Field.getText() + " (Black)",
                SwingConstants.LEFT));
        gameDataPanel.add(timerLabel);

        // Add the game data panel to the header panel
        headerPanel.add(gameDataPanel);

        // Add the header panel to the frame
        frame.add(headerPanel, BorderLayout.NORTH);
    }

    private void displayBoardPanel() {
            // Create a 2D array of CircleButton objects to represent the game board
            CircleButton[][] buttons = new CircleButton[ROWSIZE][COLSIZE];
    
            // Create a JPanel with a GridBagLayout to hold the buttons
            JPanel boardPanel = new JPanel(new GridBagLayout());
    
            // Create a GridBagConstraints object to specify constraints for the layout
            GridBagConstraints gbc = new GridBagConstraints();
    
            // Loop through each row and column of the game board
            for (int i = 0; i < ROWSIZE; i++) {
                for (int j = 0; j < COLSIZE; j++) {
                    // Create a new CircleButton and add it to the buttons array
                    buttons[i][j] = new CircleButton();
    
                    // Set the maximum and preferred size of the button
                    buttons[i][j].setMaximumSize(new Dimension(50, 50));
                    buttons[i][j].setPreferredSize(new Dimension(50, 50));
    
                    // Add an ActionListener to the button
                    final int row = i;
                    final int col = j;
                    buttons[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // When the button is clicked, set its background color to red
                            buttons[row][col].setBackground(Color.RED);
                        }
                    });
    
                    // Set the gridx and gridy constraints to the current column and row
                    gbc.gridx = j;
                    gbc.gridy = i;
    
                    // Set the insets constraint to specify the padding around the button
                    gbc.insets = new Insets(3, 0, 0, 2);
    
                    // Add the button to the boardPanel with the specified constraints
                    boardPanel.add(buttons[i][j], gbc);
                }
            }
    
            // Create a wrapper JPanel to hold the boardPanel
            JPanel wrapperPanel = new JPanel();
            wrapperPanel.setPreferredSize(new Dimension(800, 800));
            wrapperPanel.setBackground(Color.BLUE);
            wrapperPanel.setLayout(new BorderLayout());
            wrapperPanel.add(boardPanel, BorderLayout.CENTER);
    
            // Add the wrapperPanel to the frame in the center
            frame.add(wrapperPanel, BorderLayout.CENTER);
    }

    private void startTimer() {
        // Set the initial time to 0
        time = 0;

        // Create a new Timer that fires an action event every 1000 milliseconds (1
        // second)
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Increment the time by 1
                time++;

                // Format the time with leading spaces and update the timerLabel text
                String formattedTime = String.format("%-6d", time);
                timerLabel.setText("Time: " + formattedTime);
            }
        });

        // Start the timer
        timer.start();
    }

    private void stopTimer() {
        time = 0;
        if (timer != null) {
            timer.restart();
            timer.stop();
        }
    }

    public static void main(String[] args) {
     
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Inside the run method, a new instance of Connect4Game is created.
                // This presumably sets up and starts the game.
                new Connect4Game();

            }
        });
    }
}
