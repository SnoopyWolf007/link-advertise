package org.link.advertise.core.util;

import com.alibaba.druid.util.StringUtils;
import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: jcm1024@163.com
 * @Date: 2020/6/29 11:49
 */
public class UrlUtils {
    public static final String AGREEMENT_HTTP = "http";
    public static final String AGREEMENT_HTTPS = "https";

    private UrlUtils() {
    }

    public static UrlDetail analysis(String url) throws UnsupportedEncodingException {

        UrlDetail urlDetail = new UrlDetail();
        if (StringUtils.isEmpty(url)) {
            return urlDetail;
        }

        // 先解码
        url = URLDecoder.decode(url, "utf-8");

        if (url.startsWith(AGREEMENT_HTTP)) {
            urlDetail.agreement = AGREEMENT_HTTP;
        } else if (url.startsWith(AGREEMENT_HTTPS)) {
            urlDetail.agreement = AGREEMENT_HTTPS;
        }

        String[] split = url.split("\\?");
        urlDetail.remakeUrl = split[0];
        urlDetail.remakeUrlMd5 = Md5Util.md5(split[0]);
        urlDetail.domain = split[0].substring(split[0].indexOf(urlDetail.agreement + "://") + 1, split[0].indexOf("/", 2));
        if (split.length == 2 && !StringUtils.isEmpty(split[1])) {
            urlDetail.paramsMap = new LinkedHashMap<>();
            String[] paramSplit = split[0].split("&");
            for (String s : paramSplit) {
                String[] kv = s.split("=");
                if (kv.length == 2) {
                    urlDetail.paramsMap.put(kv[0], kv[1]);
                }
            }

            urlDetail.channel = urlDetail.paramsMap.get("channel");
            urlDetail.account = urlDetail.paramsMap.get("account");
        }

        return urlDetail;
    }

    @Data
    public static class UrlDetail {
        private String agreement;
        private String domain;
        private String remakeUrl;
        private String remakeUrlMd5;
        private String urlMd5;
        private String channel;
        private String account;
        private String params;
        private Map<String, String> paramsMap;
    }
}
