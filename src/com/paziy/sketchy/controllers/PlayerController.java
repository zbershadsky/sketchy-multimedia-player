package com.paziy.sketchy.controllers;

import com.paziy.sketchy.parsers.Parseable;
import com.paziy.sketchy.parsers.Parser;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 07.11.12
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public abstract class PlayerController<Type extends Parseable> {
    protected Parser<Type> parser;

    protected PlayerController(Parser<Type> parser) {
        this.parser = parser;
    }
}
