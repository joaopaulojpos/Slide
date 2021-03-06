package com.dellpc.slide;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Dell-PC on 05/12/2017.
 */

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    //list of images
    public int[] lst_images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_2,
            R.drawable.image_4
    };

    //lis of titles
    public String[] lst_titles = {
            "COSMONAUT",
            "SATELITE",
            "GALAXY",
            "ROCKET"
    };

    //list of description
    public String[] lst_description = {
            "Descripiton 1",
            "Descripiton 2",
            "Descripiton 3",
            "Descripiton 4",
    };

    //list of background colors
    public int[] lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };


    //Vamos obter o contexto da aplicação atráves do construtor
    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_titles.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        //aqui vai instancia o layout slide, usando o LayoutInflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        // Vinculou o layout de slide ao objeto View
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);

        //Agora nós acessamos os elementos do slide
        Button btnfinalizar = (Button) view.findViewById(R.id.btnfinalizar);
        ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
        TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_titles[position]);
        description.setText(lst_description[position]);

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewActivity.class);
                context.startActivity(intent);
            }
        });


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(final ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
        //super.destroyItem(container, position, object);
    }

    /**
     * Metodo para pular a introdução e ir direto o app funcional
     */

}
