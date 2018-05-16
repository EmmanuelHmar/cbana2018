package vanmang.com.Control_Page.Leaderships;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.R;


public class CBA_Officers extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cba_officers);



        /*
        btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(CBA_Officers.this, CBA_Officers2.class);
                startActivity(go);
            }
        }));

        */
        //To populate the bottom navigation menu on the layout
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);
        new BottomNavigationIntents(this, bottomNavigationView,0);
    }
}
