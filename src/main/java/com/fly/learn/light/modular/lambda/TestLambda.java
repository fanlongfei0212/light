package com.fly.learn.light.modular.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2019/5/18 下午10:47
 * @Description:
 * @Modified:
 */
public class TestLambda {



    public static void main(String[] args) {

        //java8 lambda 函数式

        List<app> apps = Stream
                .of(new app().setName("a").setColor("a"), new app().setName("b").setColor("b"))
                .collect(Collectors.toList());

        List<app> result = new TestLambda().getAppByName(obj -> obj.getName().equals("a"), apps);

        result.stream().forEach((obj) -> System.out.println(obj.getName()));

        //构造引用

        testStructure testStructure = app :: new;

        System.out.println(testStructure.getStr("name").getName());

        //参数实例方法引用
        parameter parameter = String :: compareTo;

        System.out.println(parameter.doCompare("a", "b"));

        //静态方法引用
        staticTest staticTest = System.out::println;

        //测试
        apps.stream().forEach(System.out::println);
    }

    public List<app> getAppByName(appPredicate<app> appPredicate, List<app> apps){

        List<app> result = new ArrayList<>();

        apps.forEach(app -> {

            if (appPredicate.appPre(app)){

                result.add(app);
            }
        });

        return result;
    }
}

class app{

    public app(){}
    public app(String name){

        this.name = name;
    }

    private String name;

    private String color;

    public String getName() {
        return name;
    }

    public app setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public app setColor(String color) {
        this.color = color;
        return this;
    }
}

interface appPredicate<T>{

    boolean appPre(T t);
}

interface testStructure{

    app getStr(String name);
}

interface parameter{

    int doCompare(String par1, String par2);
}

interface staticTest{

    void getStr(String str);
}
