package com.example.ubuntu.testhttpclient;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wanghome on 2017/12/13.
 */

public class TestListIter {


    @Test
    public void delete(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        this.iteratorDelete(list.iterator(), 2);
        this.outputList(list);
    }

    private void iteratorDelete(Iterator<Integer> it, int deleteObject){
        while(it.hasNext()){
            int i = it.next();
            if(i==deleteObject){
                it.remove();
            }
        }
    }

    @Test
    public void delete2(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==2){
                list.remove(i);
            }
        }
        this.outputList(list);
    }




    private void outputList(List<Integer> list){
        for (Integer i : list) {
            System.out.println(i);
        }
    }



}
