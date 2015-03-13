package com.hguarnieri.fzea.utils;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by H on 22/10/13.
 */
public class HorarioAdapter extends BaseAdapter {
    private Activity activity;
    private String[][] horarios = {{"06:25", "07:00", "07:35", "08:30", "09:45", "11:05", "11:50", "12:25", "13:35",
            "14:45", "16:00", "17:05", "17:35", "19:30", "20:15", "21:00", "21:45", "23:00"},

            {"06:40", "07:15", "07:50", "08:45", "10:00", "11:20", "12:05", "12:40", "13:50",
                    "15:00", "16:15", "17:20", "17:50", "19:45", "20:30", "21:15", "22:00", "23:15"},

            {"06:55", "07:30", "08:05", "09:00", "10:15", "11:35", "12:20", "12:55", "14:05",
                    "15:15", "16:30", "17:35", "18:05", "20:00", "20:45", "21:30", "22:15", "23:30"},

            {"05:50", "06:25", "07:35", "11:05", "12:25", "13:35", "15:00", "16:00", "17:05",
                    "17:45"},

            {"06:05", "06:40", "07:50", "11:20", "12:40", "13:50", "15:15", "16:15", "17:20",
                    "18:00"},

            {"06:20", "06:55", "08:05", "11:35", "12:55", "14:05", "15:30", "16:30", "17:35",
                    "18:15"}};

    private int tipo;

    public HorarioAdapter(Activity activity, Horario horario){
        this.activity = activity;

        switch (horario) {
            case SAIDA_PREDIO_CENTRAL:
                this.tipo = 0;
                break;
            case PORTAO_DE_ACESSO:
                this.tipo = 1;
                break;
            case CHEGADA_PREDIO_CENTRAL:
                this.tipo = 2;
                break;
            case FERIAS_SAIDA_PREDIO_CENTRAL:
                this.tipo = 3;
                break;
            case FERIAS_PORTAO_DE_ACESSO:
                this.tipo = 4;
                break;
            case FERIAS_CHEGADA_PREDIO_CENTRAL:
                this.tipo = 5;
                break;
        }

    }

    @Override
    public int getCount() {
        return horarios[tipo].length;
    }

    @Override
    public Object getItem(int position) {
        return horarios[tipo][position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtHorario = new TextView(this.activity);
        txtHorario.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT));
        txtHorario.setText(horarios[tipo][position]);
        txtHorario.setTextSize(16);
        txtHorario.setGravity(Gravity.CENTER_HORIZONTAL);

        String next = Functions.nextTime(tipo);

        if (next.equals(horarios[tipo][position])) {
            txtHorario.setTypeface(null, Typeface.BOLD);
        }

        return txtHorario;
    }
}