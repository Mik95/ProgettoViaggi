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

public class RecyclerAdapterPopolari extends RecyclerView.Adapter<RecyclerAdapterPopolari.MyViewHolder> {

 //ArrayList strutture popolari

    private ArrayList<String> nome= new ArrayList<String>();
    private ArrayList<String>descrizione= new ArrayList<String>();
    private ArrayList<Integer>img = new ArrayList<Integer>();
    private Context ct;

    public RecyclerAdapterPopolari()
    {

    }
    public RecyclerAdapterPopolari(Context context,ArrayList<String> n,ArrayList<String> d,ArrayList<Integer>i)
    {
        this.ct=context;
        this.nome=n;
        this.descrizione=d;
        this.img=i;
    }


public class MyViewHolder extends RecyclerView.ViewHolder {
    //public TextView title, year, genre;
    public TextView n,desc;
    public ImageView immagine;

    public MyViewHolder(View view) {
        super(view);
        n = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.genre);
        immagine = view.findViewById(R.id.item_image);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e="";
                Intent i = new Intent(ct, Home.class);
                i.putExtra("Popolari",e);
                ct.startActivity(i);
            }
        });
    }
}


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_popolari, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //Lista popolari
        holder.n.setText(nome.get(position));
        holder.desc.setText(descrizione.get(position));
        holder.immagine.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return nome.size();
    }
}
