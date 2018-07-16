package food;

public class Bread implements Food {
    @Override
    public void introduce() {
        System.out.println("this is bread (default)");
    }
}
