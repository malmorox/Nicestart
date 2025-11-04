package app.malmorox.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
    }

    public void abrirMain(View v) {
        Intent intent = new Intent(Login.this, Main.class);
        startActivity(intent);
    }

    public void abrirSignUp(View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
}