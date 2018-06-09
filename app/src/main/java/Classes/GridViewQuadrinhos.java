package Classes;

import android.content.Context;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pc.hqapp.R;

/**
 * Created by android on 02/05/2018.
 */

public class GridViewQuadrinhos extends BaseAdapter{
    public Context context;
    public int[] images;

    public GridViewQuadrinhos(Context context, int[] images){
        this.context = context;
        this.images = images;

    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return images[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.grid_quadrinhos,parent,false);
        ConstraintLayout lay = (ConstraintLayout) itemView.findViewById(R.id.LayoutGrid);
        ImageView image = (ImageView) itemView.findViewById(R.id.imgQuadrinho);
        image.setImageResource(this.images[position]);
        return itemView;
    }
}
