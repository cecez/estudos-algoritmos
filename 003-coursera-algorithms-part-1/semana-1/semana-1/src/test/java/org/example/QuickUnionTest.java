package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QuickUnionTest
{
    
    @Test
    public void shouldBeConnected()
    {
        QuickUnion qu = new QuickUnion(10);
        qu.union(1, 2);

        assertTrue(qu.connected(1, 2));
    }

    @Test
    public void shouldNotBeConnected()
    {
        QuickUnion qu = new QuickUnion(10);
        qu.union(1, 2);

        assertFalse(qu.connected(1, 5));
    }
}
