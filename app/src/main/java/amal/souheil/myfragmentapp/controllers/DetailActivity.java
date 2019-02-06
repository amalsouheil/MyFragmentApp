package amal.souheil.myfragmentapp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import amal.souheil.myfragmentapp.R;
import amal.souheil.myfragmentapp.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    // 1 - Create static variable to identify Intent
    public static final String EXTRA_BUTTON_TAG ="amal.souheil.myfragmentapp.controllers.DetailActivity.EXTRA_BUTTON_TAG" ;
    // 1 - Declare main fragment
    private DetailFragment detailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 2 - Configure and show home fragment
        this.configureAndShowDetailFragment();


    }
    @Override
    public void onResume() {
        super.onResume();
        // 3 - Call update method here because we are sure that DetailFragment is visible
        this.updateDetailFragmentTextViewWithIntentTag();
    }



    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowDetailFragment() {

        // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null) {
            // B - Create new main fragment
            detailFragment = new DetailFragment();
            // C - Add it to FrameLayout container
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }

    // --------------
    // UPDATE UI
    // --------------

    // 2 - Update DetailFragment with tag passed from Intent
    private void updateDetailFragmentTextViewWithIntentTag(){
        // Get button's tag from intent
        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        // Update DetailFragment's TextView
        detailFragment.updateTextView(buttonTag);
    }

}

