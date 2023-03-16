package hr.unipu;
import android.os.AsyncTask;
import java.io.IOException;
import java.util.Objects;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FuelApiTask extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://fuel-service.onrender.com/").build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected HTTP response: " + response);
            }

            return Objects.requireNonNull(response.body()).string();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}