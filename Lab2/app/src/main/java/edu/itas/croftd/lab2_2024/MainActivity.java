package edu.itas.croftd.lab2_2024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * croftd - simple EmptyActivity that can be used to start lab2
 * Showed in class Jan. 22 example of modifying the default layout (activity_main.xml)
 * to use LinearLayout, add some buttons horizontally and then some EditText fields
 * vertically. Finally we add a send buttom that runs the sendMessage() method
 * that we defined below here in Java.
 */
public class MainActivity extends AppCompatActivity {

    // this is an example of a single line comment in Java

    /**
     * This is called a Javadoc comment
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // croftd - this next line is what loads the xml view into the app
        setContentView(R.layout.activity_main);
    }

    /**
     * croftd - this method was added to lab 2 to test the send message
     * button does something when you click it
     * @param view
     */
    public void sendMessage(View view) {
        Log.d("DAVEC", "Sending message");

        // croftd - this only works if we are running as a terminal program
        //System.out.println("Dave was here");

        // the round brackets (EditText) is called casting
        // It converts whatever is returned to an EditText type
        EditText messageText = (EditText)findViewById(R.id.messageText);

        // croftd - why does getText() return Editable?
        Editable messageEdit = messageText.getText();
        // we now have to convert the Editable content to a String
        String messageContent = messageEdit.toString();

        Log.d("DAVEC", "Here is the message: " + messageContent);


    }
}