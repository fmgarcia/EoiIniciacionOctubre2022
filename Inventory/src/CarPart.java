import java.util.Objects;

public class CarPart {
    String code;
    String name;
    String category;
    double price;

    public CarPart(String code, String name, String category, double price) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarPart)) return false;
        CarPart carPart = (CarPart) o;
        return Double.compare(carPart.getPrice(), getPrice()) == 0 && getCode().equals(carPart.getCode()) && Objects.equals(getName(), carPart.getName()) && Objects.equals(getCategory(), carPart.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getCategory(), getPrice());
    }

    @Override
    public String toString() {
        return String.format("%s: %s - %s -> %6.2f",code,name,category,price);
    }
}
