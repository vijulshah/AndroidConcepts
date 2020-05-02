package royal.com.androidconcepts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyTabFrag_PagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public MyTabFrag_PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i)
        {
            case 0:
            {
                ChatTab chatTab = new ChatTab();
                return chatTab;
            }

            case 1:
            {
                StatusTab statusTab = new StatusTab();
                return statusTab;
            }

            case 2:
            {
                CallsTab callsTab = new CallsTab();
                return callsTab;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
