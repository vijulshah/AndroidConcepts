package royal.com.androidconcepts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class ChangeImage extends AppCompatActivity implements View.OnClickListener{

    ImageView iv_edit_img,iv_image_logo,iv_capture_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_image);

        init();
        iv_edit_img.setOnClickListener(this);
        iv_capture_img.setOnClickListener(this);
    }

    private void init() {

        iv_edit_img = (ImageView)findViewById(R.id.iv_edit_img);
        iv_image_logo = (ImageView)findViewById(R.id.iv_image_logo);
        iv_capture_img = (ImageView)findViewById(R.id.iv_capture_img);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.iv_edit_img :
            {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"Select Image"),10);
            }
            break;

            case R.id.iv_capture_img :
            {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,9);
            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri uri = data.getData();
        if(requestCode==10)
        {
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                iv_image_logo.setImageBitmap(bitmap);

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        if(requestCode==9)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            iv_image_logo.setImageBitmap(bitmap);
        }
    }
}
