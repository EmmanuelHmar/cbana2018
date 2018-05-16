package vanmang.com.Control_Page.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.R;
import vanmang.com.Control_Page.Schedule.Tab1Fragment;
import vanmang.com.Control_Page.Schedule.Tab2Fragment;
import vanmang.com.Control_Page.Schedule.Tab3Fragment;
import vanmang.com.Control_Page.SectionsPageAdapter;


/**
 * Created by VC 1/13/18
 */

public class ActivitySchedule extends AppCompatActivity {
    private static final String TAG = "Activity3";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);

        new BottomNavigationIntents(this, bottomNavigationView,1);
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "MAY 25");
        adapter.addFragment(new Tab2Fragment(), "MAY 26");
        adapter.addFragment(new Tab3Fragment(), "MAY 27");
        //adapter.addFragment();
        viewPager.setAdapter(adapter);
    }

}