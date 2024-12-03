import java.util.List;
//course,student, instructor için
//data tipinden BAĞIMSIZ CRUD işlemleri listeleyen interface
public interface Repository<S,U> {

    void createTable();

    void save(S entity);

    List<S> findAll();

    void update(S entity);

    void deleteById(U id);

    S findById(U id);

}
