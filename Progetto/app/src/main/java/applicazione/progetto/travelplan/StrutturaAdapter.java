package applicazione.progetto.travelplan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.Struttura;

public class StrutturaAdapter extends RecyclerView.Adapter<StrutturaAdapter.MyViewHolder> {

    private List<Struttura> structuresList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView citta, hotel, prezzo;

        public MyViewHolder(View view) {
            super(view);
            citta = (TextView) view.findViewById(R.id.title);
            hotel = (TextView) view.findViewById(R.id.genre);
            prezzo = (TextView) view.findViewById(R.id.year);
        }
    }


    public StrutturaAdapter(List<Struttura> structuresList) {
        this.structuresList = structuresList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.structure_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Struttura struttura = structuresList.get(position);
        holder.citta.setText(struttura.getCitta());
        holder.hotel.setText(struttura.getNome());
        holder.prezzo.setText((int) struttura.getPrezzo());
    }

    @Override
    public int getItemCount() {
        return structuresList.size();
    }
}