package org.example;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer; // Импортируем Timer


public class GamePanel extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {

    Timer gameTimer;

    public boolean isUpPressedP1;
    public boolean isDownPressedP1;
    public boolean isUpPressedP2; // Переменная для отслеживания нажатия клавиши "вверх" для игрока 2
    public boolean isDownPressedP2; // Переменная для отслеживания нажатия клавиши "вниз" для игрока 2
    public static int paddleY_P2; // Переменная для Y-координаты ракетки игрока 2
    public static final int paddleX_P2 = 730; // X-координата ракетки игрока 2 (фиксированная, у правого края)
    public static int paddleY_P1; // Переменная для Y-координаты верхней части ракетки игрока 1
    public static final int paddleX_P1 = 50; // X-координата ракетки игрока 1 (фиксированная)
    public static final int paddleHeight = 80; // Высота ракетки
    public static final int paddleWidth = 20; // Ширина ракетки
    public static final int paddleSpeed = 15; // Скорость движения ракетки
    public static int ballX;
    public static int ballY;
    public static final double ballDiameter = 30.0;
    public static final double ballRadius = (ballDiameter / 2);
    public double ballSpeedX = 6.0;
    public double ballSpeedY = 6.0;
    public static int scoreP1; // Переменная для счета игрока 1
    public static int scoreP2;
    public static final int WINNING_SCORE = 3;
    public static boolean gameRunning;
    public boolean isPaused;
    public final int MENU_STATE = 0;
    public final int MENU_STATE1 = 2;
    public final int MENU_STATE2 = 3;
    public final int GAME_STATE = 1;
    public int gameState; // Переменная для хранения текущего состояния игры
    public final double BALL_SPEED_INCREMENT = 0.4; // **Константа для шага увеличения скорости мячика**

    public GamePanel() {
        scoreP1 = 0; // Инициализируем счет игрока 1 нулем в начале игры
        scoreP2 = 0;
        isPaused = false;
        gameState = MENU_STATE; // **Начинаем игру в состоянии МЕНЮ**
        gameRunning = true;
        setBackground(Color.lightGray); // Устанавливаем черный фон для игрового поля
        setFocusable(true); // Делаем GamePanel фокусируемым
        addKeyListener(this); // Добавляем KeyListener к GamePanel (this - текущий объект GamePanel)
        addMouseListener(this); // **Регистрируем GamePanel как слушателя событий мыши**
        addMouseMotionListener(this); // **Регистрируем GamePanel как слушателя событий движения мыши**
        isUpPressedP1 = false; // Изначально клавиши не нажаты
        isDownPressedP1 = false;
        paddleY_P1 = 300 - (paddleHeight / 2); // Размещаем ракетку по центру экрана по вертикали
        paddleY_P2 = 300 - (paddleHeight / 2);
        ballX = 400;
        ballY = 300;
        gameTimer = new Timer(1000 / 60, this); // Создаем Timer, срабатывающий примерно 60 раз в секунду, ActionListener - this (GamePanel)


    }

    public void drawGame(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE); // Устанавливаем белый цвет для рисования

        g2d.fillRect(paddleX_P1, paddleY_P1, paddleWidth, paddleHeight); // Первая ракетка - используем paddleY_P1
        g2d.fillRect(paddleX_P2, paddleY_P2, paddleWidth, paddleHeight); // Рисуем вторую ракетку

