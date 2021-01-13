package manager;

import domain.Book;
import domain.Product;
import domain.ProductRepository;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @InjectMocks
    private ProductManager manager;

    @Mock
    private ProductRepository repository;

    Product anotherProduct;
    Book book1;
    Book book2;
    Smartphone smartphone1;
    Smartphone smartphone2;

    @BeforeEach
    private void setUp() {

        anotherProduct = new Product(0, "продукт", 0);
       // manager.add(anotherProduct);
        book1 = new Book(1, "Война и мир", 100, "Толстой");
        //manager.add(book1);
        book2 = new Book(2, "Бесприданница", 1001, "Островский");
        //manager.add(book2);
        smartphone1 = new Smartphone(3, "Айфон", 1002, "Apple");
        //manager.add(smartphone1);
        smartphone2 = new Smartphone(4, "m1", 1003, "Sony");
        //manager.add(smartphone2);


    }

    private Product[] getAllDumb(){
        Product[] p = new Product[]{anotherProduct, book1, book2, smartphone1, smartphone2};
        return new Product[]{anotherProduct, book1, book2, smartphone1, smartphone2};
    }

    @Test
    void searchByNameBook() {
        Product[] returned = getAllDumb();
        doReturn(returned).when(repository).getAll();
        Product[] actual = manager.searchBy("Война и мир");
        assertArrayEquals(new Product[]{book1}, actual);
        verify(repository).getAll();
    }

    @Test
    void searchByAuthorBook() {
        Product[] returned = getAllDumb();
        doReturn(returned).when(repository).getAll();
        Product[] actual = manager.searchBy("Толстой");
        assertArrayEquals(new Product[]{book1}, actual);
        verify(repository).getAll();
    }


    @Test
    void searchByNameSmartphone() {
        Product[] returned = getAllDumb();
        doReturn(returned).when(repository).getAll();
        Product[] actual = manager.searchBy("Айфон");
        assertArrayEquals(new Product[]{smartphone1}, actual);
        verify(repository).getAll();
    }


    @Test
    void searchByManufactureSmartphone() {
        Product[] returned = getAllDumb();
        doReturn(returned).when(repository).getAll();
        Product[] actual = manager.searchBy("Sony");
        assertArrayEquals(new Product[]{smartphone2}, actual);
        verify(repository).getAll();
    }
}