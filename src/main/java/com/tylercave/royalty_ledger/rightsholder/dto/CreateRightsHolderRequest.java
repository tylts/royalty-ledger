package com.tylercave.royalty_ledger.rightsholder.dto;

import com.tylercave.royalty_ledger.rightsholder.RightsHolderType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateRightsHolderRequest(@NotBlank @Size(max = 200) String name,
                                        @NotNull RightsHolderType type,
                                        @Email String email) {
}
