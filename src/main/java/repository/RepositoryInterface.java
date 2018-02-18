package repository;

import java.util.List;

/**
 * Created by Марiна on 28.01.2018.
 */
public interface RepositoryInterface<T> {

    T get(int id);

    void add(T entity);

    void remove(int id);

    void update(T entity);

    List<T> getAll();
}
