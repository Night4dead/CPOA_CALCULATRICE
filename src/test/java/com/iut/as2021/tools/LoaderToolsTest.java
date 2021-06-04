package com.iut.as2021.tools;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertNull;

public class LoaderToolsTest {

    @Test
    public void testProperties() throws IOException {
        Assert.assertNotNull(LoaderTools.loader("mysql.properties"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPropertiesFileIsNull() throws IOException {
        assertNull(LoaderTools.loader(null));
    }
}
