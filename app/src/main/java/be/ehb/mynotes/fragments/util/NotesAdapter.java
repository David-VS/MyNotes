package be.ehb.mynotes.fragments.util;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import be.ehb.mynotes.R;
import be.ehb.mynotes.model.Note;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    class NotesViewHolder extends RecyclerView.ViewHolder{

        final TextView titleTV, dateTV;
        final CardView card;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.row_title_tv);
            dateTV = itemView.findViewById(R.id.row_date_tv);
            card = itemView.findViewById(R.id.row_note_card);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Note noteToPass = allNotes.get(position);

                    Bundle arguments = new Bundle();
                    arguments.putSerializable("note", noteToPass);

                    Navigation.findNavController(itemView).navigate(R.id.action_overview_to_detailsFragment, arguments);
                }
            });
        }
    }

    private List<Note> allNotes;

    public NotesAdapter(List<Note> allNotes) {
        this.allNotes = allNotes;
    }

    public void reloadNotes(List<Note> newNotes){
        this.allNotes = newNotes;
        notifyDataSetChanged();//herteken, er zijn wijzigingen
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context mContext = parent.getContext();
        View row = LayoutInflater.from(mContext).inflate(R.layout.note_row, parent, false);

        return new NotesViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note currentNote = allNotes.get(position);

        holder.titleTV.setText(currentNote.getTitle());
        holder.dateTV.setText(currentNote.getLastModifiedDate().toString());
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

}
