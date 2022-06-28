import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.NotFoundException;
import ru.netology.repositories.ProductRepo;
import ru.netology.managers.ProductManager;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;


public class ProductRepoTest {
    ProductRepo repo = new ProductRepo();
    Product book1 = new Book(1, "Harry Potter", 12, "Rowling");
    Product book2 = new Book(2, "Harry Potter 2", 15, "Rowling");
    Product smartphone1 = new Smartphone(3, "12", 200, "Xiaomi");
    Product smartphone2 = new Smartphone(4, "11", 150, "Xiaomi");


    @Test
    public void testRemoveIdOK() {


        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);

        Product[] actual = repo.removeById(1);
        Product[] expected = {book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveIdNotOK() {


        repo.add(book1);
        repo.add(book2);
        repo.add(smartphone1);
        repo.add(smartphone2);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }
}
