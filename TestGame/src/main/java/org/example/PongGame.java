package org.example;

import javax.swing.JFrame;
import java.awt.Dimension;

public class PongGame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Игра Понг"); // Создаем окно JFrame с заголовком "Игра Понг"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Устанавливаем действие при закрытии окна - завершение программы
        frame.setResizable(false); // Запрещаем изменение размера окна

        GamePanel gamePanel = new GamePanel(); // Создаем экземпляр GamePanel
        gamePanel.setPreferredSize(new Dimension(800, 600)); // Устанавливаем предпочтительный размер GamePanel

        frame.getContentPane().add(gamePanel); // Добавляем GamePanel в окно
        frame.pack(); // Автоматически устанавливаем размер окна, чтобы вместить все компоненты
        frame.setLocationRelativeTo(null); // Размещаем окно по центру экрана
        frame.setVisible(true); // Делаем окно видимым

        gamePanel.requestFocusInWindow(); // Запрашиваем фокус для GamePanel - ВАЖНО!
    }
}
