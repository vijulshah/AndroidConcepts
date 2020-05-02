package royal.com.androidconcepts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddDetails extends AppCompatActivity implements View.OnClickListener{

    private Button btn_add;
    private Button btn_cancel;
    private RadioGroup rg_gender;
    private EditText edt_fn;
    private EditText edt_ln;
    private EditText edt_email;
    private EditText edt_contactno;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        init();
        btn_add.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    private void init() {

        btn_add = (Button)findViewById(R.id.btn_add);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        rg_gender = (RadioGroup)findViewById(R.id.rg_gender);
        edt_fn = (EditText)findViewById(R.id.edt_fn);
        edt_ln = (EditText)findViewById(R.id.edt_ln);
        edt_email = (EditText)findViewById(R.id.edt_email);
        edt_contactno = (EditText)findViewById(R.id.edt_contactno);
        db = new DatabaseHandler(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_add :
            {
                String first_name = edt_fn.getText().toString();
                String last_name = edt_ln.getText().toString();
                String email_id = edt_email.getText().toString();
                String contactno = edt_contactno.getText().toString();

                int radio_group_gender = rg_gender.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)findViewById(radio_group_gender);
                String gender = radioButton.getText().toString();

                UserDetailsModel userDetailsModel = new UserDetailsModel();
                userDetailsModel.setFirstName(first_name);
                userDetailsModel.setLastName(last_name);
                userDetailsModel.setEmailId(email_id);;
                userDetailsModel.setContactno(contactno);
                userDetailsModel.setGender(gender);

                db.insertRecord(userDetailsModel);
                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
            }
            break;

        }
        
        Intent intent = new Intent(this,DB_MainPage.class);
        startActivity(intent);
        finish();
    }

}
