package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPatterns {
    public static void main(String[] args) {
        //. pattern..
        boolean b = Pattern.matches("k.m", "kam");
        System.out.println(b);

        //[] pattern..
        b = Pattern.matches("[kam]", "a");
        System.out.println(b);

        //[]+ pattern..
        b = Pattern.matches("[kam]+", "aka");
        System.out.println(b);

        //[]* pattern..
        b = Pattern.matches("[kam]*", "");
        System.out.println(b);

        //[] restriction.. {5} here 5 is the size od the next substring to [MS]
        b = Pattern.matches("[MS][a-z]{5}", "Maanvi");
        System.out.println(b);

        //? return boolean if the character are there or not..
        b = Pattern.matches("[kam]?", "a");
        System.out.println(b);

        // i dont know why below 2 are not working though..
        // \\d pattern for only digits.. (please mind the escape sequence added)
        b = Pattern.matches("\\d", "1");
        System.out.println(b);

        // \\D pattern for only characters.. (please mind the escape sequence added)
        b = Pattern.matches("\\D", "k");
        System.out.println(b);
    }

}

class MyClass extends JavaPatterns{

}
