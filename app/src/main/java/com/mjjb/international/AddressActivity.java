package com.mjjb.international;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class AddressActivity extends Activity {

    public static String SERVER_URL;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_address);

    EditText input = findViewById(R.id.urlInput);
    Button btn = findViewById(R.id.connectBtn);

    // Load saved URL into field for convenience
    SharedPreferences prefs = getSharedPreferences("mjjb", MODE_PRIVATE);
    String saved = prefs.getString("url", "");
    if (!saved.isEmpty()) input.setText(saved);

    btn.setOnClickListener(v -> {
        String url = input.getText().toString().trim();
        if (url.isEmpty()) return;

        // Save for next session pre-fill
        prefs.edit().putString("url", url).apply();

        Intent i = new Intent(AddressActivity.this, MainActivity.class);
        i.putExtra("url", url);
        startActivity(i);
        // NO finish() — so back button returns here
    });
}
}
