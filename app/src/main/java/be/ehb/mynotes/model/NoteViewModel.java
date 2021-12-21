package be.ehb.mynotes.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private LiveData<List<Note>> sharedNotes;
    private NotesDatabase mDatabase;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        mDatabase = NotesDatabase.getInstance(application);
        sharedNotes = mDatabase.getNotesDAO().getAllNotes();
    }

    public LiveData<List<Note>> getSharedNotes() {
        return sharedNotes;
    }

    public void insertNote(Note n){
        NotesDatabase.dbExecutor.execute(()->{
                mDatabase.getNotesDAO().insertNote(n);
        });
    }
}
