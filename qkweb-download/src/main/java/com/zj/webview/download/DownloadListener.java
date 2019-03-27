package com.zj.webview.download;


public interface DownloadListener {


    /**
     * @param url                下载链接
     * @param userAgent          mUserAgent
     * @param contentDisposition mContentDisposition
     * @param mimetype           资源的媒体类型
     * @param contentLength      文件长度
     * @param extra              下载配置 ， 用户可以通过 Extra 修改下载icon ， 关闭进度条 ， 或者是否强制下载。
     * @return true 表示用户处理了该下载事件 ， false 交给 QKWeb 下载
     */
    boolean onStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength, AgentWebDownloader.Extra extra);


    /**
     * @param path      文件的绝对路径
     * @param url       下载的地址
     * @param throwable 如果异常，返回给用户异常
     * @return true 表示用户处理了下载完成后续的事件 ，false 默认交给AgentWeb 处理
     */
    boolean onResult(String path, String url, Throwable throwable);





}
