package royal.com.androidconcepts;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class CustomDialogBox extends AppCompatActivity implements View.OnClickListener{

    Button custom_dialog_box;
    ImageView iv_custom_dialog;
    private AlertDialog.Builder builder;
     Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_box);

        init();
        custom_dialog_box.setOnClickListener(this);
    }

    private void init() {

        custom_dialog_box = (Button)findViewById(R.id.custom_dialog_box);
        iv_custom_dialog = (ImageView)findViewById(R.id.iv_custom_dialog);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.custom_dialog_box:
            {
                showCustomDialogBox();
            }
            break;

            /*case R.id.select_gallery:
            {
                Toast.makeText(this, "Gallery Selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Image"), 11);
            }
            break;
*/
            case R.id.select_camera:
            {
                Toast.makeText(this, "Camera Selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 12);
            }
            break;
        }
    }

    private void showCustomDialogBox() {

        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

         dialog =  new Dialog(this);
       // builder = new AlertDialog.Builder(this);
        //View view1 = layoutInflater.inflate(R.layout.raw_custom_dialog,(ViewGroup) findViewById(R.id.select_box));

       // builder.setView(view1);
        dialog.setTitle("Select to Open");
        dialog.setContentView(R.layout.raw_custom_dialog);


        ImageButton select_gallery = (ImageButton)dialog.findViewById(R.id.select_gallery);
        ImageButton select_camera = (ImageButton)dialog.findViewById(R.id.select_camera);

        select_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomDialogBox.this, "Gallery Selected", Toast.LENGTH_SHORT).show();
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Image"), 11);
                if(dialog.isShowing()){

                    dialog.dismiss();
                }

            }
        });
        select_camera.setOnClickListener(this);

        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(dialog.isShowing()){

            dialog.dismiss();
        }
        Uri uri = data.getData();
        if(requestCode==11)
        {
            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                iv_custom_dialog.setImageBitmap(bitmap);

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if(requestCode==12)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            iv_custom_dialog.setImageBitmap(bitmap);
        }
    }
}
