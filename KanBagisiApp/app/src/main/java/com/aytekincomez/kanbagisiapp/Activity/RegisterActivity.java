package com.aytekincomez.kanbagisiapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aytekincomez.kanbagisiapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etAd, etSoyad, etIl, etIlce, etSİfre, etSifreTekrar;
    Button btnUyeOl;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        uiElement();
        registerWithEmailAndPassword();
    }

    public void uiElement(){
        etEmail = (EditText)findViewById(R.id.etRegisterEmail);
        etAd = (EditText)findViewById(R.id.etRegisterAd);
        etSoyad = (EditText)findViewById(R.id.etRegisterSoyad);
        etIl = (EditText)findViewById(R.id.etRegisterIl);
        etIlce = (EditText)findViewById(R.id.etRegisterIlce);
        etSİfre = (EditText)findViewById(R.id.etRegisterSifre);
        etSifreTekrar = (EditText)findViewById(R.id.etRegisterSifreTekrar);
        btnUyeOl = (Button)findViewById(R.id.btnRegisterUyeOl);

    }

    public void registerWithEmailAndPassword(){
        btnUyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etEmail.getText().toString().equals("") ||
                        etAd.getText().toString().equals("") ||
                        etSoyad.getText().toString().equals("") ||
                        etIl.getText().toString().equals("") ||
                        etIlce.getText().toString().equals("") ||
                        etSİfre.getText().toString().equals("") ||
                        etSifreTekrar.getText().toString().equals("")){
                    Toast.makeText(RegisterActivity.this,"Lütfen tüm alanları doldurunuz",Toast.LENGTH_LONG).show();
                }else{
                    if(!etSİfre.getText().toString().equals(etSifreTekrar.getText().toString())){
                        Toast.makeText(RegisterActivity.this, "Şifreler uyuşmuyor",Toast.LENGTH_LONG).show();
                    }else{
                        mAuth.createUserWithEmailAndPassword(etEmail.getText().toString(), etSİfre.getText().toString())
                                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            Log.d("CREATE","createUser:success");
                                            Toast.makeText(RegisterActivity.this, "Kaydınız Başarıyla Oluşturuldu",Toast.LENGTH_SHORT).show();
                                            user = mAuth.getCurrentUser();
                                            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                        } else{
                                            Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    }
                }

            }
        });
    }

}
