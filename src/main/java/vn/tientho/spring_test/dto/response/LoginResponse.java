package vn.tientho.spring_test.dto.response;

public class LoginResponse {
    
    private String accessToken;
    private String tokenType;
    private long expireIn;
    
    
    public LoginResponse(String accessToken, String tokenType, long expireIn) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expireIn = expireIn;
    }

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getTokenType() {
        return tokenType;
    }
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    public long getExpireIn() {
        return expireIn;
    }
    public void setExpireIn(long expireIn) {
        this.expireIn = expireIn;
    }

    
}
