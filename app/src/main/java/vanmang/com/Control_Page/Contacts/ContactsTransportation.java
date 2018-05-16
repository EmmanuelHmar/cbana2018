package vanmang.com.Control_Page.Contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import vanmang.com.Control_Page.R;
import vanmang.com.Control_Page.RecyclerOptionsAdapter;

public class ContactsTransportation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        //        Set the top textview
        TextView textView = findViewById(R.id.contacts_team_info);

        textView.setText("Hotel Team Contacts");
        textView.setTextSize(25);

        Toolbar toolbar = findViewById(R.id.toolbar_main);

//        Toolbar title
        toolbar.setTitle("Transportation Team");

//        Set the toolbar as an actionbar that can contain menus
        setSupportActionBar(toolbar);

//        Enable the home button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String names[] = new String[]{"Van Ram Lawm (Lawmte)", "Mang Thawm"};
        String emails[] = new String[]{"@mail", "@mail"};
        String phones[] = new String[]{"678-776-3189", "678-345-3119"};

        RecyclerView recyclerView = findViewById(R.id.contact_lists);

        RecyclerOptionsAdapter recyclerOptionsAdapter = new RecyclerOptionsAdapter(this, names, emails, phones);

        recyclerView.setAdapter(recyclerOptionsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //        To add the divider lines in between the items
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}