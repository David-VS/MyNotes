package be.ehb.mynotes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import be.ehb.mynotes.R;
import be.ehb.mynotes.model.Note;
import be.ehb.mynotes.model.NoteViewModel;

public class CreateNoteFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_create_new, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NoteViewModel model = new ViewModelProvider(mContext).get(NoteViewModel.class);

        EditText titleET = view.findViewById(R.id.create_title_et);
        EditText contentET = view.findViewById(R.id.create_content_et);

        Button saveBtn = view.findViewById(R.id.create_confirm_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note n = new Note(titleET.getText().toString(),
                        contentET.getText().toString());
                model.insertNote(n);
                Navigation.findNavController(view).navigateUp();
            }
        });

    }
}