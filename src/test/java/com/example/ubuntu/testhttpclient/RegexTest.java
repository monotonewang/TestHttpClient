package com.example.ubuntu.testhttpclient;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/12/27 0027.
 */

public class RegexTest {

    @Test
    public void regexUtil(){
         final String REGEX_ENGLISH="[a-zA-Z]+";

         String string=" aa";

        Pattern compile = Pattern.compile(REGEX_ENGLISH);
        Matcher matcher = compile.matcher(string);
        if(matcher.matches()){
            System.out.println(string);
        }else{
            System.out.println("not");
        }

    }

    @Test
    public void regexPassword(){
        final String REGEX_PASSWORD = "^.{8,16}$";

        Pattern compile = Pattern.compile(REGEX_PASSWORD);

        String string="`~/*-+?';:}{[]|";
        Matcher matcher = compile.matcher(string);
        if(matcher.matches()){
            System.out.println(string);
        }else{
            System.out.println("not");
        }
    }
}
