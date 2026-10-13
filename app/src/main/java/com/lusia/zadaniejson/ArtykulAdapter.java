package com.lusia.zadaniejson;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ArtykulAdapter extends ArrayAdapter<Artykul> {

    public ArtykulAdapter(
            @NonNull MainActivity context,
            @NonNull List<Artykul> artykuly) {

        super(context, 0, artykuly);
    }

    @NonNull
    @Override
    public View getView(
            int position,
            @Nullable View convertView,
            @NonNull ViewGroup parent) {

        View widok = convertView;

        if (widok == null) {
            widok = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_artykul, parent, false);
        }

        Artykul artykul = getItem(position);

        if (artykul == null) {
            return widok;
        }

        TextView tytul = widok.findViewById(R.id.textTytul);
        TextView data = widok.findViewById(R.id.textData);
        TextView tresc = widok.findViewById(R.id.textTresc);

        tytul.setText(artykul.getTytul());
        tytul.setTextColor(kolorLubDomyslny(
                artykul.getKolorTytulu(), "#800938"));
        tytul.setTextSize(artykul.getRozmiarTytulu());

        data.setText(artykul.getData());
        data.setTextColor(kolorLubDomyslny(
                artykul.getKolorDaty(), "#757575"));
        data.setTextSize(artykul.getRozmiarDaty());

        tresc.setText(artykul.getTresc());
        tresc.setTextColor(kolorLubDomyslny(
                artykul.getKolorTresci(), "#212121"));
        tresc.setTextSize(artykul.getRozmiarTresci());

        return widok;
    }

    private int kolorLubDomyslny(
            String kolor,
            String domyslny) {

        try {
            return Color.parseColor(
                    kolor == null || kolor.trim().isEmpty()
                            ? domyslny
                            : kolor);
        } catch (IllegalArgumentException e) {
            return Color.parseColor(domyslny);
        }
    }
}
