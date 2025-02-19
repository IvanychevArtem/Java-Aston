package org.example;

import java.awt.*;

public class ClickSpace {
    public static void clickSpace(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(100,500,600,50);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth("Нажмите пробел для повторной игры");
        g.drawString("Нажмите пробел для повторной игры", 100 +(600 - textWidth)/2, 500 + 30);
    }
}



