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

    EditText Num1;
    EditText Num2;
    TextView Operation;
    TextView Finalresult;
    Button Reset;

    int value1 = 0;
    int value2= 0;
    int result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1=findViewById(R.id.etNum1);
        Num2=findViewById(R.id.etNum2);
        Operation=findViewById(R.id.tvOperation);
        Finalresult=findViewById(R.id.textViewResult);
        Reset=findViewById(R.id.btnReset);

         registerForContextMenu(Operation);
        }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"+");
        menu.add(0,1,1,"-");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) {
            value1=Integer.parseInt(Num1.getText().toString());
            value2=Integer.parseInt(Num2.getText().toString());
            result= (value1+value2);
            Finalresult.setText(result);
            return true;
        }else if (item.getItemId()==1) {
            value1=Integer.parseInt(Num1.getText().toString());
            value2=Integer.parseInt(Num2.getText().toString());
            result= (value1-value2);
            Finalresult.setText(result);
            return true;
        }else if(Reset.isClickable()){
            Num1.setText("");
            Num2.setText("");
            Finalresult.setText("");
        }
        return super.onContextItemSelected(item);
    }

}



