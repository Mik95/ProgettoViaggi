package applicazione.progetto.travelplan.RecyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Activity.Home;
import applicazione.progetto.travelplan.R;

/**
 * Created by itsadmin on 02/03/2018.
 */

public class RecyclerAdapterPullman extends RecyclerView.Adapter<RecyclerAdapterPullman.MyViewHolder>{



    private Context ct;

    private ArrayList<String> partPullman = new ArrayList<>();
    private ArrayList<String> arriPullman = new ArrayList<>();

    private ArrayList<String> oraPartPullman= new ArrayList<>();
    private ArrayList<String> oraArriPullman = new ArrayList<>();

    private ArrayList<String> dataPullman = new ArrayList<>();
    private ArrayList<Integer> pullman = new ArrayList<>();

    public RecyclerAdapterPullman(Context context,ArrayList<String>partenza,ArrayList<String>arrivo,ArrayList<String>oraP,ArrayList<String>oraA,ArrayList<String>d,ArrayList<Integer>ipullman) {
        this.ct= context;
        this.partPullman=partenza;
        this.arriPullman=arrivo;
        this.oraPartPullman=oraP;
        this.oraArriPullman=oraA;
        this.dataPullman= d;
        this.pullman=ipullman;
    }

public class MyViewHolder extends RecyclerView.ViewHolder {
    //public TextView title, year, genre;
    TextView cittaPartenza,cittaArrivo,oraP,oraA,giorno;
    ImageView pullman;
    Button bprezzo;

    public MyViewHolder(View view) {
        super(view);

        oraP = view.findViewById(R.id.oraPartPullman);
        oraA = view.findViewById(R.id.oraDestPullman);
        cittaPartenza = view.findViewById(R.id.partPullman);
        cittaArrivo = view.findViewById(R.id.destPullman);
        pullman = view.findViewById(R.id.imagePullman);
        giorno = view.findViewById(R.id.giornoPullman);
        bprezzo = view.findViewById(R.id.prezzoPullman);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String cittap=cittaPartenza.getText().toString();
                String cittaa=cittaArrivo.getText().toString();
                String orap =oraP.getText().toString();
                String oraa= oraA.getText().toString();
                Bundle bundl = new Bundle();
                bundl.putString("Tratta", "Tratta "+cittap +"--> "+cittaa);
                bundl.putString("Orario", "Ora partenza " + orap +"   " + "Ora arrivo: " + oraa);
                Pianificazione dv = new Pianificazione();
                dv.setArguments(bundl);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,dv);
                ft.show(getFragmentManager().findFragmentById(R.id.frame));
                ft.addToBackStack(null);
                ft.commit();*/
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cittap=cittaPartenza.getText().toString();
                String cittaa=cittaArrivo.getText().toString();
                String orap =oraP.getText().toString();
                String oraa= oraA.getText().toString();
                //Log.d("AdapterAereo", "Fondo cliccked " + getAdapterPosition());*/
                Intent intent = new Intent(ct, Home.class);
                intent.putExtra("CittaPartenzaPullman", cittap);
                intent.putExtra("CittaArrivoPullman", cittaa);
                intent.putExtra("OraPartenzaPullman", orap);
                intent.putExtra("OraArrivoPullman", oraa);
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


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_pullman, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Widget presenti nella recycler dell'aereo
        holder.cittaPartenza.setText(partPullman.get(position));
        holder.cittaArrivo.setText(arriPullman.get(position));
        holder.oraP.setText(oraPartPullman.get(position));
        holder.oraA.setText(oraArriPullman.get(position));
        holder.pullman.setImageResource(pullman.get(position));
        holder.giorno.setText(dataPullman.get(position));
    }

    @Override
    public int getItemCount() {
        return partPullman.size();
    }


}
