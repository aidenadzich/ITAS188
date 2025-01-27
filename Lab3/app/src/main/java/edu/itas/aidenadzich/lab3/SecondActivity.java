package edu.itas.aidenadzich.lab3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String stringData = getIntent().getStringExtra("STRING_KEY");
        int intData = getIntent().getIntExtra("INT_KEY", 0);
        boolean boolData = getIntent().getBooleanExtra("BOOLEAN_KEY", false);

        TextView textView = findViewById(R.id.textView);
        textView.setText("String: " + stringData + "\nInt: " + intData + "\nBoolean: " + boolData);
    }

}