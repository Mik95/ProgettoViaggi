package applicazione.progetto.travelplan.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import applicazione.progetto.travelplan.R;
import applicazione.progetto.travelplan.RecyclerAdapter.RecyclerAdapterAereo;
import applicazione.progetto.travelplan.RecyclerAdapter.RecyclerAdapterAuto;
import applicazione.progetto.travelplan.RecyclerAdapter.RecyclerAdapterPullman;
import applicazione.progetto.travelplan.RecyclerAdapter.RecyclerAdapterTreno;

public class RicercaMezziFragment extends Fragment {

    //ArrayList per recycler adapter aereo
    private ArrayList<String> partAereo = new ArrayList<>();
    private ArrayList<String> arriAereo = new ArrayList<>();

    private ArrayList<String> oraPartAereo= new ArrayList<>();
    private ArrayList<String> oraArriAereo = new ArrayList<>();

    private ArrayList<String> dataAereo = new ArrayList<>();
    private ArrayList<Integer> aereo = new ArrayList<>();
    //ArrayList per recycler adapter pullman
    private ArrayList<String> partPullman = new ArrayList<>();
    private ArrayList<String> arriPullman = new ArrayList<>();

    private ArrayList<String> oraPartPullman= new ArrayList<>();
    private ArrayList<String> oraArriPullman = new ArrayList<>();

    private ArrayList<String> dataPullman = new ArrayList<>();
    private ArrayList<Integer> pullman = new ArrayList<>();
    //ArrayList per recycler adapter auto
    private ArrayList<String> partAuto = new ArrayList<>();
    private ArrayList<String> arriAuto = new ArrayList<>();

    private ArrayList<String> oraPartAuto= new ArrayList<>();
    private ArrayList<String> oraArriAuto = new ArrayList<>();

    private ArrayList<String> dataAuto = new ArrayList<>();
    private ArrayList<Integer> auto = new ArrayList<>();
    private String automobile = "auto";
    //ArrayList per recycler adapter treno
    private ArrayList<String> partTreno = new ArrayList<>();
    private ArrayList<String> arriTreno = new ArrayList<>();

    private ArrayList<String> oraPartTreno= new ArrayList<>();
    private ArrayList<String> oraArriTreno = new ArrayList<>();

    private ArrayList<String> dataTreno = new ArrayList<>();
    private ArrayList<Integer> treno = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_ricerca_mezzi, container, false);
        //Gestione recycler view aereo
        initAereo();
        RecyclerView recyclerViewAereo = root.findViewById(R.id.recyclerAereo);
        RecyclerAdapterAereo rva = new RecyclerAdapterAereo(getActivity(),partAereo,arriAereo,oraPartAereo,oraArriAereo,dataAereo,aereo);
        recyclerViewAereo.setAdapter(rva);
        recyclerViewAereo.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        //Fine gestione

        //Gestione recycler view pullman
        initPullman();
        RecyclerView recyclerViewPullman = root.findViewById(R.id.recyclerPullman);
        RecyclerAdapterPullman rvp = new RecyclerAdapterPullman(getActivity(),partPullman,arriPullman,oraPartPullman,oraArriPullman,dataPullman,pullman);
        recyclerViewPullman.setAdapter(rvp);
        recyclerViewPullman.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        //Fine gestione

        //Gestione recycler view auto
        initAuto();
        RecyclerView recyclerViewAuto = root.findViewById(R.id.recyclerAuto);
        RecyclerAdapterAuto rvAuto = new RecyclerAdapterAuto(getActivity(),partAuto,arriAuto,oraPartAuto,oraArriAuto,dataAuto,auto,automobile);
        recyclerViewAuto.setAdapter(rvAuto);
        recyclerViewAuto.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        //Fine gestione

        //Gestione recycler view treno
        initTreno();
        RecyclerView recyclerViewTreno = root.findViewById(R.id.recyclerTreno);
        RecyclerAdapterTreno rvt = new RecyclerAdapterTreno(getActivity(),partTreno,arriTreno,oraPartTreno,oraArriTreno,dataTreno,treno);
        recyclerViewTreno.setAdapter(rvt);
        recyclerViewTreno.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        //Fine gestione

        return root;
    }

    private void initAereo()
    {
        partAereo.add("Milan Bergamo");
        arriAereo.add("Barcellona");
        oraPartAereo.add("8,35");
        oraArriAereo.add("10,15");
        dataAereo.add("13/03/2018");
        aereo.add(R.mipmap.ic_aereo);

        partAereo.add("Milan Bergamo");
        arriAereo.add("Barcellona");
        oraPartAereo.add("15,50");
        oraArriAereo.add("17,30");
        dataAereo.add("13/03/2018");
        aereo.add(R.mipmap.ic_aereo);

        partAereo.add("Milan Bergamo");
        arriAereo.add("Barcellona");
        oraPartAereo.add("21,50");
        oraArriAereo.add("23,30");
        dataAereo.add("13/03/2018");
        aereo.add(R.mipmap.ic_aereo);

    }

    private void initPullman()
    {
        partPullman.add("Milan Bergamo");
        arriPullman.add("Barcellona");
        oraPartPullman.add("8,35");
        oraArriPullman.add("18,35");
        dataPullman.add("13/03/2018");
        pullman.add(R.mipmap.ic_pullman);

        partPullman.add("Milan Bergamo");
        arriPullman.add("Barcellona");
        oraPartPullman.add("12,00");
        oraArriPullman.add("22,00");
        dataPullman.add("13/03/2018");
        pullman.add(R.mipmap.ic_pullman);

        partPullman.add("Milan Bergamo");
        arriPullman.add("Barcellona");
        oraPartPullman.add("16,00");
        oraArriPullman.add("24,00");
        dataPullman.add("13/03/2018");
        pullman.add(R.mipmap.ic_pullman);

    }

    private void initAuto()
    {
        partAuto.add("Milan Bergamo");
        arriAuto.add("Barcellona");
        oraPartAuto.add("8,35");
        oraArriAuto.add("18,35");
        dataAuto.add("13/03/2018");
        auto.add(R.mipmap.ic_car);

        partAuto.add("Milan Bergamo");
        arriAuto.add("Barcellona");
        oraPartAuto.add("12,00");
        oraArriAuto.add("22,00");
        dataAuto.add("13/03/2018");
        auto.add(R.mipmap.ic_car);

        partAuto.add("Milan Bergamo");
        arriAuto.add("Barcellona");
        oraPartAuto.add("16,00");
        oraArriAuto.add("24,00");
        dataAuto.add("13/03/2018");
        auto.add(R.mipmap.ic_car);

    }

    private void initTreno()
    {
        partTreno.add("Milan Bergamo");
        arriTreno.add("Barcellona");
        oraPartTreno.add("8,35");
        oraArriTreno.add("18,35");
        dataTreno.add("13/03/2018");
        treno.add(R.mipmap.ic_train);

        partTreno.add("Milan Bergamo");
        arriTreno.add("Barcellona");
        oraPartTreno.add("12,00");
        oraArriTreno.add("22,00");
        dataTreno.add("13/03/2018");
        treno.add(R.mipmap.ic_train);

        partTreno.add("Milan Bergamo");
        arriTreno.add("Barcellona");
        oraPartTreno.add("16,00");
        oraArriTreno.add("24,00");
        dataTreno.add("13/03/2018");
        treno.add(R.mipmap.ic_train);

    }




}
