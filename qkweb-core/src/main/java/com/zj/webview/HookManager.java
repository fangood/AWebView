package com.zj.webview;

public class HookManager {



    public static QKWeb hookAgentWeb(QKWeb agentWeb, QKWeb.AgentBuilder agentBuilder) {
        return agentWeb;
    }

    public static boolean permissionHook(String url,String[]permissions){
        return true;
    }




}
