package com.hackcrashfiasco.letMeComplainFiasco.filter;

import com.hackcrashfiasco.letMeComplainFiasco.domain.User;

public class CurrentUserStorage {
    public static ThreadLocal<User> user = new ThreadLocal<>();

    public static void setCurrentUser(User userToSet){
        user.set(userToSet);
    }

    public static User getCurrentUser(){
        return user.get();
    }

    public static void clear(){
        user.remove();
    }
}
