package be.ehb.mynotes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.mynotes.R;
import be.ehb.mynotes.fragments.util.NotesAdapter;
import be.ehb.mynotes.model.Note;
import be.ehb.mynotes.model.NoteViewModel;

public class OverviewFragment extends Fragment {

    private FragmentActivity mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity)context;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NotesAdapter adapter = new NotesAdapter(new ArrayList<>());

        NoteViewModel model = new ViewModelProvider(mContext).get(NoteViewModel.class);
        model.getSharedNotes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                adapter.reloadNotes(notes);
            }
        });

        RecyclerView notesRV = view.findViewById(R.id.overview_rv);
        notesRV.setAdapter(adapter);
        notesRV.setLayoutManager(new GridLayoutManager(mContext, 2));
    }
}