package navin.thenapster.testyourcalculation;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.jar.Pack200;

public class MainActivity extends Activity {

    int i1=0,i2=0,iop=0;
    String[] sop={"+","-","*","/"};
    TextView d1,d2,op,result;
    EditText ans;
    String strlast="";
    float last=0,res;
    Button refresh,check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d1 = (TextView) findViewById(R.id.d1);
        d2 = (TextView) findViewById(R.id.d2);
        op = (TextView) findViewById(R.id.op);

        result = (TextView) findViewById(R.id.result);

        ans = (EditText) findViewById(R.id.ans);
        refresh = (Button) findViewById(R.id.refresh);
        check = (Button) findViewById(R.id.check);

        final Random r = new Random();
        final Random ro = new Random();
        final Random r1 = new Random();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1=r.nextInt(100)+1;
                d1.setText(i1+" ");
                i2=r1.nextInt(100)+1;
                d2.setText(i2+" ");
                iop=ro.nextInt(4);
                op.setText(sop[iop]);


            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strlast = ans.getText().toString();
                try {
                    last = Float.valueOf(strlast);

                    switch (iop) {
                        case 0:
                            res = i1 + i2;
                            break;
                        case 1:
                            res = i1 - i2;
                            break;
                        case 2:
                            res = i1 * i2;
                            break;
                        case 3:
                            res = i1 / i2;
                            break;
                    }
                    result.setText(res + " ");
                    if (res == last) {
                        result.setBackgroundColor(Color.GREEN);
                        result.setTextColor(Color.BLACK);
                    } else {
                        result.setBackgroundColor(Color.RED);
                        result.setTextColor(Color.WHITE);
                    }


                } catch (NumberFormatException e) {
                    result.setBackgroundColor(Color.RED);
                    result.setTextColor(Color.WHITE);
                    result.setText("Invalid answer");

                }

            }
        });



    }

}
