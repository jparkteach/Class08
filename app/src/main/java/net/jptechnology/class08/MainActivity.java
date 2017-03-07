package net.jptechnology.class08;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = (TextView) findViewById(R.id.display_text);
    }

    public void addPerson(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 111); // you can use any number here
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 111 && resultCode == RESULT_OK) {
            Person person = (Person) data.getSerializableExtra(Keys.PERSON);
            displayText.setText(person.toString());
        }
    }
}
