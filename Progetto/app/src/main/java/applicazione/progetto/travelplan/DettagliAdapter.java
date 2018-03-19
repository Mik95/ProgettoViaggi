package applicazione.progetto.travelplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import applicazione.progetto.travelplan.Fragment.DettagliHotelFragment;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class DettagliAdapter extends ArrayAdapter<DettagliHotelFragment> {

    Context ctx;
    ArrayList<DettagliHotelFragment> values;

    public DettagliAdapter(Context ctx) {
        super(ctx, R.layout.dettagli_adapter_layout);

        this.ctx = ctx;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.dettagli_adapter_layout, parent, false);
        TextView descrizione = (TextView) rowView.findViewById(R.id.edDescCustom);
        TextView indirizzo = (TextView) rowView.findViewById(R.id.txIndCustom);



        return rowView;

    }
}