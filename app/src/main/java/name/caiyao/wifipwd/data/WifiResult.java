package name.caiyao.wifipwd.data;

import java.util.ArrayList;

/**
 * Created by xiaomu on 2017/4/6.
 */

public class WifiResult {
  String qid;
  String sysTime;
  String retCd;
  String topn;
  String s;
  ArrayList<Aps> aps;

  public String getQid() {
    return qid;
  }

  public void setQid(String qid) {
    this.qid = qid;
  }

  public String getSysTime() {
    return sysTime;
  }

  public void setSysTime(String sysTime) {
    this.sysTime = sysTime;
  }

  public String getRetCd() {
    return retCd;
  }

  public void setRetCd(String retCd) {
    this.retCd = retCd;
  }

  public String getTopn() {
    return topn;
  }

  public void setTopn(String topn) {
    this.topn = topn;
  }

  public String getS() {
    return s;
  }

  public void setS(String s) {
    this.s = s;
  }

  public ArrayList<Aps> getAps() {
    return aps;
  }

  public void setAps(ArrayList<Aps> aps) {
    this.aps = aps;
  }
}
