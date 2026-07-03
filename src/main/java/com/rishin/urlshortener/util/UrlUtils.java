package com.rishin.urlshortener.util;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlUtils {

    public static String normalizeUrl(String url) {
        url = url.trim();

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        return url;
    }

    public static boolean isValidUrl(String url) {
        try {
            URI uri = new URI(normalizeUrl(url));

            return uri.getScheme() != null
                    && uri.getHost() != null
                    && (uri.getScheme().equals("http")
                        || uri.getScheme().equals("https"));
        } catch (URISyntaxException e) {
            return false;
        }
    }
}