package com.example.usuario.alumbrado.api;

import android.telecom.Call;

import com.example.usuario.alumbrado.models.Alumbrado;

import java.util.ArrayList;
import retrofit2.http.GET;





public interface ApiService {
    @GET("k9xw-6nx5.json")
    Call<ArrayList<Alumbrado>> obtenerListaAlumbrado();
}