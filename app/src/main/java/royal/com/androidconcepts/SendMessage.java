package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessage extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_phoneno;
    private EditText edt_message;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        init();
        btn_send.setOnClickListener(this);
    }

    private void init() {

        edt_phoneno = (EditText)findViewById(R.id.edt_phoneno);
        edt_message = (EditText)findViewById(R.id.edt_message);
        btn_send = (Button)findViewById(R.id.btn_send);

    }

    @Override
    public void onClick(View v) {
        try {

            String phoneno = edt_phoneno.getText().toString();
            String message = edt_message.getText().toString();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneno,null,message,null,null);
            Toast.makeText(SendMessage.this,"Message Sent",Toast.LENGTH_SHORT).show();

        }catch (Exception e){

            e.printStackTrace();
            Toast.makeText(SendMessage.this,"Message not sent",Toast.LENGTH_SHORT).show();

        }
    }
}
