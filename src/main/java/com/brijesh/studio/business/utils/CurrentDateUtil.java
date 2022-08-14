package com.brijesh.studio.business.utils;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CurrentDateUtil {
    public Date getCurrentDate(){
        return new Date();
    }
}
