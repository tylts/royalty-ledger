package com.tylercave.royalty_ledger.rightsholder;

import com.tylercave.royalty_ledger.rightsholder.dto.CreateRightsHolderRequest;
import com.tylercave.royalty_ledger.rightsholder.dto.RightsHolderResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RightsHolderService {
    private final RightsHolderRepository rightsHolderRepository;

    public RightsHolderService(RightsHolderRepository rightsHolderRepository) {
        this.rightsHolderRepository = rightsHolderRepository;
    }

    @Transactional
    public RightsHolderResponse create(CreateRightsHolderRequest request) {
        RightsHolder rightsHolder = new RightsHolder(request.name(), request.type(), request.email());
        RightsHolder saved = rightsHolderRepository.save(rightsHolder);
        return RightsHolderResponse.from(rightsHolder);
    }

    @Transactional(readOnly = true)
    public RightsHolderResponse getById(Long id) {
        return rightsHolderRepository.findById(id).map(RightsHolderResponse::from)
                .orElseThrow(() -> new RightsHolderNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<RightsHolderResponse> findAll() {
       return rightsHolderRepository.findAll()
               .stream()
               .map(RightsHolderResponse::from)
               .toList();
    }
}
