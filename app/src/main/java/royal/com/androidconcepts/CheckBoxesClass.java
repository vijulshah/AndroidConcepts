package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CheckBoxesClass extends AppCompatActivity implements View.OnClickListener,CheckBox.OnCheckedChangeListener{

    CheckBox chk_box1,chk_box2,chk_box3,chk_box4;
    Button chk_save,chk_clear;
    TextView chk_txtview;
    ArrayList<String> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        init();
        chk_save.setOnClickListener(this);
        chk_clear.setOnClickListener(this);
        chk_box1.setOnCheckedChangeListener(this);
        chk_box2.setOnCheckedChangeListener(this);
        chk_box3.setOnCheckedChangeListener(this);
        chk_box4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.chk_save:
            {
                showList();
            }
            break;

            case R.id.chk_clear:
            {
               onClearListCall();
            }
            break;
        }
    }

    private void init() {

        list = new ArrayList<String>();
        chk_box1 = (CheckBox) findViewById(R.id.chk_box1);
        chk_box2 = (CheckBox) findViewById(R.id.chk_box2);
        chk_box3 = (CheckBox) findViewById(R.id.chk_box3);
        chk_box4 = (CheckBox) findViewById(R.id.chk_box4);
        chk_save = (Button)   findViewById(R.id.chk_save);
        chk_clear = (Button)  findViewById(R.id.chk_clear);
        chk_txtview = (TextView) findViewById(R.id.chk_txtview);

    }

    private void showList() {

        chk_txtview.setVisibility(View.VISIBLE);
        chk_txtview.setAllCaps(false);

        chk_txtview.setText(list.toString());
    }

    private void onClearListCall() {

        list.removeAll(list);
        chk_txtview.setAllCaps(false);
        chk_txtview.setText("\'List is Empty\'");
        chk_box1.setChecked(false);
        chk_box2.setChecked(false);
        chk_box3.setChecked(false);
        chk_box4.setChecked(false);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(buttonView.isPressed() && isChecked)
        {
            String txt = buttonView.getText().toString();
            list.add(txt);
            Toast.makeText(this, txt+" added to list", Toast.LENGTH_SHORT).show();
        }
        else if(buttonView.isPressed() && !isChecked)
        {
            String txt = buttonView.getText().toString();
            list.remove(txt);
            Toast.makeText(this, txt+" removed from list", Toast.LENGTH_SHORT).show();
        }
    }
}
