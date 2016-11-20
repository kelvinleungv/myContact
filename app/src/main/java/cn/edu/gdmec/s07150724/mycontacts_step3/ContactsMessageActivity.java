package cn.edu.gdmec.s07150724.mycontacts_step3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by abc on 2016/11/17.
 */
public class ContactsMessageActivity extends AppCompatActivity{
    private TextView nameEditText;
    private TextView mobileEditText;
    private TextView qqEditText;
    private TextView danweiEdiText;
    private TextView addressEditText;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        //获得界面控件实例
        nameEditText =(TextView)findViewById(R.id.name);
        mobileEditText=(TextView)findViewById(R.id.mobile);
        danweiEdiText=(TextView)findViewById(R.id.danwei);
        qqEditText=(TextView)findViewById(R.id.qq);
        addressEditText=(TextView)findViewById(R.id.address);
        //获得Activity传来的数据
        Bundle localBundle=getIntent().getExtras();
        int id=localBundle.getInt("user_ID");
        //用ID查找联系人
        ContactsTable ct=new ContactsTable(this);
        user =ct.getUserByID(id);
        //显示联系人信息
        nameEditText.setText("姓名:"+user.getName());
        mobileEditText.setText("电话"+user.getMobile());
        qqEditText.setText("qq"+user.getQq());
        danweiEdiText.setText("单位"+user.getDanwei());
        addressEditText.setText("地址"+user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
