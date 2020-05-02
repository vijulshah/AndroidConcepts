package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtons extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_buttons);

        init();
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void init() {

        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        int radio_grup_id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton)findViewById(radio_grup_id);
        String radio_btn_data = radioButton.getText().toString();

        Toast.makeText(RadioButtons.this,"You selected : "+radio_btn_data,Toast.LENGTH_SHORT).show();
        Log.e("RadioButtons","You selected : "+radio_btn_data);

    }

}
