package com.game.gui;

import javax.swing.*;

import com.game.characters.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GameGUI class represents the main graphical user interface for the Cult Simulator game.
 */
public class GameGUI extends JFrame {
    private static final long serialVersionUID = 2256406150316982517L;
    User user = new User();
    
    /**
     * Constructs a new instance of the GameGUI class.
     * Initializes the main frame and the panels.
     */
    public GameGUI() {
        setTitle("Cult Simulator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initGameplayPanel();
        initSummaryPanel();
        
        setVisible(true);
    }
    
    /**
     * Initializes the summary panel containing information about the User's money, stress, and reputation.
     */
    public void initSummaryPanel() {
        JPanel bottomLeftPanel = new JPanel();
        bottomLeftPanel.setPreferredSize(new Dimension(500, 100)); 
        bottomLeftPanel.setLayout(new BoxLayout(bottomLeftPanel, BoxLayout.Y_AXIS));
        bottomLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bottomLeftPanel.setBackground(new Color(220, 220, 220));

        // Add labels and progress bars for money, stress, and reputation
        JLabel moneyValueLabel = new JLabel("$" + user.getMoney());
        JLabel stressLabel = new JLabel("Stress");
        ProgressBar stress = new ProgressBar(100, Color.RED, 400, 20);
        JLabel reputationLabel = new JLabel("Reputation");
        ProgressBar reputation = new ProgressBar(100, Color.ORANGE, 400, 20);

        bottomLeftPanel.add(moneyValueLabel);
        bottomLeftPanel.add(stressLabel);
        bottomLeftPanel.add(stress);
        bottomLeftPanel.add(reputationLabel);
        bottomLeftPanel.add(reputation);

        // Create a JPanel for the bottom right section
        JPanel bottomRightPanel = new JPanel(new GridBagLayout());
        bottomRightPanel.setBackground(new Color(220, 220, 220));

        Button nextDayButton = new Button("Next Day", Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.WHITE, 200, 50, 10);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        bottomRightPanel.add(nextDayButton, gbc);

        // Add both the bottom left and bottom right panels to the summary panel
        JPanel summaryPanel = new JPanel(new BorderLayout());
        summaryPanel.add(bottomLeftPanel, BorderLayout.WEST); 
        summaryPanel.add(bottomRightPanel, BorderLayout.CENTER); 

        getContentPane().add(summaryPanel, BorderLayout.SOUTH);
    }

    /**
     * Initializes the gameplay panel, which includes navigation buttons.
     */
    private void initGameplayPanel() {
        JPanel leftPanel = initNavigation();

        // Create a dynamic right panel for switching content
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(600, 400));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(leftPanel, BorderLayout.WEST);
        containerPanel.add(rightPanel, BorderLayout.CENTER);

        getContentPane().add(containerPanel, BorderLayout.CENTER);
    }

    /**
     * Initializes the navigation panel containing buttons for stats, events, upgrades, and actions.
     *
     * @return The initialized navigation panel.
     */
    private JPanel initNavigation() {
    	JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setPreferredSize(new Dimension(150, 100));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        Button upgradesButton = new Button("Upgrades", Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.WHITE, 150, 180, 0);
        Button actionsButton = new Button("Actions", Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.WHITE, 150, 180, 0);
        Button eventsButton = new Button("Events", Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.WHITE, 150, 180, 0);
        Button statsButton = new Button("Stats", Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.WHITE, 150, 180, 0);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; 
        
        statsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event for Stats
                // Retrieve user variables and display them on screen
                JOptionPane.showMessageDialog(null,
                        "Money: $" + user.getMoney() + "\nReputation: " + user.getReputation() + "\nStress: " + user.getStress(),
                        "Stats", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        eventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event for Events
                // Display sample text to the screen
                JOptionPane.showMessageDialog(null, "Sample Event Text", "Event", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        upgradesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click event for Upgrades
                // You can create and show a dialog with image placeholders and buttons here
                JPanel upgradePanel = new JPanel(new GridLayout(2, 3));

                for (int i = 0; i < 6; i++) {
                    upgradePanel.add(new Button("Upgrade " + (i + 1), Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.WHITE, 150, 50, 0));
                }

                JOptionPane.showMessageDialog(null, upgradePanel, "Upgrades", JOptionPane.PLAIN_MESSAGE);
            }
        });
        gbc.gridy = 0;
        leftPanel.add(statsButton, gbc);
        gbc.gridy = 1;
        leftPanel.add(eventsButton, gbc);
        gbc.gridy = 2; 
        leftPanel.add(upgradesButton, gbc);
        gbc.gridy = 3;
        leftPanel.add(actionsButton, gbc);
        
        return leftPanel;
    }
}
