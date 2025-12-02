package app.malmorox.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {
    EditText campoUsuario, campoContrasena;

    private final String USUARIO_CORRECTO = "admin";
    private final String CONTRASENA_CORRECTA = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        campoUsuario = findViewById(R.id.campoUsuario);
        campoContrasena = findViewById(R.id.campoContrasena);
    }

    public void abrirMain(View v) {
        // AÑADIENDO SWEET ALERT PARA SIMULAR EL LOGIN
        String user = campoUsuario.getText().toString();
        String pass = campoContrasena.getText().toString();

        if (user.isEmpty() || pass.isEmpty()) {
            mostrarAlerta(
                    SweetAlertDialog.WARNING_TYPE,
                    "Faltan datos",
                    "Por favor, rellena todos los campos",
                    null
            );
            return;
        }

        if (user.equals(USUARIO_CORRECTO) && pass.equals(CONTRASENA_CORRECTA)) {
            mostrarAlerta(
                    SweetAlertDialog.SUCCESS_TYPE,
                    "¡Bienvenido!",
                    "Acceso correcto",
                    () -> {
                        Intent intent = new Intent(Login.this, Main.class);
                        startActivity(intent);
                    }
            );
        } else {
            mostrarAlerta(
                    SweetAlertDialog.ERROR_TYPE,
                    "Error",
                    "Usuario o contraseña incorrectos",
                    null
            );
        }
    }

    public void abrirSignUp(View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }

    private void mostrarAlerta(int tipo, String titulo, String mensaje, Runnable accion) {
        SweetAlertDialog sweetAlert = new SweetAlertDialog(this, tipo)
                .setTitleText(titulo)
                .setContentText(mensaje)
                .setConfirmText("OK");

        if (accion != null) {
            sweetAlert.setConfirmClickListener(sDialog -> {
                sDialog.dismissWithAnimation();
                accion.run();
            });
        }

        sweetAlert.show();
    }
}