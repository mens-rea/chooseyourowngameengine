package com.wanderast.anghimagsikan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ChoiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<Choice> choices = new ArrayList<Choice>();
    private LayoutInflater inflater;

    public ChoiceAdapter(@NonNull Context context, @NonNull ArrayList<Choice> choices) {
        this.context = context;
        this.choices = choices;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return choices.size();
    }

    // fetches the template and creates the viewHolder
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        //inflate your layout and pass it to view holder
        View v = inflater.inflate(R.layout.template_choices, viewGroup, false);
        return new ChoiceViewHolder(v);
    }

    // instantiates the elements from the template
    public static class ChoiceViewHolder extends RecyclerView.ViewHolder {
        LinearLayout choiceOption;
        TextView choiceText;

        ChoiceViewHolder(View convertView) {
            super(convertView);

            choiceOption = convertView.findViewById(R.id.choice_option);
            choiceText = convertView.findViewById(R.id.choice_text);
        }
    }

    // called when item is given a view
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder draftViewHolder, int position) {

        final ChoiceAdapter.ChoiceViewHolder v = (ChoiceAdapter.ChoiceViewHolder) draftViewHolder;

        v.choiceText.setText(choices.get(position).text);

        v.choiceOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) context).update();
            }
        });
    }

    public void setChoices(ArrayList<Choice> choices){
        this.choices = choices;
    }
}
