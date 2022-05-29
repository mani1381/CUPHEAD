package com.example.demo.Model;

import com.example.demo.View.ParentObject;

public interface vulnerable {

    ParentObject getParentObject();

    void remove();
    boolean isDead();

    void dealDamage(int damage);


}
