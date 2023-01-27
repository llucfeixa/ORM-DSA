package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {
        try {
            String insertQuery = QueryHelper.createQueryINSERT(entity);
            PreparedStatement statement = this.conn.prepareStatement(insertQuery);
            int i = 1;
            String[] var5 = ObjectHelper.getFields(entity);
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String field = var5[var7];
                statement.setObject(i++, ObjectHelper.getter(entity, field));
            }

            statement.executeQuery();
        } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException | SQLException var9) {
            var9.printStackTrace();
        }

    }

    public void close() throws SQLException {
        this.conn.close();
    }

    public int count(Class theClass) {
        String selectQuery = QueryHelper.createQueryCOUNT(theClass);
        int val = 0;
        try {
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            ResultSet count = statement.executeQuery();
            val = (int) (count.getObject(1));
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
        return val;
    }

    public Object get(Class theClass, String id) {
        try {
            Object entity = theClass.newInstance();
            ObjectHelper.setter(entity, ObjectHelper.getIdAttributeName(theClass), id);
            String selectQuery = QueryHelper.createQuerySELECT(entity);
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            statement.setObject(1, id);
            entity = ObjectHelper.createObjects(statement.executeQuery(), theClass).get(0);

            assert entity != null;

            return entity;
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException | InvocationTargetException | ClassNotFoundException var6) {
            throw new RuntimeException(var6);
        }
    }

    public Object getObject(Class theClass, String email) {
        try {
            Object entity = theClass.newInstance();
            ObjectHelper.setter(entity, ObjectHelper.getIdAttributeName(theClass), email);
            String selectQuery = QueryHelper.createQuerySELECTEmail(entity);
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            statement.setObject(1, email);
            entity = ObjectHelper.createObjects(statement.executeQuery(), theClass).get(0);

            assert entity != null;

            return entity;
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchFieldException | InvocationTargetException | ClassNotFoundException var6) {
            throw new RuntimeException(var6);
        }
    }

    public void update(Object object) {
        try {
            String updateQuery = QueryHelper.createQueryUPDATE(object);
            PreparedStatement statement = this.conn.prepareStatement(updateQuery);
            int i = 1;
            String[] var5 = ObjectHelper.getFields(object);
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String field = var5[var7];
                statement.setObject(i++, ObjectHelper.getter(object, field));
            }

            statement.setObject(i, ObjectHelper.getter(object, ObjectHelper.getIdAttributeName(object.getClass())));
            statement.executeQuery();
        } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException | SQLException var9) {
            throw new RuntimeException(var9);
        }
    }

    public void delete(Object object) {
        try {
            String updateQuery = QueryHelper.createQueryDELETE(object);
            PreparedStatement statement = this.conn.prepareStatement(updateQuery);
            statement.setObject(1, ObjectHelper.getter(object, ObjectHelper.getIdAttributeName(object.getClass())));
            statement.executeQuery();
        } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException | SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public void deleteRelation(Object object) {
        try {
            String updateQuery = QueryHelper.createQueryDELETERelation(object);
            PreparedStatement statement = this.conn.prepareStatement(updateQuery);
            statement.setObject(1, ObjectHelper.getter(object, ObjectHelper.getIdAttributeName(object.getClass())));
            statement.executeQuery();
        } catch (NoSuchFieldException | InvocationTargetException | IllegalAccessException | SQLException var4) {
            throw new RuntimeException(var4);
        }
    }

    public List<Object> findAll(Class theClass) {
        String selectQuery = QueryHelper.createQuerySelectAll(theClass);
        List<Object> objects = null;

        try {
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            objects = ObjectHelper.createObjects(statement.executeQuery(), theClass);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | InvocationTargetException | SQLException var6) {
            var6.printStackTrace();
        }

        return objects;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }

    public void deleteRecords(Class theClass) {
        String selectQuery = QueryHelper.createQueryDeleteRecords(theClass);

        try {
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            statement.executeQuery();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }
    }

    public List<Object> userMyObjects(Class theClass, String userId) {
        String selectQuery = QueryHelper.createQuerySELECTUserMyObjects();
        List<Object> objects = null;

        try {
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            statement.setObject(1, userId);
            objects = ObjectHelper.createObjects(statement.executeQuery(), theClass);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | InvocationTargetException | SQLException var6) {
            var6.printStackTrace();
        }

        return objects;
    }

    public List<Object> userCharacters(Class theClass, String userId) {
        String selectQuery = QueryHelper.createQuerySELECTUserCharacters();
        List<Object> objects = null;

        try {
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            statement.setObject(1, userId);
            objects = ObjectHelper.createObjects(statement.executeQuery(), theClass);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | InvocationTargetException | SQLException var6) {
            var6.printStackTrace();
        }

        return objects;
    }

    public List<Object> userPartidas(Class theClass, String email) {
        String selectQuery = QueryHelper.createQuerySELECTPartida();
        List<Object> objects = null;

        try {
            PreparedStatement statement = this.conn.prepareStatement(selectQuery);
            statement.setObject(1, email);
            objects = ObjectHelper.createObjects(statement.executeQuery(), theClass);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException | InvocationTargetException | SQLException var6) {
            var6.printStackTrace();
        }

        return objects;
    }
}