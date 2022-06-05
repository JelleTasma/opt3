package opt3.Model;

public interface AbstractFactory<T> {
    T create(String accountType) ;
}
