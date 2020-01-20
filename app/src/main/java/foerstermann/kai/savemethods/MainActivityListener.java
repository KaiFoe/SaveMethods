package foerstermann.kai.savemethods;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivityListener implements View.OnClickListener {

    MainActivity mainActivity;

    public MainActivityListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSaveFile:
                saveFile(mainActivity);
                break;
            case R.id.btnLoadFile:
                mainActivity.txtvFileOutput.setText(loadFile(mainActivity));
        }
    }

    private void saveFile(Context context) {
        String filename = "Zitatdaten.txt";
        String data = "Daten, die in die Datei geschrieben werden sollen.";

        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String loadFile(Context context) {
        String filename = "Zitatdaten.txt";
        String data = "";

        FileInputStream fileInputStream;

        try {
            fileInputStream = context.openFileInput(filename);
            InputStream stream = new BufferedInputStream(fileInputStream);
            data = convertStreamToString(stream);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private String convertStreamToString(InputStream stream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        } catch (IOException e) {
            Log.e("MainActivity: ", "IOException: " + e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                Log.e("MainActivity: ", "IOException: " + e.getMessage());
            }
        }
        return stringBuilder.toString();
    }
}
