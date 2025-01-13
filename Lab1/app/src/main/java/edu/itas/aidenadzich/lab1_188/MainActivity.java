package edu.itas.aidenadzich.lab1_188;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons by their IDs
        Button randomButton = findViewById(R.id.randomButton);
        Button numbersButton = findViewById(R.id.numbersButton);
        Button namesButton = findViewById(R.id.namesButton);

        // Set onClickListeners for buttons
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNum = getRandom();
                Toast.makeText(MainActivity.this, "Random Number: " + randomNum, Toast.LENGTH_SHORT).show();
            }
        });

        numbersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] numbers = getNumbers();
                StringBuilder result = new StringBuilder();
                for (int num : numbers) {
                    result.append(num).append(" ");
                }
                Toast.makeText(MainActivity.this, "Numbers: " + result.toString(), Toast.LENGTH_LONG).show();
            }
        });

        namesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] names = getNames();
                StringBuilder result = new StringBuilder();
                for (String name : names) {
                    result.append(name).append(", ");
                }
                Toast.makeText(MainActivity.this, "Names: " + result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to get a random number between 1 and 10
    public int getRandom() {
        Random random = new Random();
        return random.nextInt(10) + 1; // Random number between 1 and 10
    }

    // Method to return an array of numbers from 1 to 100
    public int[] getNumbers() {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1; // Numbers from 1 to 100
        }
        return numbers;
    }

    // Method to return an array of 5 names
    public String[] getNames() {
        return new String[]{"Alice", "Bob", "Charlie", "Diana", "Eve"};
    }
}
