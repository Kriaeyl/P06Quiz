package sg.edu.rp.soi.p06_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView tv1;
    TextView tv2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.etNum1);
        et2 = findViewById(R.id.etNum2);
        tv1 = findViewById(R.id.tvOperation);
        b1 = findViewById(R.id.btnReset);
        tv2 = findViewById(R.id.textView);
        registerForContextMenu(tv1);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      tv2.setText("Here Shows the Result");
                                      et1.setText("");
                                      et2.setText("");
                                  }
                              }
        );
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "+");
        menu.add(0, 1, 1, "-");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            tv2.setText(Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString()));
        } else {
            tv2.setText(Integer.parseInt(et1.getText().toString()) - Integer.parseInt(et2.getText().toString()));
        }
        return true;

    }

}


