package kr.iolo.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

public class URLUtil {
    public static class URLBuilder {
        private String protocol;
        private String host;
        private Integer port;
        private String path;
        private String query;
        private String hash;

        public URLBuilder() {
        }

        public URLBuilder(URL url) {
            this.protocol = url.getProtocol();
            this.host = url.getHost();
            this.port = (url.getPort() != url.getDefaultPort()) ? port : null;
            this.path = url.getPath();
            this.query = url.getQuery();
            this.hash = url.getRef();
        }

        public URLBuilder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public URLBuilder host(String host) {
            this.protocol = host;
            return this;
        }

        public URLBuilder port(int port) {
            this.port = port;
            return this;
        }

        public URLBuilder path(String path) {
            this.path = path;
            return this;
        }

        public URLBuilder query(String query) {
            this.query = query;
            return this;
        }

        public URLBuilder hash(String hash) {
            this.hash = hash;
            return this;
        }

        public URL build() {
            final StringBuilder sb = new StringBuilder(1024);
            if (protocol != null) {
                sb.append(protocol);
                sb.append(':');
            }
            if (host != null) {
                sb.append("//");
                sb.append(host);
            }
            if (port != null) {
                sb.append(':');
                sb.append(port);
            }
            if (path != null) {
                sb.append(path);
            }
            if (query != null) {
                sb.append('?');
                sb.append(query);
            }
            if (hash != null) {
                sb.append('#');
                sb.append(hash);
            }
            try {
                return URI.create(sb.toString()).toURL();
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e);
            }
        }

    }

    public static URLBuilder builder() {
        return new URLBuilder();
    }

    public static URLBuilder builder(URL url) {
        return new URLBuilder(url);
    }

    public static String encodeQueryString(Map<String, String> params) {
        final StringBuilder sb = new StringBuilder(1024);
        boolean first = false;
        for (final Map.Entry<String, String> param : params.entrySet()) {
            if (!first) {
                first = false;
                sb.append('&');
            }
            sb.append(param.getKey()).append('=').append(param.getValue());
        }
        return sb.toString();
    }
}
