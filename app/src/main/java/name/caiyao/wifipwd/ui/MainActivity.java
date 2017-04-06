package name.caiyao.wifipwd.ui;

import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import name.caiyao.wifipwd.R;
import name.caiyao.wifipwd.adapter.WifiListAdapter;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, MainContract.View {

  @BindView(R.id.rv_wifi)
  RecyclerView rv_wifi;

  @BindView(R.id.srl_wifi)
  SwipeRefreshLayout srl_wifi;

  @Inject
  MainPresenter mainPresenter;

  List<ScanResult> scanResults = new ArrayList<>();

  WifiListAdapter wifiListAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    rv_wifi.setLayoutManager(linearLayoutManager);
    rv_wifi.setHasFixedSize(true);
    srl_wifi.setOnRefreshListener(this);

    //DaggerMainComponent.builder().mainPresenterModule(new MainPresenterModule(this, this)).build().inject(this);
    wifiListAdapter = new WifiListAdapter(scanResults);
    rv_wifi.setAdapter(wifiListAdapter);
    wifiListAdapter.setOnItemCLickListener(new WifiListAdapter.OnItemCLickListener() {
      @Override
      public void OnItemClick(View view, int position) {

      }
    });
    mainPresenter.getWifilist();
  }

  @Override
  public void onRefresh() {
    mainPresenter.getWifilist();
  }

  @Override
  public void setPresenter(MainContract.Presenter presenter) {
    mainPresenter = (MainPresenter) presenter;
  }

  @Override
  public void showWifilist(List<ScanResult> list) {
    this.scanResults.clear();
    this.scanResults.addAll(list);
    wifiListAdapter.notifyDataSetChanged();
    srl_wifi.setRefreshing(false);
  }

  @Override
  public void showPwd(String pwd) {

  }
}
