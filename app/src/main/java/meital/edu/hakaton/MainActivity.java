package meital.edu.hakaton;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FloatingActionButton fabSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bnv = findViewById(R.id.navigation);
        bnv.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChannelFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.navigation_channel:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChannelFragment()).commit();
                return true;
            case R.id.navigation_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).commit();
                return true;
            case R.id.navigation_my_library:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new PodsListFragment()).commit();
                return true;
            case R.id.navigation_games:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new GamesFragment()).commit();
                return true;
        }

        throw new IllegalArgumentException("Unknown id");
    }

}
