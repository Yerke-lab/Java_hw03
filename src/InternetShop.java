import java.util.ArrayList;
import java.util.List;

public class InternetShop {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        // Создаем массивы покупателей и товаров
        customers.add(new Customer("Василий Уткин", 54, "7778889944"));
        customers.add(new Customer("Николай Пастухов", 29, "7779897451"));

        products.add(new Product("Смартфон", 11000));
        products.add(new Product("Ноутбук", 65000));
        products.add(new Product("Наушники", 2900));
        products.add(new Product("Мышка", 1200));
        products.add(new Product("Клавиатура", 2000));

        // Выполняем несколько покупок с обработкой исключений
        try {
            makePurchase("Николай Пастухов", "Смартфон", 2);
            makePurchase("Василий Уткин", "Наушники", -5);
            makePurchase("Николай Пастухов", "Смартфон", 105);
            makePurchase("Василий Уткин", "Клавиатура", 98);
            makePurchase("Алексей Ким", "Монитор", 50);
        } catch (CustomerException | ProductException | AmountException e) {
            System.out.println(e.getMessage());
        }

        // Выводим итоговое количество совершенных покупок
        System.out.println("Итоговое количество совершенных покупок: " + orders.size());
    }

    public static Order makePurchase(String fullName, String productName, int quantity)
            throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        Product product = null;

        // Find the customer with a case-insensitive match for full name
        for (Customer c : customers) {
            if (c.getFullName().equalsIgnoreCase(fullName)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            throw new CustomerException("Клиент не найден!");
        }

        // Find the product with a case-insensitive match for product name
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                product = p;
                break;
            }
        }

        if (product == null) {
            throw new ProductException("Товар не найден!");
        }

        if (quantity < 1) {
            quantity = 1;
        } else if (quantity > 99) {
            throw new AmountException("Неверное количество! Максимально допустимое значение – 99.");
        }

        Order order = new Order(customer, product, quantity);
        orders.add(order);

        return order;
    }
}
