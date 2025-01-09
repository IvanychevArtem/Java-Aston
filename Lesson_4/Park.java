public class Park {

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



