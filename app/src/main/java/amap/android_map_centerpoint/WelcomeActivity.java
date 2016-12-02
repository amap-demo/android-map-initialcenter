package amap.android_map_centerpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button beijingButton= (Button) findViewById(R.id.bj_button);
        Button shanghaiButton= (Button) findViewById(R.id.sh_button);
        Button guangzhouButton= (Button) findViewById(R.id.gz_button);
        beijingButton.setOnClickListener(this);
        shanghaiButton.setOnClickListener(this);
        guangzhouButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.bj_button:
                intent=new Intent(WelcomeActivity.this,MainActivity.class);
                intent.putExtra(MainActivity.CITI_KEY,MainActivity.BEIJING);
                startActivity(intent);
                break;
            case  R.id.gz_button:
                intent=new Intent(WelcomeActivity.this,MainActivity.class);
                intent.putExtra(MainActivity.CITI_KEY,MainActivity.GUANGZHOU);
                startActivity(intent);
                break;
            case R.id.sh_button:
                intent=new Intent(WelcomeActivity.this,MainActivity.class);
                intent.putExtra(MainActivity.CITI_KEY,MainActivity.SHANGHAI);
                startActivity(intent);
                break;

        }
    }
}
