package vanmang.com.Control_Page.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.Leaderships.CBA_Christian;
import vanmang.com.Control_Page.Leaderships.CBA_Culture;
import vanmang.com.Control_Page.Leaderships.CBA_Development;
import vanmang.com.Control_Page.Leaderships.CBA_Minister;
import vanmang.com.Control_Page.Leaderships.CBA_Mission;
import vanmang.com.Control_Page.Leaderships.CBA_Officers;
import vanmang.com.Control_Page.Leaderships.CBA_Women;
import vanmang.com.Control_Page.Leaderships.CBA_Youth;
import vanmang.com.Control_Page.R;
import vanmang.com.Control_Page.RecyclerOptionsAdapter;
import vanmang.com.Control_Page.RecyclerTouchListener;

/**
 * Created by VC
 */

public class ActivityLeaderships extends AppCompatActivity {

    private String[] speakerTop = new String[]{"Christian", "Culture", "Development", "Minister", "Mission", "Officers", "Women", "Youth"};
    private String[] speakerBottom = new String[]{"Education", "Literature", "Department", "Council", "Department", "Council", "Department", "Department"};
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderships);

        RecyclerView recyclerView = findViewById(R.id.recycler_card);

        RecyclerOptionsAdapter adapter = new RecyclerOptionsAdapter(this, speakerTop, speakerBottom, true);

        recyclerView.setAdapter(adapter);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(ActivityLeaderships.this, CBA_Christian.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(ActivityLeaderships.this, CBA_Culture.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(ActivityLeaderships.this, CBA_Development.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(ActivityLeaderships.this, CBA_Minister.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(ActivityLeaderships.this, CBA_Mission.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(ActivityLeaderships.this, CBA_Officers.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(ActivityLeaderships.this, CBA_Women.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(ActivityLeaderships.this, CBA_Youth.class);
                        startActivity(intent);
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);
        new BottomNavigationIntents(this, bottomNavigationView, 2);

    }


}
