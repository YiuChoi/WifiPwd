package name.caiyao.wifipwd;

import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import name.caiyao.wifipwd.adapter.WifiListAdapter;
import name.caiyao.wifipwd.util.WifiUtil;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

  @BindView(R.id.rv_wifi)
  RecyclerView rv_wifi;

  @BindView(R.id.srl_wifi)
  SwipeRefreshLayout srl_wifi;

  WifiUtil wifiUtil;

  List<ScanResult> scanResults;

  WifiListAdapter wifiListAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    wifiUtil = new WifiUtil(this);
    wifiUtil.startScan();
    scanResults = wifiUtil.getWifiList();
    wifiListAdapter = new WifiListAdapter(scanResults);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    rv_wifi.setLayoutManager(linearLayoutManager);
    rv_wifi.setHasFixedSize(true);
    rv_wifi.setAdapter(wifiListAdapter);


    srl_wifi.setOnRefreshListener(this);
  }

  @Override
  public void onRefresh() {
    wifiUtil.startScan();
    scanResults = wifiUtil.getWifiList();
    wifiListAdapter.notifyDataSetChanged();
    srl_wifi.setRefreshing(false);
  }
}
