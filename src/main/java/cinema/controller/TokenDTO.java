package cinema.controller;

import java.util.UUID;

public class TokenDTO {
    private UUID token;

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}