package com.lusia.zadaniejson;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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
    ListView listView;
    List<Artykul> artykulyInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listViewNotatki);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/mechaniktgmobilne/pytania_retrofit/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JSONPlaceholderAPI jsonPlaceholderAPI = retrofit.create(JSONPlaceholderAPI.class);
        Call<List<Artykul>> call = jsonPlaceholderAPI.getArtykuly();
        call.enqueue(
                new Callback<List<Artykul>>() {
                    @Override
                    public void onResponse(Call<List<Artykul>> call, Response<List<Artykul>> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(MainActivity.this, response.code()
                                    , Toast.LENGTH_SHORT).show();
                            return;
                        }
                        artykulyInternet = response.body();
                        ArrayAdapter<Artykul> adapter = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                artykulyInternet);
                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<Artykul>> call, Throwable t) {

                    }
                }
        );
    }
}