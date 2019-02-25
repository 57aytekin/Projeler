package com.aytekincomez.methodsandclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("application started");
        test();
        System.out.println(math(5, 3));
        makeSimpson();
    }

    public void test() {
        int x = 4 + 4;
        System.out.println("volue of x :"+x);
    }

    public int math(int a, int b) {
        return a + b;
    }
    public void makeMusicians() {

        Musician james = new Musician("James", "Guitar", 50);

    }
    public void makeSimpson() {

        Simpsons homer = new Simpsons("Homer", 20, "Nuclear Reactor");
        homer.setName("Homer James Simpson");
        System.out.println(homer.getName());
    }
}
