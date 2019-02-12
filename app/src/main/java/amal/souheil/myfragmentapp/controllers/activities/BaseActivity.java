package amal.souheil.myfragmentapp.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Souheil Amal on 2019-02-10
 */
public abstract class BaseActivity extends AppCompatActivity  {
    protected abstract void configureAndShowParamsFragment();
    protected abstract void configureAndShowDetailFragment();
    protected abstract void configureAndShowMainFragment();
    protected abstract void updateDetailFragmentTextViewWithIntentTag();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



}
