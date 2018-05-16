package vanmang.com.Control_Page;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


//This class is the adapter for the recyclerView
public class RecyclerOptionsAdapter extends RecyclerView.Adapter<RecyclerOptionsAdapter.ViewHolder> {
    private String[] contactNames, speakerTop, speakerBottom, contactEmails, contactPhones;
    private Context mContext;
    private Boolean isItSpeakers; //The adapter acts differently over for the speakers
    private String className;
    private static final String TAG = "RecyclerOptionsAdapter";

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView firstTextView, secondTextView, thirdTextView;
        private LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            if (isItSpeakers) {
                firstTextView = itemView.findViewById(R.id.speakerTop);
                secondTextView = itemView.findViewById(R.id.speakerBottom);
            } else if (className.contains("Contacts")) {
                firstTextView = itemView.findViewById(R.id.contact_name_text);
                secondTextView = itemView.findViewById(R.id.contact_email_text);
                thirdTextView = itemView.findViewById(R.id.contact_phone_text);
            } else {
                firstTextView = itemView.findViewById(R.id.options_textview);
                parentLayout = itemView.findViewById(R.id.recycler_linear);
            }
        }
    }

    public RecyclerOptionsAdapter(Context context, String[] options) {
        mContext = context;
        this.contactNames = options;
        isItSpeakers = false;
        this.className = context.getClass().getSimpleName();
    }

    public RecyclerOptionsAdapter(Context context, String[] speakerTop, String[] speakerBottom, Boolean isItSpeakers) {
        this.mContext = context;
        this.speakerTop = speakerTop;
        this.speakerBottom = speakerBottom;
        this.isItSpeakers = isItSpeakers;
        this.className = context.getClass().getSimpleName();
    }

    public RecyclerOptionsAdapter(Context context, String[] contactNames, String[] contactEmails, String[] contactPhones) {
        this.mContext = context;
        this.contactNames = contactNames;
        this.contactEmails = contactEmails;
        this.contactPhones = contactPhones;
        isItSpeakers = false;
        this.className = context.getClass().getSimpleName();
    }

    //     inflate the item layout and create the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View optionsView;

//        Inflate the custom view
        if (isItSpeakers) {
            optionsView = inflater.inflate(R.layout.cardview_items, parent, false);
        } else if (className.contains("Contacts")) {
            optionsView = inflater.inflate(R.layout.item_contact_options, parent, false);
        } else {
            optionsView = inflater.inflate(R.layout.item_options, parent, false);
        }

//        Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(optionsView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

//        Get the model data based on the current position
        if (isItSpeakers) {
            final String speakerTopText = speakerTop[position];
            final String speakerBotText = speakerBottom[position];

            final TextView topTextView = holder.firstTextView;
            final TextView botTextView = holder.secondTextView;

            topTextView.setText(speakerTopText);
            botTextView.setText(speakerBotText);
        } else if (className.contains("Contacts")) {
//        Get model data based on position
            final String option = contactNames[position];
            final String email = contactEmails[position];
            final String phone = contactPhones[position];

            final TextView textView = holder.firstTextView;
            final TextView secondTextView = holder.secondTextView;
            final TextView thirdText = holder.thirdTextView;
            textView.setText(option);
            secondTextView.setText(email);
            thirdText.setText(phone);
        } else {
            final String option = contactNames[position];

            final TextView textView = holder.firstTextView;
            textView.setText(option);
        }

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        if (isItSpeakers) {
            return speakerTop.length;
        } else {
            return contactNames.length;
        }
    }
}
