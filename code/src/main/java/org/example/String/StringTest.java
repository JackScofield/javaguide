package org.example.String;

public class StringTest {

    public static void main(String[] args)  {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";
        String str4 = str1 + str2;
        String str5 = "string";
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

        final String str6 = "str";
        final String str7 = "ing";
// 下面两个表达式其实是等价的
        String c = "str" + "ing";// 常量池中的对象
        String d = str6 + str7; // 常量池中的对象
        System.out.println(c == d);// true
        try{
            int a = 1;
            int b = 0;
            int e= a/b;
        }
        catch (Exception e){
//            e.printStackTrace();
            System.out.println(e.toString());


        }
    }

}
