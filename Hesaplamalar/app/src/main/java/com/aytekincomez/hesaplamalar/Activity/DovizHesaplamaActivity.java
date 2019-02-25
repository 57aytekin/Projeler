package com.aytekincomez.hesaplamalar.Activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.aytekincomez.hesaplamalar.Helper.HttpHandler;
import com.aytekincomez.hesaplamalar.R;

import org.json.JSONObject;

public class DovizHesaplamaActivity extends AppCompatActivity {
    HttpHandler httpHandler;
    String webSiteUrl = "https://www.doviz.com/api/v1/currencies/all/latest?base_TRY";
    String webSiteResorce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doviz_hesaplama);

        new getKurlar().execute();
    }

    private class getKurlar extends AsyncTask<Void, Void, Void>{



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setTitle("Lütfen Bekleyin");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            httpHandler = new HttpHandler();
            webSiteResorce = httpHandler.makeServiceCall(webSiteUrl);

            Log.d("RESPONSE",webSiteResorce);

            if(webSiteResorce != null){
                try {
                    JSONObject jsonObject = new JSONObject(webSiteResorce);
                }catch (Exception e){

                }
            }
            /*
                [{"selling":5.8725,"update_date":1539470699,"currency":1,"buying":5.8715,"change_rate":0.0085149863760171,"name":"amerikan-dolari","full_name":"Amerikan Dolar\u0131","code":"USD"},{"selling":6.7908,"update_date":1539468000,"currency":2,"buying":6.7883,"change_rate":-0.98276515703829,"name":"euro","full_name":"Euro","code":"EUR"},{"selling":7.7399,"update_date":1539464285,"currency":3,"buying":7.7149,"change_rate":-1.4621725707375,"name":"sterlin","full_name":"\u0130ngiliz Sterlini","code":"GBP"},{"selling":5.915088638195,"update_date":1539449478,"currency":7,"buying":5.9116995569875,"change_rate":0.35364251793472,"name":"isvicre-frangi","full_name":"\u0130svi\u00e7re Frang\u0131","code":"CHF"},{"selling":4.5110616070057,"update_date":1539470514,"currency":4,"buying":4.5085617753206,"change_rate":-0.023030861354212,"name":"kanada-dolari","full_name":"Kanada Dolar\u0131","code":"CAD"},{"selling":0.0889045326551,"update_date":1539470699,"currency":12,"buying":0.088875938483894,"change_rate":-0.088925453852537,"name":"rus-rublesi","full_name":"Rus Rublesi","code":"RUB"},{"selling":1.599090513016,"update_date":1539470634,"currency":10,"buying":1.5986005608647,"change_rate":0.013615074610601,"name":"birlesik-arap-emirlikleri-dirhemi","full_name":"B.A.E. Dirhemi","code":"AED"},{"selling":4.176522,"update_date":1539468000,"currency":11,"buying":4.17874655,"change_rate":0.056203456512567,"name":"avustralya-dolari","full_name":"Avustralya Dolar\u0131","code":"AUD"},{"selling":0.90988673866225,"update_date":1539468000,"currency":5,"buying":0.90960495739737,"change_rate":0.30456537278181,"name":"danimarka-kronu","full_name":"Danimarka Kronu","code":"DKK"},{"selling":0.65546415456565,"update_date":1539467999,"currency":6,"buying":0.65522089921996,"change_rate":-0.11369589691571,"name":"isvec-kronu","full_name":"\u0130sve\u00e7 Kronu","code":"SEK"},{"selling":0.71840135055784,"update_date":1539467999,"currency":8,"buying":0.71809453922828,"change_rate":-0.38013085273585,"name":"norvec-kronu","full_name":"Norve\u00e7 Kronu","code":"NOK"},{"selling":5.2340505178345,"update_date":1539468000,"currency":9,"buying":5.2322265590191,"change_rate":0.067771218633525,"name":"japon-yeni","full_name":"100 Japon Yeni","code":"JPY"},{"selling":19.381188118812,"update_date":1539470513,"currency":13,"buying":19.250819672131,"change_rate":0.59366754617413,"name":"kuveyt-dinari","full_name":"Kuveyt Dinar\u0131","code":"KWD"},{"selling":0.40467347037218,"update_date":1539464393,"currency":14,"buying":0.40432593980044,"change_rate":-0.77010331820915,"name":"guney-afrika-randi","full_name":"G\u00fcney Afrika Rand\u0131","code":"ZAR"},{"selling":15.58932837802,"update_date":1539452228,"currency":15,"buying":15.578402759353,"change_rate":0.026539278131632,"name":"bahreyn-dinari","full_name":"Bahreyn Dinar\u0131","code":"BHD"},{"selling":4.2517376194613,"update_date":1539470513,"currency":16,"buying":4.2295778706238,"change_rate":0.50680567622358,"name":"libya-dinari","full_name":"Libya Dinar\u0131","code":"LYD"},{"selling":1.5657494800832,"update_date":1539470513,"currency":17,"buying":1.5652741862387,"change_rate":0.029333333333336,"name":"suudi-arabistan-riyali","full_name":"S. Arabistan Riyali","code":"SAR"},{"selling":0.0049390243902439,"update_date":1539470660,"currency":18,"buying":0.0049298908480269,"change_rate":0.16820857863751,"name":"irak-dinari","full_name":"Irak Dinar\u0131","code":"IQD"},{"selling":1.6223272003978,"update_date":1539470661,"currency":20,"buying":1.6175822359359,"change_rate":0.27625835681529,"name":"israil-sekeli","full_name":"\u0130srail \u015eekeli","code":"ILS"},{"selling":0.00013982142857143,"update_date":1539525221,"currency":19,"buying":0.00013963139120095,"change_rate":0.059488399762046,"name":"iran-riyali","full_name":"\u0130ran Riyali","code":"IRR"},{"selling":0.079651851218887,"update_date":1539468062,"currency":21,"buying":0.079627487384234,"change_rate":-0.17531604270402,"name":"hindistan-rupisi","full_name":"Hindistan Rupisi","code":"INR"},{"selling":0.31157151952462,"update_date":1539
             */

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setTitle("İşlem Tamamlandı");
        }

    }
}
