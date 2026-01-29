package app.malmorox.nicestart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainBab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bab);

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myFab = findViewById(R.id.floating_action_button);

        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBab.this, "FAB clickado", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheetDialog();
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.heart) {
                    Toast.makeText(MainBab.this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.search) {
                    Toast.makeText(MainBab.this, "Empezando la busqueda", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private void showBottomSheetDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_dialog, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

        TextView option1 = view.findViewById(R.id.option1);
        TextView option2 = view.findViewById(R.id.option2);
        TextView option3 = view.findViewById(R.id.option3);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBab.this, "Ajustes clickado", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBab.this, "Contacto clickado", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainBab.this, "Clickado el cierre de sesión", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
    }
}