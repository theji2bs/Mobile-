package com.malidielhadad.lasalle.fragment;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by malidielhadad on 26/04/2017.
 */

public class BaseFragment extends Fragment {

    private LoadingFragment loadingFragment;

    protected void showLoading(){

        View view = getView();

        if(view != null){
            //Justin Case
            hideLoading();

            loadingFragment = new LoadingFragment();
            int containerId = ((View)view.getParent()).getId();


            getFragmentManager()
                    .beginTransaction()
                    .add(containerId, loadingFragment)
                    .commit();

        }


    }

    protected void hideLoading(){

        if(loadingFragment != null){
            getFragmentManager()
                    .beginTransaction()
                    .remove(loadingFragment)
                    .commit();
            loadingFragment = null;
        }

    }

}
