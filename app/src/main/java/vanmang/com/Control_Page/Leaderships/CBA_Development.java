package vanmang.com.Control_Page.Leaderships;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.R;

public class CBA_Development extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cba_development);

        Toolbar toolbar = findViewById(R.id.toolbar_main);

        toolbar.setTitle("Development Department");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //To populate the bottom navigation menu on the layout
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);
        new BottomNavigationIntents(this, bottomNavigationView,0);

    }
}
