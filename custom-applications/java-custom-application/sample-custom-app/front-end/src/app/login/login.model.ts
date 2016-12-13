export interface LoginRequest {
    username: string;
    otp: string;
}

export interface LoginResponse {
    token: string;
}
