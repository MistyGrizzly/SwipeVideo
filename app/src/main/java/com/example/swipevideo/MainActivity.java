package com.example.swipevideo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemList = new ArrayList<>();


        VideoItem videoFriends = new VideoItem();
        videoFriends.videoURL = "https://github.com/MistyGrizzly/SwipeVideo/raw/refs/heads/master/PXL_20260507_221215689.mp4";
        videoFriends.videoTitle = "Best Friends";
        videoFriends.videoDescription = "Totally not angry that Biscuit is laying on top of him.";
        videoItemList.add(videoFriends);

        VideoItem catVideo = new VideoItem();
        catVideo.videoURL = "https://github.com/MistyGrizzly/SwipeVideo/raw/refs/heads/master/PXL_20260820_205904282~2.mp4";
        catVideo.videoTitle = "Goober Activities";
        catVideo.videoDescription = "The single orange braincell strikes again!!";
        videoItemList.add(catVideo);

        VideoItem theMissile = new VideoItem();
        theMissile.videoURL = "https://github.com/MistyGrizzly/SwipeVideo/raw/refs/heads/master/Snapchat-1587623076.mp4";
        theMissile.videoTitle = "The Missile";
        theMissile.videoDescription = "The missile knows where it is at all times. It knows this because it knows where it isn't.";
        videoItemList.add(theMissile);

        videoViewPager.setAdapter(new VideoAdapter(videoItemList));

    }
}