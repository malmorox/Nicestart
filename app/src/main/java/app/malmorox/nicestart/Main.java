package app.malmorox.nicestart;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView micontexto = findViewById(R.id.holaMundo);
        registerForContextMenu(micontexto);

        swipeLayout = findViewById(R.id.swipeRefresh);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    // SWIPE REFRESH

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //Toast toast = Toast.makeText(Main.this, "Ejemplo de Toast", Toast.LENGTH_LONG);
            //toast.show();

            ConstraintLayout mainLayout = findViewById(R.id.main);

            Snackbar snackbar = Snackbar
                    .make(mainLayout, "Snackbar funcionando!", Snackbar.LENGTH_LONG);
            snackbar.show();

            swipeLayout.setRefreshing(false);
        }
    };

    // MENU APPBAR

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.buscar) {
            Toast toast = Toast.makeText(this, "Pulsado el buscar", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.favoritos) {
            Toast toast = Toast.makeText(this, "Pulsado el favoritos", Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }

    // MENU CONTEXTUAL

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item1 seleccionado",
                    Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast2 = Toast.makeText(this, "Item2 seleccionado",
                    Toast.LENGTH_LONG);
            toast2.show();
        }
        return false;
    }
}