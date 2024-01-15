package com.zsw.netshop.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "netshop.auth")
public class UserProperties {

    private List<String> noAuthUrls;
}
