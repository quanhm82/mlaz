package com.mlaz.api.Enum;

/**
 * Created by jimmy on 12/2/17.
 */
public enum MarketPriceEnum {

    NEW("NEW"),
    USE("USE"),
    NOT_USE("NOT_USE");

    private final String text;

    /**
     * @param text
     */
    private MarketPriceEnum(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}