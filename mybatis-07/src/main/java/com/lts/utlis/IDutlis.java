package com.lts.utlis;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.util.UUID;

public class IDutlis {
    public static String getId()  {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutlis.getId());
    }
}
