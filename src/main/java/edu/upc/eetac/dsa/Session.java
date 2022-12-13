package edu.upc.eetac.dsa;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session {
    void save(Object var1);

    void close() throws SQLException;

    Object get(Class var1, String var2);

    void update(Object var1);

    void delete(Object var1);

    List<Object> findAll(Class var1);

    List<Object> findAll(Class var1, HashMap var2);

    void deleteRecords(Class var1);

    List<Object> query(String var1, Class var2, HashMap var3);
}
