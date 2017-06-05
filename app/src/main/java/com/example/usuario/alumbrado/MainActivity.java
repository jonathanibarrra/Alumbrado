package com.example.usuario.alumbrado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.usuario.alumbrado.api.ApiService;
import com.example.usuario.alumbrado.models.Alumbrado;


import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2. Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG = "ALUMBRADO";
    private RecyclerView recyclerView;
    private boolean aptoParaCargar;
    private adaptador  adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adaptador = new adaptador(this);
        recyclerView.setAdapter(adaptador);

        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Final.");

                            aptoParaCargar = false;
                            obtenerLista();
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        aptoParaCargar = true;
        obtenerLista();

    }

    private void obtenerLista() {

        ApiService service = retrofit.create(ApiService.class);
        Call<ArrayList<Alumbrado>> autoRespuestaCall = service.obtenerListaAlumbrado();

        autoRespuestaCall.enqueue(new Callback<ArrayList<Alumbrado>>() {

            @Override
            public void onResponse(Call<ArrayList<Alumbrado>> call, Response<ArrayList<Alumbrado>> response) {

            }


            public void onFailure(Call<ArrayList<Alumbrado>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }
}