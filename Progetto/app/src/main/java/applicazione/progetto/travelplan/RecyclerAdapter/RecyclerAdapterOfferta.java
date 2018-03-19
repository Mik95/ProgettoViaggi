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

public class RecyclerAdapterOfferta extends RecyclerView.Adapter<RecyclerAdapterOfferta.MyViewHolder> {


   private ArrayList<String>nome= new ArrayList<String>();
    private ArrayList<String>descrizione= new ArrayList<String>();
    private ArrayList<Integer>img = new ArrayList<Integer>();
    private Context ct;

    public RecyclerAdapterOfferta()
    {

    }
    public RecyclerAdapterOfferta(Context context)
    {
    this.ct=context;
    }

    public RecyclerAdapterOfferta(Context context,ArrayList<String> n,ArrayList<String> d,ArrayList<Integer>i)
    {
        this.ct=context;
        this.nome=n;
        this.descrizione=d;
        this.img=i;
    }



public class MyViewHolder extends RecyclerView.ViewHolder {
    //public TextView title, year, genre;
    public TextView n2,desc2;
    public ImageView immagine2;

    public MyViewHolder(View view) {
        super(view);

        n2 = view.findViewById(R.id.title2);
        desc2 = view.findViewById(R.id.genre2);
        immagine2 = view.findViewById(R.id.item_image2);

       view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e="";
                Intent i = new Intent(ct, Home.class);
                i.putExtra("Offerta",e);
                ct.startActivity(i);
            }
        });
    }
}


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_offerta, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Lista in offerta
        holder.n2.setText(nome.get(position));
        holder.desc2.setText(descrizione.get(position));
        holder.immagine2.setImageResource(img.get(position));
    }

    @Override
    public int getItemCount() {
        return nome.size();
    }
}