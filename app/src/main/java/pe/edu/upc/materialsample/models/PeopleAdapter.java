package pe.edu.upc.materialsample.models;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.materialsample.R;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>{
    private List<Person> people;

    public PeopleAdapter(List<Person> people) {
        this.people = people;
    }

    public PeopleAdapter() {
    }

    @NonNull
    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.ViewHolder holder, int position) {
        holder.updateViews(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }

    public PeopleAdapter setPeople(List<Person> people) {
        this.people = people;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView firstNameTextView;
        private TextView lastNameTextView;
        private ConstraintLayout personLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            firstNameTextView = (TextView) itemView.findViewById(R.id.text_first_name);
            lastNameTextView = (TextView) itemView.findViewById(R.id.text_last_name);
            personLayout = (ConstraintLayout) itemView.findViewById(R.id.layout_person);
        }
        public  void updateViews(Person person){
            firstNameTextView.setText(person.getFirstName());
            lastNameTextView.setText(person.getLastName());
        }
    }
}
