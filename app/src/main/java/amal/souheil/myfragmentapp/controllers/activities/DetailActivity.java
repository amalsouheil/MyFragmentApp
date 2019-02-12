package amal.souheil.myfragmentapp.controllers.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import amal.souheil.myfragmentapp.R;
import amal.souheil.myfragmentapp.controllers.fragments.DetailFragment;

public class DetailActivity extends BaseActivity {


    // 1 - Create static variable to identify Intent
    public static final String EXTRA_BUTTON_TAG ="amal.souheil.myfragmentapp.controllers.DetailActivity.EXTRA_BUTTON_TAG" ;
    // 1 - Declare Detail fragment
    private DetailFragment detailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 2 - Configure and show home fragment
        this.configureAndShowDetailFragment();
        this.configureToolbar();
    }


    @Override
    protected void configureAndShowParamsFragment() {
    }


    @Override
    protected void configureAndShowDetailFragment() {

        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);
        if(detailFragment == null){
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();

        }

    }

    @Override
    protected void configureAndShowMainFragment() { }


    @Override
    public void onResume() {
        super.onResume();
        // 3 - Call update method here because we are sure that DetailFragment is visible
        this.updateDetailFragmentTextViewWithIntentTag();
    }


  protected void updateDetailFragmentTextViewWithIntentTag(){
        // Get button's tag from intent
        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        // Update DetailFragment's
        detailFragment.updateTextView(buttonTag);
    }


    private void configureToolbar(){
        //Get the toolbar (Serialise)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Set the toolbar
        setSupportActionBar(toolbar);
        // Get a support ActionBar corresponding to this toolbar
//        toolbar.setTitle("amal");
//
//   // Enable the Up button
//        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


}

