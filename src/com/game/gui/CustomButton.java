package com.game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A custom Swing button with different images for normal, hover, and pressed states.
 */
public class CustomButton extends JButton {
    private static final long serialVersionUID = -6887426068358283387L;
    private Image normalImage;
    private Image hoverImage;
    private Image pressedImage;
    private boolean hover;
    private String buttonText;
    
    /**
     * Constructs a new custom button with the specified button text.
     *
     * @param text The text to display on the button.
     */
    public CustomButton(String text) {
        this.normalImage = new ImageIcon("assets/images/buttons/normal.png").getImage();
        this.hoverImage = new ImageIcon("assets/images/buttons/hover.png").getImage();
        this.pressedImage = new ImageIcon("assets/images/buttons/clicked.png").getImage();
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        hover = false;
        buttonText = text;

        // Add a mouse listener to track hover state
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.drawImage(pressedImage, 0, 0, getWidth(), getHeight(), this);
        } else if (hover) {
            g.drawImage(hoverImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.drawImage(normalImage, 0, 0, getWidth(), getHeight(), this);
        }
        // Draw the text on top of the button
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(buttonText, getWidth() / 2 - 20, getHeight() / 2 + 5);
    }
}
