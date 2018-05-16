package vanmang.com.Control_Page.Tabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.R;
import vanmang.com.Control_Page.SectionsPageAdapter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView locate = (ImageView) findViewById(R.id.location);
        TextView test = (TextView) findViewById(R.id.location_text1);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.google.com/maps/dir/''/infinite+energy+forum/@33.9895659,-84.1637424,12z/data=!4m8!4m7!1m0!1m5!1m1!1s0x88f5bd49d678ee55:0x5f1aa689ef9a04f6!2m2!1d-84.0937023!2d33.9895857"));
                startActivity(intent);
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.google.com/maps/dir/''/infinite+energy+forum/@33.9895659,-84.1637424,12z/data=!4m8!4m7!1m0!1m5!1m1!1s0x88f5bd49d678ee55:0x5f1aa689ef9a04f6!2m2!1d-84.0937023!2d33.9895857"));
                startActivity(intent2);
            }
        });

//        To populate the bottom navigation menu on the layout
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);
        new BottomNavigationIntents(this, bottomNavigationView,0);

    }


}
