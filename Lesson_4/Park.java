public class Park {
<<<<<<< HEAD
        public String name;
        public String location;

        public Park(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public static class Attraction {
            String attractionName;
            String workingHours;
            int price;

            public Attraction(String attractionName, String workingHours, int price) {
                this.attractionName = attractionName;
                this.workingHours = workingHours;
                this.price = price;
            }

            public String toString() {
                return String.format("Название: %s \n Время работы: %s \n Цена: %s Рублей\n", attractionName, workingHours, price);
            }

            public void print() {
                System.out.println(this);
            }
        }
    }

=======
    String name;
    String location;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public class Attraction {
        String attractionName;
        String workingHours;
        int price;

        public Attraction(String attractionName, String workingHours, int price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        public String toString() {
            return String.format("Название: %s \n Время работы: %s \n Цена: %s Рублей\n", attractionName, workingHours, price);
        }

        public void print() {
            System.out.println(this);
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Парк Горького", "Москва");
        Attraction theTrain = park.new Attraction("Паровозик", "10:00 - 8:00", 350);
        Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "9:00 - 10:00", 600);
        Attraction golf = park.new Attraction("Гольф", "12:00 - 12:00", 2200);

        theTrain.print();
        ferrisWheel.print();
        golf.print();
    }

}
>>>>>>> c06301a7a1bc55a8449e6e013e2b105ba4fc8b23
