package com.paziy.sketchy.users.model;

import com.paziy.sketchy.parsers.ParseableFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 07.11.12
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class UserFactory implements ParseableFactory<User> {
    @Override
    public User create() {
        return new User();
    }
}
