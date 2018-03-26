package applicazione.progetto.travelplan.Fragment.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import applicazione.progetto.travelplan.Activity.Home;
import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.Fragment.ViaggiFragment;

/**
 * Created by itsadmin on 22/02/2018.
 */

public class ConfermaTerminaPiano extends DialogFragment {

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Confermi di voler terminare il viaggio??")
                .setPositiveButton("SI, confermo", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((Home)getActivity()).getFragmentManager().beginTransaction().replace(R.id.frame,new ViaggiFragment()).commit();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }

}