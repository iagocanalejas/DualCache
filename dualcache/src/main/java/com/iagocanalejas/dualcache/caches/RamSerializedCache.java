/*
 * Copyright 2014 Vincent Brison.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iagocanalejas.dualcache.caches;

import com.iagocanalejas.dualcache.caches.base.LruCache;

import java.nio.charset.Charset;

/**
 * LRU cache used by the RAM cache layer when storing serialized object.
 */
public class RamSerializedCache extends LruCache<String, String> {

    /**
     * @param maxCacheSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public RamSerializedCache(int maxCacheSize) {
        super(maxCacheSize);
    }

    @Override
    protected int sizeOf(String key, String value) {
        return value.getBytes(Charset.defaultCharset()).length;
    }
}
