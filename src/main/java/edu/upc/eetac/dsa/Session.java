package edu.upc.eetac.dsa;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session {
    void save(Object var1);

    void close() throws SQLException;

    int count(Class theClass);

    Object get(Class var1, String var2);

    Object getObject(Class var1, String var2);

    void update(Object var1);

    void delete(Object var1);
    void deleteRelation(Object var1);

    List<Object> findAll(Class var1);

    List<Object> findAll(Class var1, HashMap var2);

    void deleteRecords(Class var1);

    /**
     * ValueObject {
     * nomUser, nomObject ..}
     * "select u.nom AS nomUser, o.nom AS objectUser FROM User u, Object o, UserObject uo
     * WHERE u.idUser=3 AND u.idUser = uo.idUser AND o.idObject = uo.idObject
     *
     *
     */
    List<Object> query(String var1, Class var2, HashMap var3);
}
