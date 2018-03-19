package applicazione.progetto.travelplan.RecyclerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Activity.Home;
import applicazione.progetto.travelplan.R;

/**
 * Created by itsadmin on 02/03/2018.
 */

public class RecyclerAdapterAereo extends RecyclerView.Adapter<RecyclerAdapterAereo.MyViewHolder> {


    private Context ct;

    private ArrayList<String> partAereo = new ArrayList<>();
    private ArrayList<String> arriAereo = new ArrayList<>();

    private ArrayList<String> oraPartAereo= new ArrayList<>();
    private ArrayList<String> oraArriAereo = new ArrayList<>();

    private ArrayList<String> dataAereo = new ArrayList<>();
    private ArrayList<Integer> aereo = new ArrayList<>();



    public RecyclerAdapterAereo() {

    }

    public RecyclerAdapterAereo(Context context,ArrayList<String>partenza,ArrayList<String>arrivo,ArrayList<String>oraP,ArrayList<String>oraA,ArrayList<String>d,ArrayList<Integer>iaereo) {
        this.ct= context;
        this.partAereo=partenza;
        this.arriAereo=arrivo;
        this.oraPartAereo=oraP;
        this.oraArriAereo=oraA;
        this.dataAereo= d;
        this.aereo=iaereo;
    }



public  class MyViewHolder extends RecyclerView.ViewHolder {
    //public TextView title, year, genre;
    public TextView cittaPartenza,cittaArrivo,oraP,oraA,giorno;
    public ImageView aereo;
    public  Button prezzo;

    RelativeLayout parentLayout;

    public MyViewHolder(View view) {
        super(view);

        oraP =  view.findViewById(R.id.oraPartAereo);
        oraA =  view.findViewById(R.id.oraDestAereo);
        cittaPartenza = view.findViewById(R.id.partAereo);
        cittaArrivo = view.findViewById(R.id.destAereo);
        aereo = view.findViewById(R.id.imageAereo);
        giorno =  view.findViewById(R.id.giornoAereo);
        prezzo =  view.findViewById(R.id.prezzoAereo);
        parentLayout = view.findViewById(R.id.parentLayout);


        //Associo a delle stringhe il contenuto del testo delle editText
        final String cittap=cittaPartenza.getText().toString();
        final String cittaa=cittaArrivo.getText().toString();
        final String orap =oraP.getText().toString();
        final String oraa= oraA.getText().toString();



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.d("AdapterAereo", "Fondo cliccked " + getAdapterPosition());*/
               /* Bundle bundl = new Bundle();
                bundl.putString("CittaPartenzaAereo", cittap);
                bundl.putString("CittaArrivoAereo", cittaa);
                bundl.putString("OraPartenzaAereo", orap);
                bundl.putString("OraArrivoAereo", oraa);
                Pianificazione dv = new Pianificazione();
                dv.setArguments(bundl);
                FragmentTransaction ft = ((Home)getClass().get)getFragmentManager().beginTransaction();
                ft.replace(R.id.frame,dv);
                ft.show(getFragmentManager().findFragmentById(R.id.frame));
                ft.addToBackStack(null);
                ft.commit();*/
                Intent intent = new Intent(ct, Home.class);
                intent.putExtra("CittaPartenzaAereo", cittap);
                intent.putExtra("CittaArrivoAereo", cittaa);
                intent.putExtra("OraPartenzaAereo", orap);
                intent.putExtra("OraArrivoAereo", oraa);
                ct.startActivity(intent);
            }
        });

        prezzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ct,Home.class);
                intent.putExtra("CittaPartenzaAereo", cittap);
                intent.putExtra("CittaArrivoAereo", cittaa);
                intent.putExtra("OraPartenzaAereo", orap);
                intent.putExtra("OraArrivoAereo", oraa);
                ct.startActivity(intent);
            }
        });
    }
}


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_aereo, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //initAereo();
        //Widget presenti nella recycler dell'aereo
        holder.cittaPartenza.setText(partAereo.get(position));
        holder.cittaArrivo.setText(arriAereo.get(position));
        holder.oraP.setText(oraPartAereo.get(position));
        holder.oraA.setText(oraArriAereo.get(position));
        holder.aereo.setImageResource(aereo.get(position));
        holder.giorno.setText(dataAereo.get(position));



    }

    @Override
    public int getItemCount() {
        return partAereo.size();
    }

}
