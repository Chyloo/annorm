package com.ropz.annorm.controller;

import com.ropz.annorm.annFactory.AnnFactory;
import com.ropz.annorm.annFactory.factoryImpl.FactoryImpl;
import com.ropz.annorm.entity.User;

/**
 * @author ropz
 */
public class DemoController {
    public static void main(String[] args) {
        AnnFactory af = new FactoryImpl();
        af.createTable(new User());
    }
}
