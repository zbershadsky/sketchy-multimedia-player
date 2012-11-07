package com.paziy.sketchy.parsers;

public interface ParseableFactory<T extends Parseable> {
    T create();
}
