package vanmang.com.Control_Page.Tabs;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.R;
import vanmang.com.Control_Page.RecyclerOptionsAdapter;
import vanmang.com.Control_Page.RecyclerTouchListener;


/**
 * Created by vmang on 5/4/18.
 */

import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by VC on 1/16/18.
 */

public class ActivityLocations extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    private static final String TAG = "ActivityLocations";

    //declaration of Items for the listView
    String names[] = new String[]{"Atlanta Chin Baptist Church", "Hotels Information", "Infinite Energy Forum", "Recommended Places to Visit"};


    public static final String API_KEY = "AIzaSyDgmaGvaTJyDB5KeYSHtnAH-jp-tXdqOp8";
    public static final String VIDEO_ID = "4prM5LDeQ0I";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_contacts);

        // Initial Youtube Player View

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(API_KEY, this);

        //Text view portion of the page
        TextView textView = findViewById(R.id.location_title);
        textView.setText("Locations");
        RecyclerView recyclerView = findViewById(R.id.contacts);
        RecyclerOptionsAdapter recyclerOptionsAdapter = new RecyclerOptionsAdapter(this, names);

        recyclerView.setAdapter(recyclerOptionsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //        Use this instead of the previous listView listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent myIntent;
                switch (position) {
                    case 0:
                        myIntent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.google.com/maps/dir/''/atlanta+chin+baptist+church/@33.9006282,-84.2742941,12z/data=!4m8!4m7!1m0!1m5!1m1!1s0x88f5a69483ae119b:0x22d254e0010fb203!2m2!1d-84.204254!2d33.900648"));
                        startActivityForResult(myIntent, 0);
                        break;
                    case 1:
                        myIntent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.exploregwinnett.org/chinbaptist"));
                        startActivityForResult(myIntent, 1);
                        break;
                    case 2:
                        myIntent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.infiniteenergycenter.com/venues/detail/forum"));
                        startActivityForResult(myIntent, 2);
                        break;
                    case 3:
                        myIntent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://www.citypass.com/atlanta/things-to-do-atlanta"));
                        startActivityForResult(myIntent, 3);
                        break;

                    default:
                        break;
                }
            }


            @Override
            public void onLongClick(View view, int position) {

            }
        }));

//        To add the divider lines in between the items
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);

        new BottomNavigationIntents(this, bottomNavigationView, 3);


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result){

        Toast.makeText(this, "Failured to initialize!", Toast.LENGTH_LONG).show();

    }

    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored){

        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);

        if (!wasRestored){
            player.cueVideo(VIDEO_ID);
        }
    }


    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener(){

        @Override
        public void onBuffering(boolean arg0){

        }
        @Override
        public void onPaused(){

        }
        @Override
        public void onPlaying(){

        }
        @Override
        public void onSeekTo(int arg0){

        }
        @Override
        public void onStopped(){

        }


    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener(){

        @Override
        public void onAdStarted(){

        }
        @Override
        public void onError(YouTubePlayer.ErrorReason arg0){

        }
        @Override
        public void onLoaded(String arg0){

        }

        @Override
        public void onLoading(){

        }
        @Override
        public void onVideoEnded(){

        }
        @Override
        public void onVideoStarted(){

        }

    };


}
