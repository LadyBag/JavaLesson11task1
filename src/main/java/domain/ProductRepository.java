package domain;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] newProducts = new Product[length];
        for (int i = 0; i < items.length; i++) {
            newProducts[i] = items[i];
        }
        newProducts[items.length] = item;
        this.items = newProducts;
    }

    public Product[] getAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] newProducts = new Product[length];

        int j = 0;
        for (int i = 0; i < items.length; i++) {
            Product item = items[i];
            if (item.getId() != id) {
                newProducts[j] = item;
                j=j+1;
            }
        }
    }

}
