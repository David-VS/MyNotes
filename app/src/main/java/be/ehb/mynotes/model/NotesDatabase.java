package be.ehb.mynotes.model;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import be.ehb.mynotes.model.util.DateConverter;

@Database(version = 1, entities = {Note.class})
@TypeConverters({DateConverter.class})
public abstract class NotesDatabase extends RoomDatabase {

    //singleton db
    private static NotesDatabase instance;

    public static NotesDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context,
                    NotesDatabase.class,
                    "notedatabase.db").build();
        }
        return instance;
    }

    //acties op database
    public abstract NotesDAO getNotesDAO();

    //werk op de achtergrond
    static final ExecutorService dbExecutor = Executors.newFixedThreadPool(2);
}
