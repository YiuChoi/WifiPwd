package name.caiyao.wifipwd.adapter;

import android.net.wifi.ScanResult;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import name.caiyao.wifipwd.R;

/**
 * Created by xiaomu on 2017/4/1.
 */

public class WifiListAdapter extends RecyclerView.Adapter<WifiListAdapter.WifiViewHolder> {

  private List<ScanResult> scanResults;

  public WifiListAdapter(List<ScanResult> scanResults) {
    this.scanResults = scanResults;
  }

  @Override
  public WifiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wifi, parent, false);
    return new WifiViewHolder(view);
  }

  @Override
  public void onBindViewHolder(WifiViewHolder holder, int position) {
    ScanResult scanResult = scanResults.get(position);
    if (scanResult.capabilities.contains("WPA")) {
      holder.wifi_state.setImageResource(R.drawable.ic_signal_wifi_4_bar_lock_white_24dp);
    } else {
      holder.wifi_state.setImageResource(R.drawable.ic_signal_wifi_4_bar_white_24dp);
    }
    holder.wifi_ssid.setText(scanResult.SSID + "\n" + scanResult.BSSID);
  }

  @Override
  public int getItemCount() {
    return scanResults.size();
  }

  class WifiViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.wifi_ssid)
    TextView wifi_ssid;

    @BindView(R.id.wifi_state)
    ImageView wifi_state;

    WifiViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
