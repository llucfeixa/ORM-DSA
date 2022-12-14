package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.MyObjects;
import edu.upc.eetac.dsa.model.ObjectType;
import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.util.ObjectHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SessionImplTest {
    Session session;

    @Before
    public void setUp() {
        this.session = FactorySession.openSession("jdbc:mariadb://localhost:3306/dsa", "user1", "password1");
        this.session.deleteRecords(User.class);
        this.session.deleteRecords(MyObjects.class);
        this.session.deleteRecords(ObjectType.class);
        ObjectType objectType = new ObjectType("1", "Tipo 1");
        this.session.save(objectType);
    }

    @Test
    public void testSaveObject() {
        MyObjects myObject = new MyObjects("1", "Espada", "Espada con poderes",3.1, "1");
        this.session.save(myObject);
        List<Object> myObjects = this.session.findAll(MyObjects.class);
        MyObjects myObject1 = (MyObjects) myObjects.get(0);
        Assert.assertEquals(1, myObjects.size());
        Assert.assertEquals(MyObjects.class, myObjects.get(0).getClass());
        Assert.assertEquals(3.1, myObject1.getObjectCoins(), 0);
    }

    @Test
    public void testGetObject() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MyObjects myObject = new MyObjects("1", "Espada", "Espada con poderes",3.1, "1");
        this.session.save(myObject);
        MyObjects myObject2 = (MyObjects) this.session.get(MyObjects.class, "1");
        List<Object> myObjects = this.session.findAll(MyObjects.class);
        Assert.assertTrue(ObjectHelper.assertEqual(myObject2, myObjects.get(0)));
    }

    @Test
    public void testUpdateObject() {
        MyObjects myObject = new MyObjects("1", "Espada", "Espada con poderes",4.5, "1");
        this.session.save(myObject);
        MyObjects myObject1 = (MyObjects) this.session.get(MyObjects.class, "1");
        myObject.setObjectCoins(3.0);
        this.session.update(myObject);
        MyObjects myObject2 = (MyObjects) this.session.get(MyObjects.class, "1");
        Assert.assertEquals(3.0, myObject2.getObjectCoins(), 0);
        Assert.assertEquals(4.5, myObject1.getObjectCoins(), 0);
    }

    @Test
    public void testDeleteObject() {
        MyObjects myObject = new MyObjects("1", "Espada", "Espada con poderes",3.1, "1");
        this.session.save(myObject);
        this.session.delete(myObject);
        List<Object> myObjects = this.session.findAll(MyObjects.class);
        Assert.assertEquals(0, myObjects.size());
    }
}
