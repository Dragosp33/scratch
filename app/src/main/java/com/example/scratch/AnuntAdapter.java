package com.example.scratch;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Adapter for the RecyclerView that displays a list of Anunts.
 */

public class AnuntAdapter extends RecyclerView.Adapter<AnuntAdapter.AnuntViewHolder> {

    private final LayoutInflater mInflater;
    private List<Anunt> mAnunts; // Cached copy of Anunts
    private static ClickListener clickListener;

    AnuntAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public AnuntViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_anunt, parent, false);
        return new AnuntViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnuntViewHolder holder, int position) {
        if (mAnunts != null) {
            Anunt current = mAnunts.get(position);
            holder.description.setText(current.getDescriere());
            holder.pret.setText(current.getPret().toString());
        } else {
            // Covers the case of data not being ready yet.

        }
    }

    /**
     * Associates a list of Anunts with this adapter
     */
    void setAnunts(List<Anunt> Anunts) {
        mAnunts = Anunts;
        notifyDataSetChanged();
    }

    /**
     * getItemCount() is called many times, and when it is first called,
     * mAnunts has not been updated (means initially, it's null, and we can't return null).
     */
    @Override
    public int getItemCount() {
        if (mAnunts != null)
            return mAnunts.size();
        else return 0;
    }

    /**
     * Gets the Anunt at a given position.
     * This method is useful for identifying which Anunt
     * was clicked or swiped in methods that handle user events.
     *
     * @param position The position of the Anunt in the RecyclerView
     * @return The Anunt at the given position
     */
    public Anunt getAnuntAtPosition(int position) {
        return mAnunts.get(position);
    }

    class AnuntViewHolder extends RecyclerView.ViewHolder {
        private final TextView description;
        private final TextView pret;

        private AnuntViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.anunt_descriere);
            pret = itemView.findViewById(R.id.iv_pret);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        AnuntAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View v, int position);
    }

}