        g2d.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius), (int) ballDiameter, (int) ballDiameter); // Рисуем мячик (овал/круг)

        g2d.setFont(new Font("Arial", Font.PLAIN, 40)); // Выбираем шрифт для счета
        g2d.drawString("Счет", 350, 40); // Рисуем слово "Счет" по центру сверху
        g2d.drawString(String.valueOf(scoreP1), 200, 70); // Рисуем счет игрока 1 слева
        g2d.drawString(String.valueOf(scoreP2), 600, 70); // Рисуем счет игрока 2 справа

        float[] dashPattern = {10f, 10f}; // Шаблон пунктиров: 10 пикселей линия, 10 пикселей пробел
        Stroke dashedStroke = new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f); // Создаем стиль пунктирной линии
        Stroke originalStroke = g2d.getStroke(); // Сохраняем текущий стиль линии, чтобы потом восстановить
        g2d.setStroke(dashedStroke); // Устанавливаем стиль пунктирной линии
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight()); // Рисуем вертикальную линию по центру экрана
        g2d.setStroke(originalStroke); // Восстанавливаем исходный стиль линии


        g.setColor(new Color(0, 0, 0, 30)); // Цвет тени: черный, полупрозрачный (alpha=100)

        // Тень для РАКЕТКИ ИГРОКА 1 (левой):
        g.fillRect(paddleX_P1 + 5, paddleY_P1 + 5, paddleWidth, paddleHeight); // Смещаем тень на 5 пикселей вправо и вниз

        // Тень для РАКЕТКИ ИГРОКА 2 (правой):
        g.fillRect(paddleX_P2 + 5, paddleY_P2 + 5, paddleWidth, paddleHeight); // Смещаем тень на 5 пикселей вправо и вниз

        // Тень для МЯЧИКА:
        g.fillOval((int) (ballX - ballRadius + 3), (int) (ballY - ballRadius + 4), (int) ballDiameter, (int) ballDiameter); // Смещаем тень на 5 пикселей вправо и вниз

        // **Градиент для РАКЕТКИ ИГРОКА 1 (левой):**
        GradientPaint paddleGradientP1 = new GradientPaint(
                paddleX_P1, paddleY_P1, new Color(100, 21, 120), // Начальная точка (левый верхний угол ракетки), начальный цвет (светло-серый)
                paddleX_P1 + paddleWidth, paddleY_P1 + paddleHeight, Color.WHITE); // Конечная точка (правый нижний угол ракетки), конечный цвет (белый)
        g2d.setPaint(paddleGradientP1); // Устанавливаем градиент в качестве цвета рисования
        g.fillRect(paddleX_P1, paddleY_P1, paddleWidth, paddleHeight); // Рисуем ракетку 1 - теперь с градиентом

        // **Градиент для РАКЕТКИ ИГРОКА 2 (правой):**
        GradientPaint paddleGradientP2 = new GradientPaint(
                paddleX_P2, paddleY_P2, new Color(57, 31, 2), // Начальная точка, начальный цвет (светло-серый)
                paddleX_P2 + paddleWidth, paddleY_P2 + paddleHeight, Color.WHITE); // Конечная точка, конечный цвет (белый)
        g2d.setPaint(paddleGradientP2); // Устанавливаем градиент
        g.fillRect(paddleX_P2, paddleY_P2, paddleWidth, paddleHeight); // Рисуем ракетку 2 - теперь с градиентом

        GradientPaint ballGradient = new GradientPaint(
                (float) (ballX - ballRadius), (float) (ballY - ballRadius), new Color(255, 0, 0, 255), // Начальная точка (левый верхний угол описанного прямоугольника мячика), начальный цвет (светло-серый)
                (float) (ballX + ballRadius), (float) (ballY + ballRadius), Color.WHITE); // Конечная точка (правый нижний угол описанного прямоугольника мячика), конечный цвет (белый)
        g2d.setPaint(ballGradient); // Устанавливаем градиент
        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius), (int) ballDiameter, (int) ballDiameter); // Рисуем мячик - теперь с градиентом


        if (!gameRunning) { // **Если игра НЕ идет (то есть, игра закончилась)**
            g2d.setFont(new Font("Arial", Font.BOLD, 60)); // Выбираем более крупный и жирный шрифт для сообщения
            g2d.setColor(new Color(0, 255, 0, 255)); // Полупрозрачный черный цвет для фона (RGBA: 0, 0, 0, Альфа=150)
            g2d.fillRect(100, 200, 600, 150); // Рисуем прямоугольник фона (x, y, ширина, высота) - нужно подобрать размеры и положение
            if (scoreP1 >= WINNING_SCORE) { // Если игрок 1 набрал победный счет
                g2d.setColor(new Color(0, 21, 255, 255));
                g2d.drawString("Игрок 1 победил!", 150, 300); // Рисуем сообщение о победе игрока 1
            } else if (scoreP2 >= WINNING_SCORE) { // Если игрок 2 набрал победный счет
                g2d.setColor(new Color(0, 21, 255, 255));
                g2d.drawString("Игрок 2 победил!", 150, 300); // Рисуем сообщение о победе игрока 2
            }
            ClickSpace.clickSpace(g2d);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Обязательно вызываем super.paintComponent(g)
        // Здесь будет код для рисования игры
        if (gameState == MENU_STATE) { // **Если игра в состоянии МЕНЮ, рисуем меню:**
            DrawMenu.newGame(g); // **Вызываем метод для рисования меню (который мы создадим в следующем шаге)**
            DrawMenu.settings(g);
        } else if (gameState == MENU_STATE1) {
            DrawMenu.oneGamer(g);
        } else if (gameState == MENU_STATE2) {
            DrawMenu.difficulty(g);
        } else if (gameState == GAME_STATE) { // **Если игра в состоянии ИГРА, рисуем игровой процесс:**
            drawGame(g); // **Вызываем метод для рисования игрового процесса (который мы перенесем из текущего paintComponent)**
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Этот метод нам пока не нужен для простой игры, оставим пустым
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); // Получаем код нажатой клавиши

        if (keyCode == KeyEvent.VK_W) { // Если нажата клавиша 'W' (для игрока 1 - вверх)
            isUpPressedP1 = true; // Устанавливаем флаг, что "вверх" нажата
        }
        if (keyCode == KeyEvent.VK_S) { // Если нажата клавиша 'S' (для игрока 1 - вниз)
            isDownPressedP1 = true; // Устанавливаем флаг, что "вниз" нажата
        }
        if (keyCode == KeyEvent.VK_UP) { // Клавиша стрелка "вверх" для игрока 2
            isUpPressedP2 = true; // Устанавливаем флаг "вверх" для игрока 2
        }
        if (keyCode == KeyEvent.VK_DOWN) { // Клавиша стрелка "вниз" для игрока 2
            isDownPressedP2 = true; // Устанавливаем флаг "вниз" для игрока 2
        }
        if (!gameRunning) { // **Если игра НЕ идет (то есть, игра закончилась)**
            if (e.getKeyCode() == KeyEvent.VK_SPACE) { // **Если нажата клавиша Пробел**
                // Перезапускаем игру:
                gameState = GAME_STATE; // Возвращаемся в состояние GAME_STATE
                scoreP1 = 0; // Сбрасываем счет игрока 1
                scoreP2 = 0; // Сбрасываем счет игрока 2
                gameRunning = true; // Возобновляем игровой процесс
                ballX = 400; // Возвращаем мячик в центр
                ballY = 300; // Возвращаем мячик в центр
                ballSpeedX = 10; // Задаем начальную скорость мячика по X
                ballSpeedY = 10; // Задаем начальную скорость мячика по Y
                gameTimer.start(); // **Запускаем таймер снова**
            }
        }

        if (gameState == MENU_STATE) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                gameState = GAME_STATE;
                gameTimer.start();
            }
        }

        if (gameState == MENU_STATE1) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                gameState = MENU_STATE;
                repaint();
            }
        }

        if (gameState == MENU_STATE2) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                gameState = MENU_STATE;
                repaint();
            }
        }

        if (gameState == GAME_STATE) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { // Если нажата клавиша ESC
                if (!isPaused) { // Если игра не на паузе
                    gameTimer.stop(); // Останавливаем таймер
                    isPaused = true; // Ставим игру на паузу
                } else { // Если игра на паузе
                    gameTimer.start(); // Запускаем таймер
                    isPaused = false; // Снимаем игру с паузы
                }
            }
        }

        }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) { // Если отпущена клавиша 'W'
            isUpPressedP1 = false; // Снимаем флаг, что "вверх" нажата
        }
        if (keyCode == KeyEvent.VK_S) { // Если отпущена клавиша 'S'
            isDownPressedP1 = false; // Снимаем флаг, что "вниз" нажата
        }
        if (keyCode == KeyEvent.VK_UP) { // Клавиша стрелка "вверх" для игрока 2
            isUpPressedP2 = false; // Снимаем флаг "вверх" для игрока 2
        }
        if (keyCode == KeyEvent.VK_DOWN) { // Клавиша стрелка "вниз" для игрока 2
            isDownPressedP2 = false; // Снимаем флаг "вниз" для игрока 2
        }
    }

    public void movePaddle() {
        if (isUpPressedP1) { // Если нажата клавиша "вверх"
            paddleY_P1 -= paddleSpeed; // Двигаем ракетку вверх (уменьшаем Y-координату)
        }
        if (isDownPressedP1) { // Если нажата клавиша "вниз"
            paddleY_P1 += paddleSpeed; // Двигаем ракетку вниз (увеличиваем Y-координату)
        }

        // Проверка границ экрана (чтобы ракетка не выходила за верхний и нижний край)
        if (paddleY_P1 < 0) { // Если верхняя часть ракетки вышла за верхнюю границу
            paddleY_P1 = 0; // Возвращаем ракетку к верхней границе
        }
        if (paddleY_P1 > getHeight() - paddleHeight) { // Если нижняя часть ракетки вышла за нижнюю границу
            paddleY_P1 = getHeight() - paddleHeight; // Возвращаем ракетку к нижней границе
        }
    }

    public void movePaddleP2() {
        if (isUpPressedP2) { // Если нажата клавиша "вверх" для игрока 2
            paddleY_P2 -= paddleSpeed; // Двигаем ракетку игрока 2 вверх
        }
        if (isDownPressedP2) { // Если нажата клавиша "вниз" для игрока 2
            paddleY_P2 += paddleSpeed; // Двигаем ракетку игрока 2 вниз
        }

        // Проверка границ экрана для ракетки игрока 2 (аналогично игроку 1)
        if (paddleY_P2 < 0) {
            paddleY_P2 = 0;
        }
        if (paddleY_P2 > getHeight() - paddleHeight) {
            paddleY_P2 = getHeight() - paddleHeight;
        }
    }

    public void moveBall() {
        ballX += (int) ballSpeedX;
        ballY += (int) ballSpeedY;
        if (ballY - ballRadius <= 0 || ballY + ballRadius >= getHeight()) {
            ballSpeedY = -ballSpeedY; // Меняем направление мяча по оси Y
        }

        if (ballX - ballRadius < 0) {
            ballX = 400;
            ballY = 300;
            scoreP2++;
            ballSpeedX = 6.0;
            ballSpeedY = 6.0;
            ballSpeedX = Math.abs(ballSpeedX);
            if (scoreP2 >= WINNING_SCORE) {
                gameTimer.stop();
                gameRunning = false;
            }
        }

        if (ballX + ballRadius > getWidth()) {
            ballX = 400;
            ballY = 300;
            scoreP1++;
            ballSpeedX = 6.0;
            ballSpeedY = 6.0;
            ballSpeedX = -Math.abs(ballSpeedX);
            if (scoreP1 >= WINNING_SCORE) {
                gameTimer.stop();
                gameRunning = false;
            }
        }

        if (ballX - ballRadius < paddleX_P1 + paddleWidth) { // Столкновение с ракеткой игрока 1 (левой)
            if (ballY + ballRadius > paddleY_P1 && ballY - ballRadius < paddleY_P1 + paddleHeight) {
                ballSpeedX = -ballSpeedX;
                ballSpeedX += (ballSpeedX > 0) ? BALL_SPEED_INCREMENT : -BALL_SPEED_INCREMENT;

                // **Новый код для "продвинутого" отскока от ракетки 1:**
                double relativeIntersectY = (paddleY_P1 + (paddleHeight / 2.0)) - ballY; // Вычисляем относительное положение точки удара по Y на ракетке
                double normalizedRelativeIntersectionY = (relativeIntersectY / (paddleHeight / 2.0)); // Нормализуем от -1 до +1

                ballSpeedY = (-normalizedRelativeIntersectionY * 5); // ballSpeedY теперь прямо пропорциональна normalizedRelativeIntersectionY, умноженной на коэффициент (5)

                ballX = (int) (paddleX_P1 + paddleWidth + ballRadius);
            }
        }


        if (ballX + ballRadius > paddleX_P2) { // Столкновение с ракеткой игрока 2 (правой)
            if (ballY + ballRadius > paddleY_P2 && ballY - ballRadius < paddleY_P2 + paddleHeight) {
                ballSpeedX = -ballSpeedX;
                ballSpeedX += (ballSpeedX > 0) ? BALL_SPEED_INCREMENT : -BALL_SPEED_INCREMENT;

                // **Новый код для "продвинутого" отскока от ракетки 2:**
                double relativeIntersectY = (paddleY_P2 + (paddleHeight / 2.0)) - ballY; // Вычисляем относительное положение точки удара по Y на ракетке
                double normalizedRelativeIntersectionY = (relativeIntersectY / (paddleHeight / 2.0)); // Нормализуем от -1 до +1

                ballSpeedY = (-normalizedRelativeIntersectionY * 5); // ballSpeedY теперь прямо пропорциональна normalizedRelativeIntersectionY, умноженной на коэффициент (5)


                ballX = (int) (paddleX_P2 - ballRadius);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movePaddle(); // Вызываем movePaddle() в каждом тике таймера
        movePaddleP2();
        moveBall();
        repaint(); // Запрашиваем перерисовку панели, чтобы увидеть изменения
    }

    // Методы MouseListener (реализуем интерфейс MouseListener):
    @Override
    public void mouseClicked(MouseEvent e) {
    } // Пока пустая реализация, добавим код позже

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameState == MENU_STATE) { // **Обрабатываем клики только в состоянии МЕНЮ**
            int mouseX = e.getX(); // Получаем X-координату клика мыши
            int mouseY = e.getY(); // Получаем Y-координату клика мыши
            // Прямоугольник кнопки "Начать новую игру" в drawMenu() был задан как:
            // g.fillRect(300, 250, 200, 50); // x=300, y=250, width=200, height=50
            // Проверяем, попадает ли клик мыши внутрь прямоугольника кнопки:
            if (mouseX >= 300 && mouseX <= 300 + 200 && mouseY >= 250 && mouseY <= 250 + 50) {
                // Клик мыши был ВНУТРИ кнопки "Начать новую игру"!
                gameState = MENU_STATE1;
                repaint();
            }
            if (mouseX >= 300 && mouseX <= 300 + 200 && mouseY >= 350 && mouseY <= 350 + 50) {
                gameState = MENU_STATE2;
                repaint();
            }
        } else if (gameState == MENU_STATE1) {

            int mouseX = e.getX();
            int mouseY = e.getY(); // Получаем Y-координату клика мыши
            if (mouseX >= 300 && mouseX <= 300 + 200 && mouseY >= 250 && mouseY <= 250 + 50) {
                gameState = GAME_STATE;
                gameTimer.start();
            }
        } else if (gameState == MENU_STATE2) {

            int mouseX = e.getX();
            int mouseY = e.getY(); // Получаем Y-координату клика мыши
        }

    }


    @Override
    public void mouseReleased(MouseEvent e) {
    } // Пока пустая реализация, добавим код позже

    @Override
    public void mouseEntered(MouseEvent e) {
    } // Пока пустая реализация, можно оставить пустыми

    @Override
    public void mouseExited(MouseEvent e) {
    }  // Пока пустая реализация, можно оставить пустыми

    // Методы MouseMotionListener (реализуем интерфейс MouseMotionListener):
    @Override
    public void mouseMoved(MouseEvent e) {
    }   // Пока пустая реализация, можно оставить пустыми

    @Override
    public void mouseDragged(MouseEvent e) {
    } // Пока пустая реализация, можно оставить пустыми
}