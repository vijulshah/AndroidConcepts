package royal.com.androidconcepts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextView_EditText extends AppCompatActivity implements View.OnClickListener {

    EditText edttxt_here;
    Button btn_edt_txt_done,btn_this_page;
    TextView txtview_show,tvname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view__edit_text);

        init();
        btn_edt_txt_done.setOnClickListener(this);
        btn_this_page.setOnClickListener(this);
    }

    private void init() {

        edttxt_here = (EditText)findViewById(R.id.edttxt_here);
        btn_edt_txt_done = (Button)findViewById(R.id.btn_edt_txt_done);
        txtview_show = (TextView) findViewById(R.id.txtview_show);
        tvname = (TextView)findViewById(R.id.tvname);
        btn_this_page = (Button)findViewById(R.id.btn_this_page);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.btn_edt_txt_done :
            {
                Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();

            }
            break;

            case R.id.btn_this_page :
            {
                String txt = edttxt_here.getText().toString();
                txtview_show.setText(txt);
                tvname.setVisibility(View.VISIBLE);
                txtview_show.setVisibility(View.VISIBLE);
            }
            break;

            default:
            {

            }
        }
    }

}
