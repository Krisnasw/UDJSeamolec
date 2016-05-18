package intivestudio.web.id.udjseamolec;

/**
 * Created by Krisnasw on 5/17/2016.
 */
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public CustomListAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView rank;
        TextView country;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_row, parent, false);
        // Get the position
        resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
        rank = (TextView) itemView.findViewById(R.id.name);
        country = (TextView) itemView.findViewById(R.id.score);

        // Capture position and set results to the TextViews
        rank.setText(resultp.get(Score.nama));
        country.setText(resultp.get(Score.nilai));
        // Capture ListView item click
//        itemView.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // Get the position
//                resultp = data.get(position);
//                Intent intent = new Intent(context, Items.class);
//                // Pass all data rank
//                intent.putExtra("nama", resultp.get(Score.nama));
//                // Pass all data country
//                intent.putExtra("nilai", resultp.get(Score.nilai));
//                // Start SingleItemView Class
//                context.startActivity(intent);
//
//            }
//        });
        return itemView;
    }
}