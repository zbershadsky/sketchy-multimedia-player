package com.paziy.sketchy.parsers;

import java.lang.reflect.Field;

/**
 * Interface of parseable object
 */
public abstract class Parseable {
    public boolean setField(String name, Object value) {
        try {
            Field field = getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(this, value);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
