package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class QueryHelperTest {
    @Test
    public void testCreateQueryINSERT() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        User user = new User("1", "Lluc", "Feixa", "29/12/2001", 50, "llucfeixa@gmail.com", "123");
        String query = QueryHelper.createQueryINSERT(user);
        Assert.assertEquals("INSERT INTO User (userId, userName, userSurname, userBirth, coins, email, password) VALUES (?, ?, ?, ?, ?, ?, ?)", query);
    }

    @Test
    public void testCreateQuerySELECT() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        user.setUserId("1");
        String query = QueryHelper.createQuerySELECT(user);
        Assert.assertEquals("SELECT * FROM User WHERE userId = ?", query);
    }

    @Test
    public void testCreateQueryUPDATE() {
        User user = new User("1", "Lluc", "Feixa", "29/12/2001", 50, "llucfeixa@gmail.com", "123");
        String query = QueryHelper.createQueryUPDATE(user);
        Assert.assertEquals("UPDATE User SET userId = ?, userName = ?, userSurname = ?, userBirth = ?, coins = ?, email = ?, password = ? WHERE userId = ?", query);
    }

    @Test
    public void testCreateQueryDELETE() {
        User user = new User("1", "Lluc", "Feixa", "29/12/2001", 50, "llucfeixa@gmail.com", "123");
        String query = QueryHelper.createQueryDELETE(user);
        Assert.assertEquals("DELETE FROM User WHERE userId = ?", query);
    }

    @Test
    public void testCreateQueryDeleteRecords() {
        String query = QueryHelper.createQueryDeleteRecords(User.class);
        Assert.assertEquals("DELETE FROM User", query);
    }

    @Test
    public void testCreateQuerySelectAll() {
        String query = QueryHelper.createQuerySelectAll(User.class);
        Assert.assertEquals("SELECT * FROM User", query);
    }
}
