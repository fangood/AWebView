package com.zj.webview.util;

import java.util.regex.Matcher;

public interface Replacement {
    String replacement(Matcher m);
}
