package vanmang.com.Control_Page.Leaderships;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.R;
import vanmang.com.Control_Page.Tabs.ActivityLeaderships;

public class CBA_Mission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cba_mission);

        ImageView button = (ImageView) findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CBA_Mission.this,ActivityLeaderships.class);
                startActivity(intent);
            }
        });
        //To populate the bottom navigation menu on the layout
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);
        new BottomNavigationIntents(this, bottomNavigationView,0);
    }
}
