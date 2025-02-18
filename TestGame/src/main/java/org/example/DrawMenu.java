package org.example;

import java.awt.*;

public class DrowMenu extends GamePanel {
    public static void drawMenu(Graphics g) {
        g.setColor(Color.WHITE);

        // Рисуем прямоугольник для кнопки "Начать новую игру":
        g.fillRect(300, 250, 200, 50); // Прямоугольник кнопки (x, y, ширина, высота)

        // Рисуем текст "Начать новую игру" по центру кнопки:
        g.setColor(Color.BLACK); // Черный цвет для текста кнопки
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Шрифт для текста кнопки
        FontMetrics fm = g.getFontMetrics(); // Получаем FontMetrics для центрирования текста
        int textWidth = fm.stringWidth("Начать игру"); // Ширина текста
        g.drawString("Начать игру", 300 + (200 - textWidth) / 2, 250 + 30); // Рисуем текст по центру кнопки
    }
}
