package id.iseet.statlibtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import id.iseet.statlib.CentralTendency;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> numbers = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 15; i++) {
            numbers.add(r.nextInt(7)+1);
        }

        double mean = CentralTendency.arithmeticMean(numbers).doubleValue();
        double median = CentralTendency.median(numbers);
        ArrayList<Integer> mode = CentralTendency.mode(numbers);

        Collections.sort(numbers);

        String res = String.format("Numbers:\n\n%s\nMean: %.1f\nMedian: %.1f\nMode: %s\n",
                numbers, mean, median, mode);
        TextView txtDisplay = (TextView)findViewById(R.id.txt_display);
        txtDisplay.setText(res);
    }
}
