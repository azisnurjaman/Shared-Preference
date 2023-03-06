package com.example.sharedpreference;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    private EditText area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        area = findViewById(R.id.edit_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences share = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String a = share.getString("area", "");

        area.setText(a);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("area", area.getText().toString());
        myEdit.apply();
    }
}