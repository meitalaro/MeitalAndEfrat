package meital.edu.hakaton;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyLibraryFragment extends Fragment  {
   FloatingActionButton fabSetting;

    public MyLibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_library, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fabSetting = view.findViewById(R.id.fabSettings);
        fabSetting.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivityIntent = new Intent(getActivity(), SettingActivity.class);
                startActivity(nextActivityIntent);


            }
        });
    }
}
