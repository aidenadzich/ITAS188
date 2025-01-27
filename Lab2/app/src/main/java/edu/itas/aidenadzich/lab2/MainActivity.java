package edu.itas.aidenadzich.lab2;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }

    public void showNumbers(View view) {
        TextView textView = findViewById(R.id.textView);
        StringBuilder numbers = new StringBuilder();

        for (int i = 1; i <= 147; i++) {
            if (isPrime(i)) {
                numbers.append(i).append(" ");
            }
        }

        textView.setText(numbers.toString());
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    private void playSound(String soundUrl) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build());
            mediaPlayer.setDataSource(soundUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();

            Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("Soundboard", "Error playing sound", e);
            Toast.makeText(getApplicationContext(), "Error playing sound", Toast.LENGTH_SHORT).show();
        }
    }

    public void playSound1(View view) {
     playSound("https://www.wavsource.com/snds_2020-10-01_3728627494378403/movies/star_wars/do_or_do_not.wav");
    }

    public void playSound2(View view) {
        playSound("https://www.wavsource.com/snds_2020-10-01_3728627494378403/movies/star_wars/your_father.wav");
    }

    public void playSound3(View view) {
        playSound("https://www.wavsource.com/snds_2020-10-01_3728627494378403/movies/star_wars/chewy.wav");
    }

    public void playSound4(View view) {
        playSound("https://www.wavsource.com/snds_2020-10-01_3728627494378403/movies/star_wars/the_force.wav");
    }

    public void showWeb(View view) {
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.slashdot.org");
    }


}