package amal.souheil.myfragmentapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import amal.souheil.myfragmentapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

/**
 * A simple {@link Fragment} subclass.
 */


public class DetailFragment extends Fragment {


    // 1 - Adding @State annotation to indicate to Icepick to save it
    @State
    int buttonTag;
    @State String nameToSaveInBundle;
    @State String titleToSaveInBundle;

    // 1 - Adding @BindView in order to indicate to ButterKnife to get & serialise it
    @BindView(R.id.fragment_detail_text_view) TextView textView;

    // 1 - Declare TextView
    //private TextView textView;

    //private int buttonTag;
    public static final String KEY_BUTTONTAG = "souheil.amal.myfragmentapp.controllers.fragments.DetailFragment.KEY_BUTTONTAG";



    public DetailFragment() {
        // Required empty public constructor
    }


    // nous permet de déclarer notre layout (fragment_detail.xml).
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // 2 - Get textView from layout (don't forget to create ID in fragment_detail.xml)

        this.textView = (TextView) view.findViewById(R.id.fragment_detail_text_view);
        TextView textView2=(TextView)view.findViewWithTag("amal");

        return(view);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 2 - Restore all @State annotation variables in Bundle
        Icepick.restoreInstanceState(this, savedInstanceState);
        this.updateTextView(this.buttonTag);
    }




    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 3 - Save all @State annotation variables in Bundle
        Icepick.saveInstanceState(this, outState);
    }


    // 3 - Update TextView depending on TAG's button
    public void updateTextView(int tag){

        // 3 - Save tag in ButtonTag variable

        this.buttonTag=tag;


        switch (tag){
            case 10:
                this.textView.setText("You're a very good programmer !");
                break;
            case 20:
                this.textView.setText("I do believe that Jon Snow is going to die in next season...");
                break;
            case 30:
                this.textView.setText("Maybe Game of Thrones next season will get back in 2040 ?");
                break;
            default:
                break;
        }
    }


}
