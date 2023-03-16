package hr.unipu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.concurrent.ExecutionException;



public class MainActivity extends AppCompatActivity {
    private Button ispisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ispisi = findViewById(R.id.ispis_button);

        ispisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Gson gson = new Gson();
                    String jsonString = new FuelApiTask().execute().get();
                    List<FuelType> fuelTypes = gson.fromJson(jsonString, new TypeToken<List<FuelType>>(){}.getType());
                    for (FuelType fuelType : fuelTypes) {
                        System.out.println("Fuel: " + fuelType.getFuel());
                        for (FuelStation data : fuelType.getData()) {
                            System.out.println("   Name: " + data.getName() + ", Price: " + data.getPrice());
                        }
                    }


                } catch (ExecutionException | InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });
}
}