package be.ehb.mynotes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import be.ehb.mynotes.R;
import be.ehb.mynotes.model.Note;

public class NoteDetailsFragment extends Fragment {

    private FragmentActivity mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Note passedNote = (getArguments() != null)? (Note) getArguments().getSerializable("note") : null;
        if(passedNote != null){
            TextView titleTV = view.findViewById(R.id.details_title_tv);
            TextView contentTV = view.findViewById(R.id.details_content_tv);
            TextView createdTV = view.findViewById(R.id.details_created_tv);
            TextView modifiedTV = view.findViewById(R.id.details_modified_tv);

            titleTV.setText(passedNote.getTitle());
            contentTV.setText(passedNote.getContent());
            createdTV.setText(passedNote.getPublishDate().toString());
            modifiedTV.setText(passedNote.getLastModifiedDate().toString());
        }

    }
}
