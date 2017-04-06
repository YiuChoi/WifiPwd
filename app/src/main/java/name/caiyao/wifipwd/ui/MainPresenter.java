package name.caiyao.wifipwd.ui;

import android.content.Context;

import javax.inject.Inject;

import name.caiyao.wifipwd.util.WifiUtil;

/**
 * Created by xiaomu on 2017/4/6.
 */

public class MainPresenter implements MainContract.Presenter {

  private Context context;

  private final MainContract.View view;

  @Inject
  MainPresenter(Context context, MainContract.View view) {
    this.view = view;
    this.context = context;
  }

  @Inject
  void setupListeners() {
    view.setPresenter(this);
  }

  @Override
  public void start() {

  }

  @Override
  public void getWifilist() {
    WifiUtil wifiUtil = new WifiUtil(context);
    wifiUtil.startScan();
    view.showWifilist(wifiUtil.getWifiList());
  }
}
