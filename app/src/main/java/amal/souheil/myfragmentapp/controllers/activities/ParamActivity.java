package amal.souheil.myfragmentapp.controllers.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import amal.souheil.myfragmentapp.R;
import amal.souheil.myfragmentapp.controllers.fragments.ParamsFragment;

public class ParamActivity extends BaseActivity {


    // 1 - Declare main fragment
    private ParamsFragment paramsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);
        this.configureAndShowParamsFragment();
        this.configureToolbar();

    }

    @Override
    protected void configureAndShowParamsFragment() {
        paramsFragment = (ParamsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_params);
        if(paramsFragment == null){
            paramsFragment = new ParamsFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_params, paramsFragment)
                    .commit();

        }
    }

    @Override
    protected void configureAndShowDetailFragment() {

    }

    @Override
    protected void configureAndShowMainFragment() {

    }

    @Override
    protected void updateDetailFragmentTextViewWithIntentTag() {

    }

    private void configureToolbar(){
        //Get the toolbar (Serialise)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Set the toolbar
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


}
