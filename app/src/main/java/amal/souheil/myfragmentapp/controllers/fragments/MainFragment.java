package amal.souheil.myfragmentapp.controllers.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import amal.souheil.myfragmentapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.fragment_main_button_happy) Button happyButton;
    @BindView(R.id.fragment_main_button_sad) Button sadButton;
    @BindView(R.id.fragment_main_button_horrible) Button horribleButton;
    private OnButtonClickedListener mCallback;


    public MainFragment() {
        // Required empty public constructor
    }


    // 1 - Declare our interface that will be implemented by any container activity
    //Nous créons ici une interface dans le but d'obliger toute activité souhaitant
    //communiquer avec ce fragment à implémenter la méthode onButtonClicked(View).

    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }


    @Override
    protected BaseFragment newInstance() {
        return null;
    }

    @Override
    protected int getFragmentLayout() {
        return 0;
    }

    @Override
    protected void configureDesign() {

    }

    @Override
    protected void updateDesign() {

    }

    //permet de récupérer le layout fragment_main.xml  afin de le définir comme layout principal
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, result);
        happyButton.setOnClickListener(this);
        sadButton.setOnClickListener(this);
        horribleButton.setOnClickListener(this);
        return result;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }


    //pour récupérer les clicks de l'utulisateur
    @Override
    public void onClick(View v) {

        // 5 - Spread the click to the parent activity
        //Propagation du clic : Nous allons ici propager le clic de notre utilisateur
        // directement à notre activité parente via la méthode onButtonClicked(View).
        mCallback.onButtonClicked(v);


    }


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
