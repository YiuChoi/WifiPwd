package name.caiyao.wifipwd.ui;

import android.net.wifi.ScanResult;

import java.util.List;

import name.caiyao.wifipwd.base.BasePresenter;
import name.caiyao.wifipwd.base.BaseView;

/**
 * Created by xiaomu on 2017/4/1.
 */

public interface MainContract {

  interface View extends BaseView<Presenter> {

    void showWifilist(List<ScanResult> list);

    void showPwd(String pwd);
  }

  interface Presenter extends BasePresenter {

    void getWifilist();

    void getPwd(ScanResult scanResult);
  }

}
