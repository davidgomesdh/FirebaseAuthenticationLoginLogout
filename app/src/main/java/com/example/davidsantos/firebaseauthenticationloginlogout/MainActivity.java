package com.example.davidsantos.firebaseauthenticationloginlogout;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

       /* mAuth.createUserWithEmailAndPassword("Teste@teste.com","12345678")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            if(currentUser!=null){
                                //Podemos ir para a proxima tela
                            }
                            else{
                                Toast.makeText(MainActivity.this, "falha na criação de usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });*/

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            //Podemos ir para a proxima tela
            Toast.makeText(MainActivity.this, "Logado", Toast.LENGTH_SHORT).show();

        }
    }

    public void logout(View view){
        mAuth.signOut();
        Toast.makeText(MainActivity.this, "Deslogou", Toast.LENGTH_SHORT).show();
    }
    public void login(View view){
        mAuth.signInWithEmailAndPassword("Teste@teste.com","12345678")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser currentUser = mAuth.getCurrentUser();
                            if(currentUser!=null){
                                //Podemos ir para a proxima tela
                                Toast.makeText(MainActivity.this, "Logado", Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Toast.makeText(MainActivity.this, "falha na autenticação de usuario", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}
