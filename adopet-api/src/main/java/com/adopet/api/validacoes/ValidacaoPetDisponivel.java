package com.adopet.api.validacoes;

import com.adopet.api.dto.SolicitacaoAdocaoDto;
import com.adopet.api.excpetion.ValidacaoException;
import com.adopet.api.model.Pet;
import com.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }

}
