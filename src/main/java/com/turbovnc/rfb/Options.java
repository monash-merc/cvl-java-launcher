/* Copyright (C) 2012 D. R. Commander.  All Rights Reserved.
 *
 * This is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301,
 * USA.
 */

package com.turbovnc.rfb;

public class Options {

  public static final int SCALE_AUTO = -1;
  public static final int SCALE_FIXEDRATIO = -2;

  public static final int NUMSPANOPT = 3;
  public static final int SPAN_PRIMARY = 0;
  public static final int SPAN_ALL = 1;
  public static final int SPAN_AUTO = 2;

  public static final int NUMSUBSAMPOPT = 4;
  public static final int SUBSAMP_NONE = 0;
  public static final int SUBSAMP_4X = 1;
  public static final int SUBSAMP_2X = 2;
  public static final int SUBSAMP_GRAY = 3;

  public static final int DEFQUAL = 95;

  public Options() {}

  public Options(Options old) {
    if (old.serverName != null)
      serverName = new String(old.serverName);
    port = old.port;
    shared = old.shared;
    viewOnly = old.viewOnly;
    fullScreen = old.fullScreen;
    span = old.span;
    scalingFactor = old.scalingFactor;
    acceptClipboard = old.acceptClipboard;
    sendClipboard = old.sendClipboard;
    acceptBell = old.acceptBell;
    preferredEncoding = old.preferredEncoding;
    allowJpeg = old.allowJpeg;
    quality = old.quality;
    subsampling = old.subsampling;
    compressLevel = old.compressLevel;
    colors = old.colors;
    cursorShape = old.cursorShape;
    continuousUpdates = old.continuousUpdates;
    if (old.user != null) user = new String(old.user);
    noUnixLogin = old.noUnixLogin;
    sendLocalUsername = old.sendLocalUsername;
    if (old.via != null) via = new String(old.via);
    tunnel = old.tunnel;
  }

  public void setScalingFactor(String scaleString) {
    if (scaleString.toLowerCase().startsWith("a"))
      scalingFactor = SCALE_AUTO;
    else if (scaleString.toLowerCase().startsWith("f"))
      scalingFactor = SCALE_FIXEDRATIO;
    else {
      scaleString = scaleString.replaceAll("[^\\d]", "");
      int sf = -1;
      try {
        sf = Integer.parseInt(scaleString);
      } catch(NumberFormatException e) {};
      if (sf >= 1 && sf <= 1000) {
        scalingFactor = sf;
      }
    }
  }

  public int getSubsamplingOrdinal() {
    switch (subsampling) {
      case SUBSAMP_2X:
        return 1;
      case SUBSAMP_4X:
        return 2;
      case SUBSAMP_GRAY:
        return 3;
    }
    return 0;
  }

  void printOpt(String name, boolean val) {
    System.out.println(name + " = " + (val ? "true" : "false"));
  }

  void printOpt(String name, int val) {
    System.out.println(name + " = " + val);
  }

  void printOpt(String name, String val) {
    System.out.println(name + " = " + val);
  }

  public void print() {
    printOpt("serverName", serverName);
    printOpt("remoteServerName", remoteServerName); // JW
    printOpt("username", username); // JW
    printOpt("password", "********"); // JW
    printOpt("cipher", cipher); // JW
    printOpt("port", port);
    printOpt("shared", shared);
    printOpt("viewOnly", viewOnly);
    printOpt("fullScreen", fullScreen);
    printOpt("span", span);
    printOpt("scalingFactor", scalingFactor);
    printOpt("acceptClipboard", acceptClipboard);
    printOpt("sendClipboard", sendClipboard);
    printOpt("acceptBell", acceptBell);
    printOpt("preferredEncoding", preferredEncoding);
    printOpt("copyRect", copyRect);
    printOpt("allowJpeg", allowJpeg);
    printOpt("quality", quality);
    printOpt("subsampling", subsampling);
    printOpt("compressLevel", compressLevel);
    printOpt("colors", colors);
    printOpt("cursorShape", cursorShape);
    printOpt("continuousUpdates", continuousUpdates);
    printOpt("user", user);
    printOpt("noUnixLogin", noUnixLogin);
    printOpt("sendLocalUsername", sendLocalUsername);
    printOpt("via", via);
    printOpt("tunnel", tunnel);
  }

  public String serverName;
  public String remoteServerName = null; // for tunnel // JW
  public String username = null; // JW
  public String password = null; // JW
  public String cipher = null; // JW
  public int tunnelLocalPort = 0; // JW
  public int port;
  public boolean shared;
  public boolean viewOnly;
  public boolean fullScreen;
  public int span;
  public int scalingFactor;
  public boolean acceptClipboard;
  public boolean sendClipboard;
  public boolean acceptBell;
  public int preferredEncoding;
  public boolean copyRect = true;
  public boolean allowJpeg;
  public int quality;
  public int subsampling;
  public int compressLevel;
  public int colors;
  public boolean cursorShape;
  public boolean continuousUpdates;
  public String user;
  public boolean noUnixLogin;
  public boolean sendLocalUsername;
  public String via;
  public boolean tunnel;
}
