package com.example.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText n1,n2;
    Button sifir,bir,iki,uc,dort,bes,alti,yedi,sekiz,dokuz,topla,cikar,carp,bol,temizle,esittir;
    TextView hesapEkrani;
    Double ilkSayi;

    Boolean virgulDurum;
    String islemDurum;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hesapEkrani=findViewById(R.id.textView4);
        n1=findViewById(R.id.editTextNumber4);
        n2=findViewById(R.id.editTextNumber5);
        sifir=findViewById(R.id.buton_sifir);
        hesapEkrani.setText("0");
        ilkSayi = 0.0;
        virgulDurum = false;
        islemDurum = "0";



        sifir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(0);
            }
        });
        bir=findViewById(R.id.buton_bir);
        bir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(1);
            }
        });
        iki=findViewById(R.id.buton_iki);
        iki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(2);
            }
        });
        uc=findViewById(R.id.buton_uc);
        uc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(3);
            }
        });
        dort=findViewById(R.id.buton_dort);
        dort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(4);
            }
        });
        bes=findViewById(R.id.buton_bes);
        bes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(5);
            }
        });
        alti=findViewById(R.id.buton_alti);
        alti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(6);
            }
        });
        yedi=findViewById(R.id.buton_yedi);
        yedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(7);
            }
        });
        sekiz=findViewById(R.id.buton_sekiz);
        sekiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(8);
            }
        });
        dokuz=findViewById(R.id.buton_dokuz);
        dokuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla(9);
            }
        });
        topla=findViewById(R.id.buton_topla);
        topla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla_sembol("+");
            }
        });
        bol=findViewById(R.id.buton_bol);
        bol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla_sembol("/");
            }
        });
        carp=findViewById(R.id.buton_carp);
        carp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla_sembol("X");
            }
        });
        cikar=findViewById(R.id.buton_cikar);
        cikar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla_sembol("-");
            }
        });
        temizle=findViewById(R.id.buton_temizle);
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla_sembol("");
            }
        });
        esittir=findViewById(R.id.buton_esittir);
        esittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tikla_sembol("=");
            }
        });
    }

    private void tikla(int sayi)
    {
        if(hesapEkrani.getText().toString() == "0"){
            hesapEkrani.setText("");
        }
        else if(
                        hesapEkrani.getText().toString() == "+" ||
                        hesapEkrani.getText().toString() == "*" ||
                        hesapEkrani.getText().toString() == "/"||
                        hesapEkrani.getText().toString() == "-")
        {
            hesapEkrani.setText("");
        }
        hesapEkrani.setText(hesapEkrani.getText() + String.valueOf(sayi));
    }
    private void tikla_sembol(String sembol)
    {
        switch (sembol)
        {
            default:
            {
                if(hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-")
                {
                    if(islemDurum == "*" || islemDurum == "/")
                        ilkSayi = -1*ilkSayi;

                    hesapEkrani.setText(sembol);
                    islemDurum = sembol;
                }
                else
                {
                    ilkSayi = Double.parseDouble(hesapEkrani.getText().toString());
                    hesapEkrani.setText(sembol);
                    islemDurum = sembol;
                }
            }
            break;
            case "":
            {
                ilkSayi = 0.0;
                hesapEkrani.setText("0");
                islemDurum = "0";
            }
            break;
            case "=":
            {
                if(hesapEkrani.getText().toString() == "+" || hesapEkrani.getText().toString() == "*"
                        || hesapEkrani.getText().toString() == "/" || hesapEkrani.getText().toString() == "-")
                {

                }
                else
                {
                    switch (islemDurum)
                    {
                        default:
                        {
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "+":
                        {
                            ilkSayi = ilkSayi + Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "-":
                        {
                            ilkSayi = ilkSayi - Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "/":
                        {
                            ilkSayi = ilkSayi / Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                        case "*":
                        {
                            ilkSayi = ilkSayi * Double.parseDouble(hesapEkrani.getText().toString());
                            hesapEkrani.setText(ilkSayi.toString());
                        }
                        break;
                    }
                }


            }
            break;
            case ",":
            {

            }
            break;
        }
    }
}