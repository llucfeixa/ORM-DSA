package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.util.ObjectHelper;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ObjectHelperTest {
    @Test
    public void testObjectGetFields() {
        User user = new User();
        String[] strings = ObjectHelper.getFields(user);
        Assert.assertEquals("userId", strings[0]);
        Assert.assertEquals("userName", strings[1]);
        Assert.assertEquals(9, strings.length);
    }

    @Test
    public void testObjectSetter() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        User user = new User();
        ObjectHelper.setter(user, "userName", "Lluc");
        Assert.assertEquals("Lluc", user.getUserName());
    }

    @Test
    public void testObjectGetter() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        User user = new User("1", "Lluc", "Feixa", "29/12/2001", 50, 1, "llucfeixa@gmail.com", "123", "esp");
        Object userName = ObjectHelper.getter(user, "userName");
        Assert.assertEquals("Lluc", userName);
    }

    @Test
    public void testAssertEqual() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        User user1 = new User("1", "Lluc", "Feixa", "29/12/2001", 50, 1, "llucfeixa@gmail.com", "123", "esp");
        User user2 = new User("1", "Lluc", "Feixa", "29/12/2001", 50, 1, "llucfeixa@gmail.com", "123", "esp");

        Assert.assertTrue(ObjectHelper.assertEqual(user1, user2));
    }
}
