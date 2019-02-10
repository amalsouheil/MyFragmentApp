package amal.souheil.myfragmentapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import amal.souheil.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

//ce constructeur vide implémenté par defaut est obligatire pour un fragment
    public MainFragment() {
        // Required empty public constructor
    }


//2 - Declare callback comme variable au sein du fragment
    private OnButtonClickedListener mCallback;


    // 1 - Declare our interface that will be implemented by any container activity

    //Nous créons ici une interface dans le but d'obliger toute activité souhaitant
    //communiquer avec ce fragment à implémenter la méthode onButtonClicked(View).

    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }


    @Override

    //permet de récupérer le layout fragment_main.xml  afin de le définir comme layout principal
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        //Inflate the layout of MainFragment
        View result=inflater.inflate(R.layout.fragment_main, container, false);

        // Set onClickListener to buttons
        result.findViewById(R.id.fragment_main_button_happy).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_sad).setOnClickListener(this);
        result.findViewById(R.id.fragment_main_button_horrible).setOnClickListener(this);

        return result;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }



    // --------------
    // ACTIONS
    // --------------


    //pour récupérer les clicks de l'utulisateur
    @Override
    public void onClick(View v) {

        // 5 - Spread the click to the parent activity
        //Propagation du clic : Nous allons ici propager le clic de notre utilisateur
        // directement à notre activité parente via la méthode onButtonClicked(View).
        mCallback.onButtonClicked(v);

    }

    // --------------
    // FRAGMENT SUPPORT
    // --------------

    // 3 - Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }


}
