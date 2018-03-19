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

public class RecyclerAdapterAuto extends RecyclerView.Adapter<RecyclerAdapterAuto.MyViewHolder> {

    private Context ct;

    private ArrayList<String> partAuto = new ArrayList<>();
    private ArrayList<String> arriAuto = new ArrayList<>();

    private ArrayList<String> oraPartAuto= new ArrayList<>();
    private ArrayList<String> oraArriAuto = new ArrayList<>();

    private ArrayList<String> dataAuto = new ArrayList<>();
    private ArrayList<Integer> auto = new ArrayList<>();

    private String mezzo = "automobile";

    public RecyclerAdapterAuto(Context context,ArrayList<String>partenza,ArrayList<String>arrivo,ArrayList<String>oraP,ArrayList<String>oraA,ArrayList<String>d,ArrayList<Integer>iauto,String mezzo) {
        this.ct= context;
        this.partAuto=partenza;
        this.arriAuto=arrivo;
        this.oraPartAuto=oraP;
        this.oraArriAuto=oraA;
        this.dataAuto= d;
        this.auto=iauto;
        this.mezzo=mezzo;
    }

public class MyViewHolder extends RecyclerView.ViewHolder {
    //public TextView title, year, genre;
    public TextView cittaPartenza,cittaArrivo,oraP,oraA,giorno;
    public ImageView auto;

    public MyViewHolder(View view) {
        super(view);

        oraP = view.findViewById(R.id.oraPartAuto);
        oraA = view.findViewById(R.id.oraDestAuto);
        cittaPartenza = view.findViewById(R.id.partAuto);
        cittaArrivo = view.findViewById(R.id.destAuto);
        auto = view.findViewById(R.id.imageAuto);
        giorno = view.findViewById(R.id.giornoAuto);
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
                intent.putExtra("CittaPartenzaAuto", cittap);
                intent.putExtra("CittaArrivoAuto", cittaa);
                intent.putExtra("OraPartenzaAuto", orap);
                intent.putExtra("Automobile",mezzo);
                intent.putExtra("OraArrivoAuto", oraa);
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


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_auto, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Widget presenti nella recycler dell'aereo
        holder.cittaPartenza.setText(partAuto.get(position));
        holder.cittaArrivo.setText(arriAuto.get(position));
        holder.oraP.setText(oraPartAuto.get(position));
        holder.oraA.setText(oraArriAuto.get(position));
        holder.auto.setImageResource(auto.get(position));
        holder.giorno.setText(dataAuto.get(position));
    }

    @Override
    public int getItemCount() {
        return partAuto.size();
    }
}
