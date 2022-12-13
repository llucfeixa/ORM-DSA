package edu.upc.eetac.dsa;

import java.util.HashMap;
import java.util.List;
import java.sql.SQLException;

public interface Session {
    void save(Object entity);
    void close() throws SQLException;
    Object get(Class theClass, String id);
    void update(Object object);
    void delete(Object object);
    List<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    void deleteRecords(Class theClass);
    List<Object> query(String query, Class theClass, HashMap params);
}
