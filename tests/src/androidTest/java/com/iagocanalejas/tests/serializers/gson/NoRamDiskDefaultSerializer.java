package com.iagocanalejas.tests.serializers.gson;


import com.iagocanalejas.core.Builder;
import com.iagocanalejas.tests.serializers.DualCacheGsonTest;
import com.iagocanalejas.tests.testobjects.AbstractVehicule;

public class NoRamDiskDefaultSerializer extends DualCacheGsonTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        cache = new Builder<AbstractVehicule>(CACHE_NAME, TEST_APP_VERSION)
                .enableLog()
                .noRam()
                .useSerializerInDisk(DISK_MAX_SIZE, true, defaultCacheSerializer, getContext())
                .build();
    }
}