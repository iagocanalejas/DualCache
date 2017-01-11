package com.iagocanalejas.tests.configurations;


import com.iagocanalejas.dualcache.DualCache;
import com.iagocanalejas.tests.DualCacheJacksonTest;
import com.iagocanalejas.tests.DualCacheTest;
import com.iagocanalejas.tests.testobjects.AbstractVehicle;

public class RamCustomSerializerDiskDefaultSerializer extends DualCacheJacksonTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        cache = new DualCache.Builder<AbstractVehicle>(CACHE_NAME, TEST_APP_VERSION)
                .enableLog()
                .useSerializerInRam(RAM_MAX_SIZE, new DualCacheTest.SerializerForTesting())
                .useSerializerInDisk(DISK_MAX_SIZE, true, mDefaultParser, getContext())
                .build();
    }
}