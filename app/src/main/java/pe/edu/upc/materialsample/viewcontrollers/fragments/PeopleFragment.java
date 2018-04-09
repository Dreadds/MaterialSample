package pe.edu.upc.materialsample.viewcontrollers.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.materialsample.R;
import pe.edu.upc.materialsample.models.PeopleAdapter;
import pe.edu.upc.materialsample.models.PeopleRepository;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {
    RecyclerView peopleRecyclerView;
    PeopleAdapter adapter;

    LinearLayoutManager layoutManager;
    public PeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        peopleRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_people);
        adapter = new PeopleAdapter((PeopleRepository.getInstance().getPeople()));
        layoutManager = new LinearLayoutManager(view.getContext());
        peopleRecyclerView.setAdapter(adapter);
        peopleRecyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
