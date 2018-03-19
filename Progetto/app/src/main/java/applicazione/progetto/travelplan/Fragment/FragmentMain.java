package applicazione.progetto.travelplan.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.RecyclerAdapter.RecyclerAdapterOfferta;
import applicazione.progetto.travelplan.RecyclerAdapter.RecyclerAdapterPopolari;

/**
 * Created by itsadmin on 22/02/2018.
 */

public class FragmentMain extends Fragment {

    //recyclerView hotel in offerta e popolari
    RecyclerView recyclerViewPop;
    RecyclerView recyclerViewOff;
    //ViewPager viewPager;
    //CustomMainSwipeAdapter csa;
    ImageView imm;

    //Arraylist per gestione della Recycler view degli hotel in offerta
    ArrayList<String> nomeOff = new ArrayList<String>();
    ArrayList<String> descOff = new ArrayList<String>();
    ArrayList<Integer> imo = new ArrayList<Integer>();

    //Arraylist per gestione della Recycler view degli hotel popolari
    ArrayList<String> nomePop = new ArrayList<String>();
    ArrayList<String> descPop = new ArrayList<String>();
    ArrayList<Integer> imop = new ArrayList<Integer>();

    public FragmentMain()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_main, container, false);

        imm=(ImageView) root.findViewById(R.id.imageView);
        initOff();
        recyclerViewOff = root.findViewById(R.id.recycler_view_off);
        RecyclerAdapterOfferta rao = new RecyclerAdapterOfferta(getActivity(), nomeOff, descOff, imo);
        recyclerViewOff.setAdapter(rao);
        recyclerViewOff.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        initPop();
        recyclerViewPop = root.findViewById(R.id.recycler_view_pop);
        RecyclerAdapterPopolari rap = new RecyclerAdapterPopolari(getActivity(), nomePop, descPop, imop);
        recyclerViewPop.setAdapter(rap);
        recyclerViewPop.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));



        return root;
    }


    //Inizializzo gli arraylist che gestiscono la recyclerview degli hotel popolari
    private void initOff() {

        nomeOff.add("Hotel Sonya");
        descOff.add("Roma");
        imo.add(R.mipmap.bbcamera1);

        nomeOff.add("Hotel Hilton");
        descOff.add("Milano");
        imo.add(R.mipmap.bbcamera1);

        nomeOff.add("TriesteVillas");
        descOff.add("Trieste");
        imo.add(R.mipmap.camera2);
    }
    //Inizializzo gli arraylist che gestiscono la recyclerview degli hotel popolari
    private void initPop() {



        nomePop.add("Hotel Hilton");
        descPop.add("Milano");
        imop.add(R.mipmap.bbcamera1);

        nomePop.add("Hotel Sonya");
        descPop.add("Roma");
        imop.add(R.mipmap.bbcamera1);

        nomePop.add("TriesteVillas");
        descPop.add("Trieste");
        imop.add(R.mipmap.camera2);
    }


}
