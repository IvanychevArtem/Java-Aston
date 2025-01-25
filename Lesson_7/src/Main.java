public class Main {
    public static void main(String[] args) {
        String[] words = {"лук", "сок", "кол", "лук", "кол", "жмых", "лид", "лид", "лук", "кол","перец","миф","лид","миф"};
        Array.array(words);
        PhoneBook.add("Иванов", "1111111111");
        PhoneBook.add("Иванов", "2222222222");
        PhoneBook.add("Петров", "3333333333");
        PhoneBook.add("Сидоров", "4444444444");
        PhoneBook.add("Быков", "5555555555");

        System.out.println(PhoneBook.get("Быков"));
        System.out.println(PhoneBook.get("Иванов"));
    }
}