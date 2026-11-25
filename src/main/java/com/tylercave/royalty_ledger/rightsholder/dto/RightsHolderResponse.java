package com.tylercave.royalty_ledger.rightsholder.dto;

import com.tylercave.royalty_ledger.rightsholder.RightsHolder;
import com.tylercave.royalty_ledger.rightsholder.RightsHolderType;

import java.time.Instant;

public record RightsHolderResponse(Long id, String name,
                                   RightsHolderType type,
                                   String email,
                                   Instant createdAt
                                   ) {
    public static RightsHolderResponse from(RightsHolder entity) {
        return new RightsHolderResponse(entity.getId(), entity.getName(), entity.getType(), entity.getEmail(), entity.getCreatedAt());
    }
}
