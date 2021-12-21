package be.ehb.mynotes.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDAO {

    @Query("SELECT * FROM Note ORDER BY title")
    LiveData<List<Note>> getAllNotes();

    @Insert
    void insertNote(Note n);
}
