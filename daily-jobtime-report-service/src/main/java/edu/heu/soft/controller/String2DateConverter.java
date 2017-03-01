package edu.heu.soft.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LZMA on 17-2-23.
 */

@Component
public class String2DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        if(s==null || s.equals("")) {
            return null;
        } else {
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Date date;
            try {
                date = df.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
            return date;
        }
    }
}
