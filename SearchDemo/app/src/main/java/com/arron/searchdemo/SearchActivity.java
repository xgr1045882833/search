package com.arron.searchdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.arron.searchdemo.adapter.SearchAdapter;
import com.arron.searchdemo.bean.Bean;
import com.arron.searchdemo.view.SearchView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView.SearchViewListener {
    /**
     * 搜索结果列表view
     */
    private ListView lvResults;

    /**
     * 搜索view
     */
    private SearchView searchView;

    /**
     * 热搜框列表adapter
     */
    private ArrayAdapter<String> hintAdapter;

    /**
     * 自动补全列表adapter
     */
    private ArrayAdapter<String> autoCompleteAdapter;

    /**
     * 搜索结果列表adapter
     */
    private SearchAdapter resultAdapter;

    /**
     * 数据库数据，总数据
     */
    private List<Bean> dbData;

    /**
     * 热搜版数据
     */
    private List<String> hintData;

    /**
     * 搜索过程中自动补全数据
     */
    private List<String> autoCompleteData;

    /**
     * 搜索结果的数据
     */
    private List<Bean> resultData;

    /**
     * 默认提示框显示项的个数
     */
    private static int DEFAULT_HINT_SIZE = 4;

    /**
     * 提示框显示项的个数
     */
    private static int hintSize = DEFAULT_HINT_SIZE;

    /**
     * 设置提示框显示项的个数
     *
     * @param hintSize 提示框显示个数
     */
    public static void setHintSize(int hintSize) {
        SearchActivity.hintSize = hintSize;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_search);
        initData();
        initViews();
    }

    private void initData() {
        //从数据库获取数据
        getDbData();
        //初始化热搜版数据
        getHintData();
        //初始化自动补全数据
        getAutoCompleteData(null);
        //初始化搜索结果数据
        getResultData(null);
    }

    private void getResultData(String text) {
        if (resultData == null) {
            resultData = new ArrayList<>();
        } else {
            resultData.clear();
            for (int i = 0; i < dbData.size(); i++) {
                if (dbData.get(i).getTitle().contains(text.trim())) {
                    resultData.add(dbData.get(i));
                }
            }
        }
        if (resultAdapter == null) {
            resultAdapter = new SearchAdapter(this, resultData, R.layout.item_bean_list);
        } else {
            resultAdapter.notifyDataSetChanged();
        }
    }

    private void getAutoCompleteData(String text) {
        if (autoCompleteAdapter == null) {
            autoCompleteData = new ArrayList<>(hintSize);
        } else {
            autoCompleteData.clear();
            for (int i = 0, count = 0; i < dbData.size() && count < hintSize; i++) {
                if (dbData.get(i).getTitle().contains(text.trim())) {
                    autoCompleteData.add(dbData.get(i).getTitle());
                    count++;
                }
            }
        }
        if (autoCompleteAdapter == null) {
            autoCompleteAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    autoCompleteData);
        } else {
            autoCompleteAdapter.notifyDataSetChanged();
        }
    }

    private void getHintData() {
        hintData = new ArrayList<>(hintSize);
        for (int i = 0; i <= hintSize; i++) {
            hintData.add("热搜版" + i + ":Android自定义View");
        }
        hintAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, hintData);
    }

    private void getDbData() {
        int size = 100;
        dbData = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            dbData.add(new Bean(R.drawable.ic_cancel,
                    "android开发必备技能" + (i + 1),
                    "Android自定义view——自定义搜索view",
                    i * 20 + 2 + ""));
        }
    }

    private void initViews() {
        lvResults = findViewById(R.id.main_lv_search_results);
        searchView = findViewById(R.id.main_search_layout);
        searchView.setSearchViewListener(this);
        searchView.setTipsHintAdapter(hintAdapter);
        searchView.setAutoCompleteAdapter(autoCompleteAdapter);

        lvResults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onRefreshAutoComplete(String text) {
        getAutoCompleteData(text);
    }

    @Override
    public void onSearch(String text) {
        getResultData(text);
        lvResults.setVisibility(View.VISIBLE);
        if (lvResults.getAdapter() == null) {
            lvResults.setAdapter(resultAdapter);
        } else {
            resultAdapter.notifyDataSetChanged();
        }
        Toast.makeText(this, "完成搜索", Toast.LENGTH_SHORT).show();
    }
}
