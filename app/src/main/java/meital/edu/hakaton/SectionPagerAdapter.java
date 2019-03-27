package meital.edu.hakaton;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new TopicsFragment();
            case 1:
                return new TemplateFragment();
            case 2:
                return new TopicsFragment();
        }

        throw new IllegalArgumentException("No Such Position. only 3 tabs");
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}