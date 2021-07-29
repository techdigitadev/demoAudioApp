package adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.audiotopapp.AudioLectureActivity;
import com.example.audiotopapp.R;

import java.text.DateFormat;
import java.text.ParseException;


import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import models.Fichier;


public class AudioAdapter extends
        RecyclerView.Adapter<AudioAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView totalTextView;
        public LinearLayout linearLayout;
        //public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            totalTextView = (TextView) itemView.findViewById(R.id.audio_count);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            // messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
    private List<Fichier> mContacts;

    // Pass in the contact array into the constructor
    public AudioAdapter(List<Fichier> contacts) {
        mContacts = contacts;
    }

    @Override
    public AudioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_category, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Get the data model based on position
        Fichier contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;

        String [] trimer = contact.getNom().split(".m");
        textView.setText(trimer[0]);

        TextView audioCount = holder.totalTextView;

        //formattage de la date
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        DateFormat formatter ;
        Date date ;
        String dates[] = contact.getCreatedAt().split(" ");

        //formatter = new SimpleDateFormat("dd-MMM-yy");
        //date = Date.valueOf(contact.getCreatedAt()) ;

        //String date1 = formatter.format(date);
        audioCount.setText("Enregistré le  "+  dates[0]+ " à "+dates[1]);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //---
                //--
               // Toast.makeText(view.getContext(), "L'id est  "+ contact.getId(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), AudioLectureActivity.class);
                intent.putExtra("audio_name", contact.getNomFichier());
               // intent.putExtra("categorie_id", contact.getId());
                view.getContext().startActivity(intent);
            }  });
        //Button button = holder.messageButton;
        //button.setText(contact.getFichierTotal().toString());
        //button.setEnabled(true);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
