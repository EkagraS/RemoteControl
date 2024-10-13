package com.example.remotecontrol;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewUtil {
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static void setGridViewHeightBasedOnChildren(GridView gridView, int numColumns) {
        ListAdapter gridAdapter = gridView.getAdapter();
        if (gridAdapter == null) {
            return;
        }

        int totalHeight = 0;
        int items = gridAdapter.getCount();
        int rows = (int) Math.ceil((double) items / numColumns);

        for (int i = 0; i < rows; i++) {
            View listItem = gridAdapter.getView(i, null, gridView);
            if (listItem != null) {
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
        }

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight + (gridView.getVerticalSpacing() * (rows - 1));
        gridView.setLayoutParams(params);
    }
}


