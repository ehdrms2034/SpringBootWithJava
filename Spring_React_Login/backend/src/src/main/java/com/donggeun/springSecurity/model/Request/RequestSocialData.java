package com.donggeun.springSecurity.model.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

@Getter
@Setter
@NoArgsConstructor
public class RequestSocialData {

    private String id;
    private String name;
    private String email;
    private String type;

}
