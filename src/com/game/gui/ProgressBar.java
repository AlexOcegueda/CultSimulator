package com.game.gui;

import javax.swing.*;
import java.awt.*;

/**
 * A custom Swing component that represents a progress bar with rounded edges and a border.
 */
public class ProgressBar extends JComponent {
    private static final long serialVersionUID = -3680692984930066591L;
    private int currentValue;
    private int maximumValue;
    private Color barColor;
    private int barWidth;
    private int barHeight;
    private int borderRadius = 15; 
    private int borderWidth = 2;  
    private Color borderColor = Color.GRAY; 

    /**
     * Constructs a new progress bar with the specified maximum value, bar color, width, and height.
     *
     * @param maximumValue The maximum value of the progress bar.
     * @param barColor     The color of the filled progress bar.
     * @param barWidth     The width of the progress bar.
     * @param barHeight    The height of the progress bar.
     */
    public ProgressBar(int maximumValue, Color barColor, int barWidth, int barHeight) {
        this.maximumValue = maximumValue;
        this.barColor = barColor;
        this.barWidth = barWidth;
        this.barHeight = barHeight;
        this.currentValue = 90;
    }
    
    /**
     * Sets the current value of the progress bar. The value should be between 0 and the maximum value.
     *
     * @param currentValue The current value of the progress bar.
     */
    public void setCurrentValue(int currentValue) {
        if (currentValue >= 0 && currentValue <= maximumValue) {
            this.currentValue = currentValue;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Draw the gray border
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(borderWidth));
        g2d.drawRoundRect(0, 0, barWidth, barHeight, borderRadius, borderRadius);

        // Calculate the width of the filled bar
        int filledWidth = (int) ((double) currentValue / maximumValue * (barWidth - 2 * borderWidth));

        // Set the bar color
        g2d.setColor(barColor);

        // Fill the rounded rectangle for the progress bar
        g2d.fillRoundRect(borderWidth, borderWidth, filledWidth, barHeight - 2 * borderWidth, borderRadius, borderRadius);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(barWidth, barHeight);
    }
}
