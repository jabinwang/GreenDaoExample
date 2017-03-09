package cnc.cad.greendaoexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wangjm1
 * @version :1.0
 * @package : cnc.cad.greendaoexample
 * @class : ${CLASS_NAME}
 * @time : 2017/3/9 ${ITME}
 * @description :TODO
 */
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private NoteClickListener clickListener;
    private List<Note> dataset;

    public interface NoteClickListener {
        void onNoteClick(int position);
    }

    public NotesAdapter(NoteClickListener clickListener) {
        this.clickListener = clickListener;
        this.dataset = new ArrayList<Note>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_note, parent, false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = dataset.get(position);
        holder.text.setText(note.getText());
        holder.comment.setText(note.getComment());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setNotes(List<Note> notes){
        this.dataset = notes;
        notifyDataSetChanged();
    }
    public Note getNote(int position) {
        return dataset.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView text;
        public TextView comment;
        public ViewHolder(View itemView, final NoteClickListener clickListener) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textViewNoteText);
            comment = (TextView) itemView.findViewById(R.id.textViewNoteComment);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(clickListener != null){
                        clickListener.onNoteClick(getAdapterPosition());
                    }
                }
            });
        }
    }

}
