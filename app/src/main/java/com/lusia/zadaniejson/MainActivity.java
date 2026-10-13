package com.lusia.zadaniejson;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArtykulAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom);

                    return insets;
                });

        listView = findViewById(R.id.listViewNotatki);

        pobierzArtykuly();
    }

    private void pobierzArtykuly() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(
                        "https://raw.githubusercontent.com/koffecraft/artykuly-json/main/")
                .addConverterFactory(
                        GsonConverterFactory.create())
                .build();

        JSONPlaceholderAPI api =
                retrofit.create(JSONPlaceholderAPI.class);

        Call<List<Artykul>> call = api.getArtykuly();

        call.enqueue(new Callback<List<Artykul>>() {

            @Override
            public void onResponse(
                    Call<List<Artykul>> call,
                    Response<List<Artykul>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Błąd serwera: " + response.code(),
                            Toast.LENGTH_LONG
                    ).show();
                    return;
                }

                List<Artykul> artykuly = response.body();

                if (artykuly == null) {
                    Toast.makeText(
                            MainActivity.this,
                            "Brak danych artykułów",
                            Toast.LENGTH_LONG
                    ).show();
                    return;
                }

                adapter = new ArtykulAdapter(
                        MainActivity.this, artykuly);

                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(
                    Call<List<Artykul>> call,
                    Throwable t) {

                Toast.makeText(
                        MainActivity.this,
                        "Błąd połączenia: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}