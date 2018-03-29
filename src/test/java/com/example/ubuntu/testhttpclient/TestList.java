package com.example.ubuntu.testhttpclient;

import com.example.ubuntu.testhttpclient.list.Student;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class TestList {



    @Test
    public void testTwoUpdateList(){

        List<Student> stationList=new ArrayList<>();
        stationList.add(new Student("你好",1));
        stationList.add(new Student("李强",2));


        List<Student> updateStationList=new ArrayList<>();
        updateStationList.add(new Student("李明",2));
        updateStationList.add(new Student("张三",2));
        updateStationList.add(new Student("张三1212",2));
        updateStationList.add(new Student("张三12",2));
        updateStationList.add(new Student("张三3",2));
        updateStationList.add(new Student("张三4",2));

        for(int i=0;i<stationList.size();i++){
            for(int j=0;j<updateStationList.size();j++){

                int updateIndex = stationList.indexOf(updateStationList.get(j));
                if (updateIndex != -1) {
                    stationList.remove(updateIndex);
                    stationList.add(updateStationList.get(j));
                }
            }
        }

        System.out.println("-----------"+stationList);

    }


    @Test
    public void copyList() {
        List<Student> listB = new ArrayList<>();
        listB.add(new Student("b", 1));
        listB.add(new Student("a", 3));
        List<Student> listX = new ArrayList<>();
        listX.add(new Student(1));
        listX.add(new Student(2));
        listX.add(new Student(3));
        List<Student> listAF = new ArrayList<>();

        boolean isFind = false;

        for (int k = 0; k < listX.size(); k++) {
            for (int j = 0; j < listB.size(); j++) {
                if (listX.get(k).equals(listB.get(j))) {
                    listAF.add(listB.get(j));
                    isFind = true;
                }
                if (j == listB.size() - 1 && !isFind) {
                    listAF.add(listX.get(k));
                }
            }
            isFind = false;
        }
        System.out.println(listAF);
    }

    @Test
    public void findDifference() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);


        //找出删除的和增加的
        List<Integer> addStationList = new ArrayList<>();
        List<Integer> deleteStationList = new ArrayList<>();


        for (int i = 0; i < list.size(); i++) {
            if (list1.contains(list.get(i))) {

            } else {
                deleteStationList.add(list.get(i));
            }
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list.contains(list1.get(i))) {

            } else {
                addStationList.add(list1.get(i));
            }
        }

        System.out.println("sss=" + addStationList);
        System.out.println("sss=" + deleteStationList);


    }


    @Test
    public void testList() {
        List<String> list = new ArrayList<>();

        List<String> listLocal = new ArrayList<>();
        listLocal.add("a");
        listLocal.add("b");
        listLocal.add("c");
        List<String> listServer = new ArrayList<>();
        listServer.add("e");
        listServer.add("f");
        listServer.add("g");
        list.addAll(listLocal);
        list.addAll(listServer);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        if (list.size() > 3) {
            for (int i = 0; i < 3; i++) {
                list.remove(0);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("after=" + list.get(i));
        }

        String icon = "http:\\/\\/q.qlogo.cn\\/qqapp\\/1106564086\\/B65AC6BF436FC01566A2318789375255\\/100";


    }

    @Test
    public void testContains() {
        List<String> stringList = new ArrayList<>();
        stringList.add("杭州市");
        stringList.add("杭as州人们");
        stringList.add("北京");

        String str = "杭州";
        Pattern pattern = Pattern.compile(str);

        for (String string : stringList) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                System.out.println("contains=" + string);
            } else {
                System.out.println("not contains=" + string);
            }
        }

    }

    @Test
    public void testSplit() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list1 = list.subList(0, list.size());
        System.out.println(list1.toString());
    }

    @Test
    public void testIndex() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> handlerType = new ArrayList<>();
        handlerType.add(2);//weixin
        handlerType.add(1);//qq

        for (int i = 0; i < list.size(); i++) {
            int i1 = handlerType.indexOf(list.get(i));
            System.out.println(i1);
        }
    }

    @Test
    public void testSort() {

        List<String> list = new ArrayList<>();

        List<String> listLocal = new ArrayList<>();
        listLocal.add("12121212121");
        listLocal.add("12121221333");
        listLocal.add("2242424");
        List<String> listServer = new ArrayList<>();
        listServer.add("11212");
        listServer.add("2898989");
        listServer.add("90809183201");
        listServer.add("90809183201");
        listServer.add("90809183201");
        listServer.add("90809183201");
        list.addAll(listLocal);
        list.addAll(listServer);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = Long.valueOf(o1).compareTo(Long.valueOf(o2));
                return i;
            }
        });
        List<String> strings = list.subList(0, 5);


//        if(list.size()>3){
//            for(int i=0;i<3;i++){
//                list.remove(0);
//            }
//        }

//        Collections.reverse(list);

        for (int i = 0; i < strings.size(); i++) {
            System.out.println("after=" + strings.get(i));
        }
        System.out.println("fdsafdas");
        strings.add(0, "好的啊");
        strings.remove(5);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("afterxxxxx=" + strings.get(i));
        }
    }

    /**
     * 正确删除list
     */
    @Test
    public void deleteList() {
        List<String> stringList=new ArrayList<>();
        stringList.add("aaa");
        stringList.add("aaa21");
        stringList.add("aaa121");
        stringList.add("aa12a121");
        stringList.add("aa11212a121");

        String target="aaa";

        for(int i = stringList.size() - 1; i >= 0; i--){
            String item = stringList.get(i);
            if(target.equals(item)){
                stringList.remove(i);
            }
        }

        System.out.println(stringList.get(0));
        System.out.println(stringList);
    }


    @Test
    public void replaceList() {
        List<String> stringList=new ArrayList<>();

        stringList.add("aaa");
        stringList.add("aaa21");
        stringList.add("aaa121");
        stringList.add("aa12a121");
        stringList.add("aa11212a121");

        String target="aaa";
        String des="121211";

        stringList.set(3,des);

        for(String a:stringList){

        }

//        for(int i = stringList.size() - 1; i >= 0; i--){
//            String item = stringList.get(i);
//            if(target.equals(item)){
//                stringList.remove(i);
//            }
//        }
        for (String number : stringList) {
            System.out.println("Number = " + number);
        }
        System.out.println(stringList.get(0));
        System.out.println(stringList);

    }
}
