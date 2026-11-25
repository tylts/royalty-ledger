package com.tylercave.royalty_ledger.rightsholder;

public class RightsHolderNotFoundException extends RuntimeException {
    public RightsHolderNotFoundException(Long id) {
        super("Rights holder " + id + " not found.");
    }
}
