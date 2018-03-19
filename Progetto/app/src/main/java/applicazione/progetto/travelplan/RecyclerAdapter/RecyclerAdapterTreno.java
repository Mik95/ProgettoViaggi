package applicazione.progetto.travelplan.RecyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Activity.Home;
import applicazione.progetto.travelplan.R;

/**
 * Created by itsadmin on 02/03/2018.
 */

public class RecyclerAdapterTreno extends RecyclerView.Adapter<RecyclerAdapterTreno.MyViewHolder> {


    private Context ct;

    private ArrayList<String> partTreno = new ArrayList<>();
    private ArrayList<String> arriTreno = new ArrayList<>();

    private ArrayList<String> oraPartTreno= new ArrayList<>();
    private ArrayList<String> oraArriTreno = new ArrayList<>();

    private ArrayList<String> dataTreno = new ArrayList<>();
    private ArrayList<Integer> treno = new ArrayList<>();

    public RecyclerAdapterTreno(Context context,ArrayList<String>partenza,ArrayList<String>arrivo,ArrayList<String>oraP,ArrayList<String>oraA,ArrayList<String>d,ArrayList<Integer>itreno) {
        this.ct= context;
        this.partTreno=partenza;
        this.arriTreno=arrivo;
        this.oraPartTreno=oraP;
        this.oraArriTreno=oraA;
        this.dataTreno= d;
        this.treno=itreno;
    }

public class MyViewHolder extends RecyclerView.ViewHolder {
    //public TextView title, year, genre;
    public TextView cittaPartenza,cittaArrivo,oraP,oraA,giorno;
    public ImageView treno;

    public MyViewHolder(View view) {
        super(view);

        oraP = view.findViewById(R.id.oraPartTreno);
        oraA =  view.findViewById(R.id.oraDestTreno);
        cittaPartenza =  view.findViewById(R.id.partTreno);
        cittaArrivo =  view.findViewById(R.id.destTreno);
        treno = view.findViewById(R.id.imageTreno);
        giorno = view.findViewById(R.id.giornoTreno);
        //year = (TextView) view.findViewById(R.id.year);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cittap=cittaPartenza.getText().toString();
                String cittaa=cittaArrivo.getText().toString();
                String orap =oraP.getText().toString();
                String oraa= oraA.getText().toString();
                //Log.d("AdapterAereo", "Fondo cliccked " + getAdapterPosition());*/
                Intent intent = new Intent(ct, Home.class);
                intent.putExtra("CittaPartenzaTreno", cittap);
                intent.putExtra("CittaArrivoTreno", cittaa);
                intent.putExtra("OraPartenzaTreno", orap);
                intent.putExtra("OraArrivoTreno", oraa);
                ct.startActivity(intent);
            }
        });
    }
}


   /* public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }*/

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_treno, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Widget presenti nella recycler dell'aereo
        holder.cittaPartenza.setText(partTreno.get(position));
        holder.cittaArrivo.setText(arriTreno.get(position));
        holder.oraP.setText(oraPartTreno.get(position));
        holder.oraA.setText(oraArriTreno.get(position));
        holder.treno.setImageResource(treno.get(position));
        holder.giorno.setText(dataTreno.get(position));
    }

    @Override
    public int getItemCount() {
        return partTreno.size();
    }
}
