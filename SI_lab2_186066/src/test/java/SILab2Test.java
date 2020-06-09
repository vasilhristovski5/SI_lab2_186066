import com.sun.org.apache.bcel.internal.generic.ATHROW;
import org.graalvm.compiler.debug.Assertions;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class SILab2Test {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(SILab2.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }



    @Test
    void everyPathTest(){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((300,60,20));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((300,50,60)));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid!"));

        assertEquals(null, SILab2.function(null));

        assertEquals(1083050, SILab2.function((300,50,50));

        assertEquals(1296000, SILab2.function((360,0,0)));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((360,1,0)));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((361,1,1)));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));
    }

    @Test
    void everyBranchTest(){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((300,60,20));
        assertTrue(ex.getMessage().contains("The minutes of the angle are not valid!"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((300,50,60)));
        assertTrue(ex.getMessage().contains("The seconds of the angle are not valid!"));

        assertEquals(null, SILab2.function(null));

        assertEquals(1083050, SILab2.function((300,50,50));

        assertEquals(1296000, SILab2.function((360,0,0)));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((360,1,0)));
        assertTrue(ex.getMessage().contains("The angle is greater then the maximum"));

        ex = assertThrows(RuntimeException.class, ()->SILab2.function((361,1,1)));
        assertTrue(ex.getMessage().contains("The angle is smaller or greater then the minimum"));
    }

}
