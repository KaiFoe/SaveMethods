package foerstermann.kai.savemethods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityListener mainActivityListener;
    Button btnSaveFile, btnLoadFile;
    TextView txtvFileOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaveFile = findViewById(R.id.btnSaveFile);
        btnLoadFile = findViewById(R.id.btnLoadFile);

        txtvFileOutput = findViewById(R.id.txtvFileOutput);

        mainActivityListener = new MainActivityListener(this);

        btnSaveFile.setOnClickListener(mainActivityListener);
        btnLoadFile.setOnClickListener(mainActivityListener);
    }
}
