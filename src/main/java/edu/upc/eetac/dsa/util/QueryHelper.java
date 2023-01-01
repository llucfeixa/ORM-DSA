package edu.upc.eetac.dsa.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class QueryHelper {
    public static String createQueryINSERT(Object entity) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        StringBuffer buffer = new StringBuffer("INSERT INTO ");
        buffer.append(entity.getClass().getSimpleName()).append(" (");

        String[] fields = ObjectHelper.getFields(entity);

        for(String field : fields) {
            buffer.append(field).append(", ");
        }
        buffer.setLength(buffer.length()-2);

        buffer.append(") VALUES (");
        for(String ignored : fields) {
            buffer.append("?, ");
        }
        buffer.setLength(buffer.length()-2);
        buffer.append(")");

        return buffer.toString();
    }

    public static String createQueryCOUNT(Class theClass) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT COUNT(*) FROM ").append(theClass.getClass().getSimpleName());
        return buffer.toString();
    }

    public static String createQuerySELECT(Object entity) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        String field = Arrays.stream(ObjectHelper.getFields(entity))
                .filter(x-> x.matches("(?i).*"+"id"+".*"))
                .findFirst()
                .orElse(null);

        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        buffer.append(" WHERE ").append(field);
        buffer.append(" = ?");

        return buffer.toString();
    }

    public static String createQuerySELECTEmail(Object entity) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        buffer.append(" WHERE email = ?");

        return buffer.toString();
    }

    public static String createQueryUPDATE(Object entity) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("UPDATE ").append(entity.getClass().getSimpleName());
        buffer.append(" SET ");

        String[] fields = ObjectHelper.getFields(entity);
        for (String field : fields) {
            buffer.append(field).append(" = ?, ");
        }
        buffer.setLength(buffer.length()-2);
        buffer.append(" WHERE ").append(ObjectHelper.getIdAttributeName(entity.getClass())).append(" = ?");

        return buffer.toString();
    }

    public static String createQueryDELETE(Object entity) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("DELETE FROM ").append(entity.getClass().getSimpleName());
        buffer.append(" WHERE ").append(ObjectHelper.getIdAttributeName(entity.getClass())).append(" = ?");

        return buffer.toString();
    }

    public static String createQueryDELETERelation(Object entity) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("DELETE FROM UserMyObjects");
        buffer.append(" WHERE ").append(ObjectHelper.getIdAttributeName(entity.getClass())).append(" = ?");

        return buffer.toString();
    }

    public static String createQueryDeleteRecords(Class theClass) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM ").append(theClass.getSimpleName());
        return query.toString();
    }

    public static String createQuerySelectAll(Class theClass) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM ").append(theClass.getSimpleName());
        return query.toString();
    }

    public static String createQuerySELECTUserMyObjects() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT o.* FROM MyObjects o, UserMyObjects uo WHERE uo.userId = ? AND o.objectId = uo.objectId");
        return buffer.toString();
    }

    public static String createQuerySELECTUserCharacters() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT c.* FROM Characters c, UserCharacters uc WHERE uc.userId = ? AND c.characterId = uc.characterId");
        return buffer.toString();
    }
}