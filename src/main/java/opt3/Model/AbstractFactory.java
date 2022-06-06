package opt3.Model;

// Abstract factory with T, so you can use the factory for more factory's
public interface AbstractFactory<T> {
    T create(String accountType) ;
}
