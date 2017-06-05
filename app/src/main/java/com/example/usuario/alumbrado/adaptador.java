package com.example.usuario.alumbrado;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.alumbrado.models.Alumbrado;

import java.util.ArrayList;

/**
 * Created by Usuario on 4/06/2017.
 */

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolder> {
        private ArrayList<Alumbrado> dataset;

        private Context context;

        public adaptador(Context context) {
            this.context = context;
            dataset = new ArrayList<>();

        }



        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumbrado, parent, false);
            return new ViewHolder(view);


        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    public int getItemCount() {

            return dataset.size();
        }

        public void setListaAlumbrado(ArrayList<Alumbrado> listaAlumbrado) {
            dataset.addAll(listaAlumbrado);
            notifyDataSetChanged();
        }

        public void notifyDataSetChanged() {
        }

        public class ViewHolder extends RecyclerView.ViewHolder {


            private TextView alumbrado;

            public ViewHolder(View itemView) {

                super(itemView);


                alumbrado = (TextView) itemView.findViewById(R.id.alumbrado);
            }
        }
    }

}
