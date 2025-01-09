public class Dish {
        private int food;

        public Dish(int food) {
            this.food = food;
        }

        public boolean decreaseFood(int amount) {
            if (amount <= 0) {
                System.out.println("Количество еды должно быть больше нуля");
                return false;
            }
            if (food >= amount) {
                food -= amount;
                return true;
            }
            System.out.println("Недостаточно еды в миске. Осталось " + food + " ед.");
            return false;
        }

        public void addFood(int amount) {
            if (amount > 0) {
                food += amount;
                System.out.println("Добавлено " + amount + " ед. еды в миску");
            } else {
                System.out.println("Количество добавляемой еды должно быть больше нуля");
            }
        }

        public int getFood() {
            return food;
        }
    }

