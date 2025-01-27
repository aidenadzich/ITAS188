package edu.itas.aidenadzich.lab3;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

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
        Log.d("ITAS274TAG", "onCreate() called");





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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ITAS274TAG", "onStart() called");
        Toast.makeText(this, "Activity onStart() running", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ITAS274TAG", "onRestart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ITAS274TAG", "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ITAS274TAG", "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ITAS274TAG", "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ITAS274TAG", "onDestroy() called");
    }

    public void showSnackbar(View view) {
        Log.d("ITAS274TAG", view.toString());
        Snackbar.make(view, "This is a Snackbar", Snackbar.LENGTH_SHORT).show();
    }

    public void intentButton(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("STRING_KEY", "Hello World");
        intent.putExtra("INT_KEY", 123);
        intent.putExtra("BOOLEAN_KEY", true);
        startActivity(intent);
    }

    public void callDad(View view) {
        Uri number = Uri.parse("tel:2507328262");
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(dialIntent);
    }

}