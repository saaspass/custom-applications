export interface SpResponse {
    resultMessage: string;
    isVerified: boolean;
    isPendingOnEmail: boolean;
    isAccountOwnerBlocked: boolean;
    warning: string;
}

export interface ErrorResponse {
    name: string;
    message: string;
    informationlink: string;
}
