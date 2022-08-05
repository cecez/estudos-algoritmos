package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UnionFindTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldBeConnected()
    {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);

        assertTrue(uf.connected(1, 2));
    }

    @Test
    public void shouldNotBeConnected()
    {
        UnionFind uf = new UnionFind(10);
        uf.union(1, 2);

        assertFalse(uf.connected(1, 5));
    }
}
