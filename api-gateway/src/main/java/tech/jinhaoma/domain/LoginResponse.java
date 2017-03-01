package tech.jinhaoma.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/21/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String state;
    private String token;
    private String url;
    private int role;

    public LoginResponse(String state) {
        this.state = state;
    }
}
