import java.util.Objects;

public class Advertising extends Part implements Priceable {
    private String product;

    public Advertising(String product, int length) {
        super(length);
        this.product = product;
    }

    @Override
    public int getPrice() {
        return getLength() * 60 * 5;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertising that = (Advertising) o;

        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return product != null ? product.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Advertising{" +
                "product='" + product + '\'' +
                "} " + super.toString();
    }
}
