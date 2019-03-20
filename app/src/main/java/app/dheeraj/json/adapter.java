package app.dheeraj.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.apholder> {
    private  Context context;
    private ArrayList<Result> resultArrayList =new ArrayList<>();

    public adapter(Context context, ArrayList<Result> resultArrayList) {
        this.context = context;
        this.resultArrayList = resultArrayList;

    }

    @NonNull
    @Override
    public adapter.apholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.item_row,viewGroup,false);
        return new apholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.apholder apholder, int i) {
        apholder.tvname.setText(resultArrayList.get(i).getSpecies().getName());
    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }
    public  class apholder extends RecyclerView.ViewHolder {
        TextView tvname;
        public apholder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tvname);
        }
    }
}
