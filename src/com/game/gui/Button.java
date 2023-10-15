package com.game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

/**
 * A custom Swing button with customizable colors, dimensions, and text.
 */
public class Button extends JButton {
    private static final long serialVersionUID = 397360966345895955L;
    private Color normalBackgroundColor;
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;
    private Color textColor;
    private int buttonWidth;
    private int buttonHeight;
    private int cornerRadius; // Radius of the curved corners
    private String buttonText;
    private boolean hover;

    /**
     * Constructs a new custom button with customizable properties.
     *
     * @param text               The text to display on the button.
     * @param normalBackgroundColor The background color in the normal state.
     * @param hoverBackgroundColor  The background color in the hover state.
     * @param pressedBackgroundColor The background color in the pressed state.
     * @param textColor           The color of the button text.
     * @param buttonWidth         The width of the button.
     * @param buttonHeight        The height of the button.
     * @param cornerRadius        The radius of the curved corners.
     */
    public Button(String text, Color normalBackgroundColor, Color hoverBackgroundColor, Color pressedBackgroundColor,
                  Color textColor, int buttonWidth, int buttonHeight, int cornerRadius) {
        this.normalBackgroundColor = normalBackgroundColor;
        this.hoverBackgroundColor = hoverBackgroundColor;
        this.pressedBackgroundColor = pressedBackgroundColor;
        this.textColor = textColor;
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.cornerRadius = cornerRadius;
        this.buttonText = text;
        hover = false;

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

        setPreferredSize(new Dimension(buttonWidth, buttonHeight));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (getModel().isPressed()) {
            g2d.setColor(pressedBackgroundColor);
        } else if (hover) {
            g2d.setColor(hoverBackgroundColor);
        } else {
            g2d.setColor(normalBackgroundColor);
        }

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, buttonWidth, buttonHeight, cornerRadius, cornerRadius);
        g2d.fill(roundedRectangle);

        g2d.setColor(textColor);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));

        FontMetrics fm = g2d.getFontMetrics();
        int textX = (buttonWidth - fm.stringWidth(buttonText)) / 2;
        int textY = (buttonHeight - fm.getHeight()) / 3 + fm.getAscent();

        g2d.drawString(buttonText, textX, textY);
    }


}
