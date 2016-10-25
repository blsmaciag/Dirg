package com.gft;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.littlegrid.ClusterMemberGroup;
import org.littlegrid.ClusterMemberGroupUtils;

import static org.junit.Assert.assertEquals;

/**
 * Simple integration test example.
 */
public final class SimpleStorageEnabledIntegrationTest {
    private static ClusterMemberGroup memberGroup;

    @BeforeClass
    public static void beforeTests() {
        memberGroup = ClusterMemberGroupUtils.newBuilder()
                .setStorageEnabledCount(2)
                .buildAndConfigureForStorageDisabledClient();
    }

    @AfterClass
    public static void afterTests() {
        ClusterMemberGroupUtils.shutdownCacheFactoryThenClusterMemberGroups(memberGroup);
    }

    @Test
    public void simpleExample() {
        final NamedCache cache = CacheFactory.getCache("test");
        cache.put("key", "Hello World");

        assertEquals(1, cache.size());
    }
}