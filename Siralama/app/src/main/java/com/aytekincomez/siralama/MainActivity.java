package com.aytekincomez.siralama;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    TextView tvSonuc;
    String yazdir ="";
    int a[] = {5, 2, 50, 55,8,3,75,12,88,43,11};
    int sayi = 0;
    Scanner sc = new Scanner(System.in);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSonuc = (TextView)findViewById(R.id.tvSonuc);
        sirala(a);
        yazdir(a);
        tvSonuc.setText(yazdir);

        System.out.println("Lütfen binary cevirmek istediğiniz sayiyi giriniz: ");
        sayi = sc.nextInt();
        binaryCevir(sayi);
        sc.close();


    }
    public static void binaryCevir(int sayi){


        int[] kalan = new int[16];
        int sayac = 0;

        for(int i=0; sayi>1; i++ ){ //sayi = 7,3,
            kalan[i] = sayi % 2;    // 1, 1, 1
            sayi = sayi/2;          // 3, 1,
            sayac++;
        }
        kalan[sayac] = sayi;
        for(int i : kalan){
            System.out.print(i);
        }
    }

    public void sirala(int[] a){
        //5, 2, 50, 55,8 == 2 5 50 55 8 ==> 2 5 8 55 50 ==> 2 5 8 50 55
        for(int i=0; i<a.length; i++){//5
            for(int j=i; j<a.length; j++){
                int tut = 0;        //3
                if(a[j] < a[i]){  //2 < 5
                    tut = a[i];     //tut = 5;
                    a[i] = a[j];  //5 ==>2;
                    a[j] = tut;   //30==> 50
                }
            }
        }
    }
    public void yazdir(int[] a){
        for(int i=0; i<a.length; i++){
            yazdir += a[i]+",";
        }
    }

}
