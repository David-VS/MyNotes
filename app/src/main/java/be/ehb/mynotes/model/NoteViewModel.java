package be.ehb.mynotes.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class NoteViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Note>> sharedNotes;
    private ArrayList<Note> notes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        sharedNotes = new MutableLiveData<ArrayList<Note>>();
        notes = new ArrayList<>();
        sharedNotes.setValue(notes);
    }

    public MutableLiveData<ArrayList<Note>> getSharedNotes() {
        return sharedNotes;
    }

    public void insertNote(Note n){
        notes.add(n);
        sharedNotes.setValue(notes);
    }
}
