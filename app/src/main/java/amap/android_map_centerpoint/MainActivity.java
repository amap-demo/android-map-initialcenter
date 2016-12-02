package amap.android_map_centerpoint;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;

public class MainActivity extends Activity {
    private MapView mapView;
    private AMap aMap;
    private LinearLayout.LayoutParams mParams;
    private RelativeLayout mContainerLayout;
    private LatLng centerSHpoint = new LatLng(31.238068, 121.501654);// 上海市经纬度
    private LatLng centerBJpoint= new LatLng(39.904989,116.405285);// 北京市经纬度
    private LatLng centerGZpoint= new LatLng(23.125178,113.280637);// 广州市经纬度

    public  static  final  String CITI_KEY="city";
    public  static  final int SHANGHAI=0;
    public  static  final int BEIJING=1;
    public  static  final int GUANGZHOU=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainerLayout = (RelativeLayout) findViewById(R.id.activity_main);
        AMapOptions aOptions = new AMapOptions();

        int cityIndex = getIntent().getIntExtra(CITI_KEY,0);
        switch (cityIndex){
            case SHANGHAI:
                aOptions.camera(new CameraPosition(centerSHpoint, 10f, 0, 0));
                break;
            case BEIJING:
                aOptions.camera(new CameraPosition(centerBJpoint, 10f, 0, 0));
                break;
            case GUANGZHOU:
                aOptions.camera(new CameraPosition(centerGZpoint, 10f, 0, 0));
                break;
        }

        mapView = new MapView(this, aOptions);
        mapView.onCreate(savedInstanceState);
        mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        mContainerLayout.addView(mapView, mParams);
        init();
    }

    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
        }
    }
    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

}
