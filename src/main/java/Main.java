import ru.netology.managers.ProductManager;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;
import ru.netology.repositories.ProductRepo;

public class Main {
    public static void main(String[] args) {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);

        manager.add(new Book(1, "Harry Potter", 12, "Rowling") );
        manager.add(new Book(2, "Harry Potter 2", 15, "Rowling") );
        manager.add(new Smartphone(3, "12", 200, "Xiaomi") );
        manager.add(new Smartphone(4, "11", 150, "Xiaomi") );

        Product[] result = manager.searchBy("Harry");

        repo.removeById(7);
    }
}