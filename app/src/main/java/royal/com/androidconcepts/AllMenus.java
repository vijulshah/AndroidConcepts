package royal.com.androidconcepts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class AllMenus extends AppCompatActivity implements View.OnClickListener {

    TextView tv_context_menu;
    Button btn_popup_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_menus);

        tv_context_menu = (TextView)findViewById(R.id.tv_context_menu);
        registerForContextMenu(tv_context_menu);

        btn_popup_menu = (Button)findViewById(R.id.btn_popup_menu);
        btn_popup_menu.setOnClickListener(this);
    }

    /* Context Menu Start*/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        onSelectItem(item);
        return true;
    }
    /* Context Menu End*/

    /* Options Menu Start */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        onSelectItem(item);
        return true;
    }
    /* Options Menu End*/

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btn_popup_menu :
            {
                PopupMenu popupMenu = new PopupMenu(this,btn_popup_menu);

                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.item_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(AllMenus.this,"you selected "+item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
            break;
        }
    }

    private void onSelectItem(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_search:
            {
                Toast.makeText(AllMenus.this,"you selected "+item.getTitle(),Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.item_wish_list:
            {
                Toast.makeText(AllMenus.this,"you selected "+item.getTitle(),Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.item_cart:
            {
                Toast.makeText(AllMenus.this,"you selected "+item.getTitle(),Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.item_logout:
            {
                Toast.makeText(AllMenus.this,"you selected "+item.getTitle(),Toast.LENGTH_SHORT).show();
            }
            break;
        }

    }
}